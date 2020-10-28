package com.radiance.tonclient;

/**
 *  
 */
public class ResultOfEncodeMessage {

    private String message;
    /**
     *  Message BOC encoded with `base64`.
     */
    public String getMessage() {
        return message;
    }
    /**
     *  Message BOC encoded with `base64`.
     */
    public void setMessage(String value) {
        message = value;
    }

    private String dataToSign;
    /**
     *  Optional data to be signed encoded in `base64`.<p> Returned in case of `Signer::External`. Can be used for external message signing. Is this case you need to use this data to create signature and then produce signed message using `abi.attach_signature`.
     */
    public String getDataToSign() {
        return dataToSign;
    }
    /**
     *  Optional data to be signed encoded in `base64`.<p> Returned in case of `Signer::External`. Can be used for external message signing. Is this case you need to use this data to create signature and then produce signed message using `abi.attach_signature`.
     */
    public void setDataToSign(String value) {
        dataToSign = value;
    }

    private String address;
    /**
     *  Destination address.
     */
    public String getAddress() {
        return address;
    }
    /**
     *  Destination address.
     */
    public void setAddress(String value) {
        address = value;
    }

    private String messageId;
    /**
     *  Message id.
     */
    public String getMessageId() {
        return messageId;
    }
    /**
     *  Message id.
     */
    public void setMessageId(String value) {
        messageId = value;
    }


    @Override
    public String toString() {
        return "{\"message\":\""+message+"\",\"data_to_sign\":\""+dataToSign+"\",\"address\":\""+address+"\",\"message_id\":\""+messageId+"\"}";
    }
}