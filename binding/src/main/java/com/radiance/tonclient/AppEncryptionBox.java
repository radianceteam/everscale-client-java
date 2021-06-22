package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

public interface AppEncryptionBox {
    CompletableFuture<Object> getInfo();
    CompletableFuture<String> encrypt(String data);
    CompletableFuture<String> decrypt(String data);
}
