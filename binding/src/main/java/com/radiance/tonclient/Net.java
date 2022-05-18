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
    /**
     *  
     */
    public static class ResultOfIteratorNext  {

        public ResultOfIteratorNext(Object[] items, Boolean hasMore, Object resumeState) {

            this.items = items;

            this.hasMore = hasMore;

            this.resumeState = resumeState;

        }
        public ResultOfIteratorNext(Object[] items, Boolean hasMore) {

            this.items = items;

            this.hasMore = hasMore;

        }
        public ResultOfIteratorNext(Object[] items) {

            this.items = items;

        }
        public ResultOfIteratorNext() {

        }


        @JsonProperty("items")
        private Object[] items;
        /**
         * Note that `iterator_next` can return an empty items and `has_more` equals to `true`.In this case the application have to continue iteration.Such situation can take place when there is no data yet butthe requested `end_time` is not reached.
         */
        public Object[] getItems() {
            return items;
        }
        /**
         * Note that `iterator_next` can return an empty items and `has_more` equals to `true`.In this case the application have to continue iteration.Such situation can take place when there is no data yet butthe requested `end_time` is not reached.
         */
        public void setItems(Object[] value) {
            this.items = value;
        }

        @JsonProperty("has_more")
        private Boolean hasMore;
        /**
         * 
         */
        public Boolean getHasMore() {
            return hasMore;
        }
        /**
         * 
         */
        public void setHasMore(Boolean value) {
            this.hasMore = value;
        }

        @JsonProperty("resume_state")
        private Object resumeState;
        /**
         * This field is returned only if the `return_resume_state` parameteris specified.<p>Note that `resume_state` corresponds to the iteration positionafter the returned items.
         */
        public Object getResumeState() {
            return resumeState;
        }
        /**
         * This field is returned only if the `return_resume_state` parameteris specified.<p>Note that `resume_state` corresponds to the iteration positionafter the returned items.
         */
        public void setResumeState(Object value) {
            this.resumeState = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((items==null?null:("\"items\":"+Arrays.toString(items))),(hasMore==null?null:("\"has_more\":"+hasMore)),(resumeState==null?null:("\"resume_state\":"+resumeState))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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
    * The subscription is a persistent communication channel betweenclient and Everscale Network.<p>### Important Notes on Subscriptions<p>Unfortunately sometimes the connection with the network brakes down.In this situation the library attempts to reconnect to the network.This reconnection sequence can take significant time.All of this time the client is disconnected from the network.<p>Bad news is that all changes that happened whilethe client was disconnected are lost.<p>Good news is that the client report errors to the callback whenit loses and resumes connection.<p>So, if the lost changes are important to the application thenthe application must handle these error reports.<p>Library reports errors with `responseType` == 101and the error object passed via `params`.<p>When the library has successfully reconnectedthe application receives callback with`responseType` == 101 and `params.code` == 614 (NetworkModuleResumed).<p>Application can use several ways to handle this situation:- If application monitors changes for the singleobject (for example specific account):  applicationcan perform a query for this object and handle actual data as aregular data from the subscription.- If application monitors sequence of some objects(for example transactions of the specific account): application mustrefresh all cached (or visible to user) lists where this sequences presents.
    *
    * @param subscription 
    * @param variables Must be a map with named values that can be used in query.
    * @return Must be closed with `unsubscribe`
    */
    public CompletableFuture<Number> subscribe(String subscription, Object variables, Consumer<SubscribeEvent> consumer) {
        return context.requestJSONCallback("net.subscribe", "{"+Stream.of((subscription==null?null:("\"subscription\":\""+subscription+"\"")),(variables==null?null:("\"variables\":"+variables))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}", (event,type)->consumer.accept(event), SubscribeEvent.class)
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
    * *Attention* this query retrieves data from 'Counterparties' service which is not supported inthe opensource version of DApp Server (and will not be supported) as well as in Evernode SE (will be supported in SE in future),but is always accessible via <a target="_blank" href="EVER OS Clouds">EVER OS Clouds</a>(../ton-os-api/networks.md)
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
    * Performs recursive retrieval of a transactions tree produced by a specific message:in_msg -&gt; dst_transaction -&gt; out_messages -&gt; dst_transaction -&gt; ...If the chain of transactions execution is in progress while the function is running,it will wait for the next transactions to appear until the full tree or more than 50 transactionsare received.<p>All the retrieved messages and transactions are includedinto `result.messages` and `result.transactions` respectively.<p>Function reads transactions layer by layer, by pages of 20 transactions.<p>The retrieval prosess goes like this:Let's assume we have an infinite chain of transactions and each transaction generates 5 messages.1. Retrieve 1st message (input parameter) and corresponding transaction - put it into result.It is the first level of the tree of transactions - its root.Retrieve 5 out message ids from the transaction for next steps.2. Retrieve 5 messages and corresponding transactions on the 2nd layer. Put them into result.Retrieve 5*5 out message ids from these transactions for next steps3. Retrieve 20 (size of the page) messages and transactions (3rd layer) and 20*5=100 message ids (4th layer).4. Retrieve the last 5 messages and 5 transactions on the 3rd layer + 15 messages and transactions (of 100) from the 4th layer+ 25 message ids of the 4th layer + 75 message ids of the 5th layer.5. Retrieve 20 more messages and 20 more transactions of the 4th layer + 100 more message ids of the 5th layer.6. Now we have 1+5+20+20+20 = 66 transactions, which is more than 50. Function exits with the tree of1m-&gt;1t-&gt;5m-&gt;5t-&gt;25m-&gt;25t-&gt;35m-&gt;35t. If we see any message ids in the last transactions out_msgs, which don't havecorresponding messages in the function result, it means that the full tree was not received and we need to continue iteration.<p>To summarize, it is guaranteed that each message in `result.messages` has the corresponding transactionin the `result.transactions`.But there is no guarantee that all messages from transactions `out_msgs` arepresented in `result.messages`.So the application has to continue retrieval for missing messages if it requires.
    *
    * @param inMsg 
    * @param abiRegistry 
    * @param timeout If some of the following messages and transactions are missing yetThe maximum waiting time is regulated by this option.<p>Default value is 60000 (1 min).
    */
    public CompletableFuture<ResultOfQueryTransactionTree> queryTransactionTree(String inMsg, Abi.ABI[] abiRegistry, Number timeout) {
        return context.requestJSON("net.query_transaction_tree", "{"+Stream.of((inMsg==null?null:("\"in_msg\":\""+inMsg+"\"")),(abiRegistry==null?null:("\"abi_registry\":"+Arrays.toString(abiRegistry))),(timeout==null?null:("\"timeout\":"+timeout))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfQueryTransactionTree.class));
    }

   /**
    * Block iterator uses robust iteration methods that guaranties that everyblock in the specified range isn't missed or iterated twice.<p>Iterated range can be reduced with some filters:- `start_time` – the bottom time range. Only blocks with `gen_utime`more or equal to this value is iterated. If this parameter is omitted then there isno bottom time edge, so all blocks since zero state is iterated.- `end_time` – the upper time range. Only blocks with `gen_utime`less then this value is iterated. If this parameter is omitted then there isno upper time edge, so iterator never finishes.- `shard_filter` – workchains and shard prefixes that reduce the set of interestingblocks. Block conforms to the shard filter if it belongs to the filter workchainand the first bits of block's `shard` fields matches to the shard prefix.Only blocks with suitable shard are iterated.<p>Items iterated is a JSON objects with block data. The minimal set of returnedfields is:```textidgen_utimeworkchain_idshardafter_splitafter_mergeprev_ref {    root_hash}prev_alt_ref {    root_hash}```Application can request additional fields in the `result` parameter.<p>Application should call the `remove_iterator` when iterator is no longer required.
    *
    * @param startTime If the application specifies this parameter then the iterationincludes blocks with `gen_utime` &gt;= `start_time`.Otherwise the iteration starts from zero state.<p>Must be specified in seconds.
    * @param endTime If the application specifies this parameter then the iterationincludes blocks with `gen_utime` &lt; `end_time`.Otherwise the iteration never stops.<p>Must be specified in seconds.
    * @param shardFilter If the application specifies this parameter and it is not the empty arraythen the iteration will include items related to accounts that belongs tothe specified shard prefixes.Shard prefix must be represented as a string "workchain:prefix".Where `workchain` is a signed integer and the `prefix` if a hexadecimalrepresentation if the 64-bit unsigned integer with tagged shard prefix.For example: "0:3800000000000000".
    * @param result List of the fields that must be returned for iterated items.This field is the same as the `result` parameter ofthe `query_collection` function.Note that iterated items can contains additional fields that arenot requested in the `result`.
    * @return Must be removed using `remove_iterator`when it is no more needed for the application.
    */
    public CompletableFuture<Number> createBlockIterator(Number startTime, Number endTime, String[] shardFilter, String result) {
        return context.requestJSON("net.create_block_iterator", "{"+Stream.of((startTime==null?null:("\"start_time\":"+startTime)),(endTime==null?null:("\"end_time\":"+endTime)),(shardFilter==null?null:("\"shard_filter\":\""+Arrays.toString(shardFilter)+"\"")),(result==null?null:("\"result\":\""+result+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Number.class));
    }

   /**
    * The iterator stays exactly at the same position where the `resume_state` was catched.<p>Application should call the `remove_iterator` when iterator is no longer required.
    *
    * @param resumeState Same as value returned from `iterator_next`.
    * @return Must be removed using `remove_iterator`when it is no more needed for the application.
    */
    public CompletableFuture<Number> resumeBlockIterator(Object resumeState) {
        return context.requestJSON("net.resume_block_iterator", "{"+(resumeState==null?"":("\"resume_state\":"+resumeState))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Number.class));
    }

   /**
    * Transaction iterator uses robust iteration methods that guaranty that everytransaction in the specified range isn't missed or iterated twice.<p>Iterated range can be reduced with some filters:- `start_time` – the bottom time range. Only transactions with `now`more or equal to this value are iterated. If this parameter is omitted then there isno bottom time edge, so all the transactions since zero state are iterated.- `end_time` – the upper time range. Only transactions with `now`less then this value are iterated. If this parameter is omitted then there isno upper time edge, so iterator never finishes.- `shard_filter` – workchains and shard prefixes that reduce the set of interestingaccounts. Account address conforms to the shard filter ifit belongs to the filter workchain and the first bits of address match tothe shard prefix. Only transactions with suitable account addresses are iterated.- `accounts_filter` – set of account addresses whose transactions must be iterated.Note that accounts filter can conflict with shard filter so application must combinethese filters carefully.<p>Iterated item is a JSON objects with transaction data. The minimal set of returnedfields is:```textidaccount_addrnowbalance_delta(format:DEC)bounce { bounce_type }in_message {    id    value(format:DEC)    msg_type    src}out_messages {    id    value(format:DEC)    msg_type    dst}```Application can request an additional fields in the `result` parameter.<p>Another parameter that affects on the returned fields is the `include_transfers`.When this parameter is `true` the iterator computes and adds `transfer` field containinglist of the useful `TransactionTransfer` objects.Each transfer is calculated from the particular message related to the transactionand has the following structure:- message – source message identifier.- isBounced – indicates that the transaction is bounced, which means the value will be returned back to the sender.- isDeposit – indicates that this transfer is the deposit (true) or withdraw (false).- counterparty – account address of the transfer source or destination depending on `isDeposit`.- value – amount of nano tokens transferred. The value is represented as a decimal stringbecause the actual value can be more precise than the JSON number can represent. Applicationmust use this string carefully – conversion to number can follow to loose of precision.<p>Application should call the `remove_iterator` when iterator is no longer required.
    *
    * @param startTime If the application specifies this parameter then the iterationincludes blocks with `gen_utime` &gt;= `start_time`.Otherwise the iteration starts from zero state.<p>Must be specified in seconds.
    * @param endTime If the application specifies this parameter then the iterationincludes blocks with `gen_utime` &lt; `end_time`.Otherwise the iteration never stops.<p>Must be specified in seconds.
    * @param shardFilter If the application specifies this parameter and it is not an empty arraythen the iteration will include items related to accounts that belongs tothe specified shard prefixes.Shard prefix must be represented as a string "workchain:prefix".Where `workchain` is a signed integer and the `prefix` if a hexadecimalrepresentation if the 64-bit unsigned integer with tagged shard prefix.For example: "0:3800000000000000".Account address conforms to the shard filter ifit belongs to the filter workchain and the first bits of address match tothe shard prefix. Only transactions with suitable account addresses are iterated.
    * @param accountsFilter Application can specify the list of accounts for whichit wants to iterate transactions.<p>If this parameter is missing or an empty list then the library iteratestransactions for all accounts that pass the shard filter.<p>Note that the library doesn't detect conflicts between the account filter and the shard filterif both are specified.So it is an application responsibility to specify the correct filter combination.
    * @param result List of the fields that must be returned for iterated items.This field is the same as the `result` parameter ofthe `query_collection` function.Note that iterated items can contain additional fields that arenot requested in the `result`.
    * @param includeTransfers If this parameter is `true` then each transaction contains field`transfers` with list of transfer. See more about this structure in function description.
    * @return Must be removed using `remove_iterator`when it is no more needed for the application.
    */
    public CompletableFuture<Number> createTransactionIterator(Number startTime, Number endTime, String[] shardFilter, String[] accountsFilter, String result, Boolean includeTransfers) {
        return context.requestJSON("net.create_transaction_iterator", "{"+Stream.of((startTime==null?null:("\"start_time\":"+startTime)),(endTime==null?null:("\"end_time\":"+endTime)),(shardFilter==null?null:("\"shard_filter\":\""+Arrays.toString(shardFilter)+"\"")),(accountsFilter==null?null:("\"accounts_filter\":\""+Arrays.toString(accountsFilter)+"\"")),(result==null?null:("\"result\":\""+result+"\"")),(includeTransfers==null?null:("\"include_transfers\":"+includeTransfers))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Number.class));
    }

   /**
    * The iterator stays exactly at the same position where the `resume_state` was caught.Note that `resume_state` doesn't store the account filter. If the application requiresto use the same account filter as it was when the iterator was created then the applicationmust pass the account filter again in `accounts_filter` parameter.<p>Application should call the `remove_iterator` when iterator is no longer required.
    *
    * @param resumeState Same as value returned from `iterator_next`.
    * @param accountsFilter Application can specify the list of accounts for whichit wants to iterate transactions.<p>If this parameter is missing or an empty list then the library iteratestransactions for all accounts that passes the shard filter.<p>Note that the library doesn't detect conflicts between the account filter and the shard filterif both are specified.So it is the application's responsibility to specify the correct filter combination.
    * @return Must be removed using `remove_iterator`when it is no more needed for the application.
    */
    public CompletableFuture<Number> resumeTransactionIterator(Object resumeState, String[] accountsFilter) {
        return context.requestJSON("net.resume_transaction_iterator", "{"+Stream.of((resumeState==null?null:("\"resume_state\":"+resumeState)),(accountsFilter==null?null:("\"accounts_filter\":\""+Arrays.toString(accountsFilter)+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Number.class));
    }

   /**
    * In addition to available items this function returns the `has_more` flagindicating that the iterator isn't reach the end of the iterated range yet.<p>This function can return the empty list of available items butindicates that there are more items is available.This situation appears when the iterator doesn't reach iterated rangebut database doesn't contains available items yet.<p>If application requests resume state in `return_resume_state` parameterthen this function returns `resume_state` that can be used later toresume the iteration from the position after returned items.<p>The structure of the items returned depends on the iterator used.See the description to the appropriated iterator creation function.
    *
    * @param iterator 
    * @param limit If value is missing or is less than 1 the library uses 1.
    * @param returnResumeState 
    */
    public CompletableFuture<ResultOfIteratorNext> iteratorNext(Number iterator, Number limit, Boolean returnResumeState) {
        return context.requestJSON("net.iterator_next", "{"+Stream.of((iterator==null?null:("\"iterator\":"+iterator)),(limit==null?null:("\"limit\":"+limit)),(returnResumeState==null?null:("\"return_resume_state\":"+returnResumeState))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfIteratorNext.class));
    }

   /**
    * Frees all resources allocated in library to serve iterator.<p>Application always should call the `remove_iterator` when iteratoris no longer required.
    *
    * @param handle Must be removed using `remove_iterator`when it is no more needed for the application.
    */
    public CompletableFuture<Void> removeIterator(Number handle) {
        return context.requestJSON("net.remove_iterator", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

}
