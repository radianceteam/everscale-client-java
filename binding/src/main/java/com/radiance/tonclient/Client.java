package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Provides information about library.
 */
public class Client {

    /**
     *  
     */
    public static class ClientConfig  {

        public ClientConfig(NetworkConfig network, CryptoConfig crypto, AbiConfig abi) {

            this.network = network;

            this.crypto = crypto;

            this.abi = abi;

        }
        public ClientConfig(NetworkConfig network, CryptoConfig crypto) {

            this.network = network;

            this.crypto = crypto;

        }
        public ClientConfig(NetworkConfig network) {

            this.network = network;

        }
        public ClientConfig() {

        }
/*        public ClientConfig() {
        }

        public ClientConfig(NetworkConfig network, CryptoConfig crypto, AbiConfig abi) {

            this.network = network;

            this.crypto = crypto;

            this.abi = abi;

        }
*/


        @JsonProperty("network")
        private NetworkConfig network;
        /**
         * 
         */
        public NetworkConfig getNetwork() {
            return network;
        }
        /**
         * 
         */
        public void setNetwork(NetworkConfig value) {
            this.network = value;
        }

        @JsonProperty("crypto")
        private CryptoConfig crypto;
        /**
         * 
         */
        public CryptoConfig getCrypto() {
            return crypto;
        }
        /**
         * 
         */
        public void setCrypto(CryptoConfig value) {
            this.crypto = value;
        }

