package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;

/**
 *  Provides message encoding and decoding according to the ABI specification.
 */
public class AbiModule {

    private TONContext context;

    public AbiModule(TONContext context) {
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
    public CompletableFuture<ResultOfEncodeMessageBody> encodeMessageBody(Abi abi, CallSet callSet, Boolean isInternal, Signer signer, Number processingTryIndex) {
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
    public CompletableFuture<String> attachSignatureToMessageBody(Abi abi, String publicKey, String message, String signature) {
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
    public CompletableFuture<ResultOfEncodeMessage> encodeMessage(Abi abi, String address, DeploySet deploySet, CallSet callSet, Signer signer, Number processingTryIndex) {
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
    public CompletableFuture<ResultOfAttachSignature> attachSignature(Abi abi, String publicKey, String message, String signature) {
        return context.requestJSON("abi.attach_signature", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(publicKey==null?null:("\"public_key\":\""+publicKey+"\"")),(message==null?null:("\"message\":\""+message+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfAttachSignature.class));
    }

   /**
    * Decodes message body using provided message BOC and ABI.
    *
    * @param abi contract ABI
    * @param message Message BOC
    */
    public CompletableFuture<DecodedMessageBody> decodeMessage(Abi abi, String message) {
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
    public CompletableFuture<DecodedMessageBody> decodeMessageBody(Abi abi, String body, Boolean isInternal) {
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
