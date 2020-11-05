package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import java.util.function.Consumer;

/**
 *   Message processing module.<p> This module incorporates functions related to complex message processing scenarios.
 */
public class ProcessingModule {

    private TONContext context;

    public ProcessingModule(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> sendMessage(String message, Abi abi, Boolean sendEvents, Consumer<SendMessageEvent> consumer) {
        return context.requestJSONCallback("processing.send_message", "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(abi==null?null:("\"abi\":"+abi)),(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", consumer, SendMessageEvent.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("shard_block_id"), String.class));
    }

    public CompletableFuture<ResultOfProcessMessage> waitForTransaction(Abi abi, String message, String shardBlockId, Boolean sendEvents, Consumer<WaitForTransactionEvent> consumer) {
        return context.requestJSONCallback("processing.wait_for_transaction", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(message==null?null:("\"message\":\""+message+"\"")),(shardBlockId==null?null:("\"shard_block_id\":\""+shardBlockId+"\"")),(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", consumer, WaitForTransactionEvent.class)
            .thenApply(json -> TONContext.convertValue(json, ResultOfProcessMessage.class));
    }

    public CompletableFuture<ResultOfProcessMessage> processMessage(Abi abi, String address, DeploySet deploySet, CallSet callSet, Signer signer, Number processingTryIndex, Boolean sendEvents, Consumer<ProcessMessageEvent> consumer) {
        return context.requestJSONCallback("processing.process_message", "{"+Stream.of("\"message_encode_params\":"+"{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(address==null?null:("\"address\":\""+address+"\"")),(deploySet==null?null:("\"deploy_set\":"+deploySet)),(callSet==null?null:("\"call_set\":"+callSet)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}",(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", consumer, ProcessMessageEvent.class)
            .thenApply(json -> TONContext.convertValue(json, ResultOfProcessMessage.class));
    }

}
