'use strict';

const api = require('./api.json');
const fs = require('fs');

const packageName = 'com.radiance.tonclient';

const reserved = {
    public: 'publicKey',
    secret: 'secretKey',
    switch: 'switchTo'
};

const PATH = './' + ('src.main.java.'+packageName).split('.').join('/') +'/';

let types = {};
let appInterfaces = {};
let currMod;

var genFiles = require('./gen-files.json');
for(var f of genFiles) {
    if (fs.existsSync(PATH + f))
        fs.unlinkSync(PATH + f);
}

genFiles = [];

function dereserve(iden) {
    //return (reserved.includes(iden)?'_':'') + iden;
    return reserved[iden]||iden;
}

const flatMap = (f,xs) =>
  xs.reduce((acc,x) =>
    acc.concat(f(x)), []);

function capitalize(s) {
    return s.charAt(0).toUpperCase() + s.slice(1);
}

function camelize(s) {
    var arr = s.split('_');
    return dereserve(arr.shift() + arr.map(capitalize).join(''));
}

function htmlize(s) {
    return s&&s.trim().replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/\n\s*\n/g, '<p>').replace(/\n/g,'').replace(/\[(.+)\]/g, (match,p1) => `<a target="_blank" href="${p1}">${p1}</a>`)||'';
}

function isFlattable(typeName) {
    let type = types[typeName];
    return type && type.isStruct && (typeName.indexOf('.ParamsOf') > 0 || typeName.indexOf('.ResultOf') > 0);
}

function trimClassName(cName, mName) {
    //console.log('==',cName,currMod.name);
    let arr = cName.split('.');
    if (arr.length == 2 && arr[0] == arr[1].toLowerCase())
        cName = arr[0] + '.' + arr[1].toUpperCase();
    return currMod&&cName.startsWith(currMod.name+'.')?cName.split('.').pop():capitalize(cName);
}

function setTypeExported(field) {
    let type = types[field.type];
    if (type&&!type.isExported) {
        type.isExported = true;
        if (type.fields)
            type.fields.forEach(f => setTypeExported(f));
        //console.log(field.type);
    }
    return field;
}

