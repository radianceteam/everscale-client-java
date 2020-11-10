package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Abi {

/**
 *  
 */
public static class Serialized extends Abi {
    public Serialized() {
    }

    public Serialized(Object value) {

        this.value = value;

    }



    @JsonProperty("value")
    private Object value;
    /**
     * 
     */
    public Object getValue() {
        return value;
    }
    /**
     * 
     */
    public void setValue(Object value) {
        value = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"Serialized\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}

/**
 *  
 */
public static class Handle extends Abi {
    public Handle() {
    }

    public Handle(Object value) {

        this.value = value;

    }



    @JsonProperty("value")
    private Object value;
    /**
     * 
     */
    public Object getValue() {
        return value;
    }
    /**
     * 
     */
    public void setValue(Object value) {
        value = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"Handle\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}
}