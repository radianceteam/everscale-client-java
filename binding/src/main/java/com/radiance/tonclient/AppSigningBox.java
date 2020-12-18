package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

public interface AppSigningBox {
    CompletableFuture<String> getPublicKey();
    CompletableFuture<String> sign(String unsigned);
}
