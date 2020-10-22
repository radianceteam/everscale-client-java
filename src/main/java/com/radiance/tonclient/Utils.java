package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

public class Utils {
    private TONContext context;

    public Utils(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> convertAddress(String _address, String _outputFormat) {
        return context.requestJSON("utils.convert_address", "{" + String.join(",", new String[]{"\"address\":\""+_address+"\"","\"output_format\":\""+_outputFormat+"\""}) + "}")
            .thenApply(json -> json.findValue("address").toString());
    }

}