        @JsonProperty("abi")
        private AbiConfig abi;
        /**
         * 
         */
        public AbiConfig getAbi() {
            return abi;
        }
        /**
         * 
         */
        public void setAbi(AbiConfig value) {
            this.abi = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((network==null?null:("\"network\":"+network)),(crypto==null?null:("\"crypto\":"+crypto)),(abi==null?null:("\"abi\":"+abi))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class NetworkConfig  {

        public NetworkConfig(String serverAddress, Number networkRetriesCount, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, String accessKey) {

            this.serverAddress = serverAddress;

            this.networkRetriesCount = networkRetriesCount;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.accessKey = accessKey;

        }
        public NetworkConfig(String serverAddress, Number networkRetriesCount, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold) {

            this.serverAddress = serverAddress;

            this.networkRetriesCount = networkRetriesCount;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

        }
        public NetworkConfig(String serverAddress, Number networkRetriesCount, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout) {

            this.serverAddress = serverAddress;

            this.networkRetriesCount = networkRetriesCount;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

        }
        public NetworkConfig(String serverAddress, Number networkRetriesCount, Number messageRetriesCount, Number messageProcessingTimeout) {

            this.serverAddress = serverAddress;

            this.networkRetriesCount = networkRetriesCount;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

        }
        public NetworkConfig(String serverAddress, Number networkRetriesCount, Number messageRetriesCount) {

            this.serverAddress = serverAddress;

            this.networkRetriesCount = networkRetriesCount;

            this.messageRetriesCount = messageRetriesCount;

        }
        public NetworkConfig(String serverAddress, Number networkRetriesCount) {

            this.serverAddress = serverAddress;

            this.networkRetriesCount = networkRetriesCount;

        }
        public NetworkConfig(String serverAddress) {

            this.serverAddress = serverAddress;

        }
        public NetworkConfig() {

        }
/*        public NetworkConfig() {
        }

        public NetworkConfig(String serverAddress, Number networkRetriesCount, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, String accessKey) {

            this.serverAddress = serverAddress;

            this.networkRetriesCount = networkRetriesCount;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.accessKey = accessKey;

        }
*/


        @JsonProperty("server_address")
        private String serverAddress;
        /**
         * 
         */
        public String getServerAddress() {
            return serverAddress;
        }
        /**
         * 
         */
        public void setServerAddress(String value) {
            this.serverAddress = value;
        }

        @JsonProperty("network_retries_count")
        private Number networkRetriesCount;
        /**
         * 
         */
        public Number getNetworkRetriesCount() {
            return networkRetriesCount;
        }
        /**
         * 
         */
        public void setNetworkRetriesCount(Number value) {
            this.networkRetriesCount = value;
        }

        @JsonProperty("message_retries_count")
        private Number messageRetriesCount;
        /**
         * 
         */
        public Number getMessageRetriesCount() {
            return messageRetriesCount;
        }
        /**
         * 
         */
        public void setMessageRetriesCount(Number value) {
            this.messageRetriesCount = value;
        }

        @JsonProperty("message_processing_timeout")
        private Number messageProcessingTimeout;
        /**
         * 
         */
        public Number getMessageProcessingTimeout() {
            return messageProcessingTimeout;
        }
        /**
         * 
         */
        public void setMessageProcessingTimeout(Number value) {
            this.messageProcessingTimeout = value;
        }

        @JsonProperty("wait_for_timeout")
        private Number waitForTimeout;
        /**
         * 
         */
        public Number getWaitForTimeout() {
            return waitForTimeout;
        }
        /**
         * 
         */
        public void setWaitForTimeout(Number value) {
            this.waitForTimeout = value;
        }

        @JsonProperty("out_of_sync_threshold")
        private Number outOfSyncThreshold;
        /**
         * 
         */
        public Number getOutOfSyncThreshold() {
            return outOfSyncThreshold;
        }
        /**
         * 
         */
        public void setOutOfSyncThreshold(Number value) {
            this.outOfSyncThreshold = value;
        }

        @JsonProperty("access_key")
        private String accessKey;
        /**
         * 
         */
        public String getAccessKey() {
            return accessKey;
        }
        /**
         * 
         */
        public void setAccessKey(String value) {
            this.accessKey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((serverAddress==null?null:("\"server_address\":\""+serverAddress+"\"")),(networkRetriesCount==null?null:("\"network_retries_count\":"+networkRetriesCount)),(messageRetriesCount==null?null:("\"message_retries_count\":"+messageRetriesCount)),(messageProcessingTimeout==null?null:("\"message_processing_timeout\":"+messageProcessingTimeout)),(waitForTimeout==null?null:("\"wait_for_timeout\":"+waitForTimeout)),(outOfSyncThreshold==null?null:("\"out_of_sync_threshold\":"+outOfSyncThreshold)),(accessKey==null?null:("\"access_key\":\""+accessKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class CryptoConfig  {

        public CryptoConfig(Number mnemonicDictionary, Number mnemonicWordCount, String hdkeyDerivationPath, Boolean hdkeyCompliant) {

            this.mnemonicDictionary = mnemonicDictionary;

            this.mnemonicWordCount = mnemonicWordCount;

            this.hdkeyDerivationPath = hdkeyDerivationPath;

            this.hdkeyCompliant = hdkeyCompliant;

        }
        public CryptoConfig(Number mnemonicDictionary, Number mnemonicWordCount, String hdkeyDerivationPath) {

            this.mnemonicDictionary = mnemonicDictionary;

            this.mnemonicWordCount = mnemonicWordCount;

            this.hdkeyDerivationPath = hdkeyDerivationPath;

        }
        public CryptoConfig(Number mnemonicDictionary, Number mnemonicWordCount) {

            this.mnemonicDictionary = mnemonicDictionary;

            this.mnemonicWordCount = mnemonicWordCount;

        }
        public CryptoConfig(Number mnemonicDictionary) {

            this.mnemonicDictionary = mnemonicDictionary;

        }
        public CryptoConfig() {

        }
/*        public CryptoConfig() {
        }

        public CryptoConfig(Number mnemonicDictionary, Number mnemonicWordCount, String hdkeyDerivationPath, Boolean hdkeyCompliant) {

            this.mnemonicDictionary = mnemonicDictionary;

            this.mnemonicWordCount = mnemonicWordCount;

            this.hdkeyDerivationPath = hdkeyDerivationPath;

            this.hdkeyCompliant = hdkeyCompliant;

        }
*/


        @JsonProperty("mnemonic_dictionary")
        private Number mnemonicDictionary;
        /**
         * 
         */
        public Number getMnemonicDictionary() {
            return mnemonicDictionary;
        }
        /**
         * 
         */
        public void setMnemonicDictionary(Number value) {
            this.mnemonicDictionary = value;
        }

        @JsonProperty("mnemonic_word_count")
        private Number mnemonicWordCount;
        /**
         * 
         */
        public Number getMnemonicWordCount() {
            return mnemonicWordCount;
        }
        /**
         * 
         */
        public void setMnemonicWordCount(Number value) {
            this.mnemonicWordCount = value;
        }

        @JsonProperty("hdkey_derivation_path")
        private String hdkeyDerivationPath;
        /**
         * 
         */
        public String getHdkeyDerivationPath() {
            return hdkeyDerivationPath;
        }
        /**
         * 
         */
        public void setHdkeyDerivationPath(String value) {
            this.hdkeyDerivationPath = value;
        }

        @JsonProperty("hdkey_compliant")
        private Boolean hdkeyCompliant;
        /**
         * 
         */
        public Boolean getHdkeyCompliant() {
            return hdkeyCompliant;
        }
        /**
         * 
         */
        public void setHdkeyCompliant(Boolean value) {
            this.hdkeyCompliant = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((mnemonicDictionary==null?null:("\"mnemonic_dictionary\":"+mnemonicDictionary)),(mnemonicWordCount==null?null:("\"mnemonic_word_count\":"+mnemonicWordCount)),(hdkeyDerivationPath==null?null:("\"hdkey_derivation_path\":\""+hdkeyDerivationPath+"\"")),(hdkeyCompliant==null?null:("\"hdkey_compliant\":"+hdkeyCompliant))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class AbiConfig  {

        public AbiConfig(Number workchain, Number messageExpirationTimeout, Number messageExpirationTimeoutGrowFactor) {

            this.workchain = workchain;

            this.messageExpirationTimeout = messageExpirationTimeout;

            this.messageExpirationTimeoutGrowFactor = messageExpirationTimeoutGrowFactor;

        }
        public AbiConfig(Number workchain, Number messageExpirationTimeout) {

            this.workchain = workchain;

            this.messageExpirationTimeout = messageExpirationTimeout;

        }
        public AbiConfig(Number workchain) {

            this.workchain = workchain;

        }
        public AbiConfig() {

        }
/*        public AbiConfig() {
        }

        public AbiConfig(Number workchain, Number messageExpirationTimeout, Number messageExpirationTimeoutGrowFactor) {

            this.workchain = workchain;

            this.messageExpirationTimeout = messageExpirationTimeout;

            this.messageExpirationTimeoutGrowFactor = messageExpirationTimeoutGrowFactor;

        }
*/


        @JsonProperty("workchain")
        private Number workchain;
        /**
         * 
         */
        public Number getWorkchain() {
            return workchain;
        }
        /**
         * 
         */
        public void setWorkchain(Number value) {
            this.workchain = value;
        }

        @JsonProperty("message_expiration_timeout")
        private Number messageExpirationTimeout;
        /**
         * 
         */
        public Number getMessageExpirationTimeout() {
            return messageExpirationTimeout;
        }
        /**
         * 
         */
        public void setMessageExpirationTimeout(Number value) {
            this.messageExpirationTimeout = value;
        }

        @JsonProperty("message_expiration_timeout_grow_factor")
        private Number messageExpirationTimeoutGrowFactor;
        /**
         * 
         */
        public Number getMessageExpirationTimeoutGrowFactor() {
            return messageExpirationTimeoutGrowFactor;
        }
        /**
         * 
         */
        public void setMessageExpirationTimeoutGrowFactor(Number value) {
            this.messageExpirationTimeoutGrowFactor = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((workchain==null?null:("\"workchain\":"+workchain)),(messageExpirationTimeout==null?null:("\"message_expiration_timeout\":"+messageExpirationTimeout)),(messageExpirationTimeoutGrowFactor==null?null:("\"message_expiration_timeout_grow_factor\":"+messageExpirationTimeoutGrowFactor))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class BuildInfoDependency  {

        public BuildInfoDependency(String name, String gitCommit) {

            this.name = name;

            this.gitCommit = gitCommit;

        }
        public BuildInfoDependency(String name) {

            this.name = name;

        }
        public BuildInfoDependency() {

        }
/*        public BuildInfoDependency() {
        }

        public BuildInfoDependency(String name, String gitCommit) {

            this.name = name;

            this.gitCommit = gitCommit;

        }
*/


        @JsonProperty("name")
        private String name;
        /**
         * Dependency name. Usually it is a crate name.
         */
        public String getName() {
            return name;
        }
        /**
         * Dependency name. Usually it is a crate name.
         */
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("git_commit")
        private String gitCommit;
        /**
         * Git commit hash of the related repository.
         */
        public String getGitCommit() {
            return gitCommit;
        }
        /**
         * Git commit hash of the related repository.
         */
        public void setGitCommit(String value) {
            this.gitCommit = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((name==null?null:("\"name\":\""+name+"\"")),(gitCommit==null?null:("\"git_commit\":\""+gitCommit+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfBuildInfo  {

        public ResultOfBuildInfo(Number buildNumber, BuildInfoDependency[] dependencies) {

            this.buildNumber = buildNumber;

            this.dependencies = dependencies;

        }
        public ResultOfBuildInfo(Number buildNumber) {

            this.buildNumber = buildNumber;

        }
        public ResultOfBuildInfo() {

        }
/*        public ResultOfBuildInfo() {
        }

        public ResultOfBuildInfo(Number buildNumber, BuildInfoDependency[] dependencies) {

            this.buildNumber = buildNumber;

            this.dependencies = dependencies;

        }
*/


        @JsonProperty("build_number")
        private Number buildNumber;
        /**
         * Build number assigned to this build by the CI.
         */
        public Number getBuildNumber() {
            return buildNumber;
        }
        /**
         * Build number assigned to this build by the CI.
         */
        public void setBuildNumber(Number value) {
            this.buildNumber = value;
        }

        @JsonProperty("dependencies")
        private BuildInfoDependency[] dependencies;
        /**
         * Fingerprint of the most important dependencies.
         */
        public BuildInfoDependency[] getDependencies() {
            return dependencies;
        }
        /**
         * Fingerprint of the most important dependencies.
         */
        public void setDependencies(BuildInfoDependency[] value) {
            this.dependencies = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((buildNumber==null?null:("\"build_number\":"+buildNumber)),(dependencies==null?null:("\"dependencies\":"+dependencies))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Client(TONContext context) {
        this.context = context;
    }

   /**
    * Returns Core Library API reference
    *
    */
    public CompletableFuture<Object> getApiReference() {
        return context.requestJSON("client.get_api_reference", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("api"), Object.class));
    }

   /**
    * Returns Core Library version
    *
    * @return Core Library version
    */
    public CompletableFuture<String> version() {
        return context.requestJSON("client.version", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("version"), String.class));
    }

   /**
    * Returns detailed information about this build.
    *
    */
    public CompletableFuture<ResultOfBuildInfo> buildInfo() {
        return context.requestJSON("client.build_info", "{}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfBuildInfo.class));
    }

}
