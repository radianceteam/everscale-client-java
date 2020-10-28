package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;

/**
 *   Crypto functions.
 */
public class Crypto {

    private TONContext context;

    public Crypto(TONContext context) {
        this.context = context;
    }

  /**
   *  Performs prime factorization – decomposition of a composite number into a product of smaller prime integers (factors). See <a target="_blank" href="https://en.wikipedia.org/wiki/Integer_factorization">https://en.wikipedia.org/wiki/Integer_factorization</a>
   *
   * @param composite  Hexadecimal representation of u64 composite number.
   */
    public CompletableFuture<String[]> factorize(String composite) {
        return context.requestJSON("crypto.factorize", "{\"composite\":\""+composite+"\"}")
            .thenApply(json -> {
                Iterable<JsonNode> it = () -> json.findValue("factors").elements();
                return StreamSupport.stream(it.spliterator(), false)
                    .map(e -> e.asText())
                    .toArray(String[]::new);
            });
    }

  /**
   *  Performs modular exponentiation for big integers (`base`^`exponent` mod `modulus`). See <a target="_blank" href="https://en.wikipedia.org/wiki/Modular_exponentiation">https://en.wikipedia.org/wiki/Modular_exponentiation</a>
   *
   * @param base  `base` argument of calculation.
   * @param exponent  `exponent` argument of calculation.
   * @param modulus  `modulus` argument of calculation.
   */
    public CompletableFuture<String> modularPower(String base, String exponent, String modulus) {
        return context.requestJSON("crypto.modular_power", "{\"base\":\""+base+"\",\"exponent\":\""+exponent+"\",\"modulus\":\""+modulus+"\"}")
            .thenApply(json -> json.findValue("modular_power").asText());
    }

  /**
   *  Calculates CRC16 using TON algorithm.
   *
   * @param data  Input data for CRC calculation. Encoded with `base64`.
   */
    public CompletableFuture<Number> tonCrc16(String data) {
        return context.requestJSON("crypto.ton_crc16", "{\"data\":\""+data+"\"}")
            .thenApply(json -> TONContext.toNumber(json.findValue("crc").asText()));
    }

  /**
   *  Generates random byte array of the specified length and returns it in `base64` format
   *
   * @param length  Size of random byte array.
   */
    public CompletableFuture<String> generateRandomBytes(Number length) {
        return context.requestJSON("crypto.generate_random_bytes", "{\"length\":"+length+"}")
            .thenApply(json -> json.findValue("bytes").asText());
    }

  /**
   *  Converts public key to ton safe_format
   *
   * @param publicKey  Public key - 64 symbols hex string
   */
    public CompletableFuture<String> convertPublicKeyToTonSafeFormat(String publicKey) {
        return context.requestJSON("crypto.convert_public_key_to_ton_safe_format", "{\"public_key\":\""+publicKey+"\"}")
            .thenApply(json -> json.findValue("ton_public_key").asText());
    }

  /**
   *  Generates random ed25519 key pair.
   *
   */
    public CompletableFuture<KeyPair> generateRandomSignKeys() {
        return context.requestValue("crypto.generate_random_sign_keys", "{}", KeyPair.class);
    }

  /**
   *  Signs a data using the provided keys.
   *
   * @param unsigned  Data that must be signed encoded in `base64`.
   * @param keys  Sign keys.
   */
    public CompletableFuture<ResultOfSign> sign(String unsigned, KeyPair keys) {
        return context.requestValue("crypto.sign", "{\"unsigned\":\""+unsigned+"\",\"keys\":"+keys+"}", ResultOfSign.class);
    }

  /**
   *  Verifies signed data using the provided public key. Raises error if verification is failed.
   *
   * @param signed  Signed data that must be verified encoded in `base64`.
   * @param _public  Signer's public key - 64 symbols hex string
   */
    public CompletableFuture<String> verifySignature(String signed, String _public) {
        return context.requestJSON("crypto.verify_signature", "{\"signed\":\""+signed+"\",\"public\":\""+_public+"\"}")
            .thenApply(json -> json.findValue("unsigned").asText());
    }

