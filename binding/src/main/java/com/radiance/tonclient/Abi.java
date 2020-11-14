package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Provides message encoding and decoding according to the ABI specification.
 */
public class Abi {

    public static abstract class ABI {

    /**
     *  
     */
    public static class Contract extends ABI  {

        public Contract(Object value) {

            this.value = value;

        }
        public Contract() {

        }
/*        public Contract() {
        }

        public Contract(Object value) {

            this.value = value;

        }
*/


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Contract\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Json extends ABI  {

        public Json(String value) {

            this.value = value;

        }
        public Json() {

        }
/*        public Json() {
        }

        public Json(String value) {

            this.value = value;

        }
*/


        @JsonProperty("value")
        private String value;
        /**
         * 
         */
        public String getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Json\"",(value==null?null:("\"value\":\""+value+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Handle extends ABI  {

        public Handle(Object value) {

            this.value = value;

        }
        public Handle() {

        }
/*        public Handle() {
        }

        public Handle(Object value) {

            this.value = value;

        }
*/


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Handle\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Serialized extends ABI  {

        public Serialized(Object value) {

            this.value = value;

        }
        public Serialized() {

        }
/*        public Serialized() {
        }

        public Serialized(Object value) {

            this.value = value;

        }
*/


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Serialized\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    /**
     *  
     */
    public static class FunctionHeader  {

        public FunctionHeader(Number expire, Long time, String pubkey) {

            this.expire = expire;

            this.time = time;

            this.pubkey = pubkey;

        }
        public FunctionHeader(Number expire, Long time) {

            this.expire = expire;

            this.time = time;

        }
        public FunctionHeader(Number expire) {

            this.expire = expire;

        }
        public FunctionHeader() {

        }
/*        public FunctionHeader() {
        }

        public FunctionHeader(Number expire, Long time, String pubkey) {

            this.expire = expire;

            this.time = time;

            this.pubkey = pubkey;

        }
*/


        @JsonProperty("expire")
        private Number expire;
        /**
         * Message expiration time in seconds. If not specified - calculated automatically from message_expiration_timeout(), try_index and message_expiration_timeout_grow_factor() (if ABI includes `expire` header).
         */
        public Number getExpire() {
            return expire;
        }
        /**
         * Message expiration time in seconds. If not specified - calculated automatically from message_expiration_timeout(), try_index and message_expiration_timeout_grow_factor() (if ABI includes `expire` header).
         */
        public void setExpire(Number value) {
            this.expire = value;
        }

        @JsonProperty("time")
        private Long time;
        /**
         * Message creation time in milliseconds. If not specified, `now` is used (if ABI includes `time` header).
         */
        public Long getTime() {
            return time;
        }
        /**
         * Message creation time in milliseconds. If not specified, `now` is used (if ABI includes `time` header).
         */
        public void setTime(Long value) {
            this.time = value;
        }

        @JsonProperty("pubkey")
        private String pubkey;
        /**
         * Public key is used by the contract to check the signature. Encoded in `hex`. If not specified, method fails with exception (if ABI includes `pubkey` header)..
         */
        public String getPubkey() {
            return pubkey;
        }
        /**
         * Public key is used by the contract to check the signature. Encoded in `hex`. If not specified, method fails with exception (if ABI includes `pubkey` header)..
         */
        public void setPubkey(String value) {
            this.pubkey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((expire==null?null:("\"expire\":"+expire)),(time==null?null:("\"time\":"+time)),(pubkey==null?null:("\"pubkey\":\""+pubkey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class CallSet  {

        public CallSet(String functionName, FunctionHeader header, Object input) {

            this.functionName = functionName;

            this.header = header;

            this.input = input;

        }
        public CallSet(String functionName, FunctionHeader header) {

            this.functionName = functionName;

            this.header = header;

        }
        public CallSet(String functionName) {

            this.functionName = functionName;

        }
        public CallSet() {

        }
/*        public CallSet() {
        }

        public CallSet(String functionName, FunctionHeader header, Object input) {

            this.functionName = functionName;

            this.header = header;

            this.input = input;

        }
*/


        @JsonProperty("function_name")
        private String functionName;
        /**
         * Function name that is being called.
         */
        public String getFunctionName() {
            return functionName;
        }
        /**
         * Function name that is being called.
         */
        public void setFunctionName(String value) {
            this.functionName = value;
        }

        @JsonProperty("header")
        private FunctionHeader header;
        /**
         * Function header.<p> If an application omits some header parameters required by the contract's ABI, the library will set the default values for them.
         */
        public FunctionHeader getHeader() {
            return header;
        }
        /**
         * Function header.<p> If an application omits some header parameters required by the contract's ABI, the library will set the default values for them.
         */
        public void setHeader(FunctionHeader value) {
            this.header = value;
        }

        @JsonProperty("input")
        private Object input;
        /**
         * Function input parameters according to ABI.
         */
        public Object getInput() {
            return input;
        }
        /**
         * Function input parameters according to ABI.
         */
        public void setInput(Object value) {
            this.input = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((functionName==null?null:("\"function_name\":\""+functionName+"\"")),(header==null?null:("\"header\":"+header)),(input==null?null:("\"input\":"+input))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class DeploySet  {

        public DeploySet(String tvc, Number workchainId, Object initialData) {

            this.tvc = tvc;

            this.workchainId = workchainId;

            this.initialData = initialData;

        }
        public DeploySet(String tvc, Number workchainId) {

            this.tvc = tvc;

            this.workchainId = workchainId;

        }
        public DeploySet(String tvc) {

            this.tvc = tvc;

        }
        public DeploySet() {

        }
/*        public DeploySet() {
        }

        public DeploySet(String tvc, Number workchainId, Object initialData) {

            this.tvc = tvc;

            this.workchainId = workchainId;

            this.initialData = initialData;

        }
*/


        @JsonProperty("tvc")
        private String tvc;
        /**
         * Content of TVC file encoded in `base64`.
         */
        public String getTvc() {
            return tvc;
        }
        /**
         * Content of TVC file encoded in `base64`.
         */
        public void setTvc(String value) {
            this.tvc = value;
        }

        @JsonProperty("workchain_id")
        private Number workchainId;
        /**
         * Target workchain for destination address. Default is `0`.
         */
        public Number getWorkchainId() {
            return workchainId;
        }
        /**
         * Target workchain for destination address. Default is `0`.
         */
        public void setWorkchainId(Number value) {
            this.workchainId = value;
        }

        @JsonProperty("initial_data")
        private Object initialData;
        /**
         * List of initial values for contract's public variables.
         */
        public Object getInitialData() {
            return initialData;
        }
        /**
         * List of initial values for contract's public variables.
         */
        public void setInitialData(Object value) {
            this.initialData = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((tvc==null?null:("\"tvc\":\""+tvc+"\"")),(workchainId==null?null:("\"workchain_id\":"+workchainId)),(initialData==null?null:("\"initial_data\":"+initialData))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    public static abstract class Signer {

        public static final None None = new None();

    /**
     *  No keys are provided. Creates an unsigned message.
     */
    public static class None extends Signer  {

        public None() {

        }
/*        public None() {
        }
*/



        @Override
        public String toString() {
            return "{"+"\"type\":\"None\""+"}";
        }
    }

    /**
     *  Only public key is provided in unprefixed hex string format to generate unsigned message  and `data_to_sign` which can be signed later.
     */
    public static class External extends Signer  {

        public External(String publicKey) {

            this.publicKey = publicKey;

        }
        public External() {

        }
/*        public External() {
        }

        public External(String publicKey) {

            this.publicKey = publicKey;

        }
*/


        @JsonProperty("public_key")
        private String publicKey;
        /**
         * 
         */
        public String getPublicKey() {
            return publicKey;
        }
        /**
         * 
         */
        public void setPublicKey(String value) {
            this.publicKey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"External\"",(publicKey==null?null:("\"public_key\":\""+publicKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  Key pair is provided for signing
     */
    public static class Keys extends Signer  {

        public Keys(Crypto.KeyPair keys) {

            this.keys = keys;

        }
        public Keys() {

        }
/*        public Keys() {
        }

        public Keys(Crypto.KeyPair keys) {

            this.keys = keys;

        }
*/


        @JsonProperty("keys")
        private Crypto.KeyPair keys;
        /**
         * 
         */
        public Crypto.KeyPair getKeys() {
            return keys;
        }
        /**
         * 
         */
        public void setKeys(Crypto.KeyPair value) {
            this.keys = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Keys\"",(keys==null?null:("\"keys\":"+keys))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  Signing Box interface is provided for signing, allows Dapps to sign messages using external APIs, such as HSM, cold wallet, etc.
     */
    public static class SigningBox extends Signer  {

        public SigningBox(Object handle) {

            this.handle = handle;

        }
        public SigningBox() {

        }
/*        public SigningBox() {
        }

        public SigningBox(Object handle) {

            this.handle = handle;

        }
*/


        @JsonProperty("handle")
        private Object handle;
        /**
         * 
         */
        public Object getHandle() {
            return handle;
        }
        /**
         * 
         */
        public void setHandle(Object value) {
            this.handle = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"SigningBox\"",(handle==null?null:("\"handle\":"+handle))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}

    /**
     *  
     */
    public enum MessageBodyType {
        
        /**
         * Message contains the input of the ABI function.
         */
        Input,

        /**
         * Message contains the output of the ABI function.
         */
        Output,

        /**
         * Message contains the input of the imported ABI function.<p> Occurs when contract sends an internal message to other contract.
         */
        InternalOutput,

        /**
         * Message contains the input of the ABI event.
         */
        Event
    }
    public static abstract class StateInitSource {

    /**
     *  Deploy message.
     */
    public static class Message extends StateInitSource  {

        public Message(Object source) {

            this.source = source;

        }
        public Message() {

        }
/*        public Message() {
        }

        public Message(Object source) {

            this.source = source;

        }
*/


        @JsonProperty("source")
        private Object source;
        /**
         * 
         */
        public Object getSource() {
            return source;
        }
        /**
         * 
         */
        public void setSource(Object value) {
            this.source = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Message\"",(source==null?null:("\"source\":"+source))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  State init data.
     */
    public static class StateInit extends StateInitSource  {

        public StateInit(String code, String data, String library) {

            this.code = code;

            this.data = data;

            this.library = library;

        }
        public StateInit(String code, String data) {

            this.code = code;

            this.data = data;

        }
        public StateInit(String code) {

            this.code = code;

        }
        public StateInit() {

        }
/*        public StateInit() {
        }

        public StateInit(String code, String data, String library) {

            this.code = code;

            this.data = data;

            this.library = library;

        }
*/


        @JsonProperty("code")
        private String code;
        /**
         * Code BOC. Encoded in `base64`.
         */
        public String getCode() {
            return code;
        }
        /**
         * Code BOC. Encoded in `base64`.
         */
        public void setCode(String value) {
            this.code = value;
        }

        @JsonProperty("data")
        private String data;
        /**
         * Data BOC. Encoded in `base64`.
         */
        public String getData() {
            return data;
        }
        /**
         * Data BOC. Encoded in `base64`.
         */
        public void setData(String value) {
            this.data = value;
        }

        @JsonProperty("library")
        private String library;
        /**
         * Library BOC. Encoded in `base64`.
         */
        public String getLibrary() {
            return library;
        }
        /**
         * Library BOC. Encoded in `base64`.
         */
        public void setLibrary(String value) {
            this.library = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"StateInit\"",(code==null?null:("\"code\":\""+code+"\"")),(data==null?null:("\"data\":\""+data+"\"")),(library==null?null:("\"library\":\""+library+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  Content of the TVC file. Encoded in `base64`.
     */
    public static class Tvc extends StateInitSource  {

        public Tvc(String tvc, String publicKey, Object initParams) {

            this.tvc = tvc;

            this.publicKey = publicKey;

            this.initParams = initParams;

        }
        public Tvc(String tvc, String publicKey) {

            this.tvc = tvc;

            this.publicKey = publicKey;

        }
        public Tvc(String tvc) {

            this.tvc = tvc;

        }
        public Tvc() {

        }
/*        public Tvc() {
        }

        public Tvc(String tvc, String publicKey, Object initParams) {

            this.tvc = tvc;

            this.publicKey = publicKey;

            this.initParams = initParams;

        }
*/


        @JsonProperty("tvc")
        private String tvc;
        /**
         * 
         */
        public String getTvc() {
            return tvc;
        }
        /**
         * 
         */
        public void setTvc(String value) {
            this.tvc = value;
        }

        @JsonProperty("public_key")
        private String publicKey;
        /**
         * 
         */
        public String getPublicKey() {
            return publicKey;
        }
        /**
         * 
         */
        public void setPublicKey(String value) {
            this.publicKey = value;
        }

        @JsonProperty("init_params")
        private Object initParams;
        /**
         * 
         */
        public Object getInitParams() {
            return initParams;
        }
        /**
         * 
         */
        public void setInitParams(Object value) {
            this.initParams = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Tvc\"",(tvc==null?null:("\"tvc\":\""+tvc+"\"")),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(initParams==null?null:("\"init_params\":"+initParams))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    /**
     *  
     */
    public static class ResultOfEncodeMessageBody  {

        public ResultOfEncodeMessageBody(String body, String dataToSign) {

            this.body = body;

            this.dataToSign = dataToSign;

        }
        public ResultOfEncodeMessageBody(String body) {

            this.body = body;

        }
        public ResultOfEncodeMessageBody() {

        }
/*        public ResultOfEncodeMessageBody() {
        }

        public ResultOfEncodeMessageBody(String body, String dataToSign) {

            this.body = body;

            this.dataToSign = dataToSign;

        }
*/


        @JsonProperty("body")
        private String body;
        /**
         * Message body BOC encoded with `base64`.
         */
        public String getBody() {
            return body;
        }
        /**
         * Message body BOC encoded with `base64`.
         */
        public void setBody(String value) {
            this.body = value;
        }

        @JsonProperty("data_to_sign")
        private String dataToSign;
        /**
         * Optional data to sign. Encoded with `base64`.<p> Presents when `message` is unsigned. Can be used for external message signing. Is this case you need to sing this data and produce signed message using `abi.attach_signature`.
         */
        public String getDataToSign() {
            return dataToSign;
        }
        /**
         * Optional data to sign. Encoded with `base64`.<p> Presents when `message` is unsigned. Can be used for external message signing. Is this case you need to sing this data and produce signed message using `abi.attach_signature`.
         */
        public void setDataToSign(String value) {
            this.dataToSign = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((body==null?null:("\"body\":\""+body+"\"")),(dataToSign==null?null:("\"data_to_sign\":\""+dataToSign+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfEncodeMessage  {

        public ResultOfEncodeMessage(String message, String dataToSign, String address, String messageId) {

            this.message = message;

            this.dataToSign = dataToSign;

            this.address = address;

            this.messageId = messageId;

        }
        public ResultOfEncodeMessage(String message, String dataToSign, String address) {

            this.message = message;

            this.dataToSign = dataToSign;

            this.address = address;

        }
        public ResultOfEncodeMessage(String message, String dataToSign) {

            this.message = message;

            this.dataToSign = dataToSign;

        }
        public ResultOfEncodeMessage(String message) {

            this.message = message;

        }
        public ResultOfEncodeMessage() {

        }
/*        public ResultOfEncodeMessage() {
        }

        public ResultOfEncodeMessage(String message, String dataToSign, String address, String messageId) {

            this.message = message;

            this.dataToSign = dataToSign;

            this.address = address;

            this.messageId = messageId;

        }
*/


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
            this.message = value;
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
            this.dataToSign = value;
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
            this.address = value;
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
            this.messageId = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(dataToSign==null?null:("\"data_to_sign\":\""+dataToSign+"\"")),(address==null?null:("\"address\":\""+address+"\"")),(messageId==null?null:("\"message_id\":\""+messageId+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfAttachSignature  {

        public ResultOfAttachSignature(String message, String messageId) {

            this.message = message;

            this.messageId = messageId;

        }
        public ResultOfAttachSignature(String message) {

            this.message = message;

        }
        public ResultOfAttachSignature() {

        }
/*        public ResultOfAttachSignature() {
        }

        public ResultOfAttachSignature(String message, String messageId) {

            this.message = message;

            this.messageId = messageId;

        }
*/


        @JsonProperty("message")
        private String message;
        /**
         * Signed message BOC
         */
        public String getMessage() {
            return message;
        }
        /**
         * Signed message BOC
         */
        public void setMessage(String value) {
            this.message = value;
        }

        @JsonProperty("message_id")
        private String messageId;
        /**
         * Message ID
         */
        public String getMessageId() {
            return messageId;
        }
        /**
         * Message ID
         */
        public void setMessageId(String value) {
            this.messageId = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(messageId==null?null:("\"message_id\":\""+messageId+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class DecodedMessageBody  {

        public DecodedMessageBody(MessageBodyType bodyType, String name, Object value, FunctionHeader header) {

            this.bodyType = bodyType;

            this.name = name;

            this.value = value;

            this.header = header;

        }
        public DecodedMessageBody(MessageBodyType bodyType, String name, Object value) {

            this.bodyType = bodyType;

            this.name = name;

            this.value = value;

        }
        public DecodedMessageBody(MessageBodyType bodyType, String name) {

            this.bodyType = bodyType;

            this.name = name;

        }
        public DecodedMessageBody(MessageBodyType bodyType) {

            this.bodyType = bodyType;

        }
        public DecodedMessageBody() {

        }
/*        public DecodedMessageBody() {
        }

        public DecodedMessageBody(MessageBodyType bodyType, String name, Object value, FunctionHeader header) {

            this.bodyType = bodyType;

            this.name = name;

            this.value = value;

            this.header = header;

        }
*/


        @JsonProperty("body_type")
        private MessageBodyType bodyType;
        /**
         * Type of the message body content.
         */
        public MessageBodyType getBodyType() {
            return bodyType;
        }
        /**
         * Type of the message body content.
         */
        public void setBodyType(MessageBodyType value) {
            this.bodyType = value;
        }

        @JsonProperty("name")
        private String name;
        /**
         * Function or event name.
         */
        public String getName() {
            return name;
        }
        /**
         * Function or event name.
         */
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("value")
        private Object value;
        /**
         * Parameters or result value.
         */
        public Object getValue() {
            return value;
        }
        /**
         * Parameters or result value.
         */
        public void setValue(Object value) {
            this.value = value;
        }

        @JsonProperty("header")
        private FunctionHeader header;
        /**
         * Function header.
         */
        public FunctionHeader getHeader() {
            return header;
        }
        /**
         * Function header.
         */
        public void setHeader(FunctionHeader value) {
            this.header = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((bodyType==null?null:("\"body_type\":"+bodyType)),(name==null?null:("\"name\":\""+name+"\"")),(value==null?null:("\"value\":"+value)),(header==null?null:("\"header\":"+header))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfEncodeAccount  {

        public ResultOfEncodeAccount(String account, String id) {

            this.account = account;

            this.id = id;

        }
        public ResultOfEncodeAccount(String account) {

            this.account = account;

        }
        public ResultOfEncodeAccount() {

        }
/*        public ResultOfEncodeAccount() {
        }

        public ResultOfEncodeAccount(String account, String id) {

            this.account = account;

            this.id = id;

        }
*/


        @JsonProperty("account")
        private String account;
        /**
         * Account BOC encoded in `base64`.
         */
        public String getAccount() {
            return account;
        }
        /**
         * Account BOC encoded in `base64`.
         */
        public void setAccount(String value) {
            this.account = value;
        }

        @JsonProperty("id")
        private String id;
        /**
         * Account ID  encoded in `hex`.
         */
        public String getId() {
            return id;
        }
        /**
         * Account ID  encoded in `hex`.
         */
        public void setId(String value) {
            this.id = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((account==null?null:("\"account\":\""+account+"\"")),(id==null?null:("\"id\":\""+id+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Abi(TONContext context) {
        this.context = context;
    }

   /**
    * Encodes message body according to ABI function call.
    *
    * @param abi Contract ABI.
    * @param callSet Function call parameters.<p> Must be specified in non deploy message.<p> In case of deploy message contains parameters of constructor.
    * @param isInternal True if internal message body must be encoded.
    * @param signer Signing parameters.
    * @param processingTryIndex Processing try index.<p> Used in message processing with retries.<p> Encoder uses the provided try index to calculate message expiration time.<p> Expiration timeouts will grow with every retry.<p> Default value is 0.
    */
    public CompletableFuture<ResultOfEncodeMessageBody> encodeMessageBody(ABI abi, CallSet callSet, Boolean isInternal, Signer signer, Number processingTryIndex) {
        return context.requestJSON("abi.encode_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(callSet==null?null:("\"call_set\":"+callSet)),(isInternal==null?null:("\"is_internal\":"+isInternal)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeMessageBody.class));
    }

   /**
    * 
    *
    * @param abi Contract ABI
    * @param publicKey Public key. Must be encoded with `hex`.
    * @param message Unsigned message BOC. Must be encoded with `base64`.
    * @param signature Signature. Must be encoded with `hex`.
    */
    public CompletableFuture<String> attachSignatureToMessageBody(ABI abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature_to_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(message==null?null:("\"message\":\""+message+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("body"), String.class));
    }

   /**
    * Encodes an ABI-compatible message<p> Allows to encode deploy and function call messages, both signed and unsigned.<p> Use cases include messages of any possible type: - deploy with initial function call (i.e. `constructor` or any other function that is used for some kind of initialization); - deploy without initial function call; - signed/unsigned + data for signing.<p> `Signer` defines how the message should or shouldn't be signed:<p> `Signer::None` creates an unsigned message. This may be needed in case of some public methods, that do not require authorization by pubkey.<p> `Signer::External` takes public key and returns `data_to_sign` for later signing. Use `attach_signature` method with the result signature to get the signed message.<p> `Signer::Keys` creates a signed message with provided key pair.<p> <a target="_blank" href="SOON">SOON</a> `Signer::SigningBox` Allows using a special interface to imlepement signing without private key disclosure to SDK. For instance, in case of using a cold wallet or HSM, when application calls some API to sign data.
    *
    * @param abi Contract ABI.
    * @param address Target address the message will be sent to.<p> Must be specified in case of non-deploy message.
    * @param deploySet Deploy parameters.<p> Must be specified in case of deploy message.
    * @param callSet Function call parameters.<p> Must be specified in case of non-deploy message.<p> In case of deploy message it is optional and contains parameters of the functions that will to be called upon deploy transaction.
    * @param signer Signing parameters.
    * @param processingTryIndex Processing try index.<p> Used in message processing with retries (if contract's ABI includes "expire" header).<p> Encoder uses the provided try index to calculate message expiration time. The 1st message expiration time is specified in Client config.<p> Expiration timeouts will grow with every retry. Retry grow factor is set in Client config: &lt;.....add config parameter with default value here&gt;<p> Default value is 0.
    */
    public CompletableFuture<ResultOfEncodeMessage> encodeMessage(ABI abi, String address, DeploySet deploySet, CallSet callSet, Signer signer, Number processingTryIndex) {
        return context.requestJSON("abi.encode_message", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(address==null?null:("\"address\":\""+address+"\"")),(deploySet==null?null:("\"deploy_set\":"+deploySet)),(callSet==null?null:("\"call_set\":"+callSet)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeMessage.class));
    }

   /**
    * Combines `hex`-encoded `signature` with `base64`-encoded `unsigned_message`. Returns signed message encoded in `base64`.
    *
    * @param abi Contract ABI
    * @param publicKey Public key encoded in `hex`.
    * @param message Unsigned message BOC encoded in `base64`.
    * @param signature Signature encoded in `hex`.
    */
    public CompletableFuture<ResultOfAttachSignature> attachSignature(ABI abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(message==null?null:("\"message\":\""+message+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfAttachSignature.class));
    }

   /**
    * Decodes message body using provided message BOC and ABI.
    *
    * @param abi contract ABI
    * @param message Message BOC
    */
    public CompletableFuture<DecodedMessageBody> decodeMessage(ABI abi, String message) {
        return context.requestJSON("abi.decode_message", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(message==null?null:("\"message\":\""+message+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, DecodedMessageBody.class));
    }

   /**
    * Decodes message body using provided body BOC and ABI.
    *
    * @param abi Contract ABI used to decode.
    * @param body Message body BOC encoded in `base64`.
    * @param isInternal True if the body belongs to the internal message.
    */
    public CompletableFuture<DecodedMessageBody> decodeMessageBody(ABI abi, String body, Boolean isInternal) {
        return context.requestJSON("abi.decode_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(body==null?null:("\"body\":\""+body+"\"")),(isInternal==null?null:("\"is_internal\":"+isInternal))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, DecodedMessageBody.class));
    }

   /**
    * Creates account state BOC<p> Creates account state provided with one of these sets of data : 1. BOC of code, BOC of data, BOC of library 2. TVC (string in `base64`), keys, init params
    *
    * @param stateInit Source of the account state init.
    * @param balance Initial balance.
    * @param lastTransLt Initial value for the `last_trans_lt`.
    * @param lastPaid Initial value for the `last_paid`.
    */
    public CompletableFuture<ResultOfEncodeAccount> encodeAccount(StateInitSource stateInit, Long balance, Long lastTransLt, Number lastPaid) {
        return context.requestJSON("abi.encode_account", "{"+Stream.of((stateInit==null?null:("\"state_init\":"+stateInit)),(balance==null?null:("\"balance\":"+balance)),(lastTransLt==null?null:("\"last_trans_lt\":"+lastTransLt)),(lastPaid==null?null:("\"last_paid\":"+lastPaid))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeAccount.class));
    }

}
