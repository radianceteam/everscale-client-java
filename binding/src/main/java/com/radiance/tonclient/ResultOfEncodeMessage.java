package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ResultOfEncodeMessage {
    public ResultOfEncodeMessage() {
    }

    public ResultOfEncodeMessage(String message, String dataToSign, String address, String messageId) {

        this.message = message;

        this.dataToSign = dataToSign;

        this.address = address;

        this.messageId = messageId;

    }



    @JsonProperty("message")
    private String message;
    /**
     * Message BOC encoded with `base64`.
     */
    public String getMessage() {
        return message;
    }
    /**
     * Message BOC encoded with `base64`.
     */
    public void setMessage(String value) {
        message = value;
    }

    @JsonProperty("data_to_sign")
    private String dataToSign;
    /**
     * Optional data to be signed encoded in `base64`.<p> Returned in case of `Signer::External`. Can be used for external message signing. Is this case you need to use this data to create signature and then produce signed message using `abi.attach_signature`.
     */
    public String getDataToSign() {
        return dataToSign;
    }
    /**
     * Optional data to be signed encoded in `base64`.<p> Returned in case of `Signer::External`. Can be used for external message signing. Is this case you need to use this data to create signature and then produce signed message using `abi.attach_signature`.
     */
    public void setDataToSign(String value) {
        dataToSign = value;
    }

    @JsonProperty("address")
    private String address;
    /**
     * Destination address.
     */
    public String getAddress() {
        return address;
    }
    /**
     * Destination address.
     */
    public void setAddress(String value) {
        address = value;
    }

    @JsonProperty("message_id")
    private String messageId;
    /**
     * Message id.
     */
    public String getMessageId() {
        return messageId;
    }
    /**
     * Message id.
     */
    public void setMessageId(String value) {
        messageId = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(dataToSign==null?null:("\"data_to_sign\":\""+dataToSign+"\"")),(address==null?null:("\"address\":\""+address+"\"")),(messageId==null?null:("\"message_id\":\""+messageId+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}