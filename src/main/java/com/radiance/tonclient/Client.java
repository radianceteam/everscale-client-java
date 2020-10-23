package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

public class Client {
    private TONContext context;

    public Client(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> getApiReference() {
        return context.request("client.get_api_reference", "{" + String.join(",", new String[]{}) + "}");
    }

    public CompletableFuture<String> version() {
        return context.requestJSON("client.version", "{" + String.join(",", new String[]{}) + "}")
            .thenApply(json -> json.findValue("version").asText());
    }

}
