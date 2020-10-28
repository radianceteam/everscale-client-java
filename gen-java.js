'use strict';

const fs = require('fs');
const api = require('./api.json');

const packageName = 'com.radiance.tonclient';
const reserved = ['public','private','protected','void','int','long','float','double','switch','case','return','new','class','interface','enum','try','catch','throw','throws'];
var skippedTypes = ['Value', 'API', 'TransactionFees'];

const PATH = './' + ('src.main.java.'+packageName).split('.').join('/') +'/';

var genFiles = require('./gen-files.json');
for(var f of genFiles) {
    if (fs.existsSync(PATH + f))
        fs.unlinkSync(PATH + f);
}

function dereserve(iden) {
    return (reserved.includes(iden)?'_':'') + iden;
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
    return s.replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/\n\s*\n/g, '<p>').replace(/\n/g,'').replace(/\[(.+)\]/g, (match,p1) => `<a target="_blank" href="${p1}">${p1}</a>`);
}

function convertType(type) {
    return skippedTypes.includes(type)?'String':type;
}

function stringifyFields(fields) {
    /*
    return `"{" + String.join(",", new String[]{` + 
        fields.map(f => {
            const qu = f.type == 'String'?'\\\"':'';
            return '"\\\"'+f.name+'\\\":'+qu+'"+'+camelize(f.name) + (qu?('+"'+qu+'"'):'');
        }) + `}) + "}"`;
    */
    return '"{' + fields.map(f=> {
        const qu = f.getType() == 'String'?'\\\"':'';
        return `\\"${f.name}\\":${qu}"+${camelize(f.name)}+"${qu}`;
    }).join(',') + '}"';
}

var functionCount = 0;
var types = {};
    var innerClasses = {};

