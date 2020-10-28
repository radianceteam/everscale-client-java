package com.radiance.tonclient;

/**
 *  
 */
public class KeyPair {

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
        return "{\"public\":\""+_public+"\",\"secret\":\""+secret+"\"}";
    }
}