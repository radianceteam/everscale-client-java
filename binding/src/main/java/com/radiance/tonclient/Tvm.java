package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *  
 */
public class Tvm {

    /**
     *  
     */
    public static class ExecutionOptions  {

        public ExecutionOptions(String blockchainConfig, Number blockTime, Long blockLt, Long transactionLt) {

            this.blockchainConfig = blockchainConfig;

            this.blockTime = blockTime;

            this.blockLt = blockLt;

            this.transactionLt = transactionLt;

        }
        public ExecutionOptions(String blockchainConfig, Number blockTime, Long blockLt) {

            this.blockchainConfig = blockchainConfig;

            this.blockTime = blockTime;

            this.blockLt = blockLt;

        }
        public ExecutionOptions(String blockchainConfig, Number blockTime) {

            this.blockchainConfig = blockchainConfig;

            this.blockTime = blockTime;

        }
        public ExecutionOptions(String blockchainConfig) {

            this.blockchainConfig = blockchainConfig;

        }
        public ExecutionOptions() {

        }


        @JsonProperty("blockchain_config")
        private String blockchainConfig;
        /**
         * 
         */
        public String getBlockchainConfig() {
            return blockchainConfig;
        }
        /**
         * 
         */
        public void setBlockchainConfig(String value) {
            this.blockchainConfig = value;
        }

        @JsonProperty("block_time")
        private Number blockTime;
        /**
         * 
         */
        public Number getBlockTime() {
            return blockTime;
        }
        /**
         * 
         */
        public void setBlockTime(Number value) {
            this.blockTime = value;
        }

        @JsonProperty("block_lt")
        private Long blockLt;
        /**
         * 
         */
        public Long getBlockLt() {
            return blockLt;
        }
        /**
         * 
         */
        public void setBlockLt(Long value) {
            this.blockLt = value;
        }

        @JsonProperty("transaction_lt")
        private Long transactionLt;
        /**
         * 
         */
        public Long getTransactionLt() {
            return transactionLt;
        }
        /**
         * 
         */
        public void setTransactionLt(Long value) {
            this.transactionLt = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((blockchainConfig==null?null:("\"blockchain_config\":\""+blockchainConfig+"\"")),(blockTime==null?null:("\"block_time\":"+blockTime)),(blockLt==null?null:("\"block_lt\":"+blockLt)),(transactionLt==null?null:("\"transaction_lt\":"+transactionLt))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    public static abstract class AccountForExecutor {

        public static final None None = new None();

    /**
     *  
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
     *  
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
     *  
     */
    public static class Account extends AccountForExecutor  {

        public Account(String boc, Boolean unlimitedBalance) {

            this.boc = boc;

            this.unlimitedBalance = unlimitedBalance;

        }
        public Account(String boc) {

            this.boc = boc;

        }
        public Account() {

        }


        @JsonProperty("boc")
        private String boc;
        /**
         * Encoded as base64.
         */
        public String getBoc() {
            return boc;
        }
        /**
         * Encoded as base64.
         */
        public void setBoc(String value) {
            this.boc = value;
        }

        @JsonProperty("unlimited_balance")
        private Boolean unlimitedBalance;
        /**
         * Can be used to calculate transaction fees without balance check
         */
        public Boolean getUnlimitedBalance() {
            return unlimitedBalance;
        }
        /**
         * Can be used to calculate transaction fees without balance check
         */
        public void setUnlimitedBalance(Boolean value) {
            this.unlimitedBalance = value;
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
    public static class TransactionFees  {

        public TransactionFees(Long inMsgFwdFee, Long storageFee, Long gasFee, Long outMsgsFwdFee, Long totalAccountFees, Long totalOutput, Long extInMsgFee, Long totalFwdFees, Long accountFees) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

            this.gasFee = gasFee;

            this.outMsgsFwdFee = outMsgsFwdFee;

            this.totalAccountFees = totalAccountFees;

            this.totalOutput = totalOutput;

            this.extInMsgFee = extInMsgFee;

            this.totalFwdFees = totalFwdFees;

            this.accountFees = accountFees;

        }
        public TransactionFees(Long inMsgFwdFee, Long storageFee, Long gasFee, Long outMsgsFwdFee, Long totalAccountFees, Long totalOutput, Long extInMsgFee, Long totalFwdFees) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

            this.gasFee = gasFee;

            this.outMsgsFwdFee = outMsgsFwdFee;

            this.totalAccountFees = totalAccountFees;

            this.totalOutput = totalOutput;

            this.extInMsgFee = extInMsgFee;

            this.totalFwdFees = totalFwdFees;

        }
        public TransactionFees(Long inMsgFwdFee, Long storageFee, Long gasFee, Long outMsgsFwdFee, Long totalAccountFees, Long totalOutput, Long extInMsgFee) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

            this.gasFee = gasFee;

            this.outMsgsFwdFee = outMsgsFwdFee;

            this.totalAccountFees = totalAccountFees;

            this.totalOutput = totalOutput;

            this.extInMsgFee = extInMsgFee;

        }
        public TransactionFees(Long inMsgFwdFee, Long storageFee, Long gasFee, Long outMsgsFwdFee, Long totalAccountFees, Long totalOutput) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

            this.gasFee = gasFee;

            this.outMsgsFwdFee = outMsgsFwdFee;

            this.totalAccountFees = totalAccountFees;

            this.totalOutput = totalOutput;

        }
        public TransactionFees(Long inMsgFwdFee, Long storageFee, Long gasFee, Long outMsgsFwdFee, Long totalAccountFees) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

            this.gasFee = gasFee;

            this.outMsgsFwdFee = outMsgsFwdFee;

            this.totalAccountFees = totalAccountFees;

        }
        public TransactionFees(Long inMsgFwdFee, Long storageFee, Long gasFee, Long outMsgsFwdFee) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

            this.gasFee = gasFee;

            this.outMsgsFwdFee = outMsgsFwdFee;

        }
        public TransactionFees(Long inMsgFwdFee, Long storageFee, Long gasFee) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

