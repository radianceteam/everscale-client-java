package com.radiance.tonclient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendMessageEvent {
    private String type, message;
    private Object error;

    @JsonProperty("shard_block_id")
    private String shardBlockId;

    @JsonProperty("message_id")
    private String messageId;

    public void setType(String value) {
        type = value;
    }

    public String getType() {
        return type;
    }

    public void setShardBlockId(String value) {
        shardBlockId = value;
    }

    public void setMessageId(String value) {
        messageId = value;
    }

    public void setMessage(String value) {
        message = value;
    }

    public void setError(Object value) {
        error = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {messageId:" + messageId + ", type:" + type + ", shardBlockId:" + shardBlockId + ", error:" + error + "}";
    }
}
