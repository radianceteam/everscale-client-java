package com.radiance.tonclient;

/**
 *  
 */
public class ResultOfAttachSignature {

    private String message;
    /**
     *  Signed message BOC
     */
    public String getMessage() {
        return message;
    }
    /**
     *  Signed message BOC
     */
    public void setMessage(String value) {
        message = value;
    }

    private String messageId;
    /**
     *  Message ID
     */
    public String getMessageId() {
        return messageId;
    }
    /**
     *  Message ID
     */
    public void setMessageId(String value) {
        messageId = value;
    }


    @Override
    public String toString() {
        return "{\"message\":\""+message+"\",\"message_id\":\""+messageId+"\"}";
    }
}