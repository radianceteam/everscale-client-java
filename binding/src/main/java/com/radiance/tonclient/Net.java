package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.function.Consumer;

/**
 *  
 */
public class Net {

    /**
     *  
     */
    public static class OrderBy  {

        public OrderBy(String path, SortDirection direction) {

            this.path = path;

            this.direction = direction;

        }
        public OrderBy(String path) {

            this.path = path;

        }
        public OrderBy() {

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
            this.path = value;
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
            this.direction = value;
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
    * 
    *
    * @param query 
    * @param variables Must be a map with named values thatcan be used in query.
    */
    public CompletableFuture<Object> query(String query, Object variables) {
        return context.requestJSON("net.query", "{"+Stream.of((query==null?null:("\"query\":\""+query+"\"")),(variables==null?null:("\"variables\":"+variables))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object.class));
    }

   /**
    * Queries data that satisfies the `filter` conditions,limits the number of returned records and orders them.The projection fields are limited to `result` fields
    *
    * @param collection 
    * @param filter 
    * @param result 
    * @param order 
    * @param limit 
    */
    public CompletableFuture<Object[]> queryCollection(String collection, Object filter, String result, OrderBy[] order, Number limit) {
        return context.requestJSON("net.query_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\"")),(order==null?null:("\"order\":"+order)),(limit==null?null:("\"limit\":"+limit))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object[].class));
    }

   /**
    * Triggers only once.If object that satisfies the `filter` conditionsalready exists - returns it immediately.If not - waits for insert/update of data within the specified `timeout`,and returns it.The projection fields are limited to `result` fields
    *
    * @param collection 
    * @param filter 
    * @param result 
    * @param timeout 
    */
    public CompletableFuture<Object> waitForCollection(String collection, Object filter, String result, Number timeout) {
        return context.requestJSON("net.wait_for_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\"")),(timeout==null?null:("\"timeout\":"+timeout))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object.class));
    }

   /**
    * Cancels a subscription specified by its handle.
    *
    * @param handle Must be closed with `unsubscribe`
    */
    public CompletableFuture<Void> unsubscribe(Number handle) {
        return context.requestJSON("net.unsubscribe", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * Triggers for each insert/update of datathat satisfies the `filter` conditions.The projection fields are limited to `result` fields.
    *
    * @param collection 
    * @param filter 
    * @param result 
    * @return Must be closed with `unsubscribe`
    */
    public CompletableFuture<Number> subscribeCollection(String collection, Object filter, String result, Consumer<SubscribeCollectionEvent> consumer) {
        return context.requestJSONCallback("net.subscribe_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", (event,type)->consumer.accept(event), SubscribeCollectionEvent.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Number.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<Void> suspend() {
        return context.requestJSON("net.suspend", "{}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<Void> resume() {
        return context.requestJSON("net.resume", "{}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * 
    *
    * @param address 
    */
    public CompletableFuture<String> findLastShardBlock(String address) {
        return context.requestJSON("net.find_last_shard_block", "{"+(address==null?"":("\"address\":\""+address+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("block_id"), String.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<String[]> fetchEndpoints() {
        return context.requestJSON("net.fetch_endpoints", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("endpoints"), String[].class));
    }

   /**
    * 
    *
    * @param endpoints 
    */
    public CompletableFuture<Void> setEndpoints(String[] endpoints) {
        return context.requestJSON("net.set_endpoints", "{"+(endpoints==null?"":("\"endpoints\":\""+endpoints+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

}
