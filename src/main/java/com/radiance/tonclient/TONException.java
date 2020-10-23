package com.radiance.tonclient;

public class TONException extends Exception {
    private int code;
    
    TONException(int code, String message) {
        super(message);
        this.code = code;
    }

    TONException(Throwable cause) {
        super(cause);
        this.code = -1;
    }

    public int getCode() {
        return code;
    }
}