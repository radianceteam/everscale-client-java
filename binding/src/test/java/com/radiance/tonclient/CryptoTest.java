package com.radiance.tonclient;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.JsonNode;

public class CryptoTest extends TestBase {

    Base64.Encoder base64 = Base64.getEncoder();
    Base64.Decoder base64Decoder = Base64.getDecoder();

    @Test
    public void math() throws Exception {
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
    }

    @Test
    public void hash() throws Exception {
        assertEquals("crypto.sha512",
            "2616a44e0da827f0244e93c2b0b914223737a6129bc938b8edf2780ac9482960baa9b7c7cdb11457c1cebd5ae77e295ed94577f32d4c963dc35482991442daa5",
            crypto.sha512(base64.encodeToString("Message to hash with sha 512".getBytes())).get()
        );

        assertEquals("crypto.sha256",
            "16fd057308dd358d5a9b3ba2de766b2dfd5e308478fc1f7ba5988db2493852f5",
            crypto.sha256(base64.encodeToString("Message to hash with sha 256".getBytes())).get()
        );

    }

    @Test
    public void keys() throws Exception {
        // generateRandomSignKeys
        Crypto.KeyPair keys = crypto.generateRandomSignKeys().get();
        System.out.println("crypto.generateRandomSignKeys():  public:" + keys.getPublic() + " secret:" + keys.getSecret());

        // convertPublicKeyToTonSafeFormat
        String safePublic = crypto.convertPublicKeyToTonSafeFormat(keys.getPublic()).get();
        System.out.println("Safe public key: '" + safePublic + "'");

        // generateRandomBytes
        String randomBytes = crypto.generateRandomBytes(15).get();
        assertEquals("length of crypto.generateRandomBytes(15)", 20, randomBytes.length());
        System.out.println("Random bytes: " + randomBytes);

        // sign
        Crypto.ResultOfSign ros = crypto.sign(randomBytes, keys).get();
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
        String xPrivate = crypto.hdkeyXprvFromMnemonic("abuse boss fly battle rubber wasp afraid hamster guide essence vibrant tattoo", null, null).get();
        System.out.println("Extended private key: " + xPrivate);
        assertEquals("crypto.hdkeyXprvFromMnemonic", "xprv9s21ZrQH143K25JhKqEwvJW7QAiVvkmi4WRenBZanA6kxHKtKAQQKwZG65kCyW5jWJ8NY9e3GkRoistUjjcpHNsGBUv94istDPXvqGNuWpC", xPrivate);

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

    @Test
    public void scrypt() throws Exception {
        assertEquals("crypto.scrypt",
            "52e7fcf91356eca55fc5d52f16f5d777e3521f54e3c570c9bbb7df58fc15add73994e5db42be368de7ebed93c9d4f21f9be7cc453358d734b04a057d0ed3626d",
            crypto.scrypt(
                base64.encodeToString("Test Password".getBytes()),
                base64.encodeToString("Test Salt".getBytes()),
                10, // logN
                8,  // r
                16, // p
                64  // dkLen
            ).get()
        );
    }

    @Test
    public void nacl() throws Exception {
        // Sign
        assertEquals("crypto.naclSignKeypairFromSecretKey",
            "aa5533618573860a7e1bf19f34bd292871710ed5b2eafa0dcdbb33405f2231c6",
            crypto.naclSignKeypairFromSecretKey(
                "8fb4f2d256e57138fb310b0a6dac5bbc4bee09eb4821223a720e5b8e1f3dd674"
            ).get().getPublic()
        );

        assertEquals("crypto.naclSign",
            "+wz+QO6l1slgZS5s65BNqKcu4vz24FCJz4NSAxef9lu0jFfs8x3PzSZRC+pn5k8+aJi3xYMA3BQzglQmjK3hA1Rlc3QgTWVzc2FnZQ==",
            crypto.naclSign(
                base64.encodeToString("Test Message".getBytes()),
                "56b6a77093d6fdf14e593f36275d872d75de5b341942376b2a08759f3cbae78f1869b7ef29d58026217e9cf163cbfbd0de889bdf1bf4daebf5433a312f5b8d6e"
            ).get()
        );

        assertEquals("crypto.naclSignOpen",
            "Test Message",
            new String(base64Decoder.decode(crypto.naclSignOpen(
                "+wz+QO6l1slgZS5s65BNqKcu4vz24FCJz4NSAxef9lu0jFfs8x3PzSZRC+pn5k8+aJi3xYMA3BQzglQmjK3hA1Rlc3QgTWVzc2FnZQ==",
                "1869b7ef29d58026217e9cf163cbfbd0de889bdf1bf4daebf5433a312f5b8d6e"
            ).get()))
        );

        // Box
        Crypto.KeyPair keys = crypto.naclBoxKeypair().get();
        assertEquals(64, keys.getPublic().length());
        assertEquals(64, keys.getSecret().length());
        assertNotEquals(keys.getPublic(), keys.getSecret());

        assertEquals("crypto.naclBoxKeypairFromSecretKey",
            "a53b003d3ffc1e159355cb37332d67fc235a7feb6381e36c803274074dc3933a",
            crypto.naclBoxKeypairFromSecretKey(
                "e207b5966fb2c5be1b71ed94ea813202706ab84253bdf4dc55232f82a1caf0d4"
            ).get().getPublic()
        );

        assertEquals("crypto.naclBox",
            "li4XED4kx/pjQ2qdP0eR2d/K30uN94voNADxwA==",
            crypto.naclBox(
                base64.encodeToString("Test Message".getBytes()),   // decrypted
                "cd7f99924bf422544046e83595dd5803f17536f5c9a11746", // nonce
                "c4e2d9fe6a6baf8d1812b799856ef2a306291be7a7024837ad33a8530db79c6b", // theirPublic
                "d9b9dc5033fb416134e5d2107fdbacab5aadb297cb82dbdcd137d663bac59f7f"  // secret
            ).get()
        );

        assertEquals("crypto.naclBoxOpen",
            "Test Message",
            new String(base64Decoder.decode(crypto.naclBoxOpen(
                "li4XED4kx/pjQ2qdP0eR2d/K30uN94voNADxwA==",   // encrypted
                "cd7f99924bf422544046e83595dd5803f17536f5c9a11746", // nonce
                "c4e2d9fe6a6baf8d1812b799856ef2a306291be7a7024837ad33a8530db79c6b", // theirPublic
                "d9b9dc5033fb416134e5d2107fdbacab5aadb297cb82dbdcd137d663bac59f7f"  // secret
            ).get()))
        );
    }

    @Test
    public void testSigningBox() throws Exception {
        CompletableFuture<Integer> res = crypto.registerSigningBox(new AppSigningBox() {
            public CompletableFuture<String> getPublicKey() {
                return CompletableFuture.completedFuture("abcdef");
            }

            public CompletableFuture<String> sign(String unsigned) {
                return CompletableFuture.completedFuture("0123456789abcdef");
            };
        });

        Integer handle = res.get();
        System.out.println("Handle: " + handle);

        CompletableFuture<Abi.ResultOfEncodeMessageBody> encoded = abiModule.encodeMessageBody(
            abiFromResource("/Transfer.abi.json"),
            new Abi.CallSet("transfer", null, "{\"comment\":\""+ (new BigInteger(1, "Hello friend!!!".getBytes()).toString(16)) +"\"}"),
            true,
            new Abi.Signer.SigningBox(handle),
            null
        );

        System.out.println("Encoded: " + encoded.get());
        crypto.removeSigningBox(handle);
    }
}

