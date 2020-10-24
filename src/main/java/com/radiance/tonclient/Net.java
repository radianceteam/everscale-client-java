package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

/**
 *   Network access.
 */
public class Net {


    
    private TONContext context;

    public Net(TONContext context) {
        this.context = context;
    }

  /**
   *  Queries collection data<p> Queries data that satisfies the `filter` conditions,  limits the number of returned records and orders them. The projection fields are limited to  `result` fields
   *
   * @param collection  Collection name (accounts, blocks, transactions, messages, block_signatures)
   * @param filter  Collection filter
   * @param result  Projection (result) string
   * @param order  Sorting order
   * @param limit  Number of documents to return
   */
    public CompletableFuture<String[]> queryCollection(String collection, String filter, String result, String order, Number limit) {
        return context.requestJSON("net.query_collection", "{" + String.join(",", new String[]{"\"collection\":\""+collection+"\"","\"filter\":\""+filter+"\"","\"result\":\""+result+"\"","\"order\":\""+order+"\"","\"limit\":"+limit}) + "}")
            .thenApply(json -> {
                Iterable<JsonNode> it = () -> json.findValue("result").elements();
                return StreamSupport.stream(it.spliterator(), false)
                    .map(e -> e.asText())
                    .toArray(String[]::new);
            });
    }

  /**
   *  Returns an object that fulfills the conditions or waits for its appearance<p> Triggers only once.  If object that satisfies the `filter` conditions  already exists - returns it immediately.  If not - waits for insert/update of data withing the specified `timeout`, and returns it.  The projection fields are limited to  `result` fields
   *
   * @param collection  Collection name (accounts, blocks, transactions, messages, block_signatures)
   * @param filter  Collection filter
   * @param result  Projection (result) string
   * @param timeout  Query timeout
   */
    public CompletableFuture<String> waitForCollection(String collection, String filter, String result, Number timeout) {
        return context.requestJSON("net.wait_for_collection", "{" + String.join(",", new String[]{"\"collection\":\""+collection+"\"","\"filter\":\""+filter+"\"","\"result\":\""+result+"\"","\"timeout\":"+timeout}) + "}")
            .thenApply(json -> json.findValue("result").asText());
    }

  /**
   *  Cancels a subscription<p> Cancels a subscription specified by its handle.
   *
   * @param handle  Subscription handle. Must be closed with `unsubscribe`
   */
    public CompletableFuture<String> unsubscribe(Number handle) {
        return context.request("net.unsubscribe", "{" + String.join(",", new String[]{"\"handle\":"+handle}) + "}");
    }

  /**
   *  Creates a subscription<p> Triggers for each insert/update of data that satisfies the `filter` conditions. The projection fields are limited to  `result` fields.
   *
   * @param collection  Collection name (accounts, blocks, transactions, messages, block_signatures)
   * @param filter  Collection filter
   * @param result  Projection (result) string
   */
    public CompletableFuture<Number> subscribeCollection(String collection, String filter, String result) {
        return context.requestJSON("net.subscribe_collection", "{" + String.join(",", new String[]{"\"collection\":\""+collection+"\"","\"filter\":\""+filter+"\"","\"result\":\""+result+"\""}) + "}")
            .thenApply(json -> TONContext.toNumber(json.findValue("handle").asText()));
    }

}
