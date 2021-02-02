package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

public interface AppDebotBrowser {
    void log(String msg);
    void switchTo(Number contextId);
    void switchCompleted();
    void showAction(Debot.DebotAction action);
    CompletableFuture<String> input(String prompt);
    CompletableFuture<Integer> getSigningBox();
    CompletableFuture<Void> invokeDebot(String debotAddr,Debot.DebotAction action);
    void send(String message);
}
