package com.radiance.tonclient;

import org.junit.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ProcessingTest extends TestBase {

    @Test
    public void testWaitMessage() throws Exception {
        Crypto.KeyPair keys = crypto.generateRandomSignKeys().get();
        Abi.ABI abi = eventsAbi;
        String tvc = eventsTvc;

        Abi.ResultOfEncodeMessage encoded = abiModule.encodeMessage(
            abi,
            null,
            new Abi.DeploySet(tvc, null, null),
            new Abi.CallSet(
                "constructor",
                new Abi.FunctionHeader((int)(System.currentTimeMillis()/1000) + 10, null, keys.getPublic())),
            new Abi.Signer.Keys(keys),
            null
        ).get();

        getGramsFromGiver(encoded.getAddress()).get();

        Collection<String> events = Collections.synchronizedCollection(new ArrayList<>());
        AtomicInteger transCounter = new AtomicInteger();

        Number subscription = net.subscribeCollection("transactions", null, "id account_addr", event -> {
            if (event.getResult().findValue("account_addr").asText().equals(encoded.getAddress()))
                transCounter.incrementAndGet();
        }).get();

        String blockId = processing.sendMessage(encoded.getMessage(), abi, true, event -> {
            events.add(event.getType());
        }).get();
        System.out.println("Block Id: " + blockId);

        processing.waitForTransaction(abi, encoded.getMessage(), blockId, true, event -> {
            events.add(event.getType());
        }).get();

        net.unsubscribe(subscription).get();

        assertArrayEquals(new String[] {"WillFetchFirstBlock", "WillSend", "DidSend", "WillFetchNextBlock"}, events.toArray(new String[0]));
        assertNotEquals("Transaction counter", 0, transCounter.get());
    }
}