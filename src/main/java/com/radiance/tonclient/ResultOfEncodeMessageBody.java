package com.radiance.tonclient;

/**
 *  
 */
public class ResultOfEncodeMessageBody {

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
        return "{\"body\":\""+body+"\",\"data_to_sign\":\""+dataToSign+"\"}";
    }
}