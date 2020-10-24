package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

/**
 *   Message processing module.<p> This module incorporates functions related to complex message processing scenarios.
 */
public class Processing {

    public static class ResultOfProcessMessage {

        private String transaction;
        /**
         *  Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
         */
        public String getTransaction() {
            return transaction;
        }
        /**
         *  Parsed transaction.<p> In addition to the regular transaction fields there is a `boc` field encoded with `base64` which contains source transaction BOC.
         */
        public void setTransaction(String value) {
            transaction = value;
        }

        private String out_messages;
        /**
         *  List of output messages' BOCs. Encoded as `base64`
         */
        public String getOutMessages() {
            return out_messages;
        }
        /**
         *  List of output messages' BOCs. Encoded as `base64`
         */
        public void setOutMessages(String value) {
            out_messages = value;
        }

        private String decoded;
        /**
         *  Optional decoded message bodies according to the optional `abi` parameter.
         */
        public String getDecoded() {
            return decoded;
        }
        /**
         *  Optional decoded message bodies according to the optional `abi` parameter.
         */
        public void setDecoded(String value) {
            decoded = value;
        }

        private String fees;
        /**
         *  Transaction fees
         */
        public String getFees() {
            return fees;
        }
        /**
         *  Transaction fees
         */
        public void setFees(String value) {
            fees = value;
        }

    }

    
    private TONContext context;

    public Processing(TONContext context) {
        this.context = context;
    }

  /**
   *  Sends message to the network<p> Sends message to the network and returns the last generated shard block of the destination account before the message was sent. It will be required later for message processing.
   *
   * @param message  Message BOC.
   * @param abi  Optional message ABI.

 If this parameter is specified and the message has the
 `expire` header then expiration time will be checked against
 the current time to prevent an unnecessary sending of already expired message.

 The `message already expired` error will be returned in this
 case.

 Note that specifying `abi` for ABI compliant contracts is
 strongly recommended due to choosing proper processing
 strategy.
   * @param sendEvents  Flag for requesting events sending
   */
    public CompletableFuture<String> sendMessage(String message, String abi, Boolean sendEvents) {
        return context.requestJSON("processing.send_message", "{" + String.join(",", new String[]{"\"message\":\""+message+"\"","\"abi\":\""+abi+"\"","\"send_events\":"+sendEvents}) + "}")
            .thenApply(json -> json.findValue("shard_block_id").asText());
    }

  /**
   *  Performs monitoring of the network for the result transaction of the external inbound message processing.<p> `send_events` enables intermediate events, such as `WillFetchNextBlock`, `FetchNextBlockFailed` that may be useful for logging of new shard blocks creation  during message processing.<p> Note that presence of the `abi` parameter is critical for ABI compliant contracts. Message processing uses drastically different strategy for processing message for contracts which ABI includes "expire" header.<p> When the ABI header `expire` is present, the processing uses `message expiration` strategy: - The maximum block gen time is set to   `message_expiration_time + transaction_wait_timeout`. - When maximum block gen time is reached the processing will   be finished with `MessageExpired` error.<p> When the ABI header `expire` isn't present or `abi` parameter isn't specified, the processing uses `transaction waiting` strategy: - The maximum block gen time is set to   `now() + transaction_wait_timeout`.<p> - If maximum block gen time is reached and no result transaction is found  the processing will exit with an error.
   *
   * @param abi  Optional ABI for decoding the transaction result.

 If it is specified then the output messages' bodies will be
 decoded according to this ABI.

 The `abi_decoded` result field will be filled out.
   * @param message  Message BOC. Encoded with `base64`.
   * @param shardBlockId  The last generated block id of the destination account shard before the message was sent.

 You must provide the same value as the `send_message` has returned.
   * @param sendEvents  Flag that enables/disables intermediate events
   */
    public CompletableFuture<ResultOfProcessMessage> waitForTransaction(String abi, String message, String shardBlockId, Boolean sendEvents) {
        return context.requestValue("processing.wait_for_transaction", "{" + String.join(",", new String[]{"\"abi\":\""+abi+"\"","\"message\":\""+message+"\"","\"shard_block_id\":\""+shardBlockId+"\"","\"send_events\":"+sendEvents}) + "}", ResultOfProcessMessage.class);
    }

  /**
   *  Creates message, sends it to the network and monitors its processing.<p> Creates ABI-compatible message, sends it to the network and monitors for the result transaction. Decodes the output messages's bodies.<p> If contract's ABI includes "expire" header then SDK implements retries in case of unsuccessful message delivery within the expiration timeout: SDK recreates the message, sends it and processes it again. <p> The intermediate events, such as `WillFetchFirstBlock`, `WillSend`, `DidSend`, `WillFetchNextBlock`, etc - are switched on/off by `send_events` flag  and logged into the supplied callback function. The retry configuration parameters are defined in config: <add correct config params here> pub const DEFAULT_EXPIRATION_RETRIES_LIMIT: i8 = 3; - max number of retries pub const DEFAULT_EXPIRATION_TIMEOUT: u32 = 40000;  - message expiration timeout in ms. pub const DEFAULT_....expiration_timeout_grow_factor... = 1.5 - factor that increases the expiration timeout for each retry<p> If contract's ABI does not include "expire" header then if no transaction is found within the network timeout (see config parameter ), exits with error.
   *
   * @param messageEncodeParams  Message encode parameters.
   * @param sendEvents  Flag for requesting events sending
   */
    public CompletableFuture<ResultOfProcessMessage> processMessage(String messageEncodeParams, Boolean sendEvents) {
        return context.requestValue("processing.process_message", "{" + String.join(",", new String[]{"\"message_encode_params\":\""+messageEncodeParams+"\"","\"send_events\":"+sendEvents}) + "}", ResultOfProcessMessage.class);
    }

}
