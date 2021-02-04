package com.radiance.tonclient;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;
import java.util.*;
import java.util.concurrent.*;

public class UtilsTest extends TestBase {
    static final String accountId = "fcb91a3a3816d0f7b8c2c76108b8a9bc5a6b7a55bd79f8ab101c52db29232260";
    static final String hex = "-1:fcb91a3a3816d0f7b8c2c76108b8a9bc5a6b7a55bd79f8ab101c52db29232260";
    static final String hexWorkchain0 = "0:fcb91a3a3816d0f7b8c2c76108b8a9bc5a6b7a55bd79f8ab101c52db29232260";
    static final String base64 = "Uf/8uRo6OBbQ97jCx2EIuKm8Wmt6Vb15+KsQHFLbKSMiYG+9";
    static final String base64url = "kf_8uRo6OBbQ97jCx2EIuKm8Wmt6Vb15-KsQHFLbKSMiYIny";

    @Test
    public void testUtils() throws Exception {
        Utils utils = new Utils(context);

        String converted = utils.convertAddress(accountId, Utils.AddressStringFormat.Hex).get();
        assertEquals("Format AccountId Hex", hexWorkchain0, converted);

        converted = utils.convertAddress(accountId, Utils.AddressStringFormat.AccountId).get();
        assertEquals("Format AccountId AccountId", accountId, converted);

        converted = utils.convertAddress(hex, new Utils.AddressStringFormat.Base64(false,false,false)).get();
        assertEquals("Format Hex Base64", base64, converted);

        converted = utils.convertAddress(base64, new Utils.AddressStringFormat.Base64(true,true,true)).get();
        assertEquals("Format Base64 base64url", base64url, converted);

        converted = utils.convertAddress(base64url, Utils.AddressStringFormat.Hex).get();
        assertEquals("Format Base64url Hex", hex, converted);
    }
}

