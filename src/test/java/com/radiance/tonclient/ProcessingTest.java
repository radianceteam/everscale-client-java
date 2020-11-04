package com.radiance.tonclient;

import org.junit.*;

import static org.junit.Assert.assertEquals;

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

        String blockId = processing.sendMessage(encoded.getMessage(), abi, true, event -> {
            System.out.println("Send message: " + event);
        }).get();
        System.out.println("Block Id: " + blockId);

        ResultOfProcessMessage depResult = processing.waitForTransaction(abi, encoded.getMessage(), blockId, true, event -> {
            System.out.println("Transaction: " + event);
        }).get();
        System.out.println("Deploy result: " + depResult);

    }
}