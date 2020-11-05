package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;

/**
 *   Crypto functions.
 */
public class CryptoModule {

    private TONContext context;

    public CryptoModule(TONContext context) {
        this.context = context;
    }

    public CompletableFuture<String[]> factorize(String composite) {
        return context.requestJSON("crypto.factorize", "{"+(composite==null?"":("\"composite\":\""+composite+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("factors"), String[].class));
    }

    public CompletableFuture<String> modularPower(String base, String exponent, String modulus) {
        return context.requestJSON("crypto.modular_power", "{"+Stream.of((base==null?null:("\"base\":\""+base+"\"")),(exponent==null?null:("\"exponent\":\""+exponent+"\"")),(modulus==null?null:("\"modulus\":\""+modulus+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("modular_power"), String.class));
    }

    public CompletableFuture<Number> tonCrc16(String data) {
        return context.requestJSON("crypto.ton_crc16", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("crc"), Number.class));
    }

    public CompletableFuture<String> generateRandomBytes(Number length) {
        return context.requestJSON("crypto.generate_random_bytes", "{"+(length==null?"":("\"length\":"+length))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("bytes"), String.class));
    }

    public CompletableFuture<String> convertPublicKeyToTonSafeFormat(String publicKey) {
        return context.requestJSON("crypto.convert_public_key_to_ton_safe_format", "{"+(publicKey==null?"":("\"public_key\":\""+publicKey+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("ton_public_key"), String.class));
    }

    public CompletableFuture<KeyPair> generateRandomSignKeys() {
        return context.requestJSON("crypto.generate_random_sign_keys", "{}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

    public CompletableFuture<ResultOfSign> sign(String unsigned, KeyPair keys) {
        return context.requestJSON("crypto.sign", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(keys==null?null:("\"keys\":"+keys))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfSign.class));
    }

    public CompletableFuture<String> verifySignature(String signed, String _public) {
        return context.requestJSON("crypto.verify_signature", "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(_public==null?null:("\"public\":\""+_public+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("unsigned"), String.class));
    }

    public CompletableFuture<String> sha256(String data) {
        return context.requestJSON("crypto.sha256", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

    public CompletableFuture<String> sha512(String data) {
        return context.requestJSON("crypto.sha512", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

    public CompletableFuture<String> scrypt(String password, String salt, Number logN, Number r, Number p, Number dkLen) {
        return context.requestJSON("crypto.scrypt", "{"+Stream.of((password==null?null:("\"password\":\""+password+"\"")),(salt==null?null:("\"salt\":\""+salt+"\"")),(logN==null?null:("\"log_n\":"+logN)),(r==null?null:("\"r\":"+r)),(p==null?null:("\"p\":"+p)),(dkLen==null?null:("\"dk_len\":"+dkLen))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("key"), String.class));
    }

    public CompletableFuture<KeyPair> naclSignKeypairFromSecretKey(String secret) {
        return context.requestJSON("crypto.nacl_sign_keypair_from_secret_key", "{"+(secret==null?"":("\"secret\":\""+secret+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

    public CompletableFuture<String> naclSign(String unsigned, String secret) {
        return context.requestJSON("crypto.nacl_sign", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("signed"), String.class));
    }

    public CompletableFuture<String> naclSignOpen(String signed, String _public) {
        return context.requestJSON("crypto.nacl_sign_open", "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(_public==null?null:("\"public\":\""+_public+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("unsigned"), String.class));
    }

    public CompletableFuture<String> naclSignDetached(String unsigned, String secret) {
        return context.requestJSON("crypto.nacl_sign_detached", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("signature"), String.class));
    }

    public CompletableFuture<KeyPair> naclBoxKeypair() {
        return context.requestJSON("crypto.nacl_box_keypair", "{}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

    public CompletableFuture<KeyPair> naclBoxKeypairFromSecretKey(String secret) {
        return context.requestJSON("crypto.nacl_box_keypair_from_secret_key", "{"+(secret==null?"":("\"secret\":\""+secret+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

    public CompletableFuture<String> naclBox(String decrypted, String nonce, String theirPublic, String secret) {
        return context.requestJSON("crypto.nacl_box", "{"+Stream.of((decrypted==null?null:("\"decrypted\":\""+decrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(theirPublic==null?null:("\"their_public\":\""+theirPublic+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("encrypted"), String.class));
    }

    public CompletableFuture<String> naclBoxOpen(String encrypted, String nonce, String theirPublic, String secret) {
        return context.requestJSON("crypto.nacl_box_open", "{"+Stream.of((encrypted==null?null:("\"encrypted\":\""+encrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(theirPublic==null?null:("\"their_public\":\""+theirPublic+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("decrypted"), String.class));
    }

    public CompletableFuture<String> naclSecretBox(String decrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box", "{"+Stream.of((decrypted==null?null:("\"decrypted\":\""+decrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(key==null?null:("\"key\":\""+key+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("encrypted"), String.class));
    }

    public CompletableFuture<String> naclSecretBoxOpen(String encrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box_open", "{"+Stream.of((encrypted==null?null:("\"encrypted\":\""+encrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(key==null?null:("\"key\":\""+key+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("decrypted"), String.class));
    }

    public CompletableFuture<String> mnemonicWords(Number dictionary) {
        return context.requestJSON("crypto.mnemonic_words", "{"+(dictionary==null?"":("\"dictionary\":"+dictionary))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("words"), String.class));
    }

    public CompletableFuture<String> mnemonicFromRandom(Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_random", "{"+Stream.of((dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("phrase"), String.class));
    }

    public CompletableFuture<String> mnemonicFromEntropy(String entropy, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_entropy", "{"+Stream.of((entropy==null?null:("\"entropy\":\""+entropy+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("phrase"), String.class));
    }

    public CompletableFuture<Boolean> mnemonicVerify(String phrase, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_verify", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("valid"), Boolean.class));
    }

    public CompletableFuture<KeyPair> mnemonicDeriveSignKeys(String phrase, String path, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_derive_sign_keys", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(path==null?null:("\"path\":\""+path+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

    public CompletableFuture<String> hdkeyXprvFromMnemonic(String phrase, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.hdkey_xprv_from_mnemonic", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

    public CompletableFuture<String> hdkeyDeriveFromXprv(String xprv, Number childIndex, Boolean hardened) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv", "{"+Stream.of((xprv==null?null:("\"xprv\":\""+xprv+"\"")),(childIndex==null?null:("\"child_index\":"+childIndex)),(hardened==null?null:("\"hardened\":"+hardened))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

    public CompletableFuture<String> hdkeyDeriveFromXprvPath(String xprv, String path) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv_path", "{"+Stream.of((xprv==null?null:("\"xprv\":\""+xprv+"\"")),(path==null?null:("\"path\":\""+path+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

    public CompletableFuture<String> hdkeySecretFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_secret_from_xprv", "{"+(xprv==null?"":("\"xprv\":\""+xprv+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("secret"), String.class));
    }

    public CompletableFuture<String> hdkeyPublicFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_public_from_xprv", "{"+(xprv==null?"":("\"xprv\":\""+xprv+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("public"), String.class));
    }

}
