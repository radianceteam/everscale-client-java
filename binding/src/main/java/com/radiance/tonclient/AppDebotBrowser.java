package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

public interface AppDebotBrowser {
    CompletableFuture<Void> log(String msg);
    CompletableFuture<Void> switchTo(Number contextId);
    CompletableFuture<Void> showAction(Debot.DebotAction action);
    CompletableFuture<String> input(String prompt);
    CompletableFuture<Integer> getSigningBox();
    CompletableFuture<Void> invokeDebot(String debotAddr,Debot.DebotAction action);
}
