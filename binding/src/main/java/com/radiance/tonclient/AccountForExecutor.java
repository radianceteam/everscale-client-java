package com.radiance.tonclient;

import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AccountForExecutor {

    public static final None None = new None();

/**
 *  Non-existing account to run a creation internal message. Should be used with `skip_transaction_check = true` if the message has no deploy data since transaction on the unitialized account are always aborted
 */
public static class None extends AccountForExecutor {
    public None() {
    }




    @Override
    public String toString() {
        return "{"+"\"type\":\"None\""+"}";
    }
}

    public static final Uninit Uninit = new Uninit();

/**
 *  Emulate unitialized account to run deploy message
 */
public static class Uninit extends AccountForExecutor {
    public Uninit() {
    }




    @Override
    public String toString() {
        return "{"+"\"type\":\"Uninit\""+"}";
    }
}

/**
 *  Account state to run message
 */
public static class Account extends AccountForExecutor {
    public Account() {
    }

    public Account(String boc, Boolean unlimitedBalance) {

        this.boc = boc;

        this.unlimitedBalance = unlimitedBalance;

    }



    @JsonProperty("boc")
    private String boc;
    /**
     * Account BOC. Encoded as base64.
     */
    public String getBoc() {
        return boc;
    }
    /**
     * Account BOC. Encoded as base64.
     */
    public void setBoc(String value) {
        boc = value;
    }

    @JsonProperty("unlimited_balance")
    private Boolean unlimitedBalance;
    /**
     * Flag for running account with the unlimited balance. Can be used to calculate transaction fees without balance check
     */
    public Boolean getUnlimitedBalance() {
        return unlimitedBalance;
    }
    /**
     * Flag for running account with the unlimited balance. Can be used to calculate transaction fees without balance check
     */
    public void setUnlimitedBalance(Boolean value) {
        unlimitedBalance = value;
    }


    @Override
    public String toString() {
        return "{"+Stream.of("\"type\":\"Account\"",(boc==null?null:("\"boc\":\""+boc+"\"")),(unlimitedBalance==null?null:("\"unlimited_balance\":"+unlimitedBalance))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
    }
}
}