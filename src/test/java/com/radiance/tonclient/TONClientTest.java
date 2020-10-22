package com.radiance.tonclient;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class TONClientTest {
    private static TONContext context;

    @BeforeClass
    public static void init() {
        context = TONContext.create("{}");
    }

    @Test
    public void clientTest() throws Exception {
        Client client = new Client(context);
        System.out.println("client.version: " + client.version().get());
    }

    @Test
    public void cryptoTest() throws Exception {
        Crypto crypto = new Crypto(context);
        System.out.println("crypto.factorize(12): " + Arrays.asList(crypto.factorize("12").get()));
        System.out.println("crypto.modularPower(4,2,3): " + crypto.modularPower("4","2","3").get());
        System.out.println("crypto.tonCrc16('abcdABCD0123'): " + crypto.tonCrc16("abcdABCD0123").get());
    }

    @AfterClass
    public static void destroy() {
        context.destroy();
    }
}
