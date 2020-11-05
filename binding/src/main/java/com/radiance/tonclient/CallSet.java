package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class CallSet {
    public CallSet() {
    }

    public CallSet(String functionName, FunctionHeader header, Object input) {

        this.functionName = functionName;

        this.header = header;

        this.input = input;

    }



    @JsonProperty("function_name")
    private String functionName;
    /**
     *  Function name that is being called.
     */
    public String getFunctionName() {
        return functionName;
    }
    /**
     *  Function name that is being called.
     */
    public void setFunctionName(String value) {
        functionName = value;
    }

    @JsonProperty("header")
    private FunctionHeader header;
    /**
     *  Function header.<p> If an application omits some header parameters required by the contract's ABI, the library will set the default values for them.
     */
    public FunctionHeader getHeader() {
        return header;
    }
    /**
     *  Function header.<p> If an application omits some header parameters required by the contract's ABI, the library will set the default values for them.
     */
    public void setHeader(FunctionHeader value) {
        header = value;
    }

    @JsonProperty("input")
    private Object input;
    /**
     *  Function input parameters according to ABI.
     */
    public Object getInput() {
        return input;
    }
    /**
     *  Function input parameters according to ABI.
     */
    public void setInput(Object value) {
        input = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((functionName==null?null:("\"function_name\":\""+functionName+"\"")),(header==null?null:("\"header\":"+header)),(input==null?null:("\"input\":"+input))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}