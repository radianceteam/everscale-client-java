package com.radiance.tonclient;

/**
 *  
 */
public class DecodedMessageBody {

    private MessageBodyType bodyType;
    /**
     *  Type of the message body content.
     */
    public MessageBodyType getBodyType() {
        return bodyType;
    }
    /**
     *  Type of the message body content.
     */
    public void setBodyType(MessageBodyType value) {
        bodyType = value;
    }

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

    private String value;
    /**
     *  Parameters or result value.
     */
    public String getValue() {
        return value;
    }
    /**
     *  Parameters or result value.
     */
    public void setValue(String value) {
        value = value;
    }

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
        return "{\"body_type\":"+bodyType+",\"name\":\""+name+"\",\"value\":\""+value+"\",\"header\":"+header+"}";
    }
}