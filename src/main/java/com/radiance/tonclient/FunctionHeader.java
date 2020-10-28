package com.radiance.tonclient;

/**
 *   The ABI function header.<p> Includes several hidden function parameters that contract uses for security and replay protection reasons.<p> The actual set of header fields depends on the contract's ABI.
 */
public class FunctionHeader {

    private Number expire;
    /**
     *  Message expiration time in seconds.
     */
    public Number getExpire() {
        return expire;
    }
    /**
     *  Message expiration time in seconds.
     */
    public void setExpire(Number value) {
        expire = value;
    }

    private Long time;
    /**
     *  Message creation time in milliseconds.
     */
    public Long getTime() {
        return time;
    }
    /**
     *  Message creation time in milliseconds.
     */
    public void setTime(Long value) {
        time = value;
    }

    private String pubkey;
    /**
     *  Public key used to sign message. Encoded with `hex`.
     */
    public String getPubkey() {
        return pubkey;
    }
    /**
     *  Public key used to sign message. Encoded with `hex`.
     */
    public void setPubkey(String value) {
        pubkey = value;
    }


    @Override
    public String toString() {
        return "{\"expire\":"+expire+",\"time\":"+time+",\"pubkey\":\""+pubkey+"\"}";
    }
}