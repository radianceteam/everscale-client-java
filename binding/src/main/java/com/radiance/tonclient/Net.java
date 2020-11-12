package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import ton.sdk.TONContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.function.Consumer;

/**
 *  Network access.
 */
public class Net {

    /**
     *  
     */
    public static class OrderBy  {
        public OrderBy() {
        }

        public OrderBy(String path, SortDirection direction) {

            this.path = path;

            this.direction = direction;

        }



        @JsonProperty("path")
        private String path;
        /**
         * 
         */
        public String getPath() {
            return path;
        }
        /**
         * 
         */
        public void setPath(String value) {
            path = value;
        }

        @JsonProperty("direction")
        private SortDirection direction;
        /**
         * 
         */
        public SortDirection getDirection() {
            return direction;
        }
        /**
         * 
         */
        public void setDirection(SortDirection value) {
            direction = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((path==null?null:("\"path\":\""+path+"\"")),(direction==null?null:("\"direction\":"+direction))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public enum SortDirection {
        
        /**
         * 
         */
        ASC,

        /**
         * 
         */
        DESC
    }
    private TONContext context;

    public Net(TONContext context) {
        this.context = context;
    }

   /**
    * Queries collection data<p> Queries data that satisfies the `filter` conditions, limits the number of returned records and orders them. The projection fields are limited to `result` fields
    *
    * @param collection Collection name (accounts, blocks, transactions, messages, block_signatures)
    * @param filter Collection filter
    * @param result Projection (result) string
    * @param order Sorting order
    * @param limit Number of documents to return
    * @return Objects that match the provided criteria
    */
    public CompletableFuture<Object[]> queryCollection(String collection, Object filter, String result, OrderBy[] order, Number limit) {
        return context.requestJSON("net.query_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\"")),(order==null?null:("\"order\":"+order)),(limit==null?null:("\"limit\":"+limit))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object[].class));
    }

   /**
    * Returns an object that fulfills the conditions or waits for its appearance<p> Triggers only once. If object that satisfies the `filter` conditions already exists - returns it immediately. If not - waits for insert/update of data within the specified `timeout`, and returns it. The projection fields are limited to `result` fields
    *
    * @param collection Collection name (accounts, blocks, transactions, messages, block_signatures)
    * @param filter Collection filter
    * @param result Projection (result) string
    * @param timeout Query timeout
    * @return First found object that matches the provided criteria
    */
    public CompletableFuture<Object> waitForCollection(String collection, Object filter, String result, Number timeout) {
        return context.requestJSON("net.wait_for_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\"")),(timeout==null?null:("\"timeout\":"+timeout))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object.class));
    }

   /**
    * Cancels a subscription<p> Cancels a subscription specified by its handle.
    *
    * @param handle Subscription handle. Must be closed with `unsubscribe`
    */
    public CompletableFuture<Void> unsubscribe(Number handle) {
        return context.requestJSON("net.unsubscribe", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * Creates a subscription<p> Triggers for each insert/update of data that satisfies the `filter` conditions. The projection fields are limited to `result` fields.
    *
    * @param collection Collection name (accounts, blocks, transactions, messages, block_signatures)
    * @param filter Collection filter
    * @param result Projection (result) string
    * @return Subscription handle. Must be closed with `unsubscribe`
    */
    public CompletableFuture<Number> subscribeCollection(String collection, Object filter, String result, Consumer<SubscribeCollectionEvent> consumer) {
        return context.requestJSONCallback("net.subscribe_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", consumer, SubscribeCollectionEvent.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Number.class));
    }

}
