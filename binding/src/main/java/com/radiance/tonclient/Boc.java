package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *  
 */
public class Boc {

    public static abstract class BocCacheType {

    /**
     *  Such BOC will not be removed from cache until it is unpinned
     */
    public static class Pinned extends BocCacheType  {

        public Pinned(String pin) {

            this.pin = pin;

        }
        public Pinned() {

        }


        @JsonProperty("pin")
        private String pin;
        /**
         * 
         */
        public String getPin() {
            return pin;
        }
        /**
         * 
         */
        public void setPin(String value) {
            this.pin = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Pinned\"",(pin==null?null:("\"pin\":\""+pin+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

        public static final Unpinned Unpinned = new Unpinned();

    /**
     *  
     */
    public static class Unpinned extends BocCacheType  {

        public Unpinned() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"Unpinned\""+"}";
        }
    }
}
    public static abstract class BuilderOp {

    /**
     *  
     */
    public static class Integer extends BuilderOp  {

        public Integer(Number size, Object value) {

            this.size = size;

            this.value = value;

        }
        public Integer(Number size) {

            this.size = size;

        }
        public Integer() {

        }


        @JsonProperty("size")
        private Number size;
        /**
         * 
         */
        public Number getSize() {
            return size;
        }
        /**
         * 
         */
        public void setSize(Number value) {
            this.size = value;
        }

        @JsonProperty("value")
        private Object value;
        /**
         * e.g. `123`, `-123`. - Decimal string. e.g. `"123"`, `"-123"`.- `0x` prefixed hexadecimal string.  e.g `0x123`, `0X123`, `-0x123`.
         */
        public Object getValue() {
            return value;
        }
        /**
         * e.g. `123`, `-123`. - Decimal string. e.g. `"123"`, `"-123"`.- `0x` prefixed hexadecimal string.  e.g `0x123`, `0X123`, `-0x123`.
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Integer\"",(size==null?null:("\"size\":"+size)),(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class BitString extends BuilderOp  {

        public BitString(String value) {

            this.value = value;

        }
        public BitString() {

        }


        @JsonProperty("value")
        private String value;
        /**
         * Contains hexadecimal string representation:- Can end with `_` tag.- Can be prefixed with `x` or `X`.- Can be prefixed with `x{` or `X{` and ended with `}`.<p>Contains binary string represented as a sequenceof `0` and `1` prefixed with `n` or `N`.<p>Examples:`1AB`, `x1ab`, `X1AB`, `x{1abc}`, `X{1ABC}``2D9_`, `x2D9_`, `X2D9_`, `x{2D9_}`, `X{2D9_}``n00101101100`, `N00101101100`
         */
        public String getValue() {
            return value;
        }
        /**
         * Contains hexadecimal string representation:- Can end with `_` tag.- Can be prefixed with `x` or `X`.- Can be prefixed with `x{` or `X{` and ended with `}`.<p>Contains binary string represented as a sequenceof `0` and `1` prefixed with `n` or `N`.<p>Examples:`1AB`, `x1ab`, `X1AB`, `x{1abc}`, `X{1ABC}``2D9_`, `x2D9_`, `X2D9_`, `x{2D9_}`, `X{2D9_}``n00101101100`, `N00101101100`
         */
        public void setValue(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"BitString\"",(value==null?null:("\"value\":\""+value+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Cell extends BuilderOp  {

        public Cell(BuilderOp[] builder) {

            this.builder = builder;

        }
        public Cell() {

        }


        @JsonProperty("builder")
        private BuilderOp[] builder;
        /**
         * 
         */
        public BuilderOp[] getBuilder() {
            return builder;
        }
        /**
         * 
         */
        public void setBuilder(BuilderOp[] value) {
            this.builder = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Cell\"",(builder==null?null:("\"builder\":"+Arrays.toString(builder)))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class CellBoc extends BuilderOp  {

        public CellBoc(String boc) {

            this.boc = boc;

        }
        public CellBoc() {

        }


        @JsonProperty("boc")
        private String boc;
        /**
         * 
         */
        public String getBoc() {
            return boc;
        }
        /**
         * 
         */
        public void setBoc(String value) {
            this.boc = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"CellBoc\"",(boc==null?null:("\"boc\":\""+boc+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    private TONContext context;

    public Boc(TONContext context) {
        this.context = context;
    }

   /**
    * JSON structure is compatible with GraphQL API message object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseMessage(String boc) {
        return context.requestJSON("boc.parse_message", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API transaction object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseTransaction(String boc) {
        return context.requestJSON("boc.parse_transaction", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API account object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseAccount(String boc) {
        return context.requestJSON("boc.parse_account", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API block object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseBlock(String boc) {
        return context.requestJSON("boc.parse_block", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API shardstate object
    *
    * @param boc 
    * @param id 
    * @param workchainId 
    */
    public CompletableFuture<Object> parseShardstate(String boc, String id, Number workchainId) {
        return context.requestJSON("boc.parse_shardstate", "{"+Stream.of((boc==null?null:("\"boc\":\""+boc+"\"")),(id==null?null:("\"id\":\""+id+"\"")),(workchainId==null?null:("\"workchain_id\":"+workchainId))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * 
    *
    * @param blockBoc 
    */
    public CompletableFuture<String> getBlockchainConfig(String blockBoc) {
        return context.requestJSON("boc.get_blockchain_config", "{"+(blockBoc==null?"":("\"block_boc\":\""+blockBoc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("config_boc"), String.class));
    }

   /**
    * 
    *
    * @param boc 
    */
    public CompletableFuture<String> getBocHash(String boc) {
        return context.requestJSON("boc.get_boc_hash", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

   /**
    * 
    *
    * @param tvc 
    */
    public CompletableFuture<String> getCodeFromTvc(String tvc) {
        return context.requestJSON("boc.get_code_from_tvc", "{"+(tvc==null?"":("\"tvc\":\""+tvc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("code"), String.class));
    }

   /**
    * 
    *
    * @param bocRef 
    */
    public CompletableFuture<String> cacheGet(String bocRef) {
        return context.requestJSON("boc.cache_get", "{"+(bocRef==null?"":("\"boc_ref\":\""+bocRef+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("boc"), String.class));
    }

   /**
    * 
    *
    * @param boc 
    * @param cacheType 
    */
    public CompletableFuture<String> cacheSet(String boc, BocCacheType cacheType) {
        return context.requestJSON("boc.cache_set", "{"+Stream.of((boc==null?null:("\"boc\":\""+boc+"\"")),(cacheType==null?null:("\"cache_type\":"+cacheType))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("boc_ref"), String.class));
    }

   /**
    * BOCs which don't have another pins will be removed from cache
    *
    * @param pin 
    * @param bocRef If it is provided then only referenced BOC is unpinned
    */
    public CompletableFuture<Void> cacheUnpin(String pin, String bocRef) {
        return context.requestJSON("boc.cache_unpin", "{"+Stream.of((pin==null?null:("\"pin\":\""+pin+"\"")),(bocRef==null?null:("\"boc_ref\":\""+bocRef+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * 
    *
    * @param builder 
    * @param bocCache 
    */
    public CompletableFuture<String> encodeBoc(BuilderOp[] builder, BocCacheType bocCache) {
        return context.requestJSON("boc.encode_boc", "{"+Stream.of((builder==null?null:("\"builder\":"+Arrays.toString(builder))),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("boc"), String.class));
    }

}
