package com.radiance.tonclient;

/**
 *  
 */
public class CallSet {

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

    private String input;
    /**
     *  Function input parameters according to ABI.
     */
    public String getInput() {
        return input;
    }
    /**
     *  Function input parameters according to ABI.
     */
    public void setInput(String value) {
        input = value;
    }


    @Override
    public String toString() {
        return "{\"function_name\":\""+functionName+"\",\"header\":"+header+",\"input\":\""+input+"\"}";
    }
}