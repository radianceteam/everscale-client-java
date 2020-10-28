package com.radiance.tonclient;

/**
 *  
 */
public class StateInitParams {

    private String abi;
    /**
     * 
     */
    public String getAbi() {
        return abi;
    }
    /**
     * 
     */
    public void setAbi(String value) {
        abi = value;
    }

    private String value;
    /**
     * 
     */
    public String getValue() {
        return value;
    }
    /**
     * 
     */
    public void setValue(String value) {
        value = value;
    }


    @Override
    public String toString() {
        return "{\"abi\":\""+abi+"\",\"value\":\""+value+"\"}";
    }
}