  /**
   *  Calculates SHA256 hash of the specified data.
   *
   * @param data  Input data for hash calculation. Encoded with `base64`.
   */
    public CompletableFuture<String> sha256(String data) {
        return context.requestJSON("crypto.sha256", "{\"data\":\""+data+"\"}")
            .thenApply(json -> json.findValue("hash").asText());
    }

  /**
   *  Calculates SHA512 hash of the specified data.
   *
   * @param data  Input data for hash calculation. Encoded with `base64`.
   */
    public CompletableFuture<String> sha512(String data) {
        return context.requestJSON("crypto.sha512", "{\"data\":\""+data+"\"}")
            .thenApply(json -> json.findValue("hash").asText());
    }

  /**
   *  Derives key from `password` and `key` using `scrypt` algorithm. See <a target="_blank" href="https://en.wikipedia.org/wiki/Scrypt">https://en.wikipedia.org/wiki/Scrypt</a>.<p> # Arguments - `log_n` - The log2 of the Scrypt parameter `N` - `r` - The Scrypt parameter `r` - `p` - The Scrypt parameter `p` # Conditions - `log_n` must be less than `64` - `r` must be greater than `0` and less than or equal to `4294967295` - `p` must be greater than `0` and less than `4294967295` # Recommended values sufficient for most use-cases - `log_n = 15` (`n = 32768`) - `r = 8` - `p = 1`
   *
   * @param password  The password bytes to be hashed. Must be encoded with `base64`.
   * @param salt  A salt bytes that modifies the hash to protect against Rainbow table attacks. Must be encoded with `base64`.
   * @param logN  CPU/memory cost parameter
   * @param r  The block size parameter, which fine-tunes sequential memory read size and performance.
   * @param p  Parallelization parameter.
   * @param dkLen  Intended output length in octets of the derived key.
   */
    public CompletableFuture<String> scrypt(String password, String salt, Number logN, Number r, Number p, Number dkLen) {
        return context.requestJSON("crypto.scrypt", "{\"password\":\""+password+"\",\"salt\":\""+salt+"\",\"log_n\":"+logN+",\"r\":"+r+",\"p\":"+p+",\"dk_len\":"+dkLen+"}")
            .thenApply(json -> json.findValue("key").asText());
    }

  /**
   *  Generates a key pair for signing from the secret key
   *
   * @param secret  Secret key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<KeyPair> naclSignKeypairFromSecretKey(String secret) {
        return context.requestValue("crypto.nacl_sign_keypair_from_secret_key", "{\"secret\":\""+secret+"\"}", KeyPair.class);
    }

  /**
   *  Signs data using the signer's secret key.
   *
   * @param unsigned  Data that must be signed encoded in `base64`.
   * @param secret  Signer's secret key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<String> naclSign(String unsigned, String secret) {
        return context.requestJSON("crypto.nacl_sign", "{\"unsigned\":\""+unsigned+"\",\"secret\":\""+secret+"\"}")
            .thenApply(json -> json.findValue("signed").asText());
    }

  /**
   * 
   *
   * @param signed  Signed data that must be unsigned. Encoded with `base64`.
   * @param _public  Signer's public key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<String> naclSignOpen(String signed, String _public) {
        return context.requestJSON("crypto.nacl_sign_open", "{\"signed\":\""+signed+"\",\"public\":\""+_public+"\"}")
            .thenApply(json -> json.findValue("unsigned").asText());
    }

  /**
   * 
   *
   * @param unsigned  Data that must be signed encoded in `base64`.
   * @param secret  Signer's secret key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<String> naclSignDetached(String unsigned, String secret) {
        return context.requestJSON("crypto.nacl_sign_detached", "{\"unsigned\":\""+unsigned+"\",\"secret\":\""+secret+"\"}")
            .thenApply(json -> json.findValue("signature").asText());
    }

  /**
   * 
   *
   */
    public CompletableFuture<KeyPair> naclBoxKeypair() {
        return context.requestValue("crypto.nacl_box_keypair", "{}", KeyPair.class);
    }

