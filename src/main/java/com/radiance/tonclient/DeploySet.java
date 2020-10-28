package com.radiance.tonclient;

/**
 *  
 */
public class DeploySet {

    private String tvc;
    /**
     *  Content of TVC file encoded in `base64`.
     */
    public String getTvc() {
        return tvc;
    }
    /**
     *  Content of TVC file encoded in `base64`.
     */
    public void setTvc(String value) {
        tvc = value;
    }

    private Number workchainId;
    /**
     *  Target workchain for destination address. Default is `0`.
     */
    public Number getWorkchainId() {
        return workchainId;
    }
    /**
     *  Target workchain for destination address. Default is `0`.
     */
    public void setWorkchainId(Number value) {
        workchainId = value;
    }

    private String initialData;
    /**
     *  List of initial values for contract's public variables.
     */
    public String getInitialData() {
        return initialData;
    }
    /**
     *  List of initial values for contract's public variables.
     */
    public void setInitialData(String value) {
        initialData = value;
    }


    @Override
    public String toString() {
        return "{\"tvc\":\""+tvc+"\",\"workchain_id\":"+workchainId+",\"initial_data\":\""+initialData+"\"}";
    }
}