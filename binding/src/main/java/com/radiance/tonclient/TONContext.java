package com.radiance.tonclient;

import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.BiConsumer;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.radiance.tonclient.*;

public class TONContext {
    private static Logger log = Logger.getLogger(TONContext.class.getName());
    private class Callback<T> {
        BiConsumer<T,Integer> consumer;
        Class<T> clazz;

        Callback(BiConsumer<T,Integer> consumer, Class<T> clazz) {
            this.consumer = consumer;
            this.clazz = clazz;
        }

        void invoke(String value, int type) {
            try {
                consumer.accept(jsonMapper.readValue(value, clazz), type);
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
            log.info("OS name: '" + osName + "'");
            osName = osName.toLowerCase();
            String libPath;
            if (osName.indexOf("mac") >= 0 || osName.indexOf("darwin") >= 0)
                libPath = "/libton_client_jni.dylib";
            else if (osName.indexOf("win") >= 0)
                libPath = "/ton_client_jni.dll";
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
        log.info("Using '" + tempFile.getAbsolutePath() + "' as '" + resourceName + "'");
        return tempFile.getAbsolutePath();
    }

    private static int requestCount = 0;
    private static HashMap<Integer, CompletableFuture<String>> responses = new HashMap<>();
    private static HashMap<Integer, Callback<?>> callbacks = new HashMap<>();
    private static HashMap<Integer, Object> appObjects = new HashMap<>();

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
        log.info("<= " + id + " " + params + " type=" + type + " finished=" + finished);
        CompletableFuture<String> future;
        Callback<?> callback;
        Object appObject;

        synchronized (responses) {
            future = finished?responses.remove(id):responses.get(id);
            callback = finished?callbacks.remove(id):callbacks.get(id);
            appObject = finished?appObjects.remove(id):appObjects.get(id);
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
            /*
            case 3:
                try {
                    JsonNode json = jsonMapper.readTree(params);
                    JsonNode requ = json.get("request_data");
                    String mName = requ.get("type").asText();
                    mName = Character.toLowerCase(mName.charAt(0)) + mName.substring(1);
                    log.info("-------- " + appObject.getClass() + " " + mName);
                } catch(JsonProcessingException e) {
                    log.severe(e.toString());
                }
                break;
            */
            case 3:
            case 4:
            case 100:   // CUSTOM (Callback)
                if (callback == null) {
                    System.out.println("Callback not found " + id);
                } else {
                    callback.invoke(params, type);
                }
        }
    }

    public static TONContext create(Object config) throws TONException {
        String result = createContext(config==null?"":config.toString());
        log.info("Create context: " + config + " => " + result);
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
        return requestCallback(functionName, params, null, null, null);
    }

    private <T> CompletableFuture<String> requestCallback(String functionName, String params, BiConsumer<T,Integer> consumer, Class<T> clazz, Object appObject) {
        CompletableFuture<String> future;

        synchronized (responses) {
            future = new CompletableFuture<>();
            responses.put(++requestCount, future);
            if (consumer != null) {
                callbacks.put(requestCount, new Callback<T>(consumer,clazz));
                //System.out.println(callbacks);
            }
            if (appObject != null) {
                appObjects.put(requestCount, appObject);
            }
            log.info("=> " + requestCount + " " +functionName + " " + params);
            request(contextId, functionName, params, requestCount);
        }
        return future;
    }

    private <T> CompletableFuture<JsonNode> requestJSONCallback(String functionName, String params, BiConsumer<T,Integer> consumer, Class<T> clazz, Object appObject) {
        return requestCallback(functionName, params, consumer, clazz, appObject)
            .thenApply(r -> {
                try {
                    return jsonMapper.readTree(r);
                } catch (JsonProcessingException ex) {
                    throw new CompletionException(ex);
                }
            });
    }

    public <T> CompletableFuture<JsonNode> requestJSONCallback(String functionName, String params, BiConsumer<T,Integer> consumer, Class<T> clazz) {
        return requestJSONCallback(functionName, params, consumer, clazz, null);
    }

    public CompletableFuture<JsonNode> requestJSON(String functionName, String params) {
        return requestJSONCallback(functionName, params, null, null);
    }

    public CompletableFuture<JsonNode> requestJSONAppObject(String functionName, String params, Object appObject) {
        return requestJSONCallback(functionName, params, null, null, appObject);
    }


/*
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
*/
    public static void main(String... args) throws Exception {
        TONContext ctx = TONContext.create("{}");
        Crypto crypto = new Crypto(ctx);

        System.out.println(Arrays.asList(crypto.factorize("EE").get()));
        //ctx.request("client.get_api_reference", "{}");
        System.out.println(ctx.request("client.version", "").get());

    }
}