package com.radiance.tonclient;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TONContext {
    // natives
    private static native String createContext(String config);
    private static native void destroyContext(int context);
    private static native void request(int context, String functionName, String params, int requestId);
    private static native String requestSync(int context, String functionName, String params);

    static {
        try {
            System.load(createTempDll("/tonclient.dll"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createTempDll(String fileName) throws IOException {
        InputStream inputStream = TONContext.class.getResourceAsStream(fileName);
        if (inputStream == null)
            throw new IOException("Cannot find resource '" + fileName + "'");
        File tempDll = File.createTempFile("TONLibrary", ".dll");
        FileOutputStream outputStream = new FileOutputStream(tempDll);
        byte[] array = new byte[8192];
        for (int i = inputStream.read(array); i != -1; i = inputStream.read(array)) {
            outputStream.write(array, 0, i);
        }
        inputStream.close();
        outputStream.close();
        tempDll.deleteOnExit();
        return tempDll.getAbsolutePath();
    }

    private static Pattern contextResultPattern = Pattern.compile("\\{\"(\\w+)\":(.+)\\}");

    private static int requestCount = 0;
    private static HashMap<Integer, CompletableFuture<String>> responses = new HashMap<>();

    private static void responseHandler(int id, String params, int type, boolean finished) {
        System.out.println("id=" + id + " params=" + params + " type=" + type + " finished=" + finished);
        CompletableFuture<String> future;
        synchronized (responses) {
            future = responses.remove(id);
        }
        if (future == null) {
            System.out.println("ResponseId not found " + id);
        } else
            future.complete(params);
    }

    public static TONContext create(String config) {
        String result = createContext(config);
        Matcher matcher = contextResultPattern.matcher(result);

        System.out.println(result);
        if (matcher.matches()) {
            return new TONContext(Integer.valueOf(matcher.group(2)));
        }
        return null;
    }

    private int contextId;
    private ObjectMapper jsonMapper = new ObjectMapper();

    private TONContext(int contextId) {
        this.contextId = contextId;
    }

    public void destroy() {
        if (contextId >= 0) {
            destroyContext(contextId);
            contextId = -1;
        }
    }

    public CompletableFuture<String> request(String functionName, String params) {
        CompletableFuture<String> future;

        synchronized (responses) {
            future = new CompletableFuture<>();
            responses.put(++requestCount, future);
            request(contextId, functionName, params, requestCount);
        }
        return future;
    }

    public CompletableFuture<JsonNode> requestJSON(String functionName, String params) {
        return request(functionName, params)
            .thenApply(r -> {
                try {
                    return jsonMapper.readTree(r);
                } catch (JsonProcessingException ex) {
                    throw new CompletionException(ex);
                }
            });
    }

    public static void main(String... args) throws Exception {
        TONContext ctx = TONContext.create("{}");
        Crypto crypto = new Crypto(ctx);

        System.out.println(Arrays.asList(crypto.factorize("EE").get()));
        //ctx.request("client.get_api_reference", "{}");
        System.out.println(ctx.request("client.version", "").get());

    }
}