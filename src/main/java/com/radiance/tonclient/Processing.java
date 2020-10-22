package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

public class Processing {
    private TONContext context;

    public Processing(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> sendMessage(String _message, String _abi, Boolean _sendEvents) {
        return context.requestJSON("processing.send_message", "{" + String.join(",", new String[]{"\"message\":\""+_message+"\"","\"abi\":\""+_abi+"\"","\"send_events\":"+_sendEvents}) + "}")
            .thenApply(json -> json.findValue("shard_block_id").toString());
    }

    public CompletableFuture<String> waitForTransaction(String _abi, String _message, String _shardBlockId, Boolean _sendEvents) {
        return context.request("processing.wait_for_transaction", "{" + String.join(",", new String[]{"\"abi\":\""+_abi+"\"","\"message\":\""+_message+"\"","\"shard_block_id\":\""+_shardBlockId+"\"","\"send_events\":"+_sendEvents}) + "}");
    }

    public CompletableFuture<String> processMessage(String _message, Boolean _sendEvents) {
        return context.request("processing.process_message", "{" + String.join(",", new String[]{"\"message\":\""+_message+"\"","\"send_events\":"+_sendEvents}) + "}");
    }

}
