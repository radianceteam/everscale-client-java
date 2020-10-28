package com.radiance.tonclient;

/**
 *  
 */
public class ResultOfRunTvm {

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
     *  Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
     */
    public String getAccount() {
        return account;
    }
    /**
     *  Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
     */
    public void setAccount(String value) {
        account = value;
    }


    @Override
    public String toString() {
        return "{\"out_messages\":\""+outMessages+"\",\"decoded\":"+decoded+",\"account\":\""+account+"\"}";
    }
}