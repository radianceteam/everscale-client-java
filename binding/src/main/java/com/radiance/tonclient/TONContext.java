package com.radiance.tonclient;

import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Consumer;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.radiance.tonclient.*;

public class TONContext {
    private class Callback<T> {
        Consumer<T> consumer;
        Class<T> clazz;

        Callback(Consumer<T> consumer, Class<T> clazz) {
            this.consumer = consumer;
            this.clazz = clazz;
        }

        void invoke(String value) {
            try {
                consumer.accept(jsonMapper.readValue(value, clazz));
            } catch (JsonProcessingException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    // natives
    private static native String loadLibrary(String path);
    private static native String createContext(String config);
    private static native void destroyContext(int context);
    private static native void request(int context, String functionName, String params, int requestId);
    private static native String requestSync(int context, String functionName, String params);

    static {
        try {
            String osName = System.getProperty("os.name");
            //System.out.println("OS name: '" + osName + "'");
            osName = osName.toLowerCase();
            String libPath;
            if (osName.indexOf("mac") >= 0 || osName.indexOf("darwin") >= 0)
                libPath = "/libton_client_jni.dylib";
            else if (osName.indexOf("win") >= 0)
                libPath = "/libton_client_jni.so";
            else    // Linux
                libPath = "/libton_client_jni.so";
            System.load(createTempFile(libPath));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createTempFile(String resourceName) throws IOException {
        InputStream inputStream = TONContext.class.getResourceAsStream(resourceName);
        if (inputStream == null)
            throw new IOException("Cannot find resource '" + resourceName + "'");
        File tempFile = File.createTempFile("TONLibrary", resourceName.substring(resourceName.lastIndexOf('.')));
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        byte[] array = new byte[8192];
        for (int i = inputStream.read(array); i != -1; i = inputStream.read(array)) {
            outputStream.write(array, 0, i);
        }
        inputStream.close();
        outputStream.close();
        tempFile.deleteOnExit();
        return tempFile.getAbsolutePath();
    }

    private static int requestCount = 0;
    private static HashMap<Integer, CompletableFuture<String>> responses = new HashMap<>();
    private static HashMap<Integer, Callback<?>> callbacks = new HashMap<>();

    static Number toNumber(String value) {
        if (value.indexOf('.') < 0) {
            if (value.length() > 6)
                return Long.valueOf(value);
            else
                return Integer.valueOf(value);
        } else {
            if (value.length() > 7)
                return Double.valueOf(value);
            else
                return Float.valueOf(value);
        }
    }

    private static void responseHandler(int id, String params, int type, boolean finished) {
        //System.out.println("<= id=" + id + " params=" + params + " type=" + type + " finished=" + finished);
        CompletableFuture<String> future;
        Callback<?> callback;

        synchronized (responses) {
            future = finished?responses.remove(id):responses.get(id);
            callback = finished?callbacks.remove(id):callbacks.get(id);
        }
        switch (type) {
            case 0:     // RESULT
                if (future == null) {
                    System.out.println("ResponseId not found " + id);
                } else {
                    future.complete(params);
                }
                break;
            case 1:     // ERROR
                Throwable throwable;
                try {
                    JsonNode error = jsonMapper.readTree(params);
                    throwable = new TONException(Integer.parseInt(error.findValue("code").toString()), error.findValue("message").toString());
                } catch (Throwable t) {
                    throwable = t;
                }
                future.completeExceptionally(throwable);
                break;
            case 2:     // NOP
                if (future != null)
                    future.completeExceptionally(new TONException(0, "No result"));
                break;
            case 100:   // CUSTOM (Callback)
                if (callback == null) {
                    System.out.println("Callback not found " + id);
                } else {
                    callback.invoke(params);
                }
        }
    }

    public static TONContext create(Object config) throws TONException {
        String result = createContext(config==null?"":config.toString());
        //System.out.println(config + " => " + result);
        try {
            JsonNode json = jsonMapper.readTree(result);
            JsonNode error = json.findValue("error");
            if (error != null)
                throw new TONException(Integer.parseInt(error.findValue("code").toString()), error.findValue("message").toString());
            return new TONContext(Integer.valueOf(json.findValue("result").toString()));
        } catch (Throwable t) {
            throw new TONException(t);
        }
    }

    public static <T> T convertValue(JsonNode json, Class<T> valueType) {
        return jsonMapper.convertValue(json, valueType);
    }

    private int contextId;
    private static ObjectMapper jsonMapper = new ObjectMapper();

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
        return requestCallback(functionName, params, null, null);
    }

    public <T> CompletableFuture<String> requestCallback(String functionName, String params, Consumer<T> consumer, Class<T> clazz) {
        CompletableFuture<String> future;

        synchronized (responses) {
            future = new CompletableFuture<>();
            responses.put(++requestCount, future);
            if (consumer != null)
                callbacks.put(requestCount, new Callback<T>(consumer,clazz));
            //System.out.println("=> id=" + requestCount + " " +functionName + " " + params);
            request(contextId, functionName, params, requestCount);
        }
        return future;
    }

    public CompletableFuture<JsonNode> requestJSON(String functionName, String params) {
        return requestJSONCallback(functionName, params, null, null);
    }

    public <T> CompletableFuture<JsonNode> requestJSONCallback(String functionName, String params, Consumer<T> consumer, Class<T> clazz) {
        return requestCallback(functionName, params, consumer, clazz)
            .thenApply(r -> {
                try {
                    return jsonMapper.readTree(r);
                } catch (JsonProcessingException ex) {
                    throw new CompletionException(ex);
                }
            });
    }

    public <T> CompletableFuture<T> requestValue(String functionName, String params, Class<T> valueType) {
        return requestValueCallback(functionName, params, valueType, null, null);
    }

    public <V,C> CompletableFuture<V> requestValueCallback(String functionName, String params, Class<V> valueType, Consumer<C> consumer, Class<C> clazz) {
        return requestCallback(functionName, params, consumer, clazz)
            .thenApply(r -> {
                try {
                    return jsonMapper.readValue(r, valueType);
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