            this.gasFee = gasFee;

        }
        public TransactionFees(Long inMsgFwdFee, Long storageFee) {

            this.inMsgFwdFee = inMsgFwdFee;

            this.storageFee = storageFee;

        }
        public TransactionFees(Long inMsgFwdFee) {

            this.inMsgFwdFee = inMsgFwdFee;

        }
        public TransactionFees() {

        }


        @JsonProperty("in_msg_fwd_fee")
        private Long inMsgFwdFee;
        /**
         * Left for backward compatibility. Does not participate in account transaction fees calculation.
         */
        public Long getInMsgFwdFee() {
            return inMsgFwdFee;
        }
        /**
         * Left for backward compatibility. Does not participate in account transaction fees calculation.
         */
        public void setInMsgFwdFee(Long value) {
            this.inMsgFwdFee = value;
        }

        @JsonProperty("storage_fee")
        private Long storageFee;
        /**
         * 
         */
        public Long getStorageFee() {
            return storageFee;
        }
        /**
         * 
         */
        public void setStorageFee(Long value) {
            this.storageFee = value;
        }

        @JsonProperty("gas_fee")
        private Long gasFee;
        /**
         * 
         */
        public Long getGasFee() {
            return gasFee;
        }
        /**
         * 
         */
        public void setGasFee(Long value) {
            this.gasFee = value;
        }

        @JsonProperty("out_msgs_fwd_fee")
        private Long outMsgsFwdFee;
        /**
         * Contains the same data as total_fwd_fees field. Deprecated because of its confusing name, that is not the same with GraphQL API Transaction type's field.
         */
        public Long getOutMsgsFwdFee() {
            return outMsgsFwdFee;
        }
        /**
         * Contains the same data as total_fwd_fees field. Deprecated because of its confusing name, that is not the same with GraphQL API Transaction type's field.
         */
        public void setOutMsgsFwdFee(Long value) {
            this.outMsgsFwdFee = value;
        }