function stringifyFields(fields, type) {
    let totLen = fields.length + (type?1:0);
    let stream = totLen > 1?'Stream.of(':'';
    return `"{${totLen?`"+${stream}${(type?[`"\\"type\\":\\"${type}\\""`]:[]).concat(fields.map(f=> {
        if (isFlattable(f.type))
            return `"\\"${f.name}\\":"+${stringifyFields(types[f.type].fields)}`;
        const typeDesc = types[f.type];
        const isEnum = typeDesc && typeDesc.isEnum;
        let qu = f.type == 'String'?'\\"':'';
        return `(${camelize(f.name)}==null?${stream?'null':'""'}:("\\"${f.name}\\":${qu}"+${(n=>f.isArray?`Arrays.toString(${n})`:n)(camelize(f.name)+(isEnum?'.ordinal()':''))}${qu?`+"${qu}"`:''}))`;
    }))}${stream&&`).filter(_f -> _f != null).collect(Collectors.joining(","))`}+"`:''}}"`
}

function fieldMapper(f) {
    let field = {name: f.name||'value', desc: f.description,
        getType:(mName) => {
            let result;
            if (field.type in types && types[field.type].isSubclass)
                result = types[field.type].parent;
            else
                result = (!field.isRef)||(field.type in types&&types[field.type].isExported)?trimClassName(field.type, mName):'Object';
            if (field.isArray)
                result += '[]';
            //console.log(field.type,'=>',result);
            return result;
        }
    };
    while (true) {
        if (f.type == 'Optional') {
            f = f.optional_inner;
            field.isOptional = true;
        } else if (f.type == 'Array') {
            f = f.array_item;
            field.isArray = true;
        } else {
            if (f.type == 'Ref') {
                field.type = f.ref_name;
                field.isRef = true;
            } else
                field.type = f.type == 'BigInt'?'Long':f.type;
            break;
        }
    }
    return field;
}

function getAppObjectHandler(obj) {
    return `(params,type) -> {
                Map data = (Map)(type==3?((Map)params).get("request_data"):params);
                switch ((String)data.remove("type")) {
${Object.entries(obj.methods).map(([n,o]) => {
    
    return `
                    case "${n}":
                        try {${o.params.length?`
                            ParamsOf${obj.type}.${n} p = new ObjectMapper().convertValue(data, ParamsOf${obj.type}.${n}.class);`:''}
                            appObject.${dereserve(n.charAt(0).toLowerCase()+n.substring(1))}(${o.params.map(p=>`p.${camelize('get_'+p.name)}()`)})${o.result?`.whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOf${obj.type}.${n}(${o.result.length?'res':''})):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            })`:''};
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;
`}).join('')
                }
                }
            }`;
}

api.modules.forEach(m => m.types.forEach(t => {
    let type = {};
    switch (t.type) {
        case 'Struct':
            type.fields = t.struct_fields.map(fieldMapper);
            type.isStruct = true;
            break;
        case 'EnumOfConsts':
            type.fields = t.enum_consts.map(f => ({name:f.name, desc: f.description/*, getType:(mName)=>{console.log('==',mName,t.name);return capitalize(t.name)}*/}));
            type.isEnum = true;
            break;
        case 'EnumOfTypes':
            type.variants = t.enum_types.map(v => ({
                name:v.name,
                desc:v.description,
                get fields() {
                    if (v.ref_name)
                        return types[v.ref_name].fields;
                    return v.struct_fields.map(fieldMapper)
                }
            }));
            type.isEnumOfTypes = true;
            break;
        case 'Number':
            type.parent = 'Integer';
            type.isSubclass = true;
            break;
        default:
            console.log('!!! ', t);
    }
    types[m.name + '.' + t.name] = type;
}));

setTypeExported({type:'client.ClientConfig'});

api.modules.forEach(mod => {
    currMod = mod;
    let imports = {'java.util.concurrent.CompletableFuture':true,'java.util.stream.*':true,'com.fasterxml.jackson.annotation.JsonProperty':true,'java.util.Arrays':true};
    let body = '';

    mod.functions.forEach(f => {
        let rName = f.result.generic_args[0].ref_name;
        let rType = types[rName];
        let rField = {getType:()=>'Void'};
        if (rType&&rType.fields.length > 1) {
            setTypeExported({type:rName})
            rField = {getType:(mName) => trimClassName(rName, mName)}
        } else if (rType) {
            const f = rType.fields[0];
            rField = f;
        }

        let event = false;
        let appObject = false;
        let fields = [];
        f.params.forEach(p => {
            switch (p.name) {
                case 'context':
                case '_context':
                    break;
                case 'params':
                    fields = types[p.ref_name].fields;
                    break;
                case 'callback':
                case 'request':
                    var ref_name = f.result.generic_args[0].ref_name;
                    event = ref_name.substring(ref_name.indexOf('.') + 9) + 'Event';
                    imports['java.util.function.Consumer'] = true;
                    break;
                case 'app_object':
                    let ref = p.generic_args[0].ref_name;
                    let name = ref.substring(ref.indexOf('.') + 9);
                    console.log(name);
                    if (!(name in appInterfaces)) {
                        let methods = {};
                        p.generic_args.forEach((t,i) => {
                            for (let m of types[t.ref_name].variants) {
                                let mName = m.name; //.charAt(0).toLowerCase() + m.name.slice(1);
                                if (i==0)
                                    methods[mName] = {params: m.fields};
                                else
                                    methods[mName].result = m.fields;
                                setTypeExported({type:t.ref_name});
                            }
                        });
                        appInterfaces[name] = {methods};
                    }
                    appObject = {type:name, methods:appInterfaces[name].methods};
                    imports['java.util.Map'] = true;
                    imports['com.fasterxml.jackson.databind.ObjectMapper'] = true;
                    break;
                default:
                    console.log(p.name);
            }
        });

        /*event = f.params.length > 2?camelize('_'+f.name+'_event'):false;
        if (event)
            imports['java.util.function.Consumer'] = true;
        fields = f.params.length > 1?types[f.params[1].ref_name].fields:[];*/

        let params = flatMap(f=> isFlattable(f.type)?types[f.type].fields:[f], fields)
            .map(p=> ({type:setTypeExported(p).getType(), name:camelize(p.name), desc:p.desc}));
        if (appObject)
            params.push({type:appObject.type, name:'appObject'});
        body += `   /**\n`;
        body += `    * ${htmlize(f.description)}\n    *\n`;
        body += params.map(p => `    * @param ${p.name} ${htmlize(p.desc)}\n`).join('');
        let rDesc = rField.desc || (((type)=>{return type&&type.desc})(types[rField.getType()]));
        if (rDesc)
            body += `    * @return ${htmlize(rDesc)}\n`;
        body += `    */\n`;
        body += `    public CompletableFuture<${rField.getType(mod.name)}> ${camelize(f.name)}(${params.map(p=>p.type+' '+p.name).join(', ')}${event?`, Consumer<${event}> consumer`:''}) {\n`
        body += `        return context.requestJSON${event||appObject?'Callback':''}("${mod.name}.${f.name}", ${stringifyFields(fields)}${event?`, (event,type)->consumer.accept(event), ${event}.class`:''}${appObject?`, ${getAppObjectHandler(appObject)}, Object.class`:''})\n`;
        body += `            .thenApply(json -> TONContext.convertValue(json${rField.name?`.findValue("${rField.name}")`:''}, ${rField.getType(mod.name)}.class));\n`;
        body += `    }\n\n`;
    });

    const className = capitalize(mod.name);
    genFiles.push(className + '.java');

    fs.writeFileSync(PATH + className + '.java', `package ${packageName};

