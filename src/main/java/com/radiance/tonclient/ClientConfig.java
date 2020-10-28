package com.radiance.tonclient;

/**
 *  
 */
public class ClientConfig {

    private NetworkConfig network;
    /**
     * 
     */
    public NetworkConfig getNetwork() {
        return network;
    }
    /**
     * 
     */
    public void setNetwork(NetworkConfig value) {
        network = value;
    }

    private CryptoConfig crypto;
    /**
     * 
     */
    public CryptoConfig getCrypto() {
        return crypto;
    }
    /**
     * 
     */
    public void setCrypto(CryptoConfig value) {
        crypto = value;
    }

    private AbiConfig abi;
    /**
     * 
     */
    public AbiConfig getAbi() {
        return abi;
    }
    /**
     * 
     */
    public void setAbi(AbiConfig value) {
        abi = value;
    }


    @Override
    public String toString() {
        return "{\"network\":"+network+",\"crypto\":"+crypto+",\"abi\":"+abi+"}";
    }
}