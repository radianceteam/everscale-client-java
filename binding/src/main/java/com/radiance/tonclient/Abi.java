package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *  
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

        public Handle(Integer value) {

            this.value = value;

        }
        public Handle() {

        }


        @JsonProperty("value")
        private Integer value;
        /**
         * 
         */
        public Integer getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Integer value) {
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


        @JsonProperty("expire")
        private Number expire;
        /**
         * If not specified - calculated automatically from message_expiration_timeout(),try_index and message_expiration_timeout_grow_factor() (if ABI includes `expire` header).
         */
        public Number getExpire() {
            return expire;
        }
        /**
         * If not specified - calculated automatically from message_expiration_timeout(),try_index and message_expiration_timeout_grow_factor() (if ABI includes `expire` header).
         */
        public void setExpire(Number value) {
            this.expire = value;
        }

        @JsonProperty("time")
        private Long time;
        /**
         * If not specified, `now` is used (if ABI includes `time` header).
         */
        public Long getTime() {
            return time;
        }
        /**
         * If not specified, `now` is used (if ABI includes `time` header).
         */
        public void setTime(Long value) {
            this.time = value;
        }

        @JsonProperty("pubkey")
        private String pubkey;
        /**
         * Encoded in `hex`. If not specified, method fails with exception (if ABI includes `pubkey` header)..
         */
        public String getPubkey() {
            return pubkey;
        }
        /**
         * Encoded in `hex`. If not specified, method fails with exception (if ABI includes `pubkey` header)..
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


        @JsonProperty("function_name")
        private String functionName;
        /**
         * 
         */
        public String getFunctionName() {
            return functionName;
        }
        /**
         * 
         */
        public void setFunctionName(String value) {
            this.functionName = value;
        }

        @JsonProperty("header")
        private FunctionHeader header;
        /**
         * If an application omits some header parameters required by thecontract's ABI, the library will set the default values forthem.
         */
        public FunctionHeader getHeader() {
            return header;
        }
        /**
         * If an application omits some header parameters required by thecontract's ABI, the library will set the default values forthem.
         */
        public void setHeader(FunctionHeader value) {
            this.header = value;
        }

        @JsonProperty("input")
        private Object input;
        /**
         * 
         */
        public Object getInput() {
            return input;
        }
        /**
         * 
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

        public DeploySet(String tvc, String code, String stateInit, Number workchainId, Object initialData, String initialPubkey) {

            this.tvc = tvc;

            this.code = code;

            this.stateInit = stateInit;

            this.workchainId = workchainId;

            this.initialData = initialData;

            this.initialPubkey = initialPubkey;

        }
        public DeploySet(String tvc, String code, String stateInit, Number workchainId, Object initialData) {

            this.tvc = tvc;

            this.code = code;

            this.stateInit = stateInit;

            this.workchainId = workchainId;

            this.initialData = initialData;

        }
        public DeploySet(String tvc, String code, String stateInit, Number workchainId) {

            this.tvc = tvc;

            this.code = code;

            this.stateInit = stateInit;

            this.workchainId = workchainId;

        }
        public DeploySet(String tvc, String code, String stateInit) {

            this.tvc = tvc;

            this.code = code;

            this.stateInit = stateInit;

        }
        public DeploySet(String tvc, String code) {

            this.tvc = tvc;

            this.code = code;

        }
        public DeploySet(String tvc) {

            this.tvc = tvc;

        }
        public DeploySet() {

        }


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

        @JsonProperty("code")
        private String code;
        /**
         * 
         */
        public String getCode() {
            return code;
        }
        /**
         * 
         */
        public void setCode(String value) {
            this.code = value;
        }

        @JsonProperty("state_init")
        private String stateInit;
        /**
         * 
         */
        public String getStateInit() {
            return stateInit;
        }
        /**
         * 
         */
        public void setStateInit(String value) {
            this.stateInit = value;
        }

        @JsonProperty("workchain_id")
        private Number workchainId;
        /**
         * Default is `0`.
         */
        public Number getWorkchainId() {
            return workchainId;
        }
        /**
         * Default is `0`.
         */
        public void setWorkchainId(Number value) {
            this.workchainId = value;
        }

        @JsonProperty("initial_data")
        private Object initialData;
        /**
         * 
         */
        public Object getInitialData() {
            return initialData;
        }
        /**
         * 
         */
        public void setInitialData(Object value) {
            this.initialData = value;
        }

        @JsonProperty("initial_pubkey")
        private String initialPubkey;
        /**
         * Public key resolving priority:1. Public key from deploy set.2. Public key, specified in TVM file.3. Public key, provided by Signer.
         */
        public String getInitialPubkey() {
            return initialPubkey;
        }
        /**
         * Public key resolving priority:1. Public key from deploy set.2. Public key, specified in TVM file.3. Public key, provided by Signer.
         */
        public void setInitialPubkey(String value) {
            this.initialPubkey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((tvc==null?null:("\"tvc\":\""+tvc+"\"")),(code==null?null:("\"code\":\""+code+"\"")),(stateInit==null?null:("\"state_init\":\""+stateInit+"\"")),(workchainId==null?null:("\"workchain_id\":"+workchainId)),(initialData==null?null:("\"initial_data\":"+initialData)),(initialPubkey==null?null:("\"initial_pubkey\":\""+initialPubkey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    public static abstract class Signer {

        public static final None None = new None();

    /**
     *  Creates an unsigned message.
     */
    public static class None extends Signer  {

        public None() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"None\""+"}";
        }
    }

    /**
     *  
     */
    public static class External extends Signer  {

        public External(String publicKey) {

            this.publicKey = publicKey;

        }
        public External() {

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


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"External\"",(publicKey==null?null:("\"public_key\":\""+publicKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Keys extends Signer  {

        public Keys(Crypto.KeyPair keys) {

            this.keys = keys;

        }
        public Keys() {

        }


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
     *  
     */
    public static class SigningBox extends Signer  {

        public SigningBox(Integer handle) {

            this.handle = handle;

        }
        public SigningBox() {

        }


        @JsonProperty("handle")
        private Integer handle;
        /**
         * 
         */
        public Integer getHandle() {
            return handle;
        }
        /**
         * 
         */
        public void setHandle(Integer value) {
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
         * 
         */
        Input,

        /**
         * 
         */
        Output,

        /**
         * Occurs when contract sends an internal message to othercontract.
         */
        InternalOutput,

        /**
         * 
         */
        Event
    }
    public static abstract class StateInitSource {

    /**
     *  
     */
    public static class Message extends StateInitSource  {

        public Message(Object source) {

            this.source = source;

        }
        public Message() {

        }


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
     *  
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


        @JsonProperty("code")
        private String code;
        /**
         * Encoded in `base64`.
         */
        public String getCode() {
            return code;
        }
        /**
         * Encoded in `base64`.
         */
        public void setCode(String value) {
            this.code = value;
        }

        @JsonProperty("data")
        private String data;
        /**
         * Encoded in `base64`.
         */
        public String getData() {
            return data;
        }
        /**
         * Encoded in `base64`.
         */
        public void setData(String value) {
            this.data = value;
        }

        @JsonProperty("library")
        private String library;
        /**
         * Encoded in `base64`.
         */
        public String getLibrary() {
            return library;
        }
        /**
         * Encoded in `base64`.
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
     *  Encoded in `base64`.
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
    public static class AbiParam  {

        public AbiParam(String name, String type, AbiParam[] components) {

            this.name = name;

            this.type = type;

            this.components = components;

        }
        public AbiParam(String name, String type) {

            this.name = name;

            this.type = type;

        }
        public AbiParam(String name) {

            this.name = name;

        }
        public AbiParam() {

        }


        @JsonProperty("name")
        private String name;
        /**
         * 
         */
        public String getName() {
            return name;
        }
        /**
         * 
         */
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("type")
        private String type;
        /**
         * 
         */
        public String getType() {
            return type;
        }
        /**
         * 
         */
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("components")
        private AbiParam[] components;
        /**
         * 
         */
        public AbiParam[] getComponents() {
            return components;
        }
        /**
         * 
         */
        public void setComponents(AbiParam[] value) {
            this.components = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((name==null?null:("\"name\":\""+name+"\"")),(type==null?null:("\"type\":\""+type+"\"")),(components==null?null:("\"components\":"+Arrays.toString(components)))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public enum DataLayout {
        
        /**
         * 
         */
        Input,

        /**
         * 
         */
        Output
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


        @JsonProperty("body")
        private String body;
        /**
         * 
         */
        public String getBody() {
            return body;
        }
        /**
         * 
         */
        public void setBody(String value) {
            this.body = value;
        }

        @JsonProperty("data_to_sign")
        private String dataToSign;
        /**
         * Encoded with `base64`. Presents when `message` is unsigned. Can be used for externalmessage signing. Is this case you need to sing this data andproduce signed message using `abi.attach_signature`.
         */
        public String getDataToSign() {
            return dataToSign;
        }
        /**
         * Encoded with `base64`. Presents when `message` is unsigned. Can be used for externalmessage signing. Is this case you need to sing this data andproduce signed message using `abi.attach_signature`.
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


        @JsonProperty("message")
        private String message;
        /**
         * 
         */
        public String getMessage() {
            return message;
        }
        /**
         * 
         */
        public void setMessage(String value) {
            this.message = value;
        }

        @JsonProperty("data_to_sign")
        private String dataToSign;
        /**
         * Returned in case of `Signer::External`. Can be used for externalmessage signing. Is this case you need to use this data to create signature andthen produce signed message using `abi.attach_signature`.
         */
        public String getDataToSign() {
            return dataToSign;
        }
        /**
         * Returned in case of `Signer::External`. Can be used for externalmessage signing. Is this case you need to use this data to create signature andthen produce signed message using `abi.attach_signature`.
         */
        public void setDataToSign(String value) {
            this.dataToSign = value;
        }

        @JsonProperty("address")
        private String address;
        /**
         * 
         */
        public String getAddress() {
            return address;
        }
        /**
         * 
         */
        public void setAddress(String value) {
            this.address = value;
        }

        @JsonProperty("message_id")
        private String messageId;
        /**
         * 
         */
        public String getMessageId() {
            return messageId;
        }
        /**
         * 
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
    public static class ResultOfEncodeInternalMessage  {

        public ResultOfEncodeInternalMessage(String message, String address, String messageId) {

            this.message = message;

            this.address = address;

            this.messageId = messageId;

        }
        public ResultOfEncodeInternalMessage(String message, String address) {

            this.message = message;

            this.address = address;

        }
        public ResultOfEncodeInternalMessage(String message) {

            this.message = message;

        }
        public ResultOfEncodeInternalMessage() {

        }


        @JsonProperty("message")
        private String message;
        /**
         * 
         */
        public String getMessage() {
            return message;
        }
        /**
         * 
         */
        public void setMessage(String value) {
            this.message = value;
        }

        @JsonProperty("address")
        private String address;
        /**
         * 
         */
        public String getAddress() {
            return address;
        }
        /**
         * 
         */
        public void setAddress(String value) {
            this.address = value;
        }

        @JsonProperty("message_id")
        private String messageId;
        /**
         * 
         */
        public String getMessageId() {
            return messageId;
        }
        /**
         * 
         */
        public void setMessageId(String value) {
            this.messageId = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(address==null?null:("\"address\":\""+address+"\"")),(messageId==null?null:("\"message_id\":\""+messageId+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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


        @JsonProperty("message")
        private String message;
        /**
         * 
         */
        public String getMessage() {
            return message;
        }
        /**
         * 
         */
        public void setMessage(String value) {
            this.message = value;
        }

        @JsonProperty("message_id")
        private String messageId;
        /**
         * 
         */
        public String getMessageId() {
            return messageId;
        }
        /**
         * 
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


        @JsonProperty("body_type")
        private MessageBodyType bodyType;
        /**
         * 
         */
        public MessageBodyType getBodyType() {
            return bodyType;
        }
        /**
         * 
         */
        public void setBodyType(MessageBodyType value) {
            this.bodyType = value;
        }

        @JsonProperty("name")
        private String name;
        /**
         * 
         */
        public String getName() {
            return name;
        }
        /**
         * 
         */
        public void setName(String value) {
            this.name = value;
        }

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

        @JsonProperty("header")
        private FunctionHeader header;
        /**
         * 
         */
        public FunctionHeader getHeader() {
            return header;
        }
        /**
         * 
         */
        public void setHeader(FunctionHeader value) {
            this.header = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((bodyType==null?null:("\"body_type\":"+bodyType.ordinal())),(name==null?null:("\"name\":\""+name+"\"")),(value==null?null:("\"value\":"+value)),(header==null?null:("\"header\":"+header))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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


        @JsonProperty("account")
        private String account;
        /**
         * 
         */
        public String getAccount() {
            return account;
        }
        /**
         * 
         */
        public void setAccount(String value) {
            this.account = value;
        }

        @JsonProperty("id")
        private String id;
        /**
         * 
         */
        public String getId() {
            return id;
        }
        /**
         * 
         */
        public void setId(String value) {
            this.id = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((account==null?null:("\"account\":\""+account+"\"")),(id==null?null:("\"id\":\""+id+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfDecodeInitialData  {

        public ResultOfDecodeInitialData(Object initialData, String initialPubkey) {

            this.initialData = initialData;

            this.initialPubkey = initialPubkey;

        }
        public ResultOfDecodeInitialData(Object initialData) {

            this.initialData = initialData;

        }
        public ResultOfDecodeInitialData() {

        }


        @JsonProperty("initial_data")
        private Object initialData;
        /**
         * Initial data is decoded if `abi` input parameter is provided
         */
        public Object getInitialData() {
            return initialData;
        }
        /**
         * Initial data is decoded if `abi` input parameter is provided
         */
        public void setInitialData(Object value) {
            this.initialData = value;
        }

        @JsonProperty("initial_pubkey")
        private String initialPubkey;
        /**
         * 
         */
        public String getInitialPubkey() {
            return initialPubkey;
        }
        /**
         * 
         */
        public void setInitialPubkey(String value) {
            this.initialPubkey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((initialData==null?null:("\"initial_data\":"+initialData)),(initialPubkey==null?null:("\"initial_pubkey\":\""+initialPubkey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfGetSignatureData  {

        public ResultOfGetSignatureData(String signature, String unsigned) {

            this.signature = signature;

            this.unsigned = unsigned;

        }
        public ResultOfGetSignatureData(String signature) {

            this.signature = signature;

        }
        public ResultOfGetSignatureData() {

        }


        @JsonProperty("signature")
        private String signature;
        /**
         * 
         */
        public String getSignature() {
            return signature;
        }
        /**
         * 
         */
        public void setSignature(String value) {
            this.signature = value;
        }

        @JsonProperty("unsigned")
        private String unsigned;
        /**
         * 
         */
        public String getUnsigned() {
            return unsigned;
        }
        /**
         * 
         */
        public void setUnsigned(String value) {
            this.unsigned = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((signature==null?null:("\"signature\":\""+signature+"\"")),(unsigned==null?null:("\"unsigned\":\""+unsigned+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Abi(TONContext context) {
        this.context = context;
    }

   /**
    * 
    *
    * @param abi 
    * @param callSet Must be specified in non deploy message.<p>In case of deploy message contains parameters of constructor.
    * @param isInternal 
    * @param signer 
    * @param processingTryIndex Used in message processing with retries.<p>Encoder uses the provided try index to calculate messageexpiration time.<p>Expiration timeouts will grow with every retry.<p>Default value is 0.
    * @param address Since ABI version 2.3 destination address of external inbound message is used in messagebody signature calculation. Should be provided when signed external inbound message body iscreated. Otherwise can be omitted.
    * @param signatureId 
    */
    public CompletableFuture<ResultOfEncodeMessageBody> encodeMessageBody(ABI abi, CallSet callSet, Boolean isInternal, Signer signer, Number processingTryIndex, String address, Number signatureId) {
        return context.requestJSON("abi.encode_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(callSet==null?null:("\"call_set\":"+callSet)),(isInternal==null?null:("\"is_internal\":"+isInternal)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex)),(address==null?null:("\"address\":\""+address+"\"")),(signatureId==null?null:("\"signature_id\":"+signatureId))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeMessageBody.class));
    }

   /**
    * 
    *
    * @param abi 
    * @param publicKey Must be encoded with `hex`.
    * @param message Must be encoded with `base64`.
    * @param signature Must be encoded with `hex`.
    */
    public CompletableFuture<String> attachSignatureToMessageBody(ABI abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature_to_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(message==null?null:("\"message\":\""+message+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("body"), String.class));
    }

   /**
    * Allows to encode deploy and function call messages,both signed and unsigned.<p>Use cases include messages of any possible type:- deploy with initial function call (i.e. `constructor` or any other function that is used for some kindof initialization);- deploy without initial function call;- signed/unsigned + data for signing.<p>`Signer` defines how the message should or shouldn't be signed:<p>`Signer::None` creates an unsigned message. This may be needed in case of some public methods,that do not require authorization by pubkey.<p>`Signer::External` takes public key and returns `data_to_sign` for later signing.Use `attach_signature` method with the result signature to get the signed message.<p>`Signer::Keys` creates a signed message with provided key pair.<p><a target="_blank" href="SOON">SOON</a> `Signer::SigningBox` Allows using a special interface to implement signingwithout private key disclosure to SDK. For instance, in case of using a cold wallet or HSM,when application calls some API to sign data.<p>There is an optional public key can be provided in deploy set in order to substitute onein TVM file.<p>Public key resolving priority:1. Public key from deploy set.2. Public key, specified in TVM file.3. Public key, provided by signer.
    *
    * @param abi 
    * @param address Must be specified in case of non-deploy message.
    * @param deploySet Must be specified in case of deploy message.
    * @param callSet Must be specified in case of non-deploy message.<p>In case of deploy message it is optional and contains parametersof the functions that will to be called upon deploy transaction.
    * @param signer 
    * @param processingTryIndex Used in message processing with retries (if contract's ABI includes "expire" header).<p>Encoder uses the provided try index to calculate messageexpiration time. The 1st message expiration time is specified inClient config.<p>Expiration timeouts will grow with every retry.Retry grow factor is set in Client config:&lt;.....add config parameter with default value here&gt;<p>Default value is 0.
    * @param signatureId 
    */
    public CompletableFuture<ResultOfEncodeMessage> encodeMessage(ABI abi, String address, DeploySet deploySet, CallSet callSet, Signer signer, Number processingTryIndex, Number signatureId) {
        return context.requestJSON("abi.encode_message", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(address==null?null:("\"address\":\""+address+"\"")),(deploySet==null?null:("\"deploy_set\":"+deploySet)),(callSet==null?null:("\"call_set\":"+callSet)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex)),(signatureId==null?null:("\"signature_id\":"+signatureId))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeMessage.class));
    }

   /**
    * Allows to encode deploy and function call messages.<p>Use cases include messages of any possible type:- deploy with initial function call (i.e. `constructor` or any other function that is used for some kindof initialization);- deploy without initial function call;- simple function call<p>There is an optional public key can be provided in deploy set in order to substitute onein TVM file.<p>Public key resolving priority:1. Public key from deploy set.2. Public key, specified in TVM file.
    *
    * @param abi Can be None if both deploy_set and call_set are None.
    * @param address Must be specified in case of non-deploy message.
    * @param srcAddress 
    * @param deploySet Must be specified in case of deploy message.
    * @param callSet Must be specified in case of non-deploy message.<p>In case of deploy message it is optional and contains parametersof the functions that will to be called upon deploy transaction.
    * @param value 
    * @param bounce Default is true.
    * @param enableIhr Default is false.
    */
    public CompletableFuture<ResultOfEncodeInternalMessage> encodeInternalMessage(ABI abi, String address, String srcAddress, DeploySet deploySet, CallSet callSet, String value, Boolean bounce, Boolean enableIhr) {
        return context.requestJSON("abi.encode_internal_message", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(address==null?null:("\"address\":\""+address+"\"")),(srcAddress==null?null:("\"src_address\":\""+srcAddress+"\"")),(deploySet==null?null:("\"deploy_set\":"+deploySet)),(callSet==null?null:("\"call_set\":"+callSet)),(value==null?null:("\"value\":\""+value+"\"")),(bounce==null?null:("\"bounce\":"+bounce)),(enableIhr==null?null:("\"enable_ihr\":"+enableIhr))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeInternalMessage.class));
    }

   /**
    * 
    *
    * @param abi 
    * @param publicKey 
    * @param message 
    * @param signature 
    */
    public CompletableFuture<ResultOfAttachSignature> attachSignature(ABI abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(message==null?null:("\"message\":\""+message+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfAttachSignature.class));
    }

   /**
    * 
    *
    * @param abi 
    * @param message 
    * @param allowPartial 
    * @param functionName 
    * @param dataLayout 
    */
    public CompletableFuture<DecodedMessageBody> decodeMessage(ABI abi, String message, Boolean allowPartial, String functionName, DataLayout dataLayout) {
        return context.requestJSON("abi.decode_message", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(message==null?null:("\"message\":\""+message+"\"")),(allowPartial==null?null:("\"allow_partial\":"+allowPartial)),(functionName==null?null:("\"function_name\":\""+functionName+"\"")),(dataLayout==null?null:("\"data_layout\":"+dataLayout.ordinal()))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, DecodedMessageBody.class));
    }

   /**
    * 
    *
    * @param abi 
    * @param body 
    * @param isInternal 
    * @param allowPartial 
    * @param functionName 
    * @param dataLayout 
    */
    public CompletableFuture<DecodedMessageBody> decodeMessageBody(ABI abi, String body, Boolean isInternal, Boolean allowPartial, String functionName, DataLayout dataLayout) {
        return context.requestJSON("abi.decode_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(body==null?null:("\"body\":\""+body+"\"")),(isInternal==null?null:("\"is_internal\":"+isInternal)),(allowPartial==null?null:("\"allow_partial\":"+allowPartial)),(functionName==null?null:("\"function_name\":\""+functionName+"\"")),(dataLayout==null?null:("\"data_layout\":"+dataLayout.ordinal()))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, DecodedMessageBody.class));
    }

   /**
    * Creates account state provided with one of these sets of data :1. BOC of code, BOC of data, BOC of library2. TVC (string in `base64`), keys, init params
    *
    * @param stateInit 
    * @param balance 
    * @param lastTransLt 
    * @param lastPaid 
    * @param bocCache The BOC itself returned if no cache type provided
    */
    public CompletableFuture<ResultOfEncodeAccount> encodeAccount(StateInitSource stateInit, Long balance, Long lastTransLt, Number lastPaid, Boc.BocCacheType bocCache) {
        return context.requestJSON("abi.encode_account", "{"+Stream.of((stateInit==null?null:("\"state_init\":"+stateInit)),(balance==null?null:("\"balance\":"+balance)),(lastTransLt==null?null:("\"last_trans_lt\":"+lastTransLt)),(lastPaid==null?null:("\"last_paid\":"+lastPaid)),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeAccount.class));
    }

   /**
    * Note: this feature requires ABI 2.1 or higher.
    *
    * @param abi 
    * @param data 
    * @param allowPartial 
    */
    public CompletableFuture<Object> decodeAccountData(ABI abi, String data, Boolean allowPartial) {
        return context.requestJSON("abi.decode_account_data", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(data==null?null:("\"data\":\""+data+"\"")),(allowPartial==null?null:("\"allow_partial\":"+allowPartial))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), Object.class));
    }

   /**
    * 
    *
    * @param abi 
    * @param data 
    * @param initialData `abi` parameter should be provided to set initial data
    * @param initialPubkey 
    * @param bocCache 
    */
    public CompletableFuture<String> updateInitialData(ABI abi, String data, Object initialData, String initialPubkey, Boc.BocCacheType bocCache) {
        return context.requestJSON("abi.update_initial_data", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(data==null?null:("\"data\":\""+data+"\"")),(initialData==null?null:("\"initial_data\":"+initialData)),(initialPubkey==null?null:("\"initial_pubkey\":\""+initialPubkey+"\"")),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), String.class));
    }

   /**
    * This function is analogue of `tvm.buildDataInit` function in Solidity.
    *
    * @param abi 
    * @param initialData `abi` parameter should be provided to set initial data
    * @param initialPubkey 
    * @param bocCache 
    */
    public CompletableFuture<String> encodeInitialData(ABI abi, Object initialData, String initialPubkey, Boc.BocCacheType bocCache) {
        return context.requestJSON("abi.encode_initial_data", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(initialData==null?null:("\"initial_data\":"+initialData)),(initialPubkey==null?null:("\"initial_pubkey\":\""+initialPubkey+"\"")),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), String.class));
    }

   /**
    * 
    *
    * @param abi Initial data is decoded if this parameter is provided
    * @param data 
    * @param allowPartial 
    */
    public CompletableFuture<ResultOfDecodeInitialData> decodeInitialData(ABI abi, String data, Boolean allowPartial) {
        return context.requestJSON("abi.decode_initial_data", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(data==null?null:("\"data\":\""+data+"\"")),(allowPartial==null?null:("\"allow_partial\":"+allowPartial))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfDecodeInitialData.class));
    }

   /**
    * Solidity functions use ABI types for <a target="_blank" href="builder encoding">builder encoding</a>(https://github.com/tonlabs/TON-Solidity-Compiler/blob/master/API.md#tvmbuilderstore).The simplest way to decode such a BOC is to use ABI decoding.ABI has it own rules for fields layout in cells so manually encodedBOC can not be described in terms of ABI rules.<p>To solve this problem we introduce a new ABI type `Ref(&lt;ParamType&gt;)`which allows to store `ParamType` ABI parameter in cell reference and, thus,decode manually encoded BOCs. This type is available only in `decode_boc` functionand will not be available in ABI messages encoding until it is included into some ABI revision.<p>Such BOC descriptions covers most users needs. If someone wants to decode some BOC whichcan not be described by these rules (i.e. BOC with TLB containing constructors of flagsdefining some parsing conditions) then they can decode the fields up to fork condition,check the parsed data manually, expand the parsing schema and then decode the whole BOCwith the full schema.
    *
    * @param params 
    * @param boc 
    * @param allowPartial 
    */
    public CompletableFuture<Object> decodeBoc(AbiParam[] params, String boc, Boolean allowPartial) {
        return context.requestJSON("abi.decode_boc", "{"+Stream.of((params==null?null:("\"params\":"+Arrays.toString(params))),(boc==null?null:("\"boc\":\""+boc+"\"")),(allowPartial==null?null:("\"allow_partial\":"+allowPartial))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), Object.class));
    }

   /**
    * 
    *
    * @param params 
    * @param data 
    * @param bocCache The BOC itself returned if no cache type provided
    */
    public CompletableFuture<String> encodeBoc(AbiParam[] params, Object data, Boc.BocCacheType bocCache) {
        return context.requestJSON("abi.encode_boc", "{"+Stream.of((params==null?null:("\"params\":"+Arrays.toString(params))),(data==null?null:("\"data\":"+data)),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("boc"), String.class));
    }

   /**
    * 
    *
    * @param abi 
    * @param functionName 
    * @param output 
    */
    public CompletableFuture<Number> calcFunctionId(ABI abi, String functionName, Boolean output) {
        return context.requestJSON("abi.calc_function_id", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(functionName==null?null:("\"function_name\":\""+functionName+"\"")),(output==null?null:("\"output\":"+output))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("function_id"), Number.class));
    }

   /**
    * 
    *
    * @param abi 
    * @param message 
    * @param signatureId 
    */
    public CompletableFuture<ResultOfGetSignatureData> getSignatureData(ABI abi, String message, Number signatureId) {
        return context.requestJSON("abi.get_signature_data", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(message==null?null:("\"message\":\""+message+"\"")),(signatureId==null?null:("\"signature_id\":"+signatureId))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfGetSignatureData.class));
    }

}
