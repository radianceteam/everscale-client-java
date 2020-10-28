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

public class TONClientTest {
    private static final Pattern versionPattern = Pattern.compile("\\d+\\.\\d+\\.\\d+");
    private static TONContext context;

    @BeforeClass
    public static void init() throws Exception {
        context = TONContext.create("{\"network\": {\"server_address\": \"net.ton.dev\"}}");
    }


    @Test
    public void clientTest() throws Exception {
        Client client = new Client(context);
        String version = client.version().get();
        System.out.println("client.version: " + version);
        assertTrue("Version pattern doesn't match", versionPattern.matcher(version).matches());
    }

    @Test
    public void cryptoTest() throws Exception {
        Crypto crypto = new Crypto(context);
        
        // factorize
        int composite = 0xda;
        String[] factorizeResult = crypto.factorize(Integer.toHexString(composite)).get();
        System.out.println("crypto.factorize(\"" + Integer.toHexString(composite) + "\"): " + Arrays.asList(factorizeResult));
        assertEquals("crypto.factorize", composite, Arrays.stream(factorizeResult)
            .map(s -> Integer.parseInt(s, 16))
            .collect(Collectors.reducing((i1,i2)->i1*i2)).get().intValue()
        );

        try {
            crypto.factorize("c7").get();
            fail("Managed to factorize a prime number");
        } catch (ExecutionException e) {    // expected exception
            System.out.println(e.getCause());
        }

        // modularPower
        int[] params = {4,2,6};
        String modularPowerResult = crypto.modularPower(Integer.toHexString(params[0]), Integer.toHexString(params[1]), Integer.toHexString(params[2])).get();
        System.out.println("crypto.modularPower("+IntStream.of(params).mapToObj(Integer::toHexString).collect(Collectors.joining(","))+"): " + modularPowerResult);
        assertEquals("crypto.modularPower", Long.toHexString(Math.round(Math.pow(params[0], params[1]))%params[2]), modularPowerResult);

        // tonCrc16
        System.out.println("crypto.tonCrc16('abcdABCD0123'): " + crypto.tonCrc16("abcdABCD0123").get());

        // generateRandomSignKeys
        KeyPair keys = crypto.generateRandomSignKeys().get();
        System.out.println("crypto.generateRandomSignKeys():  public:" + keys.getPublic() + " secret:" + keys.getSecret());

        // convertPublicKeyToTonSafeFormat
        String safePublic = crypto.convertPublicKeyToTonSafeFormat(keys.getPublic()).get();
        System.out.println("Safe public key: '" + safePublic + "'");

        // generateRandomBytes
        String randomBytes = crypto.generateRandomBytes(15).get();
        assertEquals("length of crypto.generateRandomBytes(15)", 20, randomBytes.length());
        System.out.println("Random bytes: " + randomBytes);

        // sign
        ResultOfSign ros = crypto.sign(randomBytes, keys).get();
        System.out.println("crypto.sign: " + ros);

        // verifySignature
        String verified = crypto.verifySignature(ros.getSigned(), keys.getPublic()).get();
        System.out.println("crypto.verifySignature: " + verified);

        try {
            crypto.verifySignature(randomBytes, keys.getPublic()).get();
            fail("Verified wrong data");
        } catch (ExecutionException e) {    // expected exception
            System.out.println(e.getCause());
        }

        // mnemonicWords
        crypto.mnemonicWords(1).get();

        // hdkeyXprvFromMnemonic
        String xPrivate = crypto.hdkeyXprvFromMnemonic("the quick brown fox jumps over the lazy dog", 1, 10).get();
        System.out.println("Extended private key: " + xPrivate);

        // hdkeyPublicFromXprv
        String publicKey = crypto.hdkeyPublicFromXprv(xPrivate).get();
        System.out.println("Public key: " + publicKey);

        try {
            crypto.hdkeyPublicFromXprv(randomBytes).get();
            fail("Extraction from random data must fail");
        } catch(ExecutionException e) {     // expected exception
            System.out.println(e.getCause());
        }

        // hdkeySecretFromXprv
        String secretKey = crypto.hdkeySecretFromXprv(xPrivate).get();
        System.out.println("Secret key: " + secretKey);

        try {
            crypto.hdkeySecretFromXprv(randomBytes).get();
            fail("Extraction from random data must fail");
        } catch(ExecutionException e) {     // expected exception
            System.out.println(e.getCause());
        }
    }
/*
    
    @Test
    public void abiTest() throws Exception {
        Abi abi = new Abi(context);
        ResultOfAttachSignature roas = abi.attachSignature("\"Serialized\":{}","","","").get();
        System.out.println("ResultOfAttachSignature: " + roas);
    }
*/

    @Test
    public void subscription() throws Exception {
        Net net = new Net(context);
        //net.waitForCollection("accounts");
        //Number handle = net.subscribeCollection("account", null, null).get();
        String params = "{\"collection\": \"transactions\", \"result\": \"id account_addr\"}";
        //String params = "{\"collection\": \"transactions\"}";
        System.out.println("Params: " + params);
        String response = context.request("net.subscribe_collection", params).get();
        System.out.println("Response: " + response);
        Thread.sleep(5000);
    }


    @AfterClass
    public static void destroy() {
        if (context != null)
            context.destroy();
    }
}
