package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ResultOfRunExecutor {
    public ResultOfRunExecutor() {
    }

    public ResultOfRunExecutor(Object transaction, String[] outMessages, Object decoded, String account, Object fees) {

        this.transaction = transaction;

        this.outMessages = outMessages;

        this.decoded = decoded;

        this.account = account;

        this.fees = fees;

    }



    @JsonProperty("transaction")
    private Object transaction;
    /**
     *  Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
     */
    public Object getTransaction() {
        return transaction;
    }
    /**
     *  Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
     */
    public void setTransaction(Object value) {
        transaction = value;
    }

    @JsonProperty("out_messages")
    private String[] outMessages;
    /**
     *  List of output messages' BOCs. Encoded as `base64`
     */
    public String[] getOutMessages() {
        return outMessages;
    }
    /**
     *  List of output messages' BOCs. Encoded as `base64`
     */
    public void setOutMessages(String[] value) {
        outMessages = value;
    }

    @JsonProperty("decoded")
    private Object decoded;
    /**
     *  Optional decoded message bodies according to the optional `abi` parameter.
     */
    public Object getDecoded() {
        return decoded;
    }
    /**
     *  Optional decoded message bodies according to the optional `abi` parameter.
     */
    public void setDecoded(Object value) {
        decoded = value;
    }

    @JsonProperty("account")
    private String account;
    /**
     *  Updated account state BOC. Encoded as `base64`
     */
    public String getAccount() {
        return account;
    }
    /**
     *  Updated account state BOC. Encoded as `base64`
     */
    public void setAccount(String value) {
        account = value;
    }

    @JsonProperty("fees")
    private Object fees;
    /**
     *  Transaction fees
     */
    public Object getFees() {
        return fees;
    }
    /**
     *  Transaction fees
     */
    public void setFees(Object value) {
        fees = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((transaction==null?null:("\"transaction\":"+transaction)),(outMessages==null?null:("\"out_messages\":\""+outMessages+"\"")),(decoded==null?null:("\"decoded\":"+decoded)),(account==null?null:("\"account\":\""+account+"\"")),(fees==null?null:("\"fees\":"+fees))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}