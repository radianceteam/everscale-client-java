package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ResultOfEncodeMessageBody {
    public ResultOfEncodeMessageBody() {
    }

    public ResultOfEncodeMessageBody(String body, String dataToSign) {

        this.body = body;

        this.dataToSign = dataToSign;

    }



    @JsonProperty("body")
    private String body;
    /**
     *  Message body BOC encoded with `base64`.
     */
    public String getBody() {
        return body;
    }
    /**
     *  Message body BOC encoded with `base64`.
     */
    public void setBody(String value) {
        body = value;
    }

    @JsonProperty("data_to_sign")
    private String dataToSign;
    /**
     *  Optional data to sign. Encoded with `base64`.<p> Presents when `message` is unsigned. Can be used for external message signing. Is this case you need to sing this data and produce signed message using `abi.attach_signature`.
     */
    public String getDataToSign() {
        return dataToSign;
    }
    /**
     *  Optional data to sign. Encoded with `base64`.<p> Presents when `message` is unsigned. Can be used for external message signing. Is this case you need to sing this data and produce signed message using `abi.attach_signature`.
     */
    public void setDataToSign(String value) {
        dataToSign = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((body==null?null:("\"body\":\""+body+"\"")),(dataToSign==null?null:("\"data_to_sign\":\""+dataToSign+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}