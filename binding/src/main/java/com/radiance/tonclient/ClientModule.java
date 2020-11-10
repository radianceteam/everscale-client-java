package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;

/**
 *  Provides information about library.
 */
public class ClientModule {

    private TONContext context;

    public ClientModule(TONContext context) {
        this.context = context;
    }

   /**
    * Returns Core Library API reference
    *
    */
    public CompletableFuture<Object> getApiReference() {
        return context.requestJSON("client.get_api_reference", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("api"), Object.class));
    }

   /**
    * Returns Core Library version
    *
    * @return  Core Library version
    */
    public CompletableFuture<String> version() {
        return context.requestJSON("client.version", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("version"), String.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<Object> buildInfo() {
        return context.requestJSON("client.build_info", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("build_info"), Object.class));
    }

}
