package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

/**
 *   Provides message encoding and decoding according to the ABI specification.
 */
public class Abi {

    private TONContext context;

    public Abi(TONContext context) {
        this.context = context;
    }

  /**
   *  Encodes message body according to ABI function call.
   *
   * @param abi  Contract ABI.
   * @param callSet  Function call parameters.<p> Must be specified in non deploy message.<p> In case of deploy message contains parameters of constructor.
   * @param isInternal  True if internal message body must be encoded.
   * @param signer  Signing parameters.
   * @param processingTryIndex  Processing try index.<p> Used in message processing with retries.<p> Encoder uses the provided try index to calculate message expiration time.<p> Expiration timeouts will grow with every retry.<p> Default value is 0.
   */
    public CompletableFuture<ResultOfEncodeMessageBody> encodeMessageBody(String abi, CallSet callSet, Boolean isInternal, String signer, Number processingTryIndex) {
        return context.requestValue("abi.encode_message_body", "{\"abi\":\""+abi+"\",\"call_set\":"+callSet+",\"is_internal\":"+isInternal+",\"signer\":\""+signer+"\",\"processing_try_index\":"+processingTryIndex+"}", ResultOfEncodeMessageBody.class);
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
        return context.requestJSON("abi.attach_signature_to_message_body", "{\"abi\":\""+abi+"\",\"public_key\":\""+publicKey+"\",\"message\":\""+message+"\",\"signature\":\""+signature+"\"}")
            .thenApply(json -> json.findValue("body").asText());
    }

  /**
   *  Encodes an ABI-compatible message<p> Allows to encode deploy and function call messages, both signed and unsigned.<p> Use cases include messages of any possible type: - deploy with initial function call (i.e. `constructor` or any other function that is used for some kind of initialization); - deploy without initial function call; - signed/unsigned + data for signing.<p> `Signer` defines how the message should or shouldn't be signed:<p> `Signer::None` creates an unsigned message. This may be needed in case of some public methods, that do not require authorization by pubkey.<p> `Signer::External` takes public key and returns `data_to_sign` for later signing. Use `attach_signature` method with the result signature to get the signed message.<p> `Signer::Keys` creates a signed message with provided key pair.<p> <a target="_blank" href="SOON">SOON</a> `Signer::SigningBox` Allows using a special interface to imlepement signing without private key disclosure to SDK. For instance, in case of using a cold wallet or HSM, when application calls some API to sign data.
   *
   * @param abi  Contract ABI.
   * @param address  Target address the message will be sent to.<p> Must be specified in case of non-deploy message.
   * @param deploySet  Deploy parameters.<p> Must be specified in case of deploy message.
   * @param callSet  Function call parameters.<p> Must be specified in case of non-deploy message.<p> In case of deploy message it is optional and contains parameters of the functions that will to be called upon deploy transaction.
   * @param signer  Signing parameters.
   * @param processingTryIndex  Processing try index.<p> Used in message processing with retries (if contract's ABI includes "expire" header).<p> Encoder uses the provided try index to calculate message expiration time. The 1st message expiration time is specified in Client config.<p> Expiration timeouts will grow with every retry. Retry grow factor is set in Client config: &lt;.....add config parameter with default value here&gt;<p> Default value is 0.
   */
    public CompletableFuture<ResultOfEncodeMessage> encodeMessage(String abi, String address, DeploySet deploySet, CallSet callSet, String signer, Number processingTryIndex) {
        return context.requestValue("abi.encode_message", "{\"abi\":\""+abi+"\",\"address\":\""+address+"\",\"deploy_set\":"+deploySet+",\"call_set\":"+callSet+",\"signer\":\""+signer+"\",\"processing_try_index\":"+processingTryIndex+"}", ResultOfEncodeMessage.class);
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
        return context.requestValue("abi.attach_signature", "{\"abi\":\""+abi+"\",\"public_key\":\""+publicKey+"\",\"message\":\""+message+"\",\"signature\":\""+signature+"\"}", ResultOfAttachSignature.class);
    }

  /**
   *  Decodes message body using provided message BOC and ABI.
   *
   * @param abi  contract ABI
   * @param message  Message BOC
   */
    public CompletableFuture<DecodedMessageBody> decodeMessage(String abi, String message) {
        return context.requestValue("abi.decode_message", "{\"abi\":\""+abi+"\",\"message\":\""+message+"\"}", DecodedMessageBody.class);
    }

  /**
   *  Decodes message body using provided body BOC and ABI.
   *
   * @param abi  Contract ABI used to decode.
   * @param body  Message body BOC encoded in `base64`.
   * @param isInternal  True if the body belongs to the internal message.
   */
    public CompletableFuture<DecodedMessageBody> decodeMessageBody(String abi, String body, Boolean isInternal) {
        return context.requestValue("abi.decode_message_body", "{\"abi\":\""+abi+"\",\"body\":\""+body+"\",\"is_internal\":"+isInternal+"}", DecodedMessageBody.class);
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
        return context.requestValue("abi.encode_account", "{\"state_init\":\""+stateInit+"\",\"balance\":"+balance+",\"last_trans_lt\":"+lastTransLt+",\"last_paid\":"+lastPaid+"}", ResultOfEncodeAccount.class);
    }

}