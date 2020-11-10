package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class ExecutionOptions {
    public ExecutionOptions() {
    }

    public ExecutionOptions(String blockchainConfig, Number blockTime, Long blockLt, Long transactionLt) {

        this.blockchainConfig = blockchainConfig;

        this.blockTime = blockTime;

        this.blockLt = blockLt;

        this.transactionLt = transactionLt;

    }



    @JsonProperty("blockchain_config")
    private String blockchainConfig;
    /**
     * boc with config
     */
    public String getBlockchainConfig() {
        return blockchainConfig;
    }
    /**
     * boc with config
     */
    public void setBlockchainConfig(String value) {
        blockchainConfig = value;
    }

    @JsonProperty("block_time")
    private Number blockTime;
    /**
     * time that is used as transaction time
     */
    public Number getBlockTime() {
        return blockTime;
    }
    /**
     * time that is used as transaction time
     */
    public void setBlockTime(Number value) {
        blockTime = value;
    }

    @JsonProperty("block_lt")
    private Long blockLt;
    /**
     * block logical time
     */
    public Long getBlockLt() {
        return blockLt;
    }
    /**
     * block logical time
     */
    public void setBlockLt(Long value) {
        blockLt = value;
    }

    @JsonProperty("transaction_lt")
    private Long transactionLt;
    /**
     * transaction logical time
     */
    public Long getTransactionLt() {
        return transactionLt;
    }
    /**
     * transaction logical time
     */
    public void setTransactionLt(Long value) {
        transactionLt = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((blockchainConfig==null?null:("\"blockchain_config\":\""+blockchainConfig+"\"")),(blockTime==null?null:("\"block_time\":"+blockTime)),(blockLt==null?null:("\"block_lt\":"+blockLt)),(transactionLt==null?null:("\"transaction_lt\":"+transactionLt))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}