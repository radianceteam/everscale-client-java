package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;

/**
 *  Misc utility Functions.
 */
public class UtilsModule {

    private TONContext context;

    public UtilsModule(TONContext context) {
        this.context = context;
    }

   /**
    * Converts address from any TON format to any TON format
    *
    * @param address Account address in any TON format.
    * @param outputFormat Specify the format to convert to.
    * @return  Address in the specified format
    */
    public CompletableFuture<String> convertAddress(String address, AddressStringFormat outputFormat) {
        return context.requestJSON("utils.convert_address", "{"+Stream.of((address==null?null:("\"address\":\""+address+"\"")),(outputFormat==null?null:("\"output_format\":"+outputFormat))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("address"), String.class));
    }

}
