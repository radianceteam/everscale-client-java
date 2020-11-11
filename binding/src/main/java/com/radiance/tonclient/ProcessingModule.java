package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import ton.sdk.TONContext;
import java.util.function.Consumer;

/**
 *  Message processing module.<p> This module incorporates functions related to complex message processing scenarios.
 */
public class ProcessingModule {

    private TONContext context;

    public ProcessingModule(TONContext context) {
        this.context = context;
    }

   /**
    * Sends message to the network<p> Sends message to the network and returns the last generated shard block of the destination account before the message was sent. It will be required later for message processing.
    *
    * @param message Message BOC.
    * @param abi Optional message ABI.<p> If this parameter is specified and the message has the `expire` header then expiration time will be checked against the current time to prevent an unnecessary sending of already expired message.<p> The `message already expired` error will be returned in this case.<p> Note that specifying `abi` for ABI compliant contracts is strongly recommended due to choosing proper processing strategy.
    * @param sendEvents Flag for requesting events sending
    * @return  The last generated shard block of the message destination account before the
 message was sent.

 This block id must be used as a parameter of the
 `wait_for_transaction`.
    */
    public CompletableFuture<String> sendMessage(String message, Abi abi, Boolean sendEvents, Consumer<SendMessageEvent> consumer) {
        return context.requestJSONCallback("processing.send_message", "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(abi==null?null:("\"abi\":"+abi)),(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", consumer, SendMessageEvent.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("shard_block_id"), String.class));
    }

   /**
    * Performs monitoring of the network for the result transaction of the external inbound message processing.<p> `send_events` enables intermediate events, such as `WillFetchNextBlock`, `FetchNextBlockFailed` that may be useful for logging of new shard blocks creation  during message processing.<p> Note that presence of the `abi` parameter is critical for ABI compliant contracts. Message processing uses drastically different strategy for processing message for contracts which ABI includes "expire" header.<p> When the ABI header `expire` is present, the processing uses `message expiration` strategy: - The maximum block gen time is set to   `message_expiration_time + transaction_wait_timeout`. - When maximum block gen time is reached the processing will   be finished with `MessageExpired` error.<p> When the ABI header `expire` isn't present or `abi` parameter isn't specified, the processing uses `transaction waiting` strategy: - The maximum block gen time is set to   `now() + transaction_wait_timeout`.<p> - If maximum block gen time is reached and no result transaction is found  the processing will exit with an error.
    *
    * @param abi Optional ABI for decoding the transaction result.<p> If it is specified then the output messages' bodies will be decoded according to this ABI.<p> The `abi_decoded` result field will be filled out.
    * @param message Message BOC. Encoded with `base64`.
    * @param shardBlockId The last generated block id of the destination account shard before the message was sent.<p> You must provide the same value as the `send_message` has returned.
    * @param sendEvents Flag that enables/disables intermediate events
    */
    public CompletableFuture<ResultOfProcessMessage> waitForTransaction(Abi abi, String message, String shardBlockId, Boolean sendEvents, Consumer<WaitForTransactionEvent> consumer) {
        return context.requestJSONCallback("processing.wait_for_transaction", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(message==null?null:("\"message\":\""+message+"\"")),(shardBlockId==null?null:("\"shard_block_id\":\""+shardBlockId+"\"")),(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", consumer, WaitForTransactionEvent.class)
            .thenApply(json -> TONContext.convertValue(json, ResultOfProcessMessage.class));
    }

   /**
    * Creates message, sends it to the network and monitors its processing.<p> Creates ABI-compatible message, sends it to the network and monitors for the result transaction. Decodes the output messages's bodies.<p> If contract's ABI includes "expire" header then SDK implements retries in case of unsuccessful message delivery within the expiration timeout: SDK recreates the message, sends it and processes it again. <p> The intermediate events, such as `WillFetchFirstBlock`, `WillSend`, `DidSend`, `WillFetchNextBlock`, etc - are switched on/off by `send_events` flag  and logged into the supplied callback function. The retry configuration parameters are defined in config: &lt;add correct config params here&gt; pub const DEFAULT_EXPIRATION_RETRIES_LIMIT: i8 = 3; - max number of retries pub const DEFAULT_EXPIRATION_TIMEOUT: u32 = 40000;  - message expiration timeout in ms. pub const DEFAULT_....expiration_timeout_grow_factor... = 1.5 - factor that increases the expiration timeout for each retry<p> If contract's ABI does not include "expire" header then if no transaction is found within the network timeout (see config parameter ), exits with error.
    *
    * @param abi Contract ABI.
    * @param address Target address the message will be sent to.<p> Must be specified in case of non-deploy message.
    * @param deploySet Deploy parameters.<p> Must be specified in case of deploy message.
    * @param callSet Function call parameters.<p> Must be specified in case of non-deploy message.<p> In case of deploy message it is optional and contains parameters of the functions that will to be called upon deploy transaction.
    * @param signer Signing parameters.
    * @param processingTryIndex Processing try index.<p> Used in message processing with retries (if contract's ABI includes "expire" header).<p> Encoder uses the provided try index to calculate message expiration time. The 1st message expiration time is specified in Client config.<p> Expiration timeouts will grow with every retry. Retry grow factor is set in Client config: &lt;.....add config parameter with default value here&gt;<p> Default value is 0.
    * @param sendEvents Flag for requesting events sending
    */
    public CompletableFuture<ResultOfProcessMessage> processMessage(Abi abi, String address, DeploySet deploySet, CallSet callSet, Signer signer, Number processingTryIndex, Boolean sendEvents, Consumer<ProcessMessageEvent> consumer) {
        return context.requestJSONCallback("processing.process_message", "{"+Stream.of("\"message_encode_params\":"+"{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(address==null?null:("\"address\":\""+address+"\"")),(deploySet==null?null:("\"deploy_set\":"+deploySet)),(callSet==null?null:("\"call_set\":"+callSet)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}",(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", consumer, ProcessMessageEvent.class)
            .thenApply(json -> TONContext.convertValue(json, ResultOfProcessMessage.class));
    }

}
