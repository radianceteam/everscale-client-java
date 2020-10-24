package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

/**
 *   Provides message encoding and decoding according to the ABI specification.
 */
public class Abi {

    public static class ResultOfEncodeMessageBody {

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

        private String data_to_sign;
        /**
         *  Optional data to sign. Encoded with `base64`.<p> Presents when `message` is unsigned. Can be used for external message signing. Is this case you need to sing this data and produce signed message using `abi.attach_signature`.
         */
        public String getDataToSign() {
            return data_to_sign;
        }
        /**
         *  Optional data to sign. Encoded with `base64`.<p> Presents when `message` is unsigned. Can be used for external message signing. Is this case you need to sing this data and produce signed message using `abi.attach_signature`.
         */
        public void setDataToSign(String value) {
            data_to_sign = value;
        }

    }

    public static class ResultOfEncodeMessage {

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

        private String data_to_sign;
        /**
         *  Optional data to be signed encoded in `base64`.<p> Returned in case of `Signer::External`. Can be used for external message signing. Is this case you need to use this data to create signature and then produce signed message using `abi.attach_signature`.
         */
        public String getDataToSign() {
            return data_to_sign;
        }
        /**
         *  Optional data to be signed encoded in `base64`.<p> Returned in case of `Signer::External`. Can be used for external message signing. Is this case you need to use this data to create signature and then produce signed message using `abi.attach_signature`.
         */
        public void setDataToSign(String value) {
            data_to_sign = value;
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

        private String message_id;
        /**
         *  Message id.
         */
        public String getMessageId() {
            return message_id;
        }
        /**
         *  Message id.
         */
        public void setMessageId(String value) {
            message_id = value;
        }

    }

    public static class ResultOfAttachSignature {

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

        private String message_id;
        /**
         *  Message ID
         */
        public String getMessageId() {
            return message_id;
        }
        /**
         *  Message ID
         */
        public void setMessageId(String value) {
            message_id = value;
        }

    }

    public static class DecodedMessageBody {

        private String body_type;
        /**
         *  Type of the message body content.
         */
        public String getBodyType() {
            return body_type;
        }
        /**
         *  Type of the message body content.
         */
        public void setBodyType(String value) {
            body_type = value;
        }

        private String name;
        /**
         *  Function or event name.
         */
        public String getName() {
            return name;
        }
        /**
         *  Function or event name.
         */
        public void setName(String value) {
            name = value;
        }

        private String value;
        /**
         *  Parameters or result value.
         */
        public String getValue() {
            return value;
        }
        /**
         *  Parameters or result value.
         */
        public void setValue(String value) {
            value = value;
        }

        private String header;
        /**
         *  Function header.
         */
        public String getHeader() {
            return header;
        }
        /**
         *  Function header.
         */
        public void setHeader(String value) {
            header = value;
        }

    }

    public static class ResultOfEncodeAccount {

        private String account;
        /**
         *  Account BOC encoded in `base64`.
         */
        public String getAccount() {
            return account;
        }
        /**
         *  Account BOC encoded in `base64`.
         */
        public void setAccount(String value) {
            account = value;
        }

        private String id;
        /**
         *  Account ID  encoded in `hex`.
         */
        public String getId() {
            return id;
        }
        /**
         *  Account ID  encoded in `hex`.
         */
        public void setId(String value) {
            id = value;
        }

    }

    
    private TONContext context;

    public Abi(TONContext context) {
        this.context = context;
    }

  /**
   *  Encodes message body according to ABI function call.
   *
   * @param abi  Contract ABI.
   * @param callSet  Function call parameters.

 Must be specified in non deploy message.

 In case of deploy message contains parameters of constructor.
   * @param isInternal  True if internal message body must be encoded.
   * @param signer  Signing parameters.
   * @param processingTryIndex  Processing try index.

 Used in message processing with retries.

 Encoder uses the provided try index to calculate message
 expiration time.

 Expiration timeouts will grow with every retry.

 Default value is 0.
   */
    public CompletableFuture<ResultOfEncodeMessageBody> encodeMessageBody(String abi, String callSet, Boolean isInternal, String signer, Number processingTryIndex) {
        return context.requestValue("abi.encode_message_body", "{" + String.join(",", new String[]{"\"abi\":\""+abi+"\"","\"call_set\":\""+callSet+"\"","\"is_internal\":"+isInternal,"\"signer\":\""+signer+"\"","\"processing_try_index\":"+processingTryIndex}) + "}", ResultOfEncodeMessageBody.class);
    }

