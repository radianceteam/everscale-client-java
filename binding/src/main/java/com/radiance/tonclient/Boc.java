package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import ton.sdk.TONContext;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  BOC manipulation module.
 */
public class Boc {

    private TONContext context;

    public Boc(TONContext context) {
        this.context = context;
    }

   /**
    * Parses message boc into a JSON <p> JSON structure is compatible with GraphQL API message object
    *
    * @param boc BOC encoded as base64
    * @return  JSON containing parsed BOC
    */
    public CompletableFuture<Object> parseMessage(String boc) {
        return context.requestJSON("boc.parse_message", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * Parses transaction boc into a JSON <p> JSON structure is compatible with GraphQL API transaction object
    *
    * @param boc BOC encoded as base64
    * @return  JSON containing parsed BOC
    */
    public CompletableFuture<Object> parseTransaction(String boc) {
        return context.requestJSON("boc.parse_transaction", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * Parses account boc into a JSON <p> JSON structure is compatible with GraphQL API account object
    *
    * @param boc BOC encoded as base64
    * @return  JSON containing parsed BOC
    */
    public CompletableFuture<Object> parseAccount(String boc) {
        return context.requestJSON("boc.parse_account", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * Parses block boc into a JSON <p> JSON structure is compatible with GraphQL API block object
    *
    * @param boc BOC encoded as base64
    * @return  JSON containing parsed BOC
    */
    public CompletableFuture<Object> parseBlock(String boc) {
        return context.requestJSON("boc.parse_block", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * Parses shardstate boc into a JSON <p> JSON structure is compatible with GraphQL API shardstate object
    *
    * @param boc BOC encoded as base64
    * @param id Shardstate identificator
    * @param workchainId Workchain shardstate belongs to
    * @return  JSON containing parsed BOC
    */
    public CompletableFuture<Object> parseShardstate(String boc, String id, Number workchainId) {
        return context.requestJSON("boc.parse_shardstate", "{"+Stream.of((boc==null?null:("\"boc\":\""+boc+"\"")),(id==null?null:("\"id\":\""+id+"\"")),(workchainId==null?null:("\"workchain_id\":"+workchainId))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * 
    *
    * @param blockBoc Key block BOC encoded as base64
    * @return  Blockchain config BOC encoded as base64
    */
    public CompletableFuture<String> getBlockchainConfig(String blockBoc) {
        return context.requestJSON("boc.get_blockchain_config", "{"+(blockBoc==null?"":("\"block_boc\":\""+blockBoc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("config_boc"), String.class));
    }

   /**
    * Calculates BOC root hash
    *
    * @param boc BOC encoded as base64
    * @return  BOC root hash encoded with hex
    */
    public CompletableFuture<String> getBocHash(String boc) {
        return context.requestJSON("boc.get_boc_hash", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

}
