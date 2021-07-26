package com.radiance.tonclient;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;
import java.util.*;
import java.util.concurrent.*;
import static com.radiance.tonclient.Net.ParamsOfQueryOperation.*;

public class NetTest extends TestBase {

    @Test
    public void blockSignatures() throws Exception {
        net.queryCollection("blocks_signatures", null, "id", null, 1).get();
    }

    @Test
    public void allAccounts() throws Exception {
        Object[] accounts = net.queryCollection("accounts", null, "id balance", null, null).get();
        assertTrue("allAccounts", accounts.length > 0);
    }

    @Test
    public void ranges() throws Exception {
        Object[] messages = net.queryCollection(
            "messages",
             "{\"created_at\":{\"gt\":1562342740}}",
             "body created_at",
              null,
              null
        ).get();
        assertTrue("ranges", (Integer)((Map)messages[0]).get("created_at") > 156234274);
    }

    //@Test
    public void waitFor() throws Exception {
        long now = System.currentTimeMillis() / 1000;
        getGramsFromGiver(giverAddress).get();

        Map trans = (Map)net.waitForCollection(
            "transactions",
            "{\"now\":{\"ge\":" + now + "}}",
            "id now",
            null
        ).get(10, TimeUnit.SECONDS);
        assertTrue("waitFor", (Integer)trans.get("now") >= now);
    }

    //@Test
    public void subscribeForTransactionsWithAddresses() throws Exception {
        Crypto.KeyPair keysArr[] = new Crypto.KeyPair[1];
 
        String address = crypto.generateRandomSignKeys()
            .thenCompose(keys ->
                abiModule.encodeMessage(
                    helloAbi,
                    null,   // address
                    new Abi.DeploySet(helloTvc),
                    new Abi.CallSet("constructor"),
                    new Abi.Signer.Keys(keysArr[0] = keys),
                    null    // processingTryIndex
                )
            ).thenApply(msg -> msg.getAddress())
            .get();

        ArrayList<JsonNode> transactions = new ArrayList<>();
        Number handle = net.subscribeCollection(
            "transactions",
            "{\"account_addr\":{\"eq\":\"" + address + "\"},\"status\":{\"eq\":3}}", // 3 - Finalized
            "id account_addr status",
            event -> {
                synchronized (transactions) {
                    transactions.add(event.getResult());
                }
            }
        ).get();

        deployWithGiver(helloAbi, new Abi.DeploySet(helloTvc), new Abi.CallSet("constructor"), new Abi.Signer.Keys(keysArr[0])).get();

        // give some time for subscription to receive all data
        Thread.sleep(1000);

        net.unsubscribe(handle);
        synchronized (transactions) {
            assertEquals("Transactions size", 2, transactions.size());
            assertNotEquals(
                "Transactions Ids",
                transactions.get(0).findValue("id"),
                transactions.get(1).findValue("id")
            );
        }
    }

    @Test
    public void batchQuery() throws Exception {
        CompletableFuture<Object[]> result = net.batchQuery(new Net.ParamsOfQueryOperation[] {
            new QueryCollection("blocks_signatures", null, "id"),
            new AggregateCollection("accounts", null, new Net.FieldAggregation[] {})
        });
        assertEquals("Batch query", result.get().length, 2);
    }
}

