package com.radiance.tonclient;

/**
 *  
 */
public class ResultOfEncodeAccount {

    private String account;
    /**
     *  Account BOC encoded in `base64`.
     */
    public String getAccount() {
        return account;
    }
    /**
     *  Account BOC encoded in `base64`.
     */
    public void setAccount(String value) {
        account = value;
    }

    private String id;
    /**
     *  Account ID  encoded in `hex`.
     */
    public String getId() {
        return id;
    }
    /**
     *  Account ID  encoded in `hex`.
     */
    public void setId(String value) {
        id = value;
    }


    @Override
    public String toString() {
        return "{\"account\":\""+account+"\",\"id\":\""+id+"\"}";
    }
}