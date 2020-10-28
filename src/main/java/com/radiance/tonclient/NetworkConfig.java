package com.radiance.tonclient;

/**
 *  
 */
public class NetworkConfig {

    private String serverAddress;
    /**
     * 
     */
    public String getServerAddress() {
        return serverAddress;
    }
    /**
     * 
     */
    public void setServerAddress(String value) {
        serverAddress = value;
    }

    private Number networkRetriesCount;
    /**
     * 
     */
    public Number getNetworkRetriesCount() {
        return networkRetriesCount;
    }
    /**
     * 
     */
    public void setNetworkRetriesCount(Number value) {
        networkRetriesCount = value;
    }

    private Number messageRetriesCount;
    /**
     * 
     */
    public Number getMessageRetriesCount() {
        return messageRetriesCount;
    }
    /**
     * 
     */
    public void setMessageRetriesCount(Number value) {
        messageRetriesCount = value;
    }

    private Number messageProcessingTimeout;
    /**
     * 
     */
    public Number getMessageProcessingTimeout() {
        return messageProcessingTimeout;
    }
    /**
     * 
     */
    public void setMessageProcessingTimeout(Number value) {
        messageProcessingTimeout = value;
    }

    private Number waitForTimeout;
    /**
     * 
     */
    public Number getWaitForTimeout() {
        return waitForTimeout;
    }
    /**
     * 
     */
    public void setWaitForTimeout(Number value) {
        waitForTimeout = value;
    }

    private Long outOfSyncThreshold;
    /**
     * 
     */
    public Long getOutOfSyncThreshold() {
        return outOfSyncThreshold;
    }
    /**
     * 
     */
    public void setOutOfSyncThreshold(Long value) {
        outOfSyncThreshold = value;
    }

    private String accessKey;
    /**
     * 
     */
    public String getAccessKey() {
        return accessKey;
    }
    /**
     * 
     */
    public void setAccessKey(String value) {
        accessKey = value;
    }


    @Override
    public String toString() {
        return "{\"server_address\":\""+serverAddress+"\",\"network_retries_count\":"+networkRetriesCount+",\"message_retries_count\":"+messageRetriesCount+",\"message_processing_timeout\":"+messageProcessingTimeout+",\"wait_for_timeout\":"+waitForTimeout+",\"out_of_sync_threshold\":"+outOfSyncThreshold+",\"access_key\":\""+accessKey+"\"}";
    }
}