package com.radiance.tonclient;

import org.junit.*;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.Base64;

public abstract class TestBase {
    protected static TONContext context;
    protected static CryptoModule crypto;
    protected static AbiModule abiModule;
    protected static ProcessingModule processing;
    protected static NetModule net;

    protected static Abi eventsAbi, giverWalletAbi, walletAbi, multisigWalletAbi, giverAbi;
    protected static String eventsTvc;


    @BeforeClass
    public static void init() throws Exception {
        //context = TONContext.create("{\"network\": {\"server_address\": \"net.ton.dev\"}}");
        context = TONContext.create("{\"network\": {\"server_address\": \"http://localhost\"}}");
        crypto = new CryptoModule(context);
        abiModule = new AbiModule(context);
        processing = new ProcessingModule(context);
        net = new NetModule(context);

        eventsAbi = new Abi.Serialized(TestBase.class.getResourceAsStream("/Events.abi.json"));
        eventsTvc = new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get(TestBase.class.getResource("/Events.tvc").toURI()))));
        giverWalletAbi = new Abi.Serialized(TestBase.class.getResourceAsStream("/GiverWallet.abi.json"));
        walletAbi = new Abi.Serialized(TestBase.class.getResourceAsStream("/Wallet.abi.json"));
        multisigWalletAbi = new Abi.Serialized(TestBase.class.getResourceAsStream("/SetcodeMultisigWallet.abi.json"));
        giverAbi = new Abi.Serialized(TestBase.class.getResourceAsStream("/Giver.abi.json"));
    }

    @AfterClass
    public static void destroy() {
        if (context != null)
            context.destroy();
    }


    @Before
    public void beforeTest() {
        System.out.println("==============================");
    }

    protected CompletableFuture<String> signDetached(String data, KeyPair keys) {
        return crypto.naclSignKeypairFromSecretKey(keys.getSecret())
            .thenCompose(signKeys -> crypto.naclSignDetached(data, signKeys.getSecret()));
    }
/*
    protected CompletableFuture<ResultOfProcessMessage> getGramsFromGiver(String address) {
        Abi abi = giverAbi;
        String[] message = new String[1];

        return abiModule.encodeMessage(
            abi,
            "0:841288ed3b55d9cdafa806807f02a0ae0c169aa5edfe88a789a6482429756a94",
            null,
            new CallSet(
                "sendGrams",
                null,
                "{\"dest\":\"" + address +"\", \"amount\":500000000}"),
            Signer.None,
            null)
        .thenCompose(encoded -> {
            System.out.println("Encoded: " + encoded);
            message[0] = encoded.getMessage();
            return processing.sendMessage(message[0], abi, true, event -> System.out.println("Event: " + event));
        })
        .thenCompose(blockId -> {
            System.out.println("Send Result: " + blockId);
            return processing.waitForTransaction(abi, message[0], blockId, true, event -> {
                System.out.println("Transaction: " + event);
            });
        });
    }*/

    protected CompletableFuture<ResultOfProcessMessage> getGramsFromGiver(String address) {
        return processing.processMessage(
            giverAbi,
            "0:841288ed3b55d9cdafa806807f02a0ae0c169aa5edfe88a789a6482429756a94",
            null,
            new CallSet(
                "sendGrams",
                null,
                "{\"dest\":\"" + address +"\", \"amount\":500000000}"),
            Signer.None,
            null,
            false,
            null); //event -> System.out.println("Event: " + event));
    }
}
