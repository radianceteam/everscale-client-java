package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;

/**
 *  
 */
public class TvmModule {

    private TONContext context;

    public TvmModule(TONContext context) {
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
    public CompletableFuture<ResultOfRunExecutor> runExecutor(String message, AccountForExecutor account, ExecutionOptions executionOptions, Abi abi, Boolean skipTransactionCheck) {
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
    public CompletableFuture<ResultOfRunTvm> runTvm(String message, String account, ExecutionOptions executionOptions, Abi abi) {
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
