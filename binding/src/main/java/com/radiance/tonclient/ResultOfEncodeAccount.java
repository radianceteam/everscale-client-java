package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ResultOfEncodeAccount {
    public ResultOfEncodeAccount() {
    }

    public ResultOfEncodeAccount(String account, String id) {

        this.account = account;

        this.id = id;

    }



    @JsonProperty("account")
    private String account;
    /**
     * Account BOC encoded in `base64`.
     */
    public String getAccount() {
        return account;
    }
    /**
     * Account BOC encoded in `base64`.
     */
    public void setAccount(String value) {
        account = value;
    }

    @JsonProperty("id")
    private String id;
    /**
     * Account ID  encoded in `hex`.
     */
    public String getId() {
        return id;
    }
    /**
     * Account ID  encoded in `hex`.
     */
    public void setId(String value) {
        id = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((account==null?null:("\"account\":\""+account+"\"")),(id==null?null:("\"id\":\""+id+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}