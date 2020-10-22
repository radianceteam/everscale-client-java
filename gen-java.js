'use strict';

const fs = require('fs');
const api = require('./api.json');

const packageName = 'com.radiance.tonclient';

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

function getJavaType(f) {
    if (f.type == 'Ref')
        return { type:'String' };
    var isArray = f.type=='Array';
    return {
        name:f.name,
        type:isArray?f.array_item.type:f.type,
        isArray
    };
}

var imports = {'java.util.concurrent.CompletableFuture':true};

for (var mod of api.modules) {
    console.log(mod.name, '"' + mod.description + '"');
    var types = {};
    console.log('  types:');
    for (var t of mod.types) {
        types[t.name] = {fields:t.struct_fields};
        if (t.type != 'Struct')
            console.error(t.name, t.type);
        else
            console.log('    ', t.name,t.struct_fields.map(f=>f.name+':'+(f.type=='Ref'?'->'+f.ref_name:f.type)));
    }
    var body = '';
    console.log('  functions:');
    for (var f of mod.functions) {
        var params = f.params.slice(1,2);
        if (params.length > 1)
            console.error(params.length);
        if (f.result.generic_args.length != 1)
            console.error(f.result.generic_args.length);
        const javaParams = flatMap(p=>p.fields, params.map(p=>p.ref_name).map(t=>types[t])).map(p=>{
            var type = p.type;
            if (type == 'Optional')
                type = p.optional_inner.type;
            if (type == 'Ref')
                type = 'String';
            else if (type == 'BigInt')
                type = 'Long';
            return { type, name:p.name};
        });

        console.log('    ',f.name + '(' + params.map(p=>p.ref_name) + '):' + f.result.generic_args.map(r=>r.ref_name));
        const resTypeName = f.result.generic_args[0].ref_name;
        const resType = types[resTypeName];
        const javaResult = resType?(resType.fields.length==1?getJavaType(resType.fields[0]):{type:'String'}):{type:'String'};
        const isJson = javaResult.name;
        body += `    public CompletableFuture<${javaResult.type+(javaResult.isArray?'[]':'')}> ${camelize(f.name)}(${javaParams.map(p=>p.type+' _'+camelize(p.name)).join(', ')}) {\n`;
        body += `        return context.request${isJson?'JSON':''}("${mod.name}.${f.name}", "{" + String.join(",", new String[]{` + javaParams.map(p => {
                    const qu = p.type == 'String'?'\\\"':'';
                    return '"\\\"'+p.name+'\\\":'+qu+'"+_'+camelize(p.name) + (qu?('+"'+qu+'"'):'');
                }) + `}) + "}")${isJson?'':';'}\n`;

        if(isJson) {
            if(javaResult.isArray) {
                body += `            .thenApply(json -> {\n`;
                body += `                Iterable<JsonNode> it = () -> json.findValue("${javaResult.name}").elements();\n`;
                body += `                return StreamSupport.stream(it.spliterator(), false)\n`;
                body += `                    .map(e -> e.toString())\n`;
                body += `                    .toArray(String[]::new);\n`;
                body += `            });\n`;
                imports['java.util.stream.StreamSupport'] = true;
                imports['com.fasterxml.jackson.databind.JsonNode'] = true;
            } else {
                var conv = javaResult.type;
                if (conv == 'String')
                    conv = null;
                else if (conv == 'Number') {
                    conv = 'Float';
                }
                body += `            .thenApply(json -> ${conv?conv+'.valueOf(':''}json.findValue("${javaResult.name}").toString()${conv?')':''});\n`;
            }
        }
        body += `    }\n\n`;
    }

    const className = capitalize(mod.name);

    fs.writeFileSync('./' +('src.main.java.'+packageName).split('.').join('/') +'/' + className + '.java', `package ${packageName};

${Object.keys(imports).map(i=>`import ${i};`).join('\n')}

public class ${className} {
    private TONContext context;

    public ${className}(TONContext context) {
        this.context = context;
    }

${body}}
`);

}
