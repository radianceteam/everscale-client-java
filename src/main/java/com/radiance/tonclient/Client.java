package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

/**
 *   Provides information about library.
 */
public class Client {


    
    private TONContext context;

    public Client(TONContext context) {
        this.context = context;
    }

  /**
   *  Returns Core Library API reference
   *
   */
    public CompletableFuture<String> getApiReference() {
        return context.requestJSON("client.get_api_reference", "{" + String.join(",", new String[]{}) + "}")
            .thenApply(json -> json.findValue("api").asText());
    }

  /**
   *  Returns Core Library version
   *
   */
    public CompletableFuture<String> version() {
        return context.requestJSON("client.version", "{" + String.join(",", new String[]{}) + "}")
            .thenApply(json -> json.findValue("version").asText());
    }

  /**
   * 
   *
   */
    public CompletableFuture<String> buildInfo() {
        return context.requestJSON("client.build_info", "{" + String.join(",", new String[]{}) + "}")
            .thenApply(json -> json.findValue("build_info").asText());
    }

}