for (var mod of api.modules) {
    var imports = {'java.util.concurrent.CompletableFuture':true};
    console.log(mod.name, '"' + mod.description + '"');
    console.log('  types:');
    for (var t of mod.types) {
        var type = {name:t.name,desc:t.description};
        switch (t.type) {
            case 'Struct':
                type.fields = t.struct_fields.map(f=> {
                    var result = {name:f.name, desc:f.description, getType:()=>convertType(type)};
                    while(true) {
                        var repeat = false;
                        if (f.type == 'Optional') {
                            f = f.optional_inner;
                            result.isOptional = true;
                        } else if (f.type == 'Array') {
                            f = f.array_item;
                            result.isArray = true;
                        } else
                            break;
                    };
                    var type = f.type;
                    if (type == 'Ref')
                        type = f.ref_name;
                    else if (type == 'BigInt')
                        type = 'Long';
                    result.type = type;
                    return result;
                });
                break;
            case 'EnumOfConsts':
                type.fields = t.enum_consts;
                type.isEnum = true;
                break;
            default:
                console.error(t.name, t.type);
        }
        //console.log('    ', t.name,t.struct_fields.map(f=>f.name+':'+(f.type=='Ref'?'->'+f.ref_name:f.type)));
        if (type.fields)
            types[t.name] = type;
        else
            skippedTypes.push(t.name);

        if (!t.name.startsWith('ResultOf') && !t.name.startsWith('ParamsOf') && type.fields) {
            innerClasses[t.name] = type;
            //console.error(t.name);
        }
    }
    var body = '';
    console.log(`  functions(${mod.functions.length}):`);
    functionCount += mod.functions.length;
    for (var f of mod.functions) {
        var params = f.params.slice(1,2);
        if (params.length > 1)
            console.error(params.length);
        //const javaParams = params.length?types[params[0].ref_name].fields:[];// flatMap(p=>p.fields, params.map(p=>p.ref_name).map(t=>types[t])).map(p=>{
        const javaParams = params.length?flatMap(f=> {
            return !innerClasses[f.type]&&types[f.type]?types[f.type].fields:[f];
            },types[params[0].ref_name].fields):[];// flatMap(p=>p.fields, params.map(p=>p.ref_name).map(t=>types[t])).map(p=>{

        body += `  /**\n`;
        body += `   * ${htmlize(f.description||'')}\n`;
        body += `   *\n`;
        body += javaParams.filter(p=>p.desc).map(p => `   * @param ${camelize(p.name)} ${htmlize(p.desc)}\n`).join('');
        body += `   */\n`;

        if (f.result.generic_args.length != 1)
            console.error(f.result.generic_args.length);

        //console.log('    ',f.name + '(' + params.map(p=>p.ref_name) + '):' + f.result.generic_args.map(r=>r.ref_name));
        const resTypeName = f.result.generic_args[0].ref_name;
        const resType = types[resTypeName];
        if (resType && resType.fields.length > 1)
            innerClasses[resTypeName] = resType;
        const javaResult = innerClasses[resTypeName]?{type:resType.name}:(resType&&resType.fields.length==1?resType.fields[0]:{type:'String'});

        const isJson = javaResult.name;
        const isValue = innerClasses[javaResult.type];
        body += `    public CompletableFuture<${convertType(javaResult.type)+(javaResult.isArray?'[]':'')}> ${camelize(f.name)}(${javaParams.map(p=>p.getType()+' '+dereserve(camelize(p.name))).join(', ')}) {\n`;
        body += `        return context.request${isJson?'JSON':''}${isValue?'Value':''}("${mod.name}.${f.name}", ` + stringifyFields(javaParams) +`${isValue?`, ${javaResult.type}.class`:''})${isJson?'':';'}\n`;

        if(isJson) {
            if(javaResult.isArray) {
                body += `            .thenApply(json -> {\n`;
                body += `                Iterable<JsonNode> it = () -> json.findValue("${javaResult.name}").elements();\n`;
                body += `                return StreamSupport.stream(it.spliterator(), false)\n`;
                body += `                    .map(e -> e.asText())\n`;
                body += `                    .toArray(String[]::new);\n`;
                body += `            });\n`;
                imports['java.util.stream.StreamSupport'] = true;
                imports['com.fasterxml.jackson.databind.JsonNode'] = true;
            } else {
                var conv;
                switch(convertType(javaResult.type)) {
                    case 'String':
                        conv = '';
                        break;
                    case 'Number':
                        conv = 'TONContext.toNumber(';
                        break;
                    default:
                        conv = javaResult.type + '.valueOf(';
                }
                body += `            .thenApply(json -> ${conv}json.findValue("${javaResult.name}").asText()${conv&&')'});\n`;
            }
        }
        body += `    }\n\n`;
    }


    const className = capitalize(mod.name);
    genFiles.push(className + '.java');

    fs.writeFileSync(PATH + className + '.java', `package ${packageName};

${Object.keys(imports).map(i=>`import ${i};`).join('\n')}

/**
 *  ${htmlize(mod.description||'')}
 */
public class ${className} {

    private TONContext context;

    public ${className}(TONContext context) {
        this.context = context;
    }

${body}}
`);

}

genFiles = genFiles.concat(Object.getOwnPropertyNames(innerClasses).map(f=>f+'.java'));
for(var cName in innerClasses) {
    const t = innerClasses[cName];
    fs.writeFileSync(PATH + cName + '.java', `package ${packageName};

/**
 *  ${htmlize(t.desc||'')}
 */
public ${t.isEnum?'enum':'class'} ${cName} {
${t.fields.filter(f=>f.name).map(f=>t.isEnum?f.name:`
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
        ${camelize(f.name)} = value;
    }
`).join(t.isEnum?',':'')}
${t.isEnum?'':`
    @Override
    public String toString() {
        return ${stringifyFields(t.fields.filter(f=>f.name))};
    }
`}}`);

}

fs.writeFileSync('./gen-files.json', JSON.stringify(genFiles));

console.log({functionCount});