        @JsonProperty("total_account_fees")
        private Long totalAccountFees;
        /**
         * This is the field that is named as `total_fees` in GraphQL API Transaction type. `total_account_fees` name is misleading, because it does not mean account fees, instead it meansvalidators total fees received for the transaction execution. It does not include some forward fees that accountactually pays now, but validators will receive later during value delivery to another account (not even in the receivingtransaction).Because of all of this, this field is not interesting for those who wants to understandthe real account fees, this is why it is deprecated and left for backward compatibility.
         */
        public Long getTotalAccountFees() {
            return totalAccountFees;
        }
        /**
         * This is the field that is named as `total_fees` in GraphQL API Transaction type. `total_account_fees` name is misleading, because it does not mean account fees, instead it meansvalidators total fees received for the transaction execution. It does not include some forward fees that accountactually pays now, but validators will receive later during value delivery to another account (not even in the receivingtransaction).Because of all of this, this field is not interesting for those who wants to understandthe real account fees, this is why it is deprecated and left for backward compatibility.
         */
        public void setTotalAccountFees(Long value) {
            this.totalAccountFees = value;
        }

        @JsonProperty("total_output")
        private Long totalOutput;
        /**
         * 
         */
        public Long getTotalOutput() {
            return totalOutput;
        }
        /**
         * 
         */
        public void setTotalOutput(Long value) {
            this.totalOutput = value;
        }

        @JsonProperty("ext_in_msg_fee")
        private Long extInMsgFee;
        /**
         * 
         */
        public Long getExtInMsgFee() {
            return extInMsgFee;
        }
        /**
         * 
         */
        public void setExtInMsgFee(Long value) {
            this.extInMsgFee = value;
        }

        @JsonProperty("total_fwd_fees")
        private Long totalFwdFees;
        /**
         * 
         */
        public Long getTotalFwdFees() {
            return totalFwdFees;
        }
        /**
         * 
         */
        public void setTotalFwdFees(Long value) {
            this.totalFwdFees = value;
        }

