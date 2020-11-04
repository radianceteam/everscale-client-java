package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class KeyPair {
    public KeyPair() {
    }

    public KeyPair(String _public, String secret) {

        this._public = _public;

        this.secret = secret;

    }



    @JsonProperty("public")
    private String _public;
    /**
     *  Public key - 64 symbols hex string
     */
    public String getPublic() {
        return _public;
    }
    /**
     *  Public key - 64 symbols hex string
     */
    public void setPublic(String value) {
        _public = value;
    }

    @JsonProperty("secret")
    private String secret;
    /**
     *  Private key - u64 symbols hex string
     */
    public String getSecret() {
        return secret;
    }
    /**
     *  Private key - u64 symbols hex string
     */
    public void setSecret(String value) {
        secret = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((_public==null?null:("\"public\":\""+_public+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}