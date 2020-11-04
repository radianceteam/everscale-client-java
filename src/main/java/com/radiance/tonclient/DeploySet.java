package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class DeploySet {
    public DeploySet() {
    }

    public DeploySet(String tvc, Number workchainId, Object initialData) {

        this.tvc = tvc;

        this.workchainId = workchainId;

        this.initialData = initialData;

    }



    @JsonProperty("tvc")
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

    @JsonProperty("workchain_id")
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

    @JsonProperty("initial_data")
    private Object initialData;
    /**
     *  List of initial values for contract's public variables.
     */
    public Object getInitialData() {
        return initialData;
    }
    /**
     *  List of initial values for contract's public variables.
     */
    public void setInitialData(Object value) {
        initialData = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((tvc==null?null:("\"tvc\":\""+tvc+"\"")),(workchainId==null?null:("\"workchain_id\":"+workchainId)),(initialData==null?null:("\"initial_data\":"+initialData))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}