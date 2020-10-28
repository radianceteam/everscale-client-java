package com.radiance.tonclient;

/**
 *  
 */
public class ClientError {

    private Number code;
    /**
     * 
     */
    public Number getCode() {
        return code;
    }
    /**
     * 
     */
    public void setCode(Number value) {
        code = value;
    }

    private String message;
    /**
     * 
     */
    public String getMessage() {
        return message;
    }
    /**
     * 
     */
    public void setMessage(String value) {
        message = value;
    }

    private String data;
    /**
     * 
     */
    public String getData() {
        return data;
    }
    /**
     * 
     */
    public void setData(String value) {
        data = value;
    }


    @Override
    public String toString() {
        return "{\"code\":"+code+",\"message\":\""+message+"\",\"data\":\""+data+"\"}";
    }
}