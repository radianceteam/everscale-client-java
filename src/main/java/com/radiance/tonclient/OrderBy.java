package com.radiance.tonclient;

/**
 *  
 */
public class OrderBy {

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
        return "{\"path\":\""+path+"\",\"direction\":"+direction+"}";
    }
}