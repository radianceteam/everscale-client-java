package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;

/**
 *   Provides message encoding and decoding according to the ABI specification.
 */
public class AbiModule {

    private TONContext context;

    public AbiModule(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<ResultOfEncodeMessageBody> encodeMessageBody(Abi abi, CallSet callSet, Boolean isInternal, Signer signer, Number processingTryIndex) {
        return context.requestJSON("abi.encode_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(callSet==null?null:("\"call_set\":"+callSet)),(isInternal==null?null:("\"is_internal\":"+isInternal)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeMessageBody.class));
    }

    public CompletableFuture<String> attachSignatureToMessageBody(Abi abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature_to_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(message==null?null:("\"message\":\""+message+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("body"), String.class));
    }

    public CompletableFuture<ResultOfEncodeMessage> encodeMessage(Abi abi, String address, DeploySet deploySet, CallSet callSet, Signer signer, Number processingTryIndex) {
        return context.requestJSON("abi.encode_message", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(address==null?null:("\"address\":\""+address+"\"")),(deploySet==null?null:("\"deploy_set\":"+deploySet)),(callSet==null?null:("\"call_set\":"+callSet)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeMessage.class));
    }

    public CompletableFuture<ResultOfAttachSignature> attachSignature(Abi abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(message==null?null:("\"message\":\""+message+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfAttachSignature.class));
    }

    public CompletableFuture<DecodedMessageBody> decodeMessage(Abi abi, String message) {
        return context.requestJSON("abi.decode_message", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(message==null?null:("\"message\":\""+message+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, DecodedMessageBody.class));
    }

    public CompletableFuture<DecodedMessageBody> decodeMessageBody(Abi abi, String body, Boolean isInternal) {
        return context.requestJSON("abi.decode_message_body", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(body==null?null:("\"body\":\""+body+"\"")),(isInternal==null?null:("\"is_internal\":"+isInternal))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, DecodedMessageBody.class));
    }

    public CompletableFuture<ResultOfEncodeAccount> encodeAccount(StateInitSource stateInit, Long balance, Long lastTransLt, Number lastPaid) {
        return context.requestJSON("abi.encode_account", "{"+Stream.of((stateInit==null?null:("\"state_init\":"+stateInit)),(balance==null?null:("\"balance\":"+balance)),(lastTransLt==null?null:("\"last_trans_lt\":"+lastTransLt)),(lastPaid==null?null:("\"last_paid\":"+lastPaid))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfEncodeAccount.class));
    }

}