  /**
   * 
   *
   * @param abi  Contract ABI
   * @param publicKey  Public key. Must be encoded with `hex`.
   * @param message  Unsigned message BOC. Must be encoded with `base64`.
   * @param signature  Signature. Must be encoded with `hex`.
   */
    public CompletableFuture<String> attachSignatureToMessageBody(String abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature_to_message_body", "{" + String.join(",", new String[]{"\"abi\":\""+abi+"\"","\"public_key\":\""+publicKey+"\"","\"message\":\""+message+"\"","\"signature\":\""+signature+"\""}) + "}")
            .thenApply(json -> json.findValue("body").asText());
    }

  /**
   *  Encodes an ABI-compatible message <p> Allows to encode deploy and function call messages, both signed and unsigned.<p> Use cases include messages of any possible type: - deploy with initial function call (i.e. `constructor` or any other function that is used for some kind of initialization); - deploy without initial function call; - signed/unsigned + data for signing. <p> `Signer` defines how the message should or shouldn't be signed:<p> `Signer::None` creates an unsigned message. This may be needed in case of some public methods,  that do not require authorization by pubkey. <p> `Signer::External` takes public key and returns `data_to_sign` for later signing.  Use `attach_signature` method with the result signature to get the signed message.<p> `Signer::Keys` creates a signed message with provided key pair. <p> <a target="_blank" href="SOON">SOON</a> `Signer::SigningBox` Allows using a special interface to imlepement signing  without private key disclosure to SDK. For instance, in case of using a cold wallet or HSM,  when application calls some API to sign data. 
   *
   * @param abi  Contract ABI.
   * @param address  Target address the message will be sent to.

 Must be specified in case of non-deploy message. 
   * @param deploySet  Deploy parameters.

 Must be specified in case of deploy message.
   * @param callSet  Function call parameters.

 Must be specified in case of non-deploy message.

 In case of deploy message it is optional and contains parameters  
 of the functions that will to be called upon deploy transaction.
   * @param signer  Signing parameters.
   * @param processingTryIndex  Processing try index.

 Used in message processing with retries (if contract's ABI includes "expire" header).

 Encoder uses the provided try index to calculate message
 expiration time. The 1st message expiration time is specified in
 Client config.

 Expiration timeouts will grow with every retry. 
 Retry grow factor is set in Client config:
 <.....add config parameter with default value here>

 Default value is 0.
   */
    public CompletableFuture<ResultOfEncodeMessage> encodeMessage(String abi, String address, String deploySet, String callSet, String signer, Number processingTryIndex) {
        return context.requestValue("abi.encode_message", "{" + String.join(",", new String[]{"\"abi\":\""+abi+"\"","\"address\":\""+address+"\"","\"deploy_set\":\""+deploySet+"\"","\"call_set\":\""+callSet+"\"","\"signer\":\""+signer+"\"","\"processing_try_index\":"+processingTryIndex}) + "}", ResultOfEncodeMessage.class);
    }

  /**
   *  Combines `hex`-encoded `signature` with `base64`-encoded `unsigned_message`. Returns signed message encoded in `base64`.
   *
   * @param abi  Contract ABI
   * @param publicKey  Public key encoded in `hex`.
   * @param message  Unsigned message BOC encoded in `base64`.
   * @param signature  Signature encoded in `hex`.
   */
    public CompletableFuture<ResultOfAttachSignature> attachSignature(String abi, String publicKey, String message, String signature) {
        return context.requestValue("abi.attach_signature", "{" + String.join(",", new String[]{"\"abi\":\""+abi+"\"","\"public_key\":\""+publicKey+"\"","\"message\":\""+message+"\"","\"signature\":\""+signature+"\""}) + "}", ResultOfAttachSignature.class);
    }

  /**
   *  Decodes message body using provided message BOC and ABI.
   *
   * @param abi  contract ABI
   * @param message  Message BOC
   */
    public CompletableFuture<DecodedMessageBody> decodeMessage(String abi, String message) {
        return context.requestValue("abi.decode_message", "{" + String.join(",", new String[]{"\"abi\":\""+abi+"\"","\"message\":\""+message+"\""}) + "}", DecodedMessageBody.class);
    }

  /**
   *  Decodes message body using provided body BOC and ABI.
   *
   * @param abi  Contract ABI used to decode.
   * @param body  Message body BOC encoded in `base64`.
   * @param isInternal  True if the body belongs to the internal message.
   */
    public CompletableFuture<DecodedMessageBody> decodeMessageBody(String abi, String body, Boolean isInternal) {
        return context.requestValue("abi.decode_message_body", "{" + String.join(",", new String[]{"\"abi\":\""+abi+"\"","\"body\":\""+body+"\"","\"is_internal\":"+isInternal}) + "}", DecodedMessageBody.class);
    }

  /**
   *  Creates account state BOC<p> Creates account state provided with one of these sets of data : 1. BOC of code, BOC of data, BOC of library 2. TVC (string in `base64`), keys, init params
   *
   * @param stateInit  Source of the account state init.
   * @param balance  Initial balance.
   * @param lastTransLt  Initial value for the `last_trans_lt`.
   * @param lastPaid  Initial value for the `last_paid`.
   */
    public CompletableFuture<ResultOfEncodeAccount> encodeAccount(String stateInit, Long balance, Long lastTransLt, Number lastPaid) {
        return context.requestValue("abi.encode_account", "{" + String.join(",", new String[]{"\"state_init\":\""+stateInit+"\"","\"balance\":"+balance,"\"last_trans_lt\":"+lastTransLt,"\"last_paid\":"+lastPaid}) + "}", ResultOfEncodeAccount.class);
    }

}
