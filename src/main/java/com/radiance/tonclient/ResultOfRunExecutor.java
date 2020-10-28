package com.radiance.tonclient;

/**
 *  
 */
public class ResultOfRunExecutor {

    private String transaction;
    /**
     *  Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
     */
    public String getTransaction() {
        return transaction;
    }
    /**
     *  Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
     */
    public void setTransaction(String value) {
        transaction = value;
    }

    private String outMessages;
    /**
     *  List of output messages' BOCs. Encoded as `base64`
     */
    public String getOutMessages() {
        return outMessages;
    }
    /**
     *  List of output messages' BOCs. Encoded as `base64`
     */
    public void setOutMessages(String value) {
        outMessages = value;
    }

    private DecodedOutput decoded;
    /**
     *  Optional decoded message bodies according to the optional `abi` parameter.
     */
    public DecodedOutput getDecoded() {
        return decoded;
    }
    /**
     *  Optional decoded message bodies according to the optional `abi` parameter.
     */
    public void setDecoded(DecodedOutput value) {
        decoded = value;
    }

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

    private String fees;
    /**
     *  Transaction fees
     */
    public String getFees() {
        return fees;
    }
    /**
     *  Transaction fees
     */
    public void setFees(String value) {
        fees = value;
    }


    @Override
    public String toString() {
        return "{\"transaction\":\""+transaction+"\",\"out_messages\":\""+outMessages+"\",\"decoded\":"+decoded+",\"account\":\""+account+"\",\"fees\":\""+fees+"\"}";
    }
}