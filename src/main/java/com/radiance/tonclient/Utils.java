package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

/**
 *   Misc utility Functions.
 */
public class Utils {


    
    private TONContext context;

    public Utils(TONContext context) {
        this.context = context;
    }

  /**
   *  Converts address from any TON format to any TON format
   *
   * @param address  Account address in any TON format.
   * @param outputFormat  Specify the format to convert to.
   */
    public CompletableFuture<String> convertAddress(String address, String outputFormat) {
        return context.requestJSON("utils.convert_address", "{" + String.join(",", new String[]{"\"address\":\""+address+"\"","\"output_format\":\""+outputFormat+"\""}) + "}")
            .thenApply(json -> json.findValue("address").asText());
    }

}
