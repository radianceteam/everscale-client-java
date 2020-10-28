package com.radiance.tonclient;

/**
 *  
 */
public class AbiConfig {

    private Number workchain;
    /**
     * 
     */
    public Number getWorkchain() {
        return workchain;
    }
    /**
     * 
     */
    public void setWorkchain(Number value) {
        workchain = value;
    }

    private Number messageExpirationTimeout;
    /**
     * 
     */
    public Number getMessageExpirationTimeout() {
        return messageExpirationTimeout;
    }
    /**
     * 
     */
    public void setMessageExpirationTimeout(Number value) {
        messageExpirationTimeout = value;
    }

    private Number messageExpirationTimeoutGrowFactor;
    /**
     * 
     */
    public Number getMessageExpirationTimeoutGrowFactor() {
        return messageExpirationTimeoutGrowFactor;
    }
    /**
     * 
     */
    public void setMessageExpirationTimeoutGrowFactor(Number value) {
        messageExpirationTimeoutGrowFactor = value;
    }


    @Override
    public String toString() {
        return "{\"workchain\":"+workchain+",\"message_expiration_timeout\":"+messageExpirationTimeout+",\"message_expiration_timeout_grow_factor\":"+messageExpirationTimeoutGrowFactor+"}";
    }
}