package com.radiance.tonclient;

/**
 *  
 */
public class ResultOfSign {

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
        return "{\"signed\":\""+signed+"\",\"signature\":\""+signature+"\"}";
    }
}