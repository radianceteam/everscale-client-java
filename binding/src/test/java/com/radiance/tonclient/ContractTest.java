package com.radiance.tonclient;

import org.junit.*;

public class ContractTest extends TestBase {

    @Test
    public void test1() throws Exception {
        Crypto.KeyPair keyPair = crypto.generateRandomSignKeys().get();
        System.out.println(keyPair);
    }

}
