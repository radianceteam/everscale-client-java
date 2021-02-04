package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
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
    public static abstract class ParamsOfQueryOperation {

    /**
     *  
     */
    public static class QueryCollection extends ParamsOfQueryOperation  {

        public QueryCollection(String collection, Object filter, String result, OrderBy[] order, Number limit) {

            this.collection = collection;

            this.filter = filter;

            this.result = result;

            this.order = order;

            this.limit = limit;

        }
        public QueryCollection(String collection, Object filter, String result, OrderBy[] order) {

            this.collection = collection;

            this.filter = filter;

            this.result = result;

            this.order = order;

        }
        public QueryCollection(String collection, Object filter, String result) {

            this.collection = collection;

            this.filter = filter;

            this.result = result;

        }
        public QueryCollection(String collection, Object filter) {

            this.collection = collection;

            this.filter = filter;

        }
        public QueryCollection(String collection) {

            this.collection = collection;

        }
        public QueryCollection() {

        }


        @JsonProperty("collection")
        private String collection;
        /**
         * 
         */
        public String getCollection() {
            return collection;
        }
        /**
         * 
         */
        public void setCollection(String value) {
            this.collection = value;
        }

        @JsonProperty("filter")
        private Object filter;
        /**
         * 
         */
        public Object getFilter() {
            return filter;
        }
        /**
         * 
         */
        public void setFilter(Object value) {
            this.filter = value;
        }

        @JsonProperty("result")
        private String result;
        /**
         * 
         */
        public String getResult() {
            return result;
        }
        /**
         * 
         */
        public void setResult(String value) {
            this.result = value;
        }

        @JsonProperty("order")
        private OrderBy[] order;
        /**
         * 
         */
        public OrderBy[] getOrder() {
            return order;
        }
        /**
         * 
         */
        public void setOrder(OrderBy[] value) {
            this.order = value;
        }

        @JsonProperty("limit")
        private Number limit;
        /**
         * 
         */
        public Number getLimit() {
            return limit;
        }
        /**
         * 
         */
        public void setLimit(Number value) {
            this.limit = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"QueryCollection\"",(collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\"")),(order==null?null:("\"order\":"+Arrays.toString(order))),(limit==null?null:("\"limit\":"+limit))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class WaitForCollection extends ParamsOfQueryOperation  {

        public WaitForCollection(String collection, Object filter, String result, Number timeout) {

            this.collection = collection;

            this.filter = filter;

            this.result = result;

            this.timeout = timeout;

        }
        public WaitForCollection(String collection, Object filter, String result) {

            this.collection = collection;

            this.filter = filter;

            this.result = result;

        }
        public WaitForCollection(String collection, Object filter) {

            this.collection = collection;

            this.filter = filter;

        }
        public WaitForCollection(String collection) {

            this.collection = collection;

        }
        public WaitForCollection() {

        }


        @JsonProperty("collection")
        private String collection;
        /**
         * 
         */
        public String getCollection() {
            return collection;
        }
        /**
         * 
         */
        public void setCollection(String value) {
            this.collection = value;
        }

        @JsonProperty("filter")
        private Object filter;
        /**
         * 
         */
        public Object getFilter() {
            return filter;
        }
        /**
         * 
         */
        public void setFilter(Object value) {
            this.filter = value;
        }

        @JsonProperty("result")
        private String result;
        /**
         * 
         */
        public String getResult() {
            return result;
        }
        /**
         * 
         */
        public void setResult(String value) {
            this.result = value;
        }

        @JsonProperty("timeout")
        private Number timeout;
        /**
         * 
         */
        public Number getTimeout() {
            return timeout;
        }
        /**
         * 
         */
        public void setTimeout(Number value) {
            this.timeout = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"WaitForCollection\"",(collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\"")),(timeout==null?null:("\"timeout\":"+timeout))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class AggregateCollection extends ParamsOfQueryOperation  {

        public AggregateCollection(String collection, Object filter, FieldAggregation[] fields) {

            this.collection = collection;

            this.filter = filter;

            this.fields = fields;

        }
        public AggregateCollection(String collection, Object filter) {

            this.collection = collection;

            this.filter = filter;

        }
        public AggregateCollection(String collection) {

            this.collection = collection;

        }
        public AggregateCollection() {

        }


        @JsonProperty("collection")
        private String collection;
        /**
         * 
         */
        public String getCollection() {
            return collection;
        }
        /**
         * 
         */
        public void setCollection(String value) {
            this.collection = value;
        }

        @JsonProperty("filter")
        private Object filter;
        /**
         * 
         */
        public Object getFilter() {
            return filter;
        }
        /**
         * 
         */
        public void setFilter(Object value) {
            this.filter = value;
        }

        @JsonProperty("fields")
        private FieldAggregation[] fields;
        /**
         * 
         */
        public FieldAggregation[] getFields() {
            return fields;
        }
        /**
         * 
         */
        public void setFields(FieldAggregation[] value) {
            this.fields = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"AggregateCollection\"",(collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(fields==null?null:("\"fields\":"+Arrays.toString(fields)))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    /**
     *  
     */
    public static class FieldAggregation  {

        public FieldAggregation(String field, AggregationFn fn) {

            this.field = field;

            this.fn = fn;

        }
        public FieldAggregation(String field) {

            this.field = field;

        }
        public FieldAggregation() {

        }


        @JsonProperty("field")
        private String field;
        /**
         * 
         */
        public String getField() {
            return field;
        }
        /**
         * 
         */
        public void setField(String value) {
            this.field = value;
        }

        @JsonProperty("fn")
        private AggregationFn fn;
        /**
         * 
         */
        public AggregationFn getFn() {
            return fn;
        }
        /**
         * 
         */
        public void setFn(AggregationFn value) {
            this.fn = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((field==null?null:("\"field\":\""+field+"\"")),(fn==null?null:("\"fn\":"+fn))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public enum AggregationFn {
        
        /**
         * 
         */
        COUNT,

        /**
         * 
         */
        MIN,

        /**
         * 
         */
        MAX,

        /**
         * 
         */
        SUM,

        /**
         * 
         */
        AVERAGE
    }
    private TONContext context;

    public Net(TONContext context) {
        this.context = context;
    }

   /**
    * 
    *
    * @param query 
    * @param variables Must be a map with named values that can be used in query.
    */
    public CompletableFuture<Object> query(String query, Object variables) {
        return context.requestJSON("net.query", "{"+Stream.of((query==null?null:("\"query\":\""+query+"\"")),(variables==null?null:("\"variables\":"+variables))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object.class));
    }

   /**
    * 
    *
    * @param operations 
    * @return Returns an array of values. Each value corresponds to `queries` item.
    */
    public CompletableFuture<Object[]> batchQuery(ParamsOfQueryOperation[] operations) {
        return context.requestJSON("net.batch_query", "{"+(operations==null?"":("\"operations\":"+Arrays.toString(operations)))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("results"), Object[].class));
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
        return context.requestJSON("net.query_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(result==null?null:("\"result\":\""+result+"\"")),(order==null?null:("\"order\":"+Arrays.toString(order))),(limit==null?null:("\"limit\":"+limit))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object[].class));
    }

   /**
    * Aggregates values from the specified `fields` for recordsthat satisfies the `filter` conditions,
    *
    * @param collection 
    * @param filter 
    * @param fields 
    * @return Returns an array of strings. Each string refers to the corresponding `fields` item.Numeric value is returned as a decimal string representations.
    */
    public CompletableFuture<Object> aggregateCollection(String collection, Object filter, FieldAggregation[] fields) {
        return context.requestJSON("net.aggregate_collection", "{"+Stream.of((collection==null?null:("\"collection\":\""+collection+"\"")),(filter==null?null:("\"filter\":"+filter)),(fields==null?null:("\"fields\":"+Arrays.toString(fields)))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("values"), Object.class));
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
        return context.requestJSON("net.set_endpoints", "{"+(endpoints==null?"":("\"endpoints\":\""+Arrays.toString(endpoints)+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

}
