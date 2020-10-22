package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

public class Tvm {
    private TONContext context;

    public Tvm(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> executeMessage(String _message, String _account, String _mode, String _executionOptions) {
        return context.request("tvm.execute_message", "{" + String.join(",", new String[]{"\"message\":\""+_message+"\"","\"account\":\""+_account+"\"","\"mode\":\""+_mode+"\"","\"execution_options\":\""+_executionOptions+"\""}) + "}");
    }

    public CompletableFuture<String> executeGet(String _account, String _functionName, String _input, String _executionOptions) {
        return context.request("tvm.execute_get", "{" + String.join(",", new String[]{"\"account\":\""+_account+"\"","\"function_name\":\""+_functionName+"\"","\"input\":\""+_input+"\"","\"execution_options\":\""+_executionOptions+"\""}) + "}");
    }

}
