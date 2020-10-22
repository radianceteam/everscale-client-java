package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

public class Crypto {
    private TONContext context;

    public Crypto(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String[]> factorize(String _composite) {
        return context.requestJSON("crypto.factorize", "{" + String.join(",", new String[]{"\"composite\":\""+_composite+"\""}) + "}")
            .thenApply(json -> {
                Iterable<JsonNode> it = () -> json.findValue("factors").elements();
                return StreamSupport.stream(it.spliterator(), false)
                    .map(e -> e.toString())
                    .toArray(String[]::new);
            });
    }

    public CompletableFuture<String> modularPower(String _base, String _exponent, String _modulus) {
        return context.requestJSON("crypto.modular_power", "{" + String.join(",", new String[]{"\"base\":\""+_base+"\"","\"exponent\":\""+_exponent+"\"","\"modulus\":\""+_modulus+"\""}) + "}")
            .thenApply(json -> json.findValue("modular_power").toString());
    }

    public CompletableFuture<Number> tonCrc16(String _data) {
        return context.requestJSON("crypto.ton_crc16", "{" + String.join(",", new String[]{"\"data\":\""+_data+"\""}) + "}")
            .thenApply(json -> Float.valueOf(json.findValue("crc").toString()));
    }

    public CompletableFuture<String> generateRandomBytes(Number _length) {
        return context.requestJSON("crypto.generate_random_bytes", "{" + String.join(",", new String[]{"\"length\":"+_length}) + "}")
            .thenApply(json -> json.findValue("bytes").toString());
    }

    public CompletableFuture<String> convertPublicKeyToTonSafeFormat(String _publicKey) {
        return context.requestJSON("crypto.convert_public_key_to_ton_safe_format", "{" + String.join(",", new String[]{"\"public_key\":\""+_publicKey+"\""}) + "}")
            .thenApply(json -> json.findValue("ton_public_key").toString());
    }

    public CompletableFuture<String> generateRandomSignKeys() {
        return context.request("crypto.generate_random_sign_keys", "{" + String.join(",", new String[]{}) + "}");
    }

    public CompletableFuture<String> sign(String _unsigned, String _keys) {
        return context.request("crypto.sign", "{" + String.join(",", new String[]{"\"unsigned\":\""+_unsigned+"\"","\"keys\":\""+_keys+"\""}) + "}");
    }

    public CompletableFuture<String> verifySignature(String _signed, String _public) {
        return context.requestJSON("crypto.verify_signature", "{" + String.join(",", new String[]{"\"signed\":\""+_signed+"\"","\"public\":\""+_public+"\""}) + "}")
            .thenApply(json -> json.findValue("unsigned").toString());
    }

    public CompletableFuture<String> sha256(String _data) {
        return context.requestJSON("crypto.sha256", "{" + String.join(",", new String[]{"\"data\":\""+_data+"\""}) + "}")
            .thenApply(json -> json.findValue("hash").toString());
    }

    public CompletableFuture<String> sha512(String _data) {
        return context.requestJSON("crypto.sha512", "{" + String.join(",", new String[]{"\"data\":\""+_data+"\""}) + "}")
            .thenApply(json -> json.findValue("hash").toString());
    }

    public CompletableFuture<String> scrypt(String _password, String _salt, Number _logN, Number _r, Number _p, Number _dkLen) {
        return context.requestJSON("crypto.scrypt", "{" + String.join(",", new String[]{"\"password\":\""+_password+"\"","\"salt\":\""+_salt+"\"","\"log_n\":"+_logN,"\"r\":"+_r,"\"p\":"+_p,"\"dk_len\":"+_dkLen}) + "}")
            .thenApply(json -> json.findValue("key").toString());
    }

    public CompletableFuture<String> naclSignKeypairFromSecretKey(String _secret) {
        return context.request("crypto.nacl_sign_keypair_from_secret_key", "{" + String.join(",", new String[]{"\"secret\":\""+_secret+"\""}) + "}");
    }

    public CompletableFuture<String> naclSign(String _unsigned, String _secret) {
        return context.requestJSON("crypto.nacl_sign", "{" + String.join(",", new String[]{"\"unsigned\":\""+_unsigned+"\"","\"secret\":\""+_secret+"\""}) + "}")
            .thenApply(json -> json.findValue("signed").toString());
    }

    public CompletableFuture<String> naclSignOpen(String _signed, String _public) {
        return context.requestJSON("crypto.nacl_sign_open", "{" + String.join(",", new String[]{"\"signed\":\""+_signed+"\"","\"public\":\""+_public+"\""}) + "}")
            .thenApply(json -> json.findValue("unsigned").toString());
    }

    public CompletableFuture<String> naclSignDetached(String _unsigned, String _secret) {
        return context.requestJSON("crypto.nacl_sign_detached", "{" + String.join(",", new String[]{"\"unsigned\":\""+_unsigned+"\"","\"secret\":\""+_secret+"\""}) + "}")
            .thenApply(json -> json.findValue("signature").toString());
    }

    public CompletableFuture<String> naclBoxKeypair() {
        return context.request("crypto.nacl_box_keypair", "{" + String.join(",", new String[]{}) + "}");
    }

    public CompletableFuture<String> naclBoxKeypairFromSecretKey(String _secret) {
        return context.request("crypto.nacl_box_keypair_from_secret_key", "{" + String.join(",", new String[]{"\"secret\":\""+_secret+"\""}) + "}");
    }

    public CompletableFuture<String> naclBox(String _decrypted, String _nonce, String _theirPublic, String _secret) {
        return context.requestJSON("crypto.nacl_box", "{" + String.join(",", new String[]{"\"decrypted\":\""+_decrypted+"\"","\"nonce\":\""+_nonce+"\"","\"their_public\":\""+_theirPublic+"\"","\"secret\":\""+_secret+"\""}) + "}")
            .thenApply(json -> json.findValue("encrypted").toString());
    }

    public CompletableFuture<String> naclBoxOpen(String _encrypted, String _nonce, String _theirPublic, String _secret) {
        return context.requestJSON("crypto.nacl_box_open", "{" + String.join(",", new String[]{"\"encrypted\":\""+_encrypted+"\"","\"nonce\":\""+_nonce+"\"","\"their_public\":\""+_theirPublic+"\"","\"secret\":\""+_secret+"\""}) + "}")
            .thenApply(json -> json.findValue("decrypted").toString());
    }

    public CompletableFuture<String> naclSecretBox(String _decrypted, String _nonce, String _key) {
        return context.requestJSON("crypto.nacl_secret_box", "{" + String.join(",", new String[]{"\"decrypted\":\""+_decrypted+"\"","\"nonce\":\""+_nonce+"\"","\"key\":\""+_key+"\""}) + "}")
            .thenApply(json -> json.findValue("encrypted").toString());
    }

    public CompletableFuture<String> naclSecretBoxOpen(String _encrypted, String _nonce, String _key) {
        return context.requestJSON("crypto.nacl_secret_box_open", "{" + String.join(",", new String[]{"\"encrypted\":\""+_encrypted+"\"","\"nonce\":\""+_nonce+"\"","\"key\":\""+_key+"\""}) + "}")
            .thenApply(json -> json.findValue("decrypted").toString());
    }

    public CompletableFuture<String> mnemonicWords(Number _dictionary) {
        return context.requestJSON("crypto.mnemonic_words", "{" + String.join(",", new String[]{"\"dictionary\":"+_dictionary}) + "}")
            .thenApply(json -> json.findValue("words").toString());
    }

    public CompletableFuture<String> mnemonicFromRandom(Number _dictionary, Number _wordCount) {
        return context.requestJSON("crypto.mnemonic_from_random", "{" + String.join(",", new String[]{"\"dictionary\":"+_dictionary,"\"word_count\":"+_wordCount}) + "}")
            .thenApply(json -> json.findValue("phrase").toString());
    }

    public CompletableFuture<String> mnemonicFromEntropy(String _entropy, Number _dictionary, Number _wordCount) {
        return context.requestJSON("crypto.mnemonic_from_entropy", "{" + String.join(",", new String[]{"\"entropy\":\""+_entropy+"\"","\"dictionary\":"+_dictionary,"\"word_count\":"+_wordCount}) + "}")
            .thenApply(json -> json.findValue("phrase").toString());
    }

    public CompletableFuture<Boolean> mnemonicVerify(String _phrase, Number _dictionary, Number _wordCount) {
        return context.requestJSON("crypto.mnemonic_verify", "{" + String.join(",", new String[]{"\"phrase\":\""+_phrase+"\"","\"dictionary\":"+_dictionary,"\"word_count\":"+_wordCount}) + "}")
            .thenApply(json -> Boolean.valueOf(json.findValue("valid").toString()));
    }

    public CompletableFuture<String> mnemonicDeriveSignKeys(String _phrase, String _path, Number _dictionary, Number _wordCount) {
        return context.request("crypto.mnemonic_derive_sign_keys", "{" + String.join(",", new String[]{"\"phrase\":\""+_phrase+"\"","\"path\":\""+_path+"\"","\"dictionary\":"+_dictionary,"\"word_count\":"+_wordCount}) + "}");
    }

    public CompletableFuture<String> hdkeyXprvFromMnemonic(String _phrase) {
        return context.requestJSON("crypto.hdkey_xprv_from_mnemonic", "{" + String.join(",", new String[]{"\"phrase\":\""+_phrase+"\""}) + "}")
            .thenApply(json -> json.findValue("xprv").toString());
    }

    public CompletableFuture<String> hdkeyDeriveFromXprv(String _xprv, Number _childIndex, Boolean _hardened) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv", "{" + String.join(",", new String[]{"\"xprv\":\""+_xprv+"\"","\"child_index\":"+_childIndex,"\"hardened\":"+_hardened}) + "}")
            .thenApply(json -> json.findValue("xprv").toString());
    }

    public CompletableFuture<String> hdkeyDeriveFromXprvPath(String _xprv, String _path) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv_path", "{" + String.join(",", new String[]{"\"xprv\":\""+_xprv+"\"","\"path\":\""+_path+"\""}) + "}")
            .thenApply(json -> json.findValue("xprv").toString());
    }

    public CompletableFuture<String> hdkeySecretFromXprv(String _xprv) {
        return context.requestJSON("crypto.hdkey_secret_from_xprv", "{" + String.join(",", new String[]{"\"xprv\":\""+_xprv+"\""}) + "}")
            .thenApply(json -> json.findValue("secret").toString());
    }

    public CompletableFuture<String> hdkeyPublicFromXprv(String _xprv) {
        return context.requestJSON("crypto.hdkey_public_from_xprv", "{" + String.join(",", new String[]{"\"xprv\":\""+_xprv+"\""}) + "}")
            .thenApply(json -> json.findValue("public").toString());
    }

}
