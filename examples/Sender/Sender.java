package com.mycompany.app;

import com.radiance.tonclient.*;
import com.radiance.tonclient.Abi;
import com.radiance.tonclient.Crypto.KeyPair;
import static com.radiance.tonclient.Client.*;

import java.util.*;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

public class Sender {

    private Abi.ABI abiFromResource(String name) {
        Scanner s = new Scanner(getClass().getResourceAsStream(name)).useDelimiter("\\A");
        String data = s.hasNext() ? s.next() : "";
        s.close();
        return new Abi.ABI.Serialized(data);
    }

    public CompletableFuture<Void> sendMoney(String senderAddress, KeyPair senderKeys, String receipientAddress) throws Exception {
        TONContext ctx = TONContext.create(new ClientConfig(
            new NetworkConfig("https://net1.ton.dev/")
        ));

        Abi abi = new Abi(ctx);
        return abi.encodeMessageBody(
            abiFromResource("/Transfer.abi.json"),
            new Abi.CallSet("transfer", null, "{\"comment\":\""+ (new BigInteger(1, "Hello friend!!!".getBytes()).toString(16)) +"\"}"),
            true,
            Abi.Signer.None,
            null
        ).thenCompose(payload -> new Processing(ctx).processMessage(
                abiFromResource("/SetcodeMultisigWallet.abi.json"),
                senderAddress,
                null,
                new Abi.CallSet(
                    "sendTransaction",
                    null,
                    "{\"dest\":\"" + receipientAddress + "\", \"value\":300000000, \"bounce\":false, \"flags\":3, \"payload\":\""+ payload.getBody()+"\"}"
                ),
                new Abi.Signer.Keys(senderKeys),
                null,
                true,
                System.out::println
            ).thenApply(result -> {
                System.out.println(result);
                return null;
            })
        );
    }
}
