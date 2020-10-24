package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

/**
 *  
 */
public class Tvm {

    public static class ResultOfRunExecutor {

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

        private String account;
        /**
         *  Updated account state BOC. Encoded as `base64`
         */
        public String getAccount() {
            return account;
        }
        /**
         *  Updated account state BOC. Encoded as `base64`
         */
        public void setAccount(String value) {
            account = value;
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

    public static class ResultOfRunTvm {

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

        private String account;
        /**
         *  Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
         */
        public String getAccount() {
            return account;
        }
        /**
         *  Updated account state BOC. Encoded as `base64`. Attention! Only data in account state is updated.
         */
        public void setAccount(String value) {
            account = value;
        }

    }

    
    private TONContext context;

    public Tvm(TONContext context) {
        this.context = context;
    }

  /**
   * 
   *
   * @param message  Input message BOC. Must be encoded as base64.
   * @param account  Account BOC. Must be encoded as base64.
   * @param executionOptions  Execution options.
   * @param abi  Contract ABI for dedcoding output messages
   */
    public CompletableFuture<ResultOfRunExecutor> runExecutor(String message, String account, String executionOptions, String abi) {
        return context.requestValue("tvm.run_executor", "{" + String.join(",", new String[]{"\"message\":\""+message+"\"","\"account\":\""+account+"\"","\"execution_options\":\""+executionOptions+"\"","\"abi\":\""+abi+"\""}) + "}", ResultOfRunExecutor.class);
    }

  /**
   * 
   *
   * @param message  Input message BOC. Must be encoded as base64.
   * @param account  Account BOC. Must be encoded as base64.
   * @param executionOptions  Execution options.
   * @param abi  Contract ABI for dedcoding output messages
   */
    public CompletableFuture<ResultOfRunTvm> runTvm(String message, String account, String executionOptions, String abi) {
        return context.requestValue("tvm.run_tvm", "{" + String.join(",", new String[]{"\"message\":\""+message+"\"","\"account\":\""+account+"\"","\"execution_options\":\""+executionOptions+"\"","\"abi\":\""+abi+"\""}) + "}", ResultOfRunTvm.class);
    }

  /**
   *  Executes getmethod and returns data from TVM stack
   *
   * @param account  Account BOC in `base64`
   * @param functionName  Function name
   * @param input  Input parameters
   */
    public CompletableFuture<String> runGet(String account, String functionName, String input, String executionOptions) {
        return context.requestJSON("tvm.run_get", "{" + String.join(",", new String[]{"\"account\":\""+account+"\"","\"function_name\":\""+functionName+"\"","\"input\":\""+input+"\"","\"execution_options\":\""+executionOptions+"\""}) + "}")
            .thenApply(json -> json.findValue("output").asText());
    }

}
