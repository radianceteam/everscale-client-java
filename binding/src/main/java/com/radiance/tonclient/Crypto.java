package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Crypto functions.
 */
public class Crypto {

    /**
     *  
     */
    public static class KeyPair  {

        public KeyPair(String _public, String secret) {

            this._public = _public;

            this.secret = secret;

        }
        public KeyPair(String _public) {

            this._public = _public;

        }
        public KeyPair() {

        }
/*        public KeyPair() {
        }

        public KeyPair(String _public, String secret) {

            this._public = _public;

            this.secret = secret;

        }
*/


        @JsonProperty("public")
        private String _public;
        /**
         * Public key - 64 symbols hex string
         */
        public String getPublic() {
            return _public;
        }
        /**
         * Public key - 64 symbols hex string
         */
        public void setPublic(String value) {
            this._public = value;
        }

        @JsonProperty("secret")
        private String secret;
        /**
         * Private key - u64 symbols hex string
         */
        public String getSecret() {
            return secret;
        }
        /**
         * Private key - u64 symbols hex string
         */
        public void setSecret(String value) {
            this.secret = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((_public==null?null:("\"public\":\""+_public+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfSign  {

        public ResultOfSign(String signed, String signature) {

            this.signed = signed;

            this.signature = signature;

        }
        public ResultOfSign(String signed) {

            this.signed = signed;

        }
        public ResultOfSign() {

        }
/*        public ResultOfSign() {
        }

        public ResultOfSign(String signed, String signature) {

            this.signed = signed;

            this.signature = signature;

        }
*/


        @JsonProperty("signed")
        private String signed;
        /**
         * Signed data combined with signature encoded in `base64`.
         */
        public String getSigned() {
            return signed;
        }
        /**
         * Signed data combined with signature encoded in `base64`.
         */
        public void setSigned(String value) {
            this.signed = value;
        }

        @JsonProperty("signature")
        private String signature;
        /**
         * Signature encoded in `hex`.
         */
        public String getSignature() {
            return signature;
        }
        /**
         * Signature encoded in `hex`.
         */
        public void setSignature(String value) {
            this.signature = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Crypto(TONContext context) {
        this.context = context;
    }

   /**
    * Performs prime factorization – decomposition of a composite number into a product of smaller prime integers (factors). See <a target="_blank" href="https://en.wikipedia.org/wiki/Integer_factorization">https://en.wikipedia.org/wiki/Integer_factorization</a>
    *
    * @param composite Hexadecimal representation of u64 composite number.
    * @return Two factors of composite or empty if composite can't be factorized.
    */
    public CompletableFuture<String[]> factorize(String composite) {
        return context.requestJSON("crypto.factorize", "{"+(composite==null?"":("\"composite\":\""+composite+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("factors"), String[].class));
    }

   /**
    * Performs modular exponentiation for big integers (`base`^`exponent` mod `modulus`). See <a target="_blank" href="https://en.wikipedia.org/wiki/Modular_exponentiation">https://en.wikipedia.org/wiki/Modular_exponentiation</a>
    *
    * @param base `base` argument of calculation.
    * @param exponent `exponent` argument of calculation.
    * @param modulus `modulus` argument of calculation.
    * @return Result of modular exponentiation
    */
    public CompletableFuture<String> modularPower(String base, String exponent, String modulus) {
        return context.requestJSON("crypto.modular_power", "{"+Stream.of((base==null?null:("\"base\":\""+base+"\"")),(exponent==null?null:("\"exponent\":\""+exponent+"\"")),(modulus==null?null:("\"modulus\":\""+modulus+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("modular_power"), String.class));
    }

   /**
    * Calculates CRC16 using TON algorithm.
    *
    * @param data Input data for CRC calculation. Encoded with `base64`.
    * @return Calculated CRC for input data.
    */
    public CompletableFuture<Number> tonCrc16(String data) {
        return context.requestJSON("crypto.ton_crc16", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("crc"), Number.class));
    }

   /**
    * Generates random byte array of the specified length and returns it in `base64` format
    *
    * @param length Size of random byte array.
    * @return Generated bytes encoded in `base64`.
    */
    public CompletableFuture<String> generateRandomBytes(Number length) {
        return context.requestJSON("crypto.generate_random_bytes", "{"+(length==null?"":("\"length\":"+length))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("bytes"), String.class));
    }

   /**
    * Converts public key to ton safe_format
    *
    * @param publicKey Public key - 64 symbols hex string
    * @return Public key represented in TON safe format.
    */
    public CompletableFuture<String> convertPublicKeyToTonSafeFormat(String publicKey) {
        return context.requestJSON("crypto.convert_public_key_to_ton_safe_format", "{"+(publicKey==null?"":("\"public_key\":\""+publicKey+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("ton_public_key"), String.class));
    }

   /**
    * Generates random ed25519 key pair.
    *
    */
    public CompletableFuture<KeyPair> generateRandomSignKeys() {
        return context.requestJSON("crypto.generate_random_sign_keys", "{}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * Signs a data using the provided keys.
    *
    * @param unsigned Data that must be signed encoded in `base64`.
    * @param keys Sign keys.
    */
    public CompletableFuture<ResultOfSign> sign(String unsigned, KeyPair keys) {
        return context.requestJSON("crypto.sign", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(keys==null?null:("\"keys\":"+keys))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfSign.class));
    }

   /**
    * Verifies signed data using the provided public key. Raises error if verification is failed.
    *
    * @param signed Signed data that must be verified encoded in `base64`.
    * @param _public Signer's public key - 64 symbols hex string
    * @return Unsigned data encoded in `base64`.
    */
    public CompletableFuture<String> verifySignature(String signed, String _public) {
        return context.requestJSON("crypto.verify_signature", "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(_public==null?null:("\"public\":\""+_public+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("unsigned"), String.class));
    }

   /**
    * Calculates SHA256 hash of the specified data.
    *
    * @param data Input data for hash calculation. Encoded with `base64`.
    * @return Hash of input `data`. Encoded with 'hex'.
    */
    public CompletableFuture<String> sha256(String data) {
        return context.requestJSON("crypto.sha256", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

   /**
    * Calculates SHA512 hash of the specified data.
    *
    * @param data Input data for hash calculation. Encoded with `base64`.
    * @return Hash of input `data`. Encoded with 'hex'.
    */
    public CompletableFuture<String> sha512(String data) {
        return context.requestJSON("crypto.sha512", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

   /**
    * Derives key from `password` and `key` using `scrypt` algorithm. See <a target="_blank" href="https://en.wikipedia.org/wiki/Scrypt">https://en.wikipedia.org/wiki/Scrypt</a>.<p> # Arguments - `log_n` - The log2 of the Scrypt parameter `N` - `r` - The Scrypt parameter `r` - `p` - The Scrypt parameter `p` # Conditions - `log_n` must be less than `64` - `r` must be greater than `0` and less than or equal to `4294967295` - `p` must be greater than `0` and less than `4294967295` # Recommended values sufficient for most use-cases - `log_n = 15` (`n = 32768`) - `r = 8` - `p = 1`
    *
    * @param password The password bytes to be hashed. Must be encoded with `base64`.
    * @param salt Salt bytes that modify the hash to protect against Rainbow table attacks. Must be encoded with `base64`.
    * @param logN CPU/memory cost parameter
    * @param r The block size parameter, which fine-tunes sequential memory read size and performance.
    * @param p Parallelization parameter.
    * @param dkLen Intended output length in octets of the derived key.
    * @return Derived key. Encoded with `hex`.
    */
    public CompletableFuture<String> scrypt(String password, String salt, Number logN, Number r, Number p, Number dkLen) {
        return context.requestJSON("crypto.scrypt", "{"+Stream.of((password==null?null:("\"password\":\""+password+"\"")),(salt==null?null:("\"salt\":\""+salt+"\"")),(logN==null?null:("\"log_n\":"+logN)),(r==null?null:("\"r\":"+r)),(p==null?null:("\"p\":"+p)),(dkLen==null?null:("\"dk_len\":"+dkLen))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("key"), String.class));
    }

   /**
    * Generates a key pair for signing from the secret key
    *
    * @param secret Secret key - unprefixed 0-padded to 64 symbols hex string
    */
    public CompletableFuture<KeyPair> naclSignKeypairFromSecretKey(String secret) {
        return context.requestJSON("crypto.nacl_sign_keypair_from_secret_key", "{"+(secret==null?"":("\"secret\":\""+secret+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * Signs data using the signer's secret key.
    *
    * @param unsigned Data that must be signed encoded in `base64`.
    * @param secret Signer's secret key - unprefixed 0-padded to 64 symbols hex string
    * @return Signed data, encoded in `base64`.
    */
    public CompletableFuture<String> naclSign(String unsigned, String secret) {
        return context.requestJSON("crypto.nacl_sign", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("signed"), String.class));
    }

   /**
    * 
    *
    * @param signed Signed data that must be unsigned. Encoded with `base64`.
    * @param _public Signer's public key - unprefixed 0-padded to 64 symbols hex string
    * @return Unsigned data, encoded in `base64`.
    */
    public CompletableFuture<String> naclSignOpen(String signed, String _public) {
        return context.requestJSON("crypto.nacl_sign_open", "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(_public==null?null:("\"public\":\""+_public+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("unsigned"), String.class));
    }

   /**
    * 
    *
    * @param unsigned Data that must be signed encoded in `base64`.
    * @param secret Signer's secret key - unprefixed 0-padded to 64 symbols hex string
    * @return Signature encoded in `hex`.
    */
    public CompletableFuture<String> naclSignDetached(String unsigned, String secret) {
        return context.requestJSON("crypto.nacl_sign_detached", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("signature"), String.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<KeyPair> naclBoxKeypair() {
        return context.requestJSON("crypto.nacl_box_keypair", "{}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * Generates key pair from a secret key
    *
    * @param secret Secret key - unprefixed 0-padded to 64 symbols hex string
    */
    public CompletableFuture<KeyPair> naclBoxKeypairFromSecretKey(String secret) {
        return context.requestJSON("crypto.nacl_box_keypair_from_secret_key", "{"+(secret==null?"":("\"secret\":\""+secret+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * Public key authenticated encryption<p> Encrypt and authenticate a message using the senders secret key, the recievers public key, and a nonce.
    *
    * @param decrypted Data that must be encrypted encoded in `base64`.
    * @param nonce Nonce, encoded in `hex`
    * @param theirPublic Receiver's public key - unprefixed 0-padded to 64 symbols hex string
    * @param secret Sender's private key - unprefixed 0-padded to 64 symbols hex string
    * @return Encrypted data encoded in `base64`.
    */
    public CompletableFuture<String> naclBox(String decrypted, String nonce, String theirPublic, String secret) {
        return context.requestJSON("crypto.nacl_box", "{"+Stream.of((decrypted==null?null:("\"decrypted\":\""+decrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(theirPublic==null?null:("\"their_public\":\""+theirPublic+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("encrypted"), String.class));
    }

   /**
    * Decrypt and verify the cipher text using the recievers secret key, the senders public key, and the nonce.
    *
    * @param encrypted Data that must be decrypted. Encoded with `base64`.
    * @param nonce 
    * @param theirPublic Sender's public key - unprefixed 0-padded to 64 symbols hex string
    * @param secret Receiver's private key - unprefixed 0-padded to 64 symbols hex string
    * @return Decrypted data encoded in `base64`.
    */
    public CompletableFuture<String> naclBoxOpen(String encrypted, String nonce, String theirPublic, String secret) {
        return context.requestJSON("crypto.nacl_box_open", "{"+Stream.of((encrypted==null?null:("\"encrypted\":\""+encrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(theirPublic==null?null:("\"their_public\":\""+theirPublic+"\"")),(secret==null?null:("\"secret\":\""+secret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("decrypted"), String.class));
    }

   /**
    * Encrypt and authenticate message using nonce and secret key.
    *
    * @param decrypted Data that must be encrypted. Encoded with `base64`.
    * @param nonce Nonce in `hex`
    * @param key Secret key - unprefixed 0-padded to 64 symbols hex string
    * @return Encrypted data encoded in `base64`.
    */
    public CompletableFuture<String> naclSecretBox(String decrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box", "{"+Stream.of((decrypted==null?null:("\"decrypted\":\""+decrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(key==null?null:("\"key\":\""+key+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("encrypted"), String.class));
    }

   /**
    * Decrypts and verifies cipher text using `nonce` and secret `key`.
    *
    * @param encrypted Data that must be decrypted. Encoded with `base64`.
    * @param nonce Nonce in `hex`
    * @param key Public key - unprefixed 0-padded to 64 symbols hex string
    * @return Decrypted data encoded in `base64`.
    */
    public CompletableFuture<String> naclSecretBoxOpen(String encrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box_open", "{"+Stream.of((encrypted==null?null:("\"encrypted\":\""+encrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(key==null?null:("\"key\":\""+key+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("decrypted"), String.class));
    }

   /**
    * Prints the list of words from the specified dictionary
    *
    * @param dictionary Dictionary identifier
    * @return The list of mnemonic words
    */
    public CompletableFuture<String> mnemonicWords(Number dictionary) {
        return context.requestJSON("crypto.mnemonic_words", "{"+(dictionary==null?"":("\"dictionary\":"+dictionary))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("words"), String.class));
    }

   /**
    * Generates a random mnemonic from the specified dictionary and word count
    *
    * @param dictionary Dictionary identifier
    * @param wordCount Mnemonic word count
    * @return String of mnemonic words
    */
    public CompletableFuture<String> mnemonicFromRandom(Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_random", "{"+Stream.of((dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("phrase"), String.class));
    }

   /**
    * Generates mnemonic from pre-generated entropy
    *
    * @param entropy Entropy bytes. Hex encoded.
    * @param dictionary Dictionary identifier
    * @param wordCount Mnemonic word count
    * @return Phrase
    */
    public CompletableFuture<String> mnemonicFromEntropy(String entropy, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_entropy", "{"+Stream.of((entropy==null?null:("\"entropy\":\""+entropy+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("phrase"), String.class));
    }

   /**
    * The phrase supplied will be checked for word length and validated according to the checksum specified in BIP0039.
    *
    * @param phrase Phrase
    * @param dictionary Dictionary identifier
    * @param wordCount Word count
    * @return Flag indicating if the mnemonic is valid or not
    */
    public CompletableFuture<Boolean> mnemonicVerify(String phrase, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_verify", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("valid"), Boolean.class));
    }

   /**
    * Validates the seed phrase, generates master key and then derives the key pair from the master key and the specified path
    *
    * @param phrase Phrase
    * @param path Derivation path, for instance "m/44'/396'/0'/0/0"
    * @param dictionary Dictionary identifier
    * @param wordCount Word count
    */
    public CompletableFuture<KeyPair> mnemonicDeriveSignKeys(String phrase, String path, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_derive_sign_keys", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(path==null?null:("\"path\":\""+path+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * Generates an extended master private key that will be the root for all the derived keys
    *
    * @param phrase String with seed phrase
    * @param dictionary Dictionary identifier
    * @param wordCount Mnemonic word count
    * @return Serialized extended master private key
    */
    public CompletableFuture<String> hdkeyXprvFromMnemonic(String phrase, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.hdkey_xprv_from_mnemonic", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary)),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

   /**
    * Returns extended private key derived from the specified extended private key and child index
    *
    * @param xprv Serialized extended private key
    * @param childIndex Child index (see BIP-0032)
    * @param hardened Indicates the derivation of hardened/not-hardened key (see BIP-0032)
    * @return Serialized extended private key
    */
    public CompletableFuture<String> hdkeyDeriveFromXprv(String xprv, Number childIndex, Boolean hardened) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv", "{"+Stream.of((xprv==null?null:("\"xprv\":\""+xprv+"\"")),(childIndex==null?null:("\"child_index\":"+childIndex)),(hardened==null?null:("\"hardened\":"+hardened))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

   /**
    * Derives the exented private key from the specified key and path
    *
    * @param xprv Serialized extended private key
    * @param path Derivation path, for instance "m/44'/396'/0'/0/0"
    * @return Derived serialized extended private key
    */
    public CompletableFuture<String> hdkeyDeriveFromXprvPath(String xprv, String path) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv_path", "{"+Stream.of((xprv==null?null:("\"xprv\":\""+xprv+"\"")),(path==null?null:("\"path\":\""+path+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

   /**
    * Extracts the private key from the serialized extended private key
    *
    * @param xprv Serialized extended private key
    * @return Private key - 64 symbols hex string
    */
    public CompletableFuture<String> hdkeySecretFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_secret_from_xprv", "{"+(xprv==null?"":("\"xprv\":\""+xprv+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("secret"), String.class));
    }

   /**
    * Extracts the public key from the serialized extended private key
    *
    * @param xprv Serialized extended private key
    * @return Public key - 64 symbols hex string
    */
    public CompletableFuture<String> hdkeyPublicFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_public_from_xprv", "{"+(xprv==null?"":("\"xprv\":\""+xprv+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("public"), String.class));
    }

   /**
    * Performs symmetric `chacha20` encryption.
    *
    * @param data Source data to be encrypted or decrypted. Must be encoded with `base64`.
    * @param key 256-bit key. Must be encoded with `hex`.
    * @param nonce 96-bit nonce. Must be encoded with `hex`.
    * @return Encrypted/decrypted data. Encoded with `base64`.
    */
    public CompletableFuture<String> chacha20(String data, String key, String nonce) {
        return context.requestJSON("crypto.chacha20", "{"+Stream.of((data==null?null:("\"data\":\""+data+"\"")),(key==null?null:("\"key\":\""+key+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), String.class));
    }

}