        @JsonProperty("account_fees")
        private Long accountFees;
        /**
         * 
         */
        public Long getAccountFees() {
            return accountFees;
        }
        /**
         * 
         */
        public void setAccountFees(Long value) {
            this.accountFees = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((inMsgFwdFee==null?null:("\"in_msg_fwd_fee\":"+inMsgFwdFee)),(storageFee==null?null:("\"storage_fee\":"+storageFee)),(gasFee==null?null:("\"gas_fee\":"+gasFee)),(outMsgsFwdFee==null?null:("\"out_msgs_fwd_fee\":"+outMsgsFwdFee)),(totalAccountFees==null?null:("\"total_account_fees\":"+totalAccountFees)),(totalOutput==null?null:("\"total_output\":"+totalOutput)),(extInMsgFee==null?null:("\"ext_in_msg_fee\":"+extInMsgFee)),(totalFwdFees==null?null:("\"total_fwd_fees\":"+totalFwdFees)),(accountFees==null?null:("\"account_fees\":"+accountFees))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfRunExecutor  {

        public ResultOfRunExecutor(Object transaction, String[] outMessages, Processing.DecodedOutput decoded, String account, TransactionFees fees) {

            this.transaction = transaction;

            this.outMessages = outMessages;

            this.decoded = decoded;

            this.account = account;

            this.fees = fees;

        }
        public ResultOfRunExecutor(Object transaction, String[] outMessages, Processing.DecodedOutput decoded, String account) {

            this.transaction = transaction;

            this.outMessages = outMessages;

            this.decoded = decoded;

            this.account = account;

        }
        public ResultOfRunExecutor(Object transaction, String[] outMessages, Processing.DecodedOutput decoded) {

            this.transaction = transaction;

            this.outMessages = outMessages;

            this.decoded = decoded;

        }
        public ResultOfRunExecutor(Object transaction, String[] outMessages) {

            this.transaction = transaction;

            this.outMessages = outMessages;

        }
        public ResultOfRunExecutor(Object transaction) {

            this.transaction = transaction;

        }
        public ResultOfRunExecutor() {

        }


        @JsonProperty("transaction")
        private Object transaction;
        /**
         * In addition to the regular transaction fields there is a`boc` field encoded with `base64` which contains sourcetransaction BOC.
         */
        public Object getTransaction() {
            return transaction;
        }
        /**
         * In addition to the regular transaction fields there is a`boc` field encoded with `base64` which contains sourcetransaction BOC.
         */
        public void setTransaction(Object value) {
            this.transaction = value;
        }

        @JsonProperty("out_messages")
        private String[] outMessages;
        /**
         * Encoded as `base64`
         */
        public String[] getOutMessages() {
            return outMessages;
        }
        /**
         * Encoded as `base64`
         */
        public void setOutMessages(String[] value) {
            this.outMessages = value;
        }

        @JsonProperty("decoded")
        private Processing.DecodedOutput decoded;
        /**
         * 
         */
        public Processing.DecodedOutput getDecoded() {
            return decoded;
        }
        /**
         * 
         */
        public void setDecoded(Processing.DecodedOutput value) {
            this.decoded = value;
        }

        @JsonProperty("account")
        private String account;
        /**
         * Encoded as `base64`
         */
        public String getAccount() {
            return account;
        }
        /**
         * Encoded as `base64`
         */
        public void setAccount(String value) {
            this.account = value;
        }

        @JsonProperty("fees")
        private TransactionFees fees;
        /**
         * 
         */
        public TransactionFees getFees() {
            return fees;
        }
        /**
         * 
         */
        public void setFees(TransactionFees value) {
            this.fees = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((transaction==null?null:("\"transaction\":"+transaction)),(outMessages==null?null:("\"out_messages\":\""+Arrays.toString(outMessages)+"\"")),(decoded==null?null:("\"decoded\":"+decoded)),(account==null?null:("\"account\":\""+account+"\"")),(fees==null?null:("\"fees\":"+fees))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfRunTvm  {

        public ResultOfRunTvm(String[] outMessages, Processing.DecodedOutput decoded, String account) {

            this.outMessages = outMessages;

            this.decoded = decoded;

            this.account = account;

        }
        public ResultOfRunTvm(String[] outMessages, Processing.DecodedOutput decoded) {

            this.outMessages = outMessages;

            this.decoded = decoded;

        }
        public ResultOfRunTvm(String[] outMessages) {

            this.outMessages = outMessages;

        }
        public ResultOfRunTvm() {

        }


        @JsonProperty("out_messages")
        private String[] outMessages;
        /**
         * Encoded as `base64`
         */
        public String[] getOutMessages() {
            return outMessages;
        }
        /**
         * Encoded as `base64`
         */
        public void setOutMessages(String[] value) {
            this.outMessages = value;
        }

        @JsonProperty("decoded")
        private Processing.DecodedOutput decoded;
        /**
         * 
         */
        public Processing.DecodedOutput getDecoded() {
            return decoded;
        }
        /**
         * 
         */
        public void setDecoded(Processing.DecodedOutput value) {
            this.decoded = value;
        }

        @JsonProperty("account")
        private String account;
        /**
         * Encoded as `base64`. Attention! Only `account_state.storage.state.data` part of the BOC is updated.
         */
        public String getAccount() {
            return account;
        }
        /**
         * Encoded as `base64`. Attention! Only `account_state.storage.state.data` part of the BOC is updated.
         */
        public void setAccount(String value) {
            this.account = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((outMessages==null?null:("\"out_messages\":\""+Arrays.toString(outMessages)+"\"")),(decoded==null?null:("\"decoded\":"+decoded)),(account==null?null:("\"account\":\""+account+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Tvm(TONContext context) {
        this.context = context;
    }

   /**
    * Performs all the phases of contract execution on Transaction Executor -the same component that is used on Validator Nodes.<p>Can be used for contract debugging, to find out the reason why a message was not delivered successfully.Validators throw away the failed external inbound messages (if they failed bedore `ACCEPT`) in the real network.This is why these messages are impossible to debug in the real network.With the help of run_executor you can do that. In fact, `process_message` functionperforms local check with `run_executor` if there was no transaction as a result of processingand returns the error, if there is one.<p>Another use case to use `run_executor` is to estimate fees for message execution.Set  `AccountForExecutor::Account.unlimited_balance`to `true` so that emulation will not depend on the actual balance.This may be needed to calculate deploy fees for an account that does not exist yet.JSON with fees is in `fees` field of the result.<p>One more use case - you can produce the sequence of operations,thus emulating the sequential contract calls locally.And so on.<p>Transaction executor requires account BOC (bag of cells) as a parameter.To get the account BOC - use `net.query` method to download it from GraphQL API(field `boc` of `account`) or generate it with `abi.encode_account` method.<p>Also it requires message BOC. To get the message BOC - use `abi.encode_message` or `abi.encode_internal_message`.<p>If you need this emulation to be as precise as possible (for instance - emulate transactionwith particular lt in particular block or use particular blockchain config,downloaded from a particular key block - then specify `execution_options` parameter.<p>If you need to see the aborted transaction as a result, not as an error, set `skip_transaction_check` to `true`.
    *
    * @param message Must be encoded as base64.
    * @param account 
    * @param executionOptions 
    * @param abi 
    * @param skipTransactionCheck 
    * @param bocCache The BOC itself returned if no cache type provided
    * @param returnUpdatedAccount Empty string is returned if the flag is `false`
    */
    public CompletableFuture<ResultOfRunExecutor> runExecutor(String message, AccountForExecutor account, ExecutionOptions executionOptions, Abi.ABI abi, Boolean skipTransactionCheck, Boc.BocCacheType bocCache, Boolean returnUpdatedAccount) {
        return context.requestJSON("tvm.run_executor", "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(account==null?null:("\"account\":"+account)),(executionOptions==null?null:("\"execution_options\":"+executionOptions)),(abi==null?null:("\"abi\":"+abi)),(skipTransactionCheck==null?null:("\"skip_transaction_check\":"+skipTransactionCheck)),(bocCache==null?null:("\"boc_cache\":"+bocCache)),(returnUpdatedAccount==null?null:("\"return_updated_account\":"+returnUpdatedAccount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfRunExecutor.class));
    }

   /**
    * Performs only a part of compute phase of transaction executionthat is used to run get-methods of ABI-compatible contracts.<p>If you try to run get-methods with `run_executor` you will get an error, because it checks ACCEPT and exitsif there is none, which is actually true for get-methods.<p> To get the account BOC (bag of cells) - use `net.query` method to download it from GraphQL API(field `boc` of `account`) or generate it with `abi.encode_account method`.To get the message BOC - use `abi.encode_message` or prepare it any other way, for instance, with FIFT script.<p>Attention! Updated account state is produces as well, but only`account_state.storage.state.data`  part of the BOC is updated.
    *
    * @param message Must be encoded as base64.
    * @param account Must be encoded as base64.
    * @param executionOptions 
    * @param abi 
    * @param bocCache The BOC itself returned if no cache type provided
    * @param returnUpdatedAccount Empty string is returned if the flag is `false`
    */
    public CompletableFuture<ResultOfRunTvm> runTvm(String message, String account, ExecutionOptions executionOptions, Abi.ABI abi, Boc.BocCacheType bocCache, Boolean returnUpdatedAccount) {
        return context.requestJSON("tvm.run_tvm", "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(account==null?null:("\"account\":\""+account+"\"")),(executionOptions==null?null:("\"execution_options\":"+executionOptions)),(abi==null?null:("\"abi\":"+abi)),(bocCache==null?null:("\"boc_cache\":"+bocCache)),(returnUpdatedAccount==null?null:("\"return_updated_account\":"+returnUpdatedAccount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfRunTvm.class));
    }

   /**
    * Executes a get-method of FIFT contract that fulfills the smc-guidelines https://test.ton.org/smc-guidelines.txtand returns the result data from TVM's stack
    *
    * @param account 
    * @param functionName 
    * @param input 
    * @param executionOptions 
    * @param tupleListAsArray Default is `false`. Input parameters may use any of lists representationsIf you receive this error on Web: "Runtime error. Unreachable code should not be executed...",set this flag to true.This may happen, for example, when elector contract contains too many participants
    */
    public CompletableFuture<Object> runGet(String account, String functionName, Object input, ExecutionOptions executionOptions, Boolean tupleListAsArray) {
        return context.requestJSON("tvm.run_get", "{"+Stream.of((account==null?null:("\"account\":\""+account+"\"")),(functionName==null?null:("\"function_name\":\""+functionName+"\"")),(input==null?null:("\"input\":"+input)),(executionOptions==null?null:("\"execution_options\":"+executionOptions)),(tupleListAsArray==null?null:("\"tuple_list_as_array\":"+tupleListAsArray))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("output"), Object.class));
    }

}
