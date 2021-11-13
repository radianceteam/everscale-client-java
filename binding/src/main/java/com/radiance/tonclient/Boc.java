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
    /**
     *  
     */
    public static class ResultOfDecodeTvc  {

        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data, String dataHash, Number dataDepth, String library, Boolean tick, Boolean tock, Number splitDepth, String compilerVersion) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

            this.dataHash = dataHash;

            this.dataDepth = dataDepth;

            this.library = library;

            this.tick = tick;

            this.tock = tock;

            this.splitDepth = splitDepth;

            this.compilerVersion = compilerVersion;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data, String dataHash, Number dataDepth, String library, Boolean tick, Boolean tock, Number splitDepth) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

            this.dataHash = dataHash;

            this.dataDepth = dataDepth;

            this.library = library;

            this.tick = tick;

            this.tock = tock;

            this.splitDepth = splitDepth;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data, String dataHash, Number dataDepth, String library, Boolean tick, Boolean tock) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

            this.dataHash = dataHash;

            this.dataDepth = dataDepth;

            this.library = library;

            this.tick = tick;

            this.tock = tock;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data, String dataHash, Number dataDepth, String library, Boolean tick) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

            this.dataHash = dataHash;

            this.dataDepth = dataDepth;

            this.library = library;

            this.tick = tick;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data, String dataHash, Number dataDepth, String library) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

            this.dataHash = dataHash;

            this.dataDepth = dataDepth;

            this.library = library;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data, String dataHash, Number dataDepth) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

            this.dataHash = dataHash;

            this.dataDepth = dataDepth;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data, String dataHash) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

            this.dataHash = dataHash;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth, String data) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

            this.data = data;

        }
        public ResultOfDecodeTvc(String code, String codeHash, Number codeDepth) {

            this.code = code;

            this.codeHash = codeHash;

            this.codeDepth = codeDepth;

        }
        public ResultOfDecodeTvc(String code, String codeHash) {

            this.code = code;

            this.codeHash = codeHash;

        }
        public ResultOfDecodeTvc(String code) {

            this.code = code;

        }
        public ResultOfDecodeTvc() {

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

        @JsonProperty("code_hash")
        private String codeHash;
        /**
         * 
         */
        public String getCodeHash() {
            return codeHash;
        }
        /**
         * 
         */
        public void setCodeHash(String value) {
            this.codeHash = value;
        }

        @JsonProperty("code_depth")
        private Number codeDepth;
        /**
         * 
         */
        public Number getCodeDepth() {
            return codeDepth;
        }
        /**
         * 
         */
        public void setCodeDepth(Number value) {
            this.codeDepth = value;
        }

        @JsonProperty("data")
        private String data;
        /**
         * 
         */
        public String getData() {
            return data;
        }
        /**
         * 
         */
        public void setData(String value) {
            this.data = value;
        }

        @JsonProperty("data_hash")
        private String dataHash;
        /**
         * 
         */
        public String getDataHash() {
            return dataHash;
        }
        /**
         * 
         */
        public void setDataHash(String value) {
            this.dataHash = value;
        }

        @JsonProperty("data_depth")
        private Number dataDepth;
        /**
         * 
         */
        public Number getDataDepth() {
            return dataDepth;
        }
        /**
         * 
         */
        public void setDataDepth(Number value) {
            this.dataDepth = value;
        }

        @JsonProperty("library")
        private String library;
        /**
         * 
         */
        public String getLibrary() {
            return library;
        }
        /**
         * 
         */
        public void setLibrary(String value) {
            this.library = value;
        }

        @JsonProperty("tick")
        private Boolean tick;
        /**
         * Specifies the contract ability to handle tick transactions
         */
        public Boolean getTick() {
            return tick;
        }
        /**
         * Specifies the contract ability to handle tick transactions
         */
        public void setTick(Boolean value) {
            this.tick = value;
        }

        @JsonProperty("tock")
        private Boolean tock;
        /**
         * Specifies the contract ability to handle tock transactions
         */
        public Boolean getTock() {
            return tock;
        }
        /**
         * Specifies the contract ability to handle tock transactions
         */
        public void setTock(Boolean value) {
            this.tock = value;
        }

        @JsonProperty("split_depth")
        private Number splitDepth;
        /**
         * 
         */
        public Number getSplitDepth() {
            return splitDepth;
        }
        /**
         * 
         */
        public void setSplitDepth(Number value) {
            this.splitDepth = value;
        }

        @JsonProperty("compiler_version")
        private String compilerVersion;
        /**
         * 
         */
        public String getCompilerVersion() {
            return compilerVersion;
        }
        /**
         * 
         */
        public void setCompilerVersion(String value) {
            this.compilerVersion = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((code==null?null:("\"code\":\""+code+"\"")),(codeHash==null?null:("\"code_hash\":\""+codeHash+"\"")),(codeDepth==null?null:("\"code_depth\":"+codeDepth)),(data==null?null:("\"data\":\""+data+"\"")),(dataHash==null?null:("\"data_hash\":\""+dataHash+"\"")),(dataDepth==null?null:("\"data_depth\":"+dataDepth)),(library==null?null:("\"library\":\""+library+"\"")),(tick==null?null:("\"tick\":"+tick)),(tock==null?null:("\"tock\":"+tock)),(splitDepth==null?null:("\"split_depth\":"+splitDepth)),(compilerVersion==null?null:("\"compiler_version\":\""+compilerVersion+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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
    * @param boc 
    */
    public CompletableFuture<Number> getBocDepth(String boc) {
        return context.requestJSON("boc.get_boc_depth", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("depth"), Number.class));
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

   /**
    * 
    *
    * @param code 
    * @param bocCache 
    * @return BOC encoded as base64 or BOC handle
    */
    public CompletableFuture<String> getCodeSalt(String code, BocCacheType bocCache) {
        return context.requestJSON("boc.get_code_salt", "{"+Stream.of((code==null?null:("\"code\":\""+code+"\"")),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("salt"), String.class));
    }

   /**
    * Returns the new contract code with salt.
    *
    * @param code 
    * @param salt BOC encoded as base64 or BOC handle
    * @param bocCache 
    * @return BOC encoded as base64 or BOC handle
    */
    public CompletableFuture<String> setCodeSalt(String code, String salt, BocCacheType bocCache) {
        return context.requestJSON("boc.set_code_salt", "{"+Stream.of((code==null?null:("\"code\":\""+code+"\"")),(salt==null?null:("\"salt\":\""+salt+"\"")),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("code"), String.class));
    }

   /**
    * 
    *
    * @param tvc 
    * @param bocCache 
    */
    public CompletableFuture<ResultOfDecodeTvc> decodeTvc(String tvc, BocCacheType bocCache) {
        return context.requestJSON("boc.decode_tvc", "{"+Stream.of((tvc==null?null:("\"tvc\":\""+tvc+"\"")),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfDecodeTvc.class));
    }

   /**
    * 
    *
    * @param code 
    * @param data 
    * @param library 
    * @param tick Specifies the contract ability to handle tick transactions
    * @param tock Specifies the contract ability to handle tock transactions
    * @param splitDepth 
    * @param bocCache 
    */
    public CompletableFuture<String> encodeTvc(String code, String data, String library, Boolean tick, Boolean tock, Number splitDepth, BocCacheType bocCache) {
        return context.requestJSON("boc.encode_tvc", "{"+Stream.of((code==null?null:("\"code\":\""+code+"\"")),(data==null?null:("\"data\":\""+data+"\"")),(library==null?null:("\"library\":\""+library+"\"")),(tick==null?null:("\"tick\":"+tick)),(tock==null?null:("\"tock\":"+tock)),(splitDepth==null?null:("\"split_depth\":"+splitDepth)),(bocCache==null?null:("\"boc_cache\":"+bocCache))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("tvc"), String.class));
    }

   /**
    * 
    *
    * @param code 
    */
    public CompletableFuture<String> getCompilerVersion(String code) {
        return context.requestJSON("boc.get_compiler_version", "{"+(code==null?"":("\"code\":\""+code+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("version"), String.class));
    }

}
