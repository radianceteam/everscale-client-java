'use strict';

const fs = require('fs');
const api = require('./api.json');

const packageName = 'com.radiance.tonclient';
const reserved = ['public'];

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
    return arr.shift() + arr.map(capitalize).join('');
}

function htmlize(s) {
    return s.replace(/\n\s*\n/g, '<p>').replace(/\n/g,'').replace(/\[(.+)\]/g, (match,p1) => `<a target="_blank" href="${p1}">${p1}</a>`);
}

var imports = {'java.util.concurrent.CompletableFuture':true};
var functionCount = 0;

for (var mod of api.modules) {
    console.log(mod.name, '"' + mod.description + '"');
    var types = {};
    var innerClasses = {};
    console.log('  types:');
    for (var t of mod.types) {
        var type = {name:t.name};
        switch (t.type) {
            case 'Struct':
                type.fields = t.struct_fields.map(f=> {
                    var result = {name:f.name, desc:f.description};
                    if (f.type == 'Optional') {
                        f = f.optional_inner;
                        result.isOptional = true;
                    }
                    if (f.type == 'Array') {
                        f = f.array_item;
                        result.isArray = true;
                    }
                    var type = f.type;
                    if (type == 'Ref')
                        type = 'String';//f.ref_name;
                    else if (type == 'BigInt')
                        type = 'Long';
                    result.type = type;
                    return result;
                });
                break;
            default:
                console.error(t.name, t.type);
        }
        //console.log('    ', t.name,t.struct_fields.map(f=>f.name+':'+(f.type=='Ref'?'->'+f.ref_name:f.type)));
        types[t.name] = type;
    }
    var body = '';
    console.log(`  functions(${mod.functions.length}):`);
    functionCount += mod.functions.length;
    for (var f of mod.functions) {
        var params = f.params.slice(1,2);
        if (params.length > 1)
            console.error(params.length);
        const javaParams = params.length?types[params[0].ref_name].fields:[];// flatMap(p=>p.fields, params.map(p=>p.ref_name).map(t=>types[t])).map(p=>{
        /*
            var type = p.type;
            if (type == 'Optional')
                type = p.optional_inner.type;
            if (type == 'Ref')
                type = 'String';
            else if (type == 'BigInt')
                type = 'Long';
            return { type, name:p.name, desc:p.description};
        });*/

        body += `  /**\n`;
        body += `   * ${htmlize(f.description||'')}\n`;
        body += `   *\n`;
        body += javaParams.filter(p=>p.desc).map(p => `   * @param ${camelize(p.name)} ${p.desc}\n`).join('');
        body += `   */\n`;

        if (f.result.generic_args.length != 1)
            console.error(f.result.generic_args.length);

        console.log('    ',f.name + '(' + params.map(p=>p.ref_name) + '):' + f.result.generic_args.map(r=>r.ref_name));
        const resTypeName = f.result.generic_args[0].ref_name;
        const resType = types[resTypeName];
        if (resType && resType.fields.length > 1)
            innerClasses[resTypeName] = resType;
        const javaResult = innerClasses[resTypeName]?{type:resType.name}:(resType&&resType.fields.length==1?resType.fields[0]:{type:'String'});
        console.log('--',resType);
        console.log('-',javaResult);

        const isJson = javaResult.name;
        const isValue = innerClasses[javaResult.type];
        body += `    public CompletableFuture<${javaResult.type+(javaResult.isArray?'[]':'')}> ${camelize(f.name)}(${javaParams.map(p=>p.type+' '+dereserve(camelize(p.name))).join(', ')}) {\n`;
        body += `        return context.request${isJson?'JSON':''}${isValue?'Value':''}("${mod.name}.${f.name}", "{" + String.join(",", new String[]{` + javaParams.map(p => {
                    const qu = p.type == 'String'?'\\\"':'';
                    return '"\\\"'+p.name+'\\\":'+qu+'"+'+dereserve(camelize(p.name)) + (qu?('+"'+qu+'"'):'');
                }) + `}) + "}"${isValue?`, ${javaResult.type}.class`:''})${isJson?'':';'}\n`;

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
                switch(javaResult.type) {
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

    fs.writeFileSync('./' +('src.main.java.'+packageName).split('.').join('/') +'/' + className + '.java', `package ${packageName};

${Object.keys(imports).map(i=>`import ${i};`).join('\n')}

/**
 *  ${htmlize(mod.description||'')}
 */
public class ${className} {

${Object.entries(innerClasses).map(([name,t]) => `    public static class ${name} {
${t.fields.map(f=>`
        private ${f.type} ${dereserve(f.name)};
        /**
         * ${htmlize(f.desc||'')}
         */
        public ${f.type} ${camelize('get_'+f.name)}() {
            return ${dereserve(f.name)};
        }
        /**
         * ${htmlize(f.desc||'')}
         */
        public void ${camelize('set_'+f.name)}(${f.type} value) {
            ${dereserve(f.name)} = value;
        }
`).join('')}
    }
`).join('\n')}
    
    private TONContext context;

    public ${className}(TONContext context) {
        this.context = context;
    }

${body}}
`);

}

console.log({functionCount});
