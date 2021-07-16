package com.radiance.app;

import com.radiance.tonclient.*;
import java.util.concurrent.CompletableFuture;

public class KeyGenerator {
    private TONContext context;
    private Crypto crypto;

    public KeyGenerator() throws TONException {
        context = TONContext.create("{\"network\": {\"server_address\": \"net.ton.dev\"}}");
        crypto = new Crypto(context);
    }

    public CompletableFuture<Crypto.KeyPair> generate() {
        return crypto.generateRandomSignKeys();
    }


    public void destroy() {
        context.destroy();
    }


    public static void main(String... args) throws TONException {
        KeyGenerator g = new KeyGenerator();

        System.out.println("CALLING THREAD " + Thread.currentThread());
        g.generate().whenComplete((keys, ex) -> {
            System.out.println("CALLBACK THREAD " + Thread.currentThread());
            System.out.println("KEYS " + keys);
            g.destroy();
        });
    }

}