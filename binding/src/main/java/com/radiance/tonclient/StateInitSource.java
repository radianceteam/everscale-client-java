package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class StateInitSource {

/**
 *  Deploy message.
 */
public static class Message extends StateInitSource {
    public Message() {
    }

    public Message(Object source) {

        this.source = source;

    }



    @JsonProperty("source")
    private Object source;
    /**
     * 
     */
    public Object getSource() {
        return source;
    }
    /**
     * 
     */
    public void setSource(Object value) {
        source = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"Message\"",(source==null?null:("\"source\":"+source))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}

/**
 *  State init data.
 */
public static class StateInit extends StateInitSource {
    public StateInit() {
    }

    public StateInit(String code, String data, String library) {

        this.code = code;

        this.data = data;

        this.library = library;

    }



    @JsonProperty("code")
    private String code;
    /**
     * Code BOC. Encoded in `base64`.
     */
    public String getCode() {
        return code;
    }
    /**
     * Code BOC. Encoded in `base64`.
     */
    public void setCode(String value) {
        code = value;
    }

    @JsonProperty("data")
    private String data;
    /**
     * Data BOC. Encoded in `base64`.
     */
    public String getData() {
        return data;
    }
    /**
     * Data BOC. Encoded in `base64`.
     */
    public void setData(String value) {
        data = value;
    }

    @JsonProperty("library")
    private String library;
    /**
     * Library BOC. Encoded in `base64`.
     */
    public String getLibrary() {
        return library;
    }
    /**
     * Library BOC. Encoded in `base64`.
     */
    public void setLibrary(String value) {
        library = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"StateInit\"",(code==null?null:("\"code\":\""+code+"\"")),(data==null?null:("\"data\":\""+data+"\"")),(library==null?null:("\"library\":\""+library+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}

/**
 *  Content of the TVC file. Encoded in `base64`.
 */
public static class Tvc extends StateInitSource {
    public Tvc() {
    }

    public Tvc(String tvc, String publicKey, Object initParams) {

        this.tvc = tvc;

        this.publicKey = publicKey;

        this.initParams = initParams;

    }



    @JsonProperty("tvc")
    private String tvc;
    /**
     * 
     */
    public String getTvc() {
        return tvc;
    }
    /**
     * 
     */
    public void setTvc(String value) {
        tvc = value;
    }

    @JsonProperty("public_key")
    private String publicKey;
    /**
     * 
     */
    public String getPublicKey() {
        return publicKey;
    }
    /**
     * 
     */
    public void setPublicKey(String value) {
        publicKey = value;
    }

    @JsonProperty("init_params")
    private Object initParams;
    /**
     * 
     */
    public Object getInitParams() {
        return initParams;
    }
    /**
     * 
     */
    public void setInitParams(Object value) {
        initParams = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"Tvc\"",(tvc==null?null:("\"tvc\":\""+tvc+"\"")),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(initParams==null?null:("\"init_params\":"+initParams))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}
}