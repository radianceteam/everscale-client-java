package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ResultOfAttachSignature {
    public ResultOfAttachSignature() {
    }

    public ResultOfAttachSignature(String message, String messageId) {

        this.message = message;

        this.messageId = messageId;

    }



    @JsonProperty("message")
    private String message;
    /**
     * Signed message BOC
     */
    public String getMessage() {
        return message;
    }
    /**
     * Signed message BOC
     */
    public void setMessage(String value) {
        message = value;
    }

    @JsonProperty("message_id")
    private String messageId;
    /**
     * Message ID
     */
    public String getMessageId() {
        return messageId;
    }
    /**
     * Message ID
     */
    public void setMessageId(String value) {
        messageId = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(messageId==null?null:("\"message_id\":\""+messageId+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}