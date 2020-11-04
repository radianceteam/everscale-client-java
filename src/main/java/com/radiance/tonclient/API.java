package com.radiance.tonclient;

public class API {
    String data;
    
    private API(String data) {
        this.data = data;
    }
    
    public static API valueOf(String data) {
        return new API(data);
    }
}
