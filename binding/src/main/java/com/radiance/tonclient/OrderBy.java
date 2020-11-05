package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  
 */
public class OrderBy {
    public OrderBy() {
    }

    public OrderBy(String path, SortDirection direction) {

        this.path = path;

        this.direction = direction;

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
        path = value;
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
        direction = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of((path==null?null:("\"path\":\""+path+"\"")),(direction==null?null:("\"direction\":"+direction))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}