package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

public class Abi {
    private TONContext context;

    public Abi(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String> encodeMessageBody(String _abi, String _callSet, Boolean _isInternal, String _signer, Number _processingTryIndex) {
        return context.request("abi.encode_message_body", "{" + String.join(",", new String[]{"\"abi\":\""+_abi+"\"","\"call_set\":\""+_callSet+"\"","\"is_internal\":"+_isInternal,"\"signer\":\""+_signer+"\"","\"processing_try_index\":"+_processingTryIndex}) + "}");
    }

    public CompletableFuture<String> attachSignatureToMessageBody(String _abi, String _publicKey, String _message, String _signature) {
        return context.requestJSON("abi.attach_signature_to_message_body", "{" + String.join(",", new String[]{"\"abi\":\""+_abi+"\"","\"public_key\":\""+_publicKey+"\"","\"message\":\""+_message+"\"","\"signature\":\""+_signature+"\""}) + "}")
            .thenApply(json -> json.findValue("body").toString());
    }

    public CompletableFuture<String> encodeMessage(String _abi, String _address, String _deploySet, String _callSet, String _signer, Number _processingTryIndex) {
        return context.request("abi.encode_message", "{" + String.join(",", new String[]{"\"abi\":\""+_abi+"\"","\"address\":\""+_address+"\"","\"deploy_set\":\""+_deploySet+"\"","\"call_set\":\""+_callSet+"\"","\"signer\":\""+_signer+"\"","\"processing_try_index\":"+_processingTryIndex}) + "}");
    }

    public CompletableFuture<String> attachSignature(String _abi, String _publicKey, String _message, String _signature) {
        return context.request("abi.attach_signature", "{" + String.join(",", new String[]{"\"abi\":\""+_abi+"\"","\"public_key\":\""+_publicKey+"\"","\"message\":\""+_message+"\"","\"signature\":\""+_signature+"\""}) + "}");
    }

    public CompletableFuture<String> decodeMessage(String _abi, String _message) {
        return context.request("abi.decode_message", "{" + String.join(",", new String[]{"\"abi\":\""+_abi+"\"","\"message\":\""+_message+"\""}) + "}");
    }

    public CompletableFuture<String> decodeMessageBody(String _abi, String _body, Boolean _isInternal) {
        return context.request("abi.decode_message_body", "{" + String.join(",", new String[]{"\"abi\":\""+_abi+"\"","\"body\":\""+_body+"\"","\"is_internal\":"+_isInternal}) + "}");
    }

    public CompletableFuture<String> encodeAccount(String _stateInit, Long _balance, Long _lastTransLt, Number _lastPaid) {
        return context.request("abi.encode_account", "{" + String.join(",", new String[]{"\"state_init\":\""+_stateInit+"\"","\"balance\":"+_balance,"\"last_trans_lt\":"+_lastTransLt,"\"last_paid\":"+_lastPaid}) + "}");
    }

}
