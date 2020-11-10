package com.radiance.tonclient;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.JsonNode;

public class TONClientTest extends TestBase {
    private static final Pattern versionPattern = Pattern.compile("\\d+\\.\\d+\\.\\d+");

    @Test
    public void clientTest() throws Exception {
        ClientModule client = new ClientModule(context);
        String version = client.version().get();
        System.out.println("client.version: " + version);
        assertTrue("Version pattern doesn't match", versionPattern.matcher(version).matches());
    }

    @Test
    public void subscription() throws Exception {
        //net.waitForCollection("accounts");
        
        Number handle = net.subscribeCollection("transactions", null, "id account_addr", event -> System.out.println("Event: " + event)).get();
        System.out.println("Handle: " + handle);
        Thread.sleep(3000);
        net.unsubscribe(handle).get();;
    }
}

