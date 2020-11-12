package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import ton.sdk.TONContext;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class Tvm {

    /**
     *  
     */
    public static class ExecutionOptions  {
        public ExecutionOptions() {
        }

        public ExecutionOptions(String blockchainConfig, Number blockTime, Long blockLt, Long transactionLt) {

            this.blockchainConfig = blockchainConfig;

            this.blockTime = blockTime;

            this.blockLt = blockLt;

            this.transactionLt = transactionLt;

        }



        @JsonProperty("blockchain_config")
        private String blockchainConfig;
        /**
         * boc with config
         */
        public String getBlockchainConfig() {
            return blockchainConfig;
        }
        /**
         * boc with config
         */
        public void setBlockchainConfig(String value) {
            blockchainConfig = value;
        }

        @JsonProperty("block_time")
        private Number blockTime;
        /**
         * time that is used as transaction time
         */
        public Number getBlockTime() {
            return blockTime;
        }
        /**
         * time that is used as transaction time
         */
        public void setBlockTime(Number value) {
            blockTime = value;
        }

        @JsonProperty("block_lt")
        private Long blockLt;
        /**
         * block logical time
         */
        public Long getBlockLt() {
            return blockLt;
        }
        /**
         * block logical time
         */
        public void setBlockLt(Long value) {
            blockLt = value;
        }

        @JsonProperty("transaction_lt")
        private Long transactionLt;
        /**
         * transaction logical time
         */
        public Long getTransactionLt() {
            return transactionLt;
        }
        /**
         * transaction logical time
         */
        public void setTransactionLt(Long value) {
            transactionLt = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((blockchainConfig==null?null:("\"blockchain_config\":\""+blockchainConfig+"\"")),(blockTime==null?null:("\"block_time\":"+blockTime)),(blockLt==null?null:("\"block_lt\":"+blockLt)),(transactionLt==null?null:("\"transaction_lt\":"+transactionLt))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    public static abstract class AccountForExecutor {

        public static final None None = new None();

    /**
     *  Non-existing account to run a creation internal message. Should be used with `skip_transaction_check = true` if the message has no deploy data since transactions on the uninitialized account are always aborted
     */
    public static class None extends AccountForExecutor  {
        public None() {
        }




        @Override
        public String toString() {
            return "{"+"\"type\":\"None\""+"}";
        }
    }

        public static final Uninit Uninit = new Uninit();

    /**
     *  Emulate uninitialized account to run deploy message
     */
    public static class Uninit extends AccountForExecutor  {
        public Uninit() {
        }




        @Override
        public String toString() {
            return "{"+"\"type\":\"Uninit\""+"}";
        }
    }

    /**
     *  Account state to run message
     */
    public static class Account extends AccountForExecutor  {
        public Account() {
        }

        public Account(String boc, Boolean unlimitedBalance) {

            this.boc = boc;

            this.unlimitedBalance = unlimitedBalance;

        }



        @JsonProperty("boc")
        private String boc;
        /**
         * Account BOC. Encoded as base64.
         */
        public String getBoc() {
            return boc;
        }
        /**
         * Account BOC. Encoded as base64.
         */
        public void setBoc(String value) {
            boc = value;
        }

        @JsonProperty("unlimited_balance")
        private Boolean unlimitedBalance;
        /**
         * Flag for running account with the unlimited balance. Can be used to calculate transaction fees without balance check
         */
        public Boolean getUnlimitedBalance() {
            return unlimitedBalance;
        }
        /**
         * Flag for running account with the unlimited balance. Can be used to calculate transaction fees without balance check
         */
        public void setUnlimitedBalance(Boolean value) {
            unlimitedBalance = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Account\"",(boc==null?null:("\"boc\":\""+boc+"\"")),(unlimitedBalance==null?null:("\"unlimited_balance\":"+unlimitedBalance))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    /**
     *  
     */
    public static class ResultOfRunExecutor  {
        public ResultOfRunExecutor() {
        }

        public ResultOfRunExecutor(Object transaction, String[] outMessages, Object decoded, String account, Object fees) {

            this.transaction = transaction;

            this.outMessages = outMessages;

            this.decoded = decoded;

            this.account = account;

            this.fees = fees;

        }



        @JsonProperty("transaction")
        private Object transaction;
        /**
         * Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
         */
        public Object getTransaction() {
            return transaction;
        }
        /**
         * Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
         */
        public void setTransaction(Object value) {
            transaction = value;
        }

        @JsonProperty("out_messages")
        private String[] outMessages;
        /**
         * List of output messages' BOCs. Encoded as `base64`
         */
        public String[] getOutMessages() {
            return outMessages;
        }
        /**
         * List of output messages' BOCs. Encoded as `base64`
         */
        public void setOutMessages(String[] value) {
            outMessages = value;
        }

        @JsonProperty("decoded")
        private Object decoded;
        /**
         * Optional decoded message bodies according to the optional `abi` parameter.
         */
        public Object getDecoded() {
            return decoded;
        }
        /**
         * Optional decoded message bodies according to the optional `abi` parameter.
         */
        public void setDecoded(Object value) {
            decoded = value;
        }

        @JsonProperty("account")
        private String account;
        /**
         * Updated account state BOC. Encoded as `base64`
         */
        public String getAccount() {
            return account;
        }
        /**
         * Updated account state BOC. Encoded as `base64`
         */
        public void setAccount(String value) {
            account = value;
        }

        @JsonProperty("fees")
        private Object fees;
        /**
         * Transaction fees
         */
        public Object getFees() {
            return fees;
        }
        /**
         * Transaction fees
         */
        public void setFees(Object value) {
            fees = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((transaction==null?null:("\"transaction\":"+transaction)),(outMessages==null?null:("\"out_messages\":\""+outMessages+"\"")),(decoded==null?null:("\"decoded\":"+decoded)),(account==null?null:("\"account\":\""+account+"\"")),(fees==null?null:("\"fees\":"+fees))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfRunTvm  {
        public ResultOfRunTvm() {
        }

        public ResultOfRunTvm(String[] outMessages, Object decoded, String account) {

            this.outMessages = outMessages;

            this.decoded = decoded;

            this.account = account;

        }



        @JsonProperty("out_messages")
        private String[] outMessages;
        /**
         * List of output messages' BOCs. Encoded as `base64`
         */
        public String[] getOutMessages() {
            return outMessages;
        }
        /**
         * List of output messages' BOCs. Encoded as `base64`
         */
        public void setOutMessages(String[] value) {
            outMessages = value;
        }

        @JsonProperty("decoded")
        private Object decoded;
        /**
         * Optional decoded message bodies according to the optional `abi` parameter.
         */
        public Object getDecoded() {
            return decoded;
        }
        /**
         * Optional decoded message bodies according to the optional `abi` parameter.
         */
        public void setDecoded(Object value) {
            decoded = value;
        }

        @JsonProperty("account")
        private String account;
        /**
         * Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
         */
        public String getAccount() {
            return account;
        }
        /**
         * Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
         */
        public void setAccount(String value) {
            account = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((outMessages==null?null:("\"out_messages\":\""+outMessages+"\"")),(decoded==null?null:("\"decoded\":"+decoded)),(account==null?null:("\"account\":\""+account+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Tvm(TONContext context) {
        this.context = context;
    }

   /**
    * 
    *
    * @param message Input message BOC. Must be encoded as base64.
    * @param account Account to run on executor
    * @param executionOptions Execution options.
    * @param abi Contract ABI for decoding output messages
    * @param skipTransactionCheck Skip transaction check flag
    */
    public CompletableFuture<ResultOfRunExecutor> runExecutor(String message, AccountForExecutor account, ExecutionOptions executionOptions, Abi.ABI abi, Boolean skipTransactionCheck) {
        return context.requestJSON("tvm.run_executor", "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(account==null?null:("\"account\":"+account)),(executionOptions==null?null:("\"execution_options\":"+executionOptions)),(abi==null?null:("\"abi\":"+abi)),(skipTransactionCheck==null?null:("\"skip_transaction_check\":"+skipTransactionCheck))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfRunExecutor.class));
    }

   /**
    * 
    *
    * @param message Input message BOC. Must be encoded as base64.
    * @param account Account BOC. Must be encoded as base64.
    * @param executionOptions Execution options.
    * @param abi Contract ABI for dedcoding output messages
    */
    public CompletableFuture<ResultOfRunTvm> runTvm(String message, String account, ExecutionOptions executionOptions, Abi.ABI abi) {
        return context.requestJSON("tvm.run_tvm", "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(account==null?null:("\"account\":\""+account+"\"")),(executionOptions==null?null:("\"execution_options\":"+executionOptions)),(abi==null?null:("\"abi\":"+abi))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfRunTvm.class));
    }

   /**
    * Executes getmethod and returns data from TVM stack
    *
    * @param account Account BOC in `base64`
    * @param functionName Function name
    * @param input Input parameters
    * @param executionOptions 
    * @return  Values returned by getmethod on stack
    */
    public CompletableFuture<Object> runGet(String account, String functionName, Object input, ExecutionOptions executionOptions) {
        return context.requestJSON("tvm.run_get", "{"+Stream.of((account==null?null:("\"account\":\""+account+"\"")),(functionName==null?null:("\"function_name\":\""+functionName+"\"")),(input==null?null:("\"input\":"+input)),(executionOptions==null?null:("\"execution_options\":"+executionOptions))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("output"), Object.class));
    }

}
