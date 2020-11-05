package com.radiance.tonclient;

import com.fasterxml.jackson.databind.JsonNode;

public class SubscribeCollectionEvent {
    private JsonNode result;

    public void setResult(JsonNode value) {
        result = value;
    }

    public JsonNode getResult() {
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + result;
    }
}
