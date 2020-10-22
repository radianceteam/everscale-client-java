package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

public class Boc {
    private TONContext context;

    public Boc(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> parseMessage(String _boc) {
        return context.request("boc.parse_message", "{" + String.join(",", new String[]{"\"boc\":\""+_boc+"\""}) + "}");
    }

    public CompletableFuture<String> parseTransaction(String _boc) {
        return context.request("boc.parse_transaction", "{" + String.join(",", new String[]{"\"boc\":\""+_boc+"\""}) + "}");
    }

    public CompletableFuture<String> parseAccount(String _boc) {
        return context.request("boc.parse_account", "{" + String.join(",", new String[]{"\"boc\":\""+_boc+"\""}) + "}");
    }

    public CompletableFuture<String> parseBlock(String _boc) {
        return context.request("boc.parse_block", "{" + String.join(",", new String[]{"\"boc\":\""+_boc+"\""}) + "}");
    }

    public CompletableFuture<String> getBlockchainConfig(String _blockBoc) {
        return context.requestJSON("boc.get_blockchain_config", "{" + String.join(",", new String[]{"\"block_boc\":\""+_blockBoc+"\""}) + "}")
            .thenApply(json -> json.findValue("config_boc").toString());
    }

}
