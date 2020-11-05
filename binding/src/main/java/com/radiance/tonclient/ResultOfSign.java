package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ResultOfSign {
    public ResultOfSign() {
    }

    public ResultOfSign(String signed, String signature) {

        this.signed = signed;

        this.signature = signature;

    }



    @JsonProperty("signed")
    private String signed;
    /**
     *  Signed data combined with signature encoded in `base64`.
     */
    public String getSigned() {
        return signed;
    }
    /**
     *  Signed data combined with signature encoded in `base64`.
     */
    public void setSigned(String value) {
        signed = value;
    }

    @JsonProperty("signature")
    private String signature;
    /**
     *  Signature encoded in `hex`.
     */
    public String getSignature() {
        return signature;
    }
    /**
     *  Signature encoded in `hex`.
     */
    public void setSignature(String value) {
        signature = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}