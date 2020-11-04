package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class DecodedMessageBody {
    public DecodedMessageBody() {
    }

    public DecodedMessageBody(Object bodyType, String name, Object value, FunctionHeader header) {

        this.bodyType = bodyType;

        this.name = name;

        this.value = value;

        this.header = header;

    }



    @JsonProperty("body_type")
    private Object bodyType;
    /**
     *  Type of the message body content.
     */
    public Object getBodyType() {
        return bodyType;
    }
    /**
     *  Type of the message body content.
     */
    public void setBodyType(Object value) {
        bodyType = value;
    }

    @JsonProperty("name")
    private String name;
    /**
     *  Function or event name.
     */
    public String getName() {
        return name;
    }
    /**
     *  Function or event name.
     */
    public void setName(String value) {
        name = value;
    }

    @JsonProperty("value")
    private Object value;
    /**
     *  Parameters or result value.
     */
    public Object getValue() {
        return value;
    }
    /**
     *  Parameters or result value.
     */
    public void setValue(Object value) {
        value = value;
    }

    @JsonProperty("header")
    private FunctionHeader header;
    /**
     *  Function header.
     */
    public FunctionHeader getHeader() {
        return header;
    }
    /**
     *  Function header.
     */
    public void setHeader(FunctionHeader value) {
        header = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((bodyType==null?null:("\"body_type\":"+bodyType)),(name==null?null:("\"name\":\""+name+"\"")),(value==null?null:("\"value\":"+value)),(header==null?null:("\"header\":"+header))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}