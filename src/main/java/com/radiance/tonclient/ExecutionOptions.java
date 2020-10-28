package com.radiance.tonclient;

/**
 *  
 */
public class ExecutionOptions {

    private String blockchainConfig;
    /**
     *  boc with config
     */
    public String getBlockchainConfig() {
        return blockchainConfig;
    }
    /**
     *  boc with config
     */
    public void setBlockchainConfig(String value) {
        blockchainConfig = value;
    }

    private Number blockTime;
    /**
     *  time that is used as transaction time
     */
    public Number getBlockTime() {
        return blockTime;
    }
    /**
     *  time that is used as transaction time
     */
    public void setBlockTime(Number value) {
        blockTime = value;
    }

    private Long blockLt;
    /**
     *  block logical time
     */
    public Long getBlockLt() {
        return blockLt;
    }
    /**
     *  block logical time
     */
    public void setBlockLt(Long value) {
        blockLt = value;
    }

    private Long transactionLt;
    /**
     *  transaction logical time
     */
    public Long getTransactionLt() {
        return transactionLt;
    }
    /**
     *  transaction logical time
     */
    public void setTransactionLt(Long value) {
        transactionLt = value;
    }


    @Override
    public String toString() {
        return "{\"blockchain_config\":\""+blockchainConfig+"\",\"block_time\":"+blockTime+",\"block_lt\":"+blockLt+",\"transaction_lt\":"+transactionLt+"}";
    }
}