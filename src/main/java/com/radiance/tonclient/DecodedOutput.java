package com.radiance.tonclient;

/**
 *  
 */
public class DecodedOutput {

    private DecodedMessageBody outMessages;
    /**
     *  Decoded bodies of the out messages.<p> If the message can't be decoded then `None` will be stored in the appropriate position.
     */
    public DecodedMessageBody getOutMessages() {
        return outMessages;
    }
    /**
     *  Decoded bodies of the out messages.<p> If the message can't be decoded then `None` will be stored in the appropriate position.
     */
    public void setOutMessages(DecodedMessageBody value) {
        outMessages = value;
    }

    private String output;
    /**
     *  Decoded body of the function output message.
     */
    public String getOutput() {
        return output;
    }
    /**
     *  Decoded body of the function output message.
     */
    public void setOutput(String value) {
        output = value;
    }


    @Override
    public String toString() {
        return "{\"out_messages\":"+outMessages+",\"output\":\""+output+"\"}";
    }
}