  /**
   *  Generates key pair from a secret key
   *
   * @param secret  Secret key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<KeyPair> naclBoxKeypairFromSecretKey(String secret) {
        return context.requestValue("crypto.nacl_box_keypair_from_secret_key", "{\"secret\":\""+secret+"\"}", KeyPair.class);
    }

  /**
   *  Public key authenticated encryption<p> Encrypt and authenticate a message using the senders secret key, the recievers public key, and a nonce. 
   *
   * @param decrypted  Data that must be encrypted encoded in `base64`.
   * @param nonce  Nonce, encoded in `hex`
   * @param theirPublic  Receiver's public key - unprefixed 0-padded to 64 symbols hex string 
   * @param secret  Sender's private key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<String> naclBox(String decrypted, String nonce, String theirPublic, String secret) {
        return context.requestJSON("crypto.nacl_box", "{\"decrypted\":\""+decrypted+"\",\"nonce\":\""+nonce+"\",\"their_public\":\""+theirPublic+"\",\"secret\":\""+secret+"\"}")
            .thenApply(json -> json.findValue("encrypted").asText());
    }

  /**
   *  Decrypt and verify the cipher text using the recievers secret key, the senders public key, and the nonce.
   *
   * @param encrypted  Data that must be decrypted. Encoded with `base64`.
   * @param theirPublic  Sender's public key - unprefixed 0-padded to 64 symbols hex string 
   * @param secret  Receiver's private key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<String> naclBoxOpen(String encrypted, String nonce, String theirPublic, String secret) {
        return context.requestJSON("crypto.nacl_box_open", "{\"encrypted\":\""+encrypted+"\",\"nonce\":\""+nonce+"\",\"their_public\":\""+theirPublic+"\",\"secret\":\""+secret+"\"}")
            .thenApply(json -> json.findValue("decrypted").asText());
    }

  /**
   *  Encrypt and authenticate message using nonce and secret key.
   *
   * @param decrypted  Data that must be encrypted. Encoded with `base64`.
   * @param nonce  Nonce in `hex`
   * @param key  Secret key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<String> naclSecretBox(String decrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box", "{\"decrypted\":\""+decrypted+"\",\"nonce\":\""+nonce+"\",\"key\":\""+key+"\"}")
            .thenApply(json -> json.findValue("encrypted").asText());
    }

  /**
   *  Decrypts and verifies cipher text using `nonce` and secret `key`.
   *
   * @param encrypted  Data that must be decrypted. Encoded with `base64`.
   * @param nonce  Nonce in `hex`
   * @param key  Public key - unprefixed 0-padded to 64 symbols hex string 
   */
    public CompletableFuture<String> naclSecretBoxOpen(String encrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box_open", "{\"encrypted\":\""+encrypted+"\",\"nonce\":\""+nonce+"\",\"key\":\""+key+"\"}")
            .thenApply(json -> json.findValue("decrypted").asText());
    }

  /**
   *  Prints the list of words from the specified dictionary
   *
   * @param dictionary  Dictionary identifier
   */
    public CompletableFuture<String> mnemonicWords(Number dictionary) {
        return context.requestJSON("crypto.mnemonic_words", "{\"dictionary\":"+dictionary+"}")
            .thenApply(json -> json.findValue("words").asText());
    }

  /**
   *  Generates a random mnemonic from the specified dictionary and word count
   *
   * @param dictionary  Dictionary identifier
   * @param wordCount  Mnemonic word count
   */
    public CompletableFuture<String> mnemonicFromRandom(Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_random", "{\"dictionary\":"+dictionary+",\"word_count\":"+wordCount+"}")
            .thenApply(json -> json.findValue("phrase").asText());
    }

