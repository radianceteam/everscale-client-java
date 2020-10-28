package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

/**
 *  
 */
public class Tvm {

    private TONContext context;

    public Tvm(TONContext context) {
        this.context = context;
    }

  /**
   * 
   *
   * @param message  Input message BOC. Must be encoded as base64.
   * @param account  Account to run on executor
   * @param executionOptions  Execution options.
   * @param abi  Contract ABI for decoding output messages
   * @param skipTransactionCheck  Skip transaction check flag
   */
    public CompletableFuture<ResultOfRunExecutor> runExecutor(String message, String account, ExecutionOptions executionOptions, String abi, Boolean skipTransactionCheck) {
        return context.requestValue("tvm.run_executor", "{\"message\":\""+message+"\",\"account\":\""+account+"\",\"execution_options\":"+executionOptions+",\"abi\":\""+abi+"\",\"skip_transaction_check\":"+skipTransactionCheck+"}", ResultOfRunExecutor.class);
    }

  /**
   * 
   *
   * @param message  Input message BOC. Must be encoded as base64.
   * @param account  Account BOC. Must be encoded as base64.
   * @param executionOptions  Execution options.
   * @param abi  Contract ABI for dedcoding output messages
   */
    public CompletableFuture<ResultOfRunTvm> runTvm(String message, String account, ExecutionOptions executionOptions, String abi) {
        return context.requestValue("tvm.run_tvm", "{\"message\":\""+message+"\",\"account\":\""+account+"\",\"execution_options\":"+executionOptions+",\"abi\":\""+abi+"\"}", ResultOfRunTvm.class);
    }

  /**
   *  Executes getmethod and returns data from TVM stack
   *
   * @param account  Account BOC in `base64`
   * @param functionName  Function name
   * @param input  Input parameters
   */
    public CompletableFuture<String> runGet(String account, String functionName, String input, ExecutionOptions executionOptions) {
        return context.requestJSON("tvm.run_get", "{\"account\":\""+account+"\",\"function_name\":\""+functionName+"\",\"input\":\""+input+"\",\"execution_options\":"+executionOptions+"}")
            .thenApply(json -> json.findValue("output").asText());
    }

}
