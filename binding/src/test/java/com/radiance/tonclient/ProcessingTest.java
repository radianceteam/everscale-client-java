package com.radiance.tonclient;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessingTest extends TestBase {

    @Test
    public void testWaitMessage() throws Exception {
        KeyPair keys = crypto.generateRandomSignKeys().get();
        Abi abi = eventsAbi;
        String tvc = eventsTvc;

        ResultOfEncodeMessage encoded = abiModule.encodeMessage(
            abi,
            null,
            new DeploySet(tvc, null, null),
            new CallSet(
                "constructor",
                new FunctionHeader(Integer.MAX_VALUE, null, keys.getPublic()),
                null),
            new Signer.Keys(keys),
            null).get();

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

        //System.out.println("Events: " + events);
        //System.out.println("Transactions: " + transCounter.get());
        assertEquals(new String[] {"WillFetchFirstBlock", "WillSend", "DidSend", "WillFetchNextBlock"}, events.toArray(new String[0]));
        assertNotEquals("Transaction counter", 0, transCounter.get());
    }
}