package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class FunctionHeader {
    public FunctionHeader() {
    }

    public FunctionHeader(Number expire, Long time, String pubkey) {

        this.expire = expire;

        this.time = time;

        this.pubkey = pubkey;

    }



    @JsonProperty("expire")
    private Number expire;
    /**
     * Message expiration time in seconds.
     */
    public Number getExpire() {
        return expire;
    }
    /**
     * Message expiration time in seconds.
     */
    public void setExpire(Number value) {
        expire = value;
    }

    @JsonProperty("time")
    private Long time;
    /**
     * Message creation time in milliseconds.
     */
    public Long getTime() {
        return time;
    }
    /**
     * Message creation time in milliseconds.
     */
    public void setTime(Long value) {
        time = value;
    }

    @JsonProperty("pubkey")
    private String pubkey;
    /**
     * Public key used to sign message. Encoded with `hex`.
     */
    public String getPubkey() {
        return pubkey;
    }
    /**
     * Public key used to sign message. Encoded with `hex`.
     */
    public void setPubkey(String value) {
        pubkey = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((expire==null?null:("\"expire\":"+expire)),(time==null?null:("\"time\":"+time)),(pubkey==null?null:("\"pubkey\":\""+pubkey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}