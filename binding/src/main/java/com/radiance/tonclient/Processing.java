package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *  This module incorporates functions related to complex messageprocessing scenarios.
 */
public class Processing {

    /**
     *  
     */
    public static class ResultOfProcessMessage  {

        public ResultOfProcessMessage(Object transaction, String[] outMessages, DecodedOutput decoded, Tvm.TransactionFees fees) {

            this.transaction = transaction;

            this.outMessages = outMessages;

            this.decoded = decoded;

            this.fees = fees;

        }
        public ResultOfProcessMessage(Object transaction, String[] outMessages, DecodedOutput decoded) {

            this.transaction = transaction;

            this.outMessages = outMessages;

            this.decoded = decoded;

        }
        public ResultOfProcessMessage(Object transaction, String[] outMessages) {

            this.transaction = transaction;

            this.outMessages = outMessages;

        }
        public ResultOfProcessMessage(Object transaction) {

            this.transaction = transaction;

        }
        public ResultOfProcessMessage() {

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
        private DecodedOutput decoded;
        /**
         * 
         */
        public DecodedOutput getDecoded() {
            return decoded;
        }
        /**
         * 
         */
        public void setDecoded(DecodedOutput value) {
            this.decoded = value;
        }

        @JsonProperty("fees")
        private Tvm.TransactionFees fees;
        /**
         * 
         */
        public Tvm.TransactionFees getFees() {
            return fees;
        }
        /**
         * 
         */
        public void setFees(Tvm.TransactionFees value) {
            this.fees = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((transaction==null?null:("\"transaction\":"+transaction)),(outMessages==null?null:("\"out_messages\":\""+Arrays.toString(outMessages)+"\"")),(decoded==null?null:("\"decoded\":"+decoded)),(fees==null?null:("\"fees\":"+fees))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class DecodedOutput  {

        public DecodedOutput(Abi.DecodedMessageBody[] outMessages, Object output) {

            this.outMessages = outMessages;

            this.output = output;

        }
        public DecodedOutput(Abi.DecodedMessageBody[] outMessages) {

            this.outMessages = outMessages;

        }
        public DecodedOutput() {

        }


        @JsonProperty("out_messages")
        private Abi.DecodedMessageBody[] outMessages;
        /**
         * If the message can't be decoded, then `None` will be stored inthe appropriate position.
         */
        public Abi.DecodedMessageBody[] getOutMessages() {
            return outMessages;
        }
        /**
         * If the message can't be decoded, then `None` will be stored inthe appropriate position.
         */
        public void setOutMessages(Abi.DecodedMessageBody[] value) {
            this.outMessages = value;
        }

        @JsonProperty("output")
        private Object output;
        /**
         * 
         */
        public Object getOutput() {
            return output;
        }
        /**
         * 
         */
        public void setOutput(Object value) {
            this.output = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((outMessages==null?null:("\"out_messages\":"+Arrays.toString(outMessages))),(output==null?null:("\"output\":"+output))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfSendMessage  {

        public ResultOfSendMessage(String shardBlockId, String[] sendingEndpoints) {

            this.shardBlockId = shardBlockId;

            this.sendingEndpoints = sendingEndpoints;

        }
        public ResultOfSendMessage(String shardBlockId) {

            this.shardBlockId = shardBlockId;

        }
        public ResultOfSendMessage() {

        }


        @JsonProperty("shard_block_id")
        private String shardBlockId;
        /**
         * This block id must be used as a parameter of the`wait_for_transaction`.
         */
        public String getShardBlockId() {
            return shardBlockId;
        }
        /**
         * This block id must be used as a parameter of the`wait_for_transaction`.
         */
        public void setShardBlockId(String value) {
            this.shardBlockId = value;
        }

        @JsonProperty("sending_endpoints")
        private String[] sendingEndpoints;
        /**
         * This list id must be used as a parameter of the`wait_for_transaction`.
         */
        public String[] getSendingEndpoints() {
            return sendingEndpoints;
        }
        /**
         * This list id must be used as a parameter of the`wait_for_transaction`.
         */
        public void setSendingEndpoints(String[] value) {
            this.sendingEndpoints = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((shardBlockId==null?null:("\"shard_block_id\":\""+shardBlockId+"\"")),(sendingEndpoints==null?null:("\"sending_endpoints\":\""+Arrays.toString(sendingEndpoints)+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Processing(TONContext context) {
        this.context = context;
    }

   /**
    * Sends message to the network and returns the last generated shard block of the destination accountbefore the message was sent. It will be required later for message processing.
    *
    * @param message 
    * @param abi If this parameter is specified and the message has the`expire` header then expiration time will be checked againstthe current time to prevent unnecessary sending of already expired message.<p>The `message already expired` error will be returned in thiscase.<p>Note, that specifying `abi` for ABI compliant contracts isstrongly recommended, so that proper processing strategy can bechosen.
    * @param sendEvents 
    */
    public CompletableFuture<ResultOfSendMessage> sendMessage(String message, Abi.ABI abi, Boolean sendEvents, Consumer<SendMessageEvent> consumer) {
        return context.requestJSONCallback("processing.send_message", "{"+Stream.of((message==null?null:("\"message\":\""+message+"\"")),(abi==null?null:("\"abi\":"+abi)),(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", (event,type)->consumer.accept(event), SendMessageEvent.class)
            .thenApply(json -> TONContext.convertValue(json, ResultOfSendMessage.class));
    }

   /**
    * `send_events` enables intermediate events, such as `WillFetchNextBlock`,`FetchNextBlockFailed` that may be useful for logging of new shard blocks creationduring message processing.<p>Note, that presence of the `abi` parameter is critical for ABIcompliant contracts. Message processing uses drasticallydifferent strategy for processing message for contracts whichABI includes "expire" header.<p>When the ABI header `expire` is present, the processing uses`message expiration` strategy:- The maximum block gen time is set to  `message_expiration_timeout + transaction_wait_timeout`.- When maximum block gen time is reached, the processing will  be finished with `MessageExpired` error.<p>When the ABI header `expire` isn't present or `abi` parameterisn't specified, the processing uses `transaction waiting`strategy:- The maximum block gen time is set to  `now() + transaction_wait_timeout`.<p>- If maximum block gen time is reached and no result transaction is found,the processing will exit with an error.
    *
    * @param abi If it is specified, then the output messages' bodies will bedecoded according to this ABI.<p>The `abi_decoded` result field will be filled out.
    * @param message Encoded with `base64`.
    * @param shardBlockId You must provide the same value as the `send_message` has returned.
    * @param sendEvents 
    * @param sendingEndpoints Use this field to get more informative errors.Provide the same value as the `send_message` has returned.If the message was not delivered (expired), SDK will log the endpoint URLs, used for its sending.
    */
    public CompletableFuture<ResultOfProcessMessage> waitForTransaction(Abi.ABI abi, String message, String shardBlockId, Boolean sendEvents, String[] sendingEndpoints, Consumer<WaitForTransactionEvent> consumer) {
        return context.requestJSONCallback("processing.wait_for_transaction", "{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(message==null?null:("\"message\":\""+message+"\"")),(shardBlockId==null?null:("\"shard_block_id\":\""+shardBlockId+"\"")),(sendEvents==null?null:("\"send_events\":"+sendEvents)),(sendingEndpoints==null?null:("\"sending_endpoints\":\""+Arrays.toString(sendingEndpoints)+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", (event,type)->consumer.accept(event), WaitForTransactionEvent.class)
            .thenApply(json -> TONContext.convertValue(json, ResultOfProcessMessage.class));
    }

   /**
    * Creates ABI-compatible message,sends it to the network and monitors for the result transaction.Decodes the output messages' bodies.<p>If contract's ABI includes "expire" header, thenSDK implements retries in case of unsuccessful message delivery within the expirationtimeout: SDK recreates the message, sends it and processes it again.<p>The intermediate events, such as `WillFetchFirstBlock`, `WillSend`, `DidSend`,`WillFetchNextBlock`, etc - are switched on/off by `send_events` flagand logged into the supplied callback function.<p>The retry configuration parameters are defined in the client's `NetworkConfig` and `AbiConfig`.<p>If contract's ABI does not include "expire" headerthen, if no transaction is found within the network timeout (see config parameter ), exits with error.
    *
    * @param abi 
    * @param address Must be specified in case of non-deploy message.
    * @param deploySet Must be specified in case of deploy message.
    * @param callSet Must be specified in case of non-deploy message.<p>In case of deploy message it is optional and contains parametersof the functions that will to be called upon deploy transaction.
    * @param signer 
    * @param processingTryIndex Used in message processing with retries (if contract's ABI includes "expire" header).<p>Encoder uses the provided try index to calculate messageexpiration time. The 1st message expiration time is specified inClient config.<p>Expiration timeouts will grow with every retry.Retry grow factor is set in Client config:&lt;.....add config parameter with default value here&gt;<p>Default value is 0.
    * @param sendEvents 
    */
    public CompletableFuture<ResultOfProcessMessage> processMessage(Abi.ABI abi, String address, Abi.DeploySet deploySet, Abi.CallSet callSet, Abi.Signer signer, Number processingTryIndex, Boolean sendEvents, Consumer<ProcessMessageEvent> consumer) {
        return context.requestJSONCallback("processing.process_message", "{"+Stream.of("\"message_encode_params\":"+"{"+Stream.of((abi==null?null:("\"abi\":"+abi)),(address==null?null:("\"address\":\""+address+"\"")),(deploySet==null?null:("\"deploy_set\":"+deploySet)),(callSet==null?null:("\"call_set\":"+callSet)),(signer==null?null:("\"signer\":"+signer)),(processingTryIndex==null?null:("\"processing_try_index\":"+processingTryIndex))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}",(sendEvents==null?null:("\"send_events\":"+sendEvents))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", (event,type)->consumer.accept(event), ProcessMessageEvent.class)
            .thenApply(json -> TONContext.convertValue(json, ResultOfProcessMessage.class));
    }

}
