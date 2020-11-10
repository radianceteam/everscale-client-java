package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AddressStringFormat {

    public static final AccountId AccountId = new AccountId();

/**
 *  
 */
public static class AccountId extends AddressStringFormat {
    public AccountId() {
    }




    @Override
    public String toString() {
        return "{"+"\"type\":\"AccountId\""+"}";
    }
}

    public static final Hex Hex = new Hex();

/**
 *  
 */
public static class Hex extends AddressStringFormat {
    public Hex() {
    }




    @Override
    public String toString() {
        return "{"+"\"type\":\"Hex\""+"}";
    }
}

/**
 *  
 */
public static class Base64 extends AddressStringFormat {
    public Base64() {
    }

    public Base64(Boolean url, Boolean test, Boolean bounce) {

        this.url = url;

        this.test = test;

        this.bounce = bounce;

    }



    @JsonProperty("url")
    private Boolean url;
    /**
     * 
     */
    public Boolean getUrl() {
        return url;
    }
    /**
     * 
     */
    public void setUrl(Boolean value) {
        url = value;
    }

    @JsonProperty("test")
    private Boolean test;
    /**
     * 
     */
    public Boolean getTest() {
        return test;
    }
    /**
     * 
     */
    public void setTest(Boolean value) {
        test = value;
    }

    @JsonProperty("bounce")
    private Boolean bounce;
    /**
     * 
     */
    public Boolean getBounce() {
        return bounce;
    }
    /**
     * 
     */
    public void setBounce(Boolean value) {
        bounce = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"Base64\"",(url==null?null:("\"url\":"+url)),(test==null?null:("\"test\":"+test)),(bounce==null?null:("\"bounce\":"+bounce))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}
}