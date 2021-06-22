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

    /**
     *  
     */
    public static class QueryCounterparties extends ParamsOfQueryOperation  {

        public QueryCounterparties(String account, String result, Number first, String after) {

            this.account = account;

            this.result = result;

            this.first = first;

            this.after = after;

        }
        public QueryCounterparties(String account, String result, Number first) {

            this.account = account;

            this.result = result;

            this.first = first;

        }
        public QueryCounterparties(String account, String result) {

            this.account = account;

            this.result = result;

        }
        public QueryCounterparties(String account) {

            this.account = account;

        }
        public QueryCounterparties() {

        }


        @JsonProperty("account")
        private String account;
        /**
         * 
         */
        public String getAccount() {
            return account;
        }
        /**
         * 
         */
        public void setAccount(String value) {
            this.account = value;
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

        @JsonProperty("first")
        private Number first;
        /**
         * 
         */
        public Number getFirst() {
            return first;
        }
        /**
         * 
         */
        public void setFirst(Number value) {
            this.first = value;
        }

        @JsonProperty("after")
        private String after;
        /**
         * 
         */
        public String getAfter() {
            return after;
        }
        /**
         * 
         */
        public void setAfter(String value) {
            this.after = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"QueryCounterparties\"",(account==null?null:("\"account\":\""+account+"\"")),(result==null?null:("\"result\":\""+result+"\"")),(first==null?null:("\"first\":"+first)),(after==null?null:("\"after\":\""+after+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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
    /**
     *  
     */
    public static class TransactionNode  {

        public TransactionNode(String id, String inMsg, String[] outMsgs, String accountAddr, String totalFees, Boolean aborted, Number exitCode) {

            this.id = id;

            this.inMsg = inMsg;

            this.outMsgs = outMsgs;

            this.accountAddr = accountAddr;

            this.totalFees = totalFees;

            this.aborted = aborted;

            this.exitCode = exitCode;

        }
        public TransactionNode(String id, String inMsg, String[] outMsgs, String accountAddr, String totalFees, Boolean aborted) {

            this.id = id;

            this.inMsg = inMsg;

            this.outMsgs = outMsgs;

            this.accountAddr = accountAddr;

            this.totalFees = totalFees;

            this.aborted = aborted;

        }
        public TransactionNode(String id, String inMsg, String[] outMsgs, String accountAddr, String totalFees) {

            this.id = id;

            this.inMsg = inMsg;

            this.outMsgs = outMsgs;

            this.accountAddr = accountAddr;

            this.totalFees = totalFees;

        }
        public TransactionNode(String id, String inMsg, String[] outMsgs, String accountAddr) {

            this.id = id;

            this.inMsg = inMsg;

            this.outMsgs = outMsgs;

            this.accountAddr = accountAddr;

        }
        public TransactionNode(String id, String inMsg, String[] outMsgs) {

            this.id = id;

            this.inMsg = inMsg;

            this.outMsgs = outMsgs;

        }
        public TransactionNode(String id, String inMsg) {

            this.id = id;

            this.inMsg = inMsg;

        }
        public TransactionNode(String id) {

            this.id = id;

        }
        public TransactionNode() {

        }


        @JsonProperty("id")
        private String id;
        /**
         * 
         */
        public String getId() {
            return id;
        }
        /**
         * 
         */
        public void setId(String value) {
            this.id = value;
        }

        @JsonProperty("in_msg")
        private String inMsg;
        /**
         * 
         */
        public String getInMsg() {
            return inMsg;
        }
        /**
         * 
         */
        public void setInMsg(String value) {
            this.inMsg = value;
        }

        @JsonProperty("out_msgs")
        private String[] outMsgs;
        /**
         * 
         */
        public String[] getOutMsgs() {
            return outMsgs;
        }
        /**
         * 
         */
        public void setOutMsgs(String[] value) {
            this.outMsgs = value;
        }

        @JsonProperty("account_addr")
        private String accountAddr;
        /**
         * 
         */
        public String getAccountAddr() {
            return accountAddr;
        }
        /**
         * 
         */
        public void setAccountAddr(String value) {
            this.accountAddr = value;
        }

        @JsonProperty("total_fees")
        private String totalFees;
        /**
         * 
         */
        public String getTotalFees() {
            return totalFees;
        }
        /**
         * 
         */
        public void setTotalFees(String value) {
            this.totalFees = value;
        }

        @JsonProperty("aborted")
        private Boolean aborted;
        /**
         * 
         */
        public Boolean getAborted() {
            return aborted;
        }
        /**
         * 
         */
        public void setAborted(Boolean value) {
            this.aborted = value;
        }

        @JsonProperty("exit_code")
        private Number exitCode;
        /**
         * 
         */
        public Number getExitCode() {
            return exitCode;
        }
        /**
         * 
         */
        public void setExitCode(Number value) {
            this.exitCode = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((id==null?null:("\"id\":\""+id+"\"")),(inMsg==null?null:("\"in_msg\":\""+inMsg+"\"")),(outMsgs==null?null:("\"out_msgs\":\""+Arrays.toString(outMsgs)+"\"")),(accountAddr==null?null:("\"account_addr\":\""+accountAddr+"\"")),(totalFees==null?null:("\"total_fees\":\""+totalFees+"\"")),(aborted==null?null:("\"aborted\":"+aborted)),(exitCode==null?null:("\"exit_code\":"+exitCode))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class MessageNode  {

        public MessageNode(String id, String srcTransactionId, String dstTransactionId, String src, String dst, String value, Boolean bounce, Abi.DecodedMessageBody decodedBody) {

            this.id = id;

            this.srcTransactionId = srcTransactionId;

            this.dstTransactionId = dstTransactionId;

            this.src = src;

            this.dst = dst;

            this.value = value;

            this.bounce = bounce;

            this.decodedBody = decodedBody;

        }
        public MessageNode(String id, String srcTransactionId, String dstTransactionId, String src, String dst, String value, Boolean bounce) {

            this.id = id;

            this.srcTransactionId = srcTransactionId;

            this.dstTransactionId = dstTransactionId;

            this.src = src;

            this.dst = dst;

            this.value = value;

            this.bounce = bounce;

        }
        public MessageNode(String id, String srcTransactionId, String dstTransactionId, String src, String dst, String value) {

            this.id = id;

            this.srcTransactionId = srcTransactionId;

            this.dstTransactionId = dstTransactionId;

            this.src = src;

            this.dst = dst;

            this.value = value;

        }
        public MessageNode(String id, String srcTransactionId, String dstTransactionId, String src, String dst) {

            this.id = id;

            this.srcTransactionId = srcTransactionId;

            this.dstTransactionId = dstTransactionId;

            this.src = src;

            this.dst = dst;

        }
        public MessageNode(String id, String srcTransactionId, String dstTransactionId, String src) {

            this.id = id;

            this.srcTransactionId = srcTransactionId;

            this.dstTransactionId = dstTransactionId;

            this.src = src;

        }
        public MessageNode(String id, String srcTransactionId, String dstTransactionId) {

            this.id = id;

            this.srcTransactionId = srcTransactionId;

            this.dstTransactionId = dstTransactionId;

        }
        public MessageNode(String id, String srcTransactionId) {

            this.id = id;

            this.srcTransactionId = srcTransactionId;

        }
        public MessageNode(String id) {

            this.id = id;

        }
        public MessageNode() {

        }


        @JsonProperty("id")
        private String id;
        /**
         * 
         */
        public String getId() {
            return id;
        }
        /**
         * 
         */
        public void setId(String value) {
            this.id = value;
        }

        @JsonProperty("src_transaction_id")
        private String srcTransactionId;
        /**
         * This field is missing for an external inbound messages.
         */
        public String getSrcTransactionId() {
            return srcTransactionId;
        }
        /**
         * This field is missing for an external inbound messages.
         */
        public void setSrcTransactionId(String value) {
            this.srcTransactionId = value;
        }

        @JsonProperty("dst_transaction_id")
        private String dstTransactionId;
        /**
         * This field is missing for an external outbound messages.
         */
        public String getDstTransactionId() {
            return dstTransactionId;
        }
        /**
         * This field is missing for an external outbound messages.
         */
        public void setDstTransactionId(String value) {
            this.dstTransactionId = value;
        }

        @JsonProperty("src")
        private String src;
        /**
         * 
         */
        public String getSrc() {
            return src;
        }
        /**
         * 
         */
        public void setSrc(String value) {
            this.src = value;
        }

        @JsonProperty("dst")
        private String dst;
        /**
         * 
         */
        public String getDst() {
            return dst;
        }
        /**
         * 
         */
        public void setDst(String value) {
            this.dst = value;
        }

        @JsonProperty("value")
        private String value;
        /**
         * 
         */
        public String getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(String value) {
            this.value = value;
        }

        @JsonProperty("bounce")
        private Boolean bounce;
        /**
         * 
         */
        public Boolean getBounce() {
            return bounce;
        }
        /**
         * 
         */
        public void setBounce(Boolean value) {
            this.bounce = value;
        }

        @JsonProperty("decoded_body")
        private Abi.DecodedMessageBody decodedBody;
        /**
         * Library tries to decode message body using provided `params.abi_registry`.This field will be missing if none of the provided abi can be used to decode.
         */
        public Abi.DecodedMessageBody getDecodedBody() {
            return decodedBody;
        }
        /**
         * Library tries to decode message body using provided `params.abi_registry`.This field will be missing if none of the provided abi can be used to decode.
         */
        public void setDecodedBody(Abi.DecodedMessageBody value) {
            this.decodedBody = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((id==null?null:("\"id\":\""+id+"\"")),(srcTransactionId==null?null:("\"src_transaction_id\":\""+srcTransactionId+"\"")),(dstTransactionId==null?null:("\"dst_transaction_id\":\""+dstTransactionId+"\"")),(src==null?null:("\"src\":\""+src+"\"")),(dst==null?null:("\"dst\":\""+dst+"\"")),(value==null?null:("\"value\":\""+value+"\"")),(bounce==null?null:("\"bounce\":"+bounce)),(decodedBody==null?null:("\"decoded_body\":"+decodedBody))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfGetEndpoints  {

        public ResultOfGetEndpoints(String query, String[] endpoints) {

            this.query = query;

            this.endpoints = endpoints;

        }
        public ResultOfGetEndpoints(String query) {

            this.query = query;

        }
        public ResultOfGetEndpoints() {

        }


        @JsonProperty("query")
        private String query;
        /**
         * 
         */
        public String getQuery() {
            return query;
        }
        /**
         * 
         */
        public void setQuery(String value) {
            this.query = value;
        }

        @JsonProperty("endpoints")
        private String[] endpoints;
        /**
         * 
         */
        public String[] getEndpoints() {
            return endpoints;
        }
        /**
         * 
         */
        public void setEndpoints(String[] value) {
            this.endpoints = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((query==null?null:("\"query\":\""+query+"\"")),(endpoints==null?null:("\"endpoints\":\""+Arrays.toString(endpoints)+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfQueryTransactionTree  {

        public ResultOfQueryTransactionTree(MessageNode[] messages, TransactionNode[] transactions) {

            this.messages = messages;

            this.transactions = transactions;

        }
        public ResultOfQueryTransactionTree(MessageNode[] messages) {

            this.messages = messages;

        }
        public ResultOfQueryTransactionTree() {

        }


        @JsonProperty("messages")
        private MessageNode[] messages;
        /**
         * 
         */
        public MessageNode[] getMessages() {
            return messages;
        }
        /**
         * 
         */
        public void setMessages(MessageNode[] value) {
            this.messages = value;
        }

        @JsonProperty("transactions")
        private TransactionNode[] transactions;
        /**
         * 
         */
        public TransactionNode[] getTransactions() {
            return transactions;
        }
        /**
         * 
         */
        public void setTransactions(TransactionNode[] value) {
            this.transactions = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((messages==null?null:("\"messages\":"+Arrays.toString(messages))),(transactions==null?null:("\"transactions\":"+Arrays.toString(transactions)))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
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
    * Triggers for each insert/update of data that satisfiesthe `filter` conditions.The projection fields are limited to `result` fields.<p>The subscription is a persistent communication channel betweenclient and Free TON Network.All changes in the blockchain will be reflected in realtime.Changes means inserts and updates of the blockchain entities.<p>### Important Notes on Subscriptions<p>Unfortunately sometimes the connection with the network brakes down.In this situation the library attempts to reconnect to the network.This reconnection sequence can take significant time.All of this time the client is disconnected from the network.<p>Bad news is that all blockchain changes that happened whilethe client was disconnected are lost.<p>Good news is that the client report errors to the callback whenit loses and resumes connection.<p>So, if the lost changes are important to the application thenthe application must handle these error reports.<p>Library reports errors with `responseType` == 101and the error object passed via `params`.<p>When the library has successfully reconnectedthe application receives callback with`responseType` == 101 and `params.code` == 614 (NetworkModuleResumed).<p>Application can use several ways to handle this situation:- If application monitors changes for the single blockchainobject (for example specific account):  applicationcan perform a query for this object and handle actual data as aregular data from the subscription.- If application monitors sequence of some blockchain objects(for example transactions of the specific account): application mustrefresh all cached (or visible to user) lists where this sequences presents.
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

   /**
    * 
    *
    */
    public CompletableFuture<ResultOfGetEndpoints> getEndpoints() {
        return context.requestJSON("net.get_endpoints", "{}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfGetEndpoints.class));
    }

   /**
    * *Attention* this query retrieves data from 'Counterparties' service which is not supported inthe opensource version of DApp Server (and will not be supported) as well as in TON OS SE (will be supported in SE in future),but is always accessible via <a target="_blank" href="TON OS Devnet/Mainnet Clouds">TON OS Devnet/Mainnet Clouds</a>(https://docs.ton.dev/86757ecb2/p/85c869-networks)
    *
    * @param account 
    * @param result 
    * @param first 
    * @param after 
    */
    public CompletableFuture<Object[]> queryCounterparties(String account, String result, Number first, String after) {
        return context.requestJSON("net.query_counterparties", "{"+Stream.of((account==null?null:("\"account\":\""+account+"\"")),(result==null?null:("\"result\":\""+result+"\"")),(first==null?null:("\"first\":"+first)),(after==null?null:("\"after\":\""+after+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("result"), Object[].class));
    }

   /**
    * Performs recursive retrieval of the transactions tree produced by the specific message:in_msg -&gt; dst_transaction -&gt; out_messages -&gt; dst_transaction -&gt; ...<p>All retrieved messages and transactions will be includedinto `result.messages` and `result.transactions` respectively.<p>The retrieval process will stop when the retrieved transaction count is more than 50.<p>It is guaranteed that each message in `result.messages` has the corresponding transactionin the `result.transactions`.<p>But there are no guaranties that all messages from transactions `out_msgs` arepresented in `result.messages`.So the application have to continue retrieval for missing messages if it requires.
    *
    * @param inMsg 
    * @param abiRegistry 
    * @param timeout If some of the following messages and transactions are missing yetThe maximum waiting time is regulated by this option.<p>Default value is 60000 (1 min).
    */
    public CompletableFuture<ResultOfQueryTransactionTree> queryTransactionTree(String inMsg, Abi.ABI[] abiRegistry, Number timeout) {
        return context.requestJSON("net.query_transaction_tree", "{"+Stream.of((inMsg==null?null:("\"in_msg\":\""+inMsg+"\"")),(abiRegistry==null?null:("\"abi_registry\":"+Arrays.toString(abiRegistry))),(timeout==null?null:("\"timeout\":"+timeout))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfQueryTransactionTree.class));
    }

}