  /**
   *  Generates mnemonic from pre-generated entropy
   *
   * @param entropy  Entropy bytes. Hex encoded.
   * @param dictionary  Dictionary identifier
   * @param wordCount  Mnemonic word count
   */
    public CompletableFuture<String> mnemonicFromEntropy(String entropy, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_entropy", "{\"entropy\":\""+entropy+"\",\"dictionary\":"+dictionary+",\"word_count\":"+wordCount+"}")
            .thenApply(json -> json.findValue("phrase").asText());
    }

  /**
   *  The phrase supplied will be checked for word length and validated according to the checksum specified in BIP0039.
   *
   * @param phrase  Phrase
   * @param dictionary  Dictionary identifier
   * @param wordCount  Word count
   */
    public CompletableFuture<Boolean> mnemonicVerify(String phrase, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_verify", "{\"phrase\":\""+phrase+"\",\"dictionary\":"+dictionary+",\"word_count\":"+wordCount+"}")
            .thenApply(json -> Boolean.valueOf(json.findValue("valid").asText()));
    }

  /**
   *  Validates the seed phrase, generates master key and then derives the key pair from the master key and the specified path
   *
   * @param phrase  Phrase
   * @param path  Derivation path, for instance "m/44'/396'/0'/0/0"
   * @param dictionary  Dictionary identifier
   * @param wordCount  Word count
   */
    public CompletableFuture<KeyPair> mnemonicDeriveSignKeys(String phrase, String path, Number dictionary, Number wordCount) {
        return context.requestValue("crypto.mnemonic_derive_sign_keys", "{\"phrase\":\""+phrase+"\",\"path\":\""+path+"\",\"dictionary\":"+dictionary+",\"word_count\":"+wordCount+"}", KeyPair.class);
    }

  /**
   *  Generates an extended master private key that will be the root for all the derived keys
   *
   * @param phrase  String with seed phrase
   * @param dictionary  Dictionary identifier
   * @param wordCount  Mnemonic word count
   */
    public CompletableFuture<String> hdkeyXprvFromMnemonic(String phrase, Number dictionary, Number wordCount) {
        return context.requestJSON("crypto.hdkey_xprv_from_mnemonic", "{\"phrase\":\""+phrase+"\",\"dictionary\":"+dictionary+",\"word_count\":"+wordCount+"}")
            .thenApply(json -> json.findValue("xprv").asText());
    }

  /**
   *  Returns extended private key derived from the specified extended private key and child index
   *
   * @param xprv  Serialized extended private key
   * @param childIndex  Child index (see BIP-0032)
   * @param hardened  Indicates the derivation of hardened/not-hardened key (see BIP-0032)
   */
    public CompletableFuture<String> hdkeyDeriveFromXprv(String xprv, Number childIndex, Boolean hardened) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv", "{\"xprv\":\""+xprv+"\",\"child_index\":"+childIndex+",\"hardened\":"+hardened+"}")
            .thenApply(json -> json.findValue("xprv").asText());
    }

  /**
   *  Derives the exented private key from the specified key and path
   *
   * @param xprv  Serialized extended private key
   * @param path  Derivation path, for instance "m/44'/396'/0'/0/0"
   */
    public CompletableFuture<String> hdkeyDeriveFromXprvPath(String xprv, String path) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv_path", "{\"xprv\":\""+xprv+"\",\"path\":\""+path+"\"}")
            .thenApply(json -> json.findValue("xprv").asText());
    }

  /**
   *  Extracts the private key from the serialized extended private key
   *
   * @param xprv  Serialized extended private key
   */
    public CompletableFuture<String> hdkeySecretFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_secret_from_xprv", "{\"xprv\":\""+xprv+"\"}")
            .thenApply(json -> json.findValue("secret").asText());
    }

  /**
   *  Extracts the public key from the serialized extended private key
   *
   * @param xprv  Serialized extended private key
   */
    public CompletableFuture<String> hdkeyPublicFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_public_from_xprv", "{\"xprv\":\""+xprv+"\"}")
            .thenApply(json -> json.findValue("public").asText());
    }

}
