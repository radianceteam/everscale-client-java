package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;

/**
 *   Misc utility Functions.
 */
public class UtilsModule {

    private TONContext context;

    public UtilsModule(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> convertAddress(String address, AddressStringFormat outputFormat) {
        return context.requestJSON("utils.convert_address", "{"+Stream.of((address==null?null:("\"address\":\""+address+"\"")),(outputFormat==null?null:("\"output_format\":"+outputFormat))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("address"), String.class));
    }

}
