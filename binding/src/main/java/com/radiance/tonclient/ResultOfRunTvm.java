package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ResultOfRunTvm {
    public ResultOfRunTvm() {
    }

    public ResultOfRunTvm(String[] outMessages, Object decoded, String account) {

        this.outMessages = outMessages;

        this.decoded = decoded;

        this.account = account;

    }



    @JsonProperty("out_messages")
    private String[] outMessages;
    /**
     * List of output messages' BOCs. Encoded as `base64`
     */
    public String[] getOutMessages() {
        return outMessages;
    }
    /**
     * List of output messages' BOCs. Encoded as `base64`
     */
    public void setOutMessages(String[] value) {
        outMessages = value;
    }

    @JsonProperty("decoded")
    private Object decoded;
    /**
     * Optional decoded message bodies according to the optional `abi` parameter.
     */
    public Object getDecoded() {
        return decoded;
    }
    /**
     * Optional decoded message bodies according to the optional `abi` parameter.
     */
    public void setDecoded(Object value) {
        decoded = value;
    }

    @JsonProperty("account")
    private String account;
    /**
     * Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
     */
    public String getAccount() {
        return account;
    }
    /**
     * Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
     */
    public void setAccount(String value) {
        account = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((outMessages==null?null:("\"out_messages\":\""+outMessages+"\"")),(decoded==null?null:("\"decoded\":"+decoded)),(account==null?null:("\"account\":\""+account+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}