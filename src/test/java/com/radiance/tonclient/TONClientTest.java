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
    public static void init() throws TONException {
        context = TONContext.create("{}");
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
    }

    @AfterClass
    public static void destroy() {
        if (context != null)
            context.destroy();
    }
}