${Object.keys(imports).map(i=>`import ${i};`).join('\n')}

/**
 *  ${htmlize(mod.description||'')}
 */
public class ${className} {
${Object.entries(types).filter(([n,t])=>t.isExported&&n.startsWith(mod.name+'.')).map(([cName,t]) => {
    let genFunc;
    if (t.isEnum)
        genFunc = getEnumSource;
    else if(t.isEnumOfTypes)
        genFunc = getEnumOfTypesSource;
    //else if(t.isSubclass)
    //    genFunc = (cName,t) => `    public static class ${cName} extends ${t.parent} {}\n`;
    else if(t.isStruct)
        genFunc = getStructSource;
    if (genFunc)
        return genFunc(cName.split('.').pop(),t);
}).join('')}
    private TONContext context;

    public ${className}(TONContext context) {
        this.context = context;
    }

${body}}
`);

});

function getStructSource(cName, t, sClass) {
    //console.log(cName,t.fields, sClass);
    var args = t.fields.filter(f=>f.name);
    var constr = '';
    do {
        constr += `
        public ${cName}(${args.map(f=>`${f.getType()} ${camelize(f.name)}`).join(', ')}) {
${args.map(f=>`
            this.${camelize(f.name)} = ${camelize(f.name)};
`).join('')}
        }`;
    } while(args.pop());
    return `
    /**
     *  ${htmlize(t.desc||'')}
     */
    public static class ${cName} ${sClass?`extends ${sClass} `:''} {
${constr}

${t.fields.filter(f=>f.name).map(f=> {
    var arr = f.isArray?'[]':'';
    return `
        @JsonProperty("${f.name}")
        private ${f.getType()} ${camelize(f.name)};
        /**
         * ${htmlize(f.desc||'')}
         */
        public ${f.getType()} ${camelize('get_'+f.name)}() {
            return ${camelize(f.name)};
        }
        /**
         * ${htmlize(f.desc||'')}
         */
        public void ${camelize('set_'+f.name)}(${f.getType()} value) {
            this.${camelize(f.name)} = value;
        }
`}).join('')}

        @Override
        public String toString() {
            return ${stringifyFields(t.fields.filter(f=>f.name), sClass&&cName)};
        }
    }`
}

function getEnumSource(cName, t) {
    return `

    /**
     *  ${htmlize(t.desc||'')}
     */
    public enum ${cName} {
        ${t.fields.filter(f=>f.name).map(f=> `
        /**
         * ${htmlize(f.desc)}
         */
        ${f.name}`).join(',\n')}
    }`
}

function getEnumOfTypesSource(cName, t) {
    if (capitalize(currMod.name) == cName)
        cName = cName.toUpperCase();
    return `
    public static abstract class ${cName} {
${t.variants.map(v => {

    return (v.fields.length?'':`
        public static final ${v.name} ${v.name} = new ${v.name}();
`) + getStructSource(v.name,v,cName);
}).join('\n')}
}`;
}

currMod = null;

for(let className in appInterfaces) {
    genFiles.push(className + '.java');
    let iface = appInterfaces[className];
    fs.writeFileSync(PATH + className + '.java', `package ${packageName};

import java.util.concurrent.CompletableFuture;

public interface ${className} {
${Object.entries(iface.methods).map(([n,o]) => {
    let name = n.charAt(0).toLowerCase() + n.slice(1);
    let res = o.result&&o.result.length?o.result[0].getType():'Void';
    return `    ${o.result?`CompletableFuture<${res}>`:'void'} ${dereserve(name)}(${o.params.map(p=>p.getType()+' '+camelize(p.name))});`;
}).join('\n')}
}
`);
}

fs.writeFileSync('./gen-files.json', JSON.stringify(genFiles));

//Object.entries(types).filter(([n,t])=>true/*t.isExported*/).forEach(([n,t])=>console.log(n,t.isExported));
