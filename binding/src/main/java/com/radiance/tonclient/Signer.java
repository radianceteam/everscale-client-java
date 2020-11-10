package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Signer {

    public static final None None = new None();

/**
 *  No keys are provided. Creates an unsigned message.
 */
public static class None extends Signer {
    public None() {
    }




    @Override
    public String toString() {
        return "{"+"\"type\":\"None\""+"}";
    }
}

/**
 *  Only public key is provided to generate unsigned message and `data_to_sign` which can be signed later.
 */
public static class External extends Signer {
    public External() {
    }

    public External(String publicKey) {

        this.publicKey = publicKey;

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


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"External\"",(publicKey==null?null:("\"public_key\":\""+publicKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}

/**
 *  Key pair is provided for signing
 */
public static class Keys extends Signer {
    public Keys() {
    }

    public Keys(KeyPair keys) {

        this.keys = keys;

    }



    @JsonProperty("keys")
    private KeyPair keys;
    /**
     * 
     */
    public KeyPair getKeys() {
        return keys;
    }
    /**
     * 
     */
    public void setKeys(KeyPair value) {
        keys = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"Keys\"",(keys==null?null:("\"keys\":"+keys))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}

/**
 *  Signing Box interface is provided for signing, allows Dapps to sign messages using external APIs, such as HSM, cold wallet, etc.
 */
public static class SigningBox extends Signer {
    public SigningBox() {
    }

    public SigningBox(Object handle) {

        this.handle = handle;

    }



    @JsonProperty("handle")
    private Object handle;
    /**
     * 
     */
    public Object getHandle() {
        return handle;
    }
    /**
     * 
     */
    public void setHandle(Object value) {
        handle = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"SigningBox\"",(handle==null?null:("\"handle\":"+handle))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}
}