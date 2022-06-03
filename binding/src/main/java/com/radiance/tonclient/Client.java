package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *  
 */
public class Client {

    /**
     *  
     */
    public static class ClientConfig  {

        public ClientConfig(NetworkConfig network, CryptoConfig crypto, AbiConfig abi, BocConfig boc, ProofsConfig proofs, String localStoragePath) {

            this.network = network;

            this.crypto = crypto;

            this.abi = abi;

            this.boc = boc;

            this.proofs = proofs;

            this.localStoragePath = localStoragePath;

        }
        public ClientConfig(NetworkConfig network, CryptoConfig crypto, AbiConfig abi, BocConfig boc, ProofsConfig proofs) {

            this.network = network;

            this.crypto = crypto;

            this.abi = abi;

            this.boc = boc;

            this.proofs = proofs;

        }
        public ClientConfig(NetworkConfig network, CryptoConfig crypto, AbiConfig abi, BocConfig boc) {

            this.network = network;

            this.crypto = crypto;

            this.abi = abi;

            this.boc = boc;

        }
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

        @JsonProperty("boc")
        private BocConfig boc;
        /**
         * 
         */
        public BocConfig getBoc() {
            return boc;
        }
        /**
         * 
         */
        public void setBoc(BocConfig value) {
            this.boc = value;
        }

        @JsonProperty("proofs")
        private ProofsConfig proofs;
        /**
         * 
         */
        public ProofsConfig getProofs() {
            return proofs;
        }
        /**
         * 
         */
        public void setProofs(ProofsConfig value) {
            this.proofs = value;
        }

        @JsonProperty("local_storage_path")
        private String localStoragePath;
        /**
         * 
         */
        public String getLocalStoragePath() {
            return localStoragePath;
        }
        /**
         * 
         */
        public void setLocalStoragePath(String value) {
            this.localStoragePath = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((network==null?null:("\"network\":"+network)),(crypto==null?null:("\"crypto\":"+crypto)),(abi==null?null:("\"abi\":"+abi)),(boc==null?null:("\"boc\":"+boc)),(proofs==null?null:("\"proofs\":"+proofs)),(localStoragePath==null?null:("\"local_storage_path\":\""+localStoragePath+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class NetworkConfig  {

        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount, Number latencyDetectionInterval, Number maxLatency, Number queryTimeout, NetworkQueriesProtocol queriesProtocol, Number firstRempStatusTimeout, Number nextRempStatusTimeout, String accessKey) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

            this.latencyDetectionInterval = latencyDetectionInterval;

            this.maxLatency = maxLatency;

            this.queryTimeout = queryTimeout;

            this.queriesProtocol = queriesProtocol;

            this.firstRempStatusTimeout = firstRempStatusTimeout;

            this.nextRempStatusTimeout = nextRempStatusTimeout;

            this.accessKey = accessKey;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount, Number latencyDetectionInterval, Number maxLatency, Number queryTimeout, NetworkQueriesProtocol queriesProtocol, Number firstRempStatusTimeout, Number nextRempStatusTimeout) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

            this.latencyDetectionInterval = latencyDetectionInterval;

            this.maxLatency = maxLatency;

            this.queryTimeout = queryTimeout;

            this.queriesProtocol = queriesProtocol;

            this.firstRempStatusTimeout = firstRempStatusTimeout;

            this.nextRempStatusTimeout = nextRempStatusTimeout;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount, Number latencyDetectionInterval, Number maxLatency, Number queryTimeout, NetworkQueriesProtocol queriesProtocol, Number firstRempStatusTimeout) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

            this.latencyDetectionInterval = latencyDetectionInterval;

            this.maxLatency = maxLatency;

            this.queryTimeout = queryTimeout;

            this.queriesProtocol = queriesProtocol;

            this.firstRempStatusTimeout = firstRempStatusTimeout;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount, Number latencyDetectionInterval, Number maxLatency, Number queryTimeout, NetworkQueriesProtocol queriesProtocol) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

            this.latencyDetectionInterval = latencyDetectionInterval;

            this.maxLatency = maxLatency;

            this.queryTimeout = queryTimeout;

            this.queriesProtocol = queriesProtocol;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount, Number latencyDetectionInterval, Number maxLatency, Number queryTimeout) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

            this.latencyDetectionInterval = latencyDetectionInterval;

            this.maxLatency = maxLatency;

            this.queryTimeout = queryTimeout;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount, Number latencyDetectionInterval, Number maxLatency) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

            this.latencyDetectionInterval = latencyDetectionInterval;

            this.maxLatency = maxLatency;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount, Number latencyDetectionInterval) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

            this.latencyDetectionInterval = latencyDetectionInterval;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold, Number sendingEndpointCount) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

            this.sendingEndpointCount = sendingEndpointCount;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout, Number outOfSyncThreshold) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

            this.outOfSyncThreshold = outOfSyncThreshold;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout, Number waitForTimeout) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

            this.waitForTimeout = waitForTimeout;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount, Number messageProcessingTimeout) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

            this.messageProcessingTimeout = messageProcessingTimeout;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout, Number messageRetriesCount) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

            this.messageRetriesCount = messageRetriesCount;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout, Number reconnectTimeout) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

            this.reconnectTimeout = reconnectTimeout;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount, Number maxReconnectTimeout) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

            this.maxReconnectTimeout = maxReconnectTimeout;

        }
        public NetworkConfig(String serverAddress, String[] endpoints, Number networkRetriesCount) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

            this.networkRetriesCount = networkRetriesCount;

        }
        public NetworkConfig(String serverAddress, String[] endpoints) {

            this.serverAddress = serverAddress;

            this.endpoints = endpoints;

        }
        public NetworkConfig(String serverAddress) {

            this.serverAddress = serverAddress;

        }
        public NetworkConfig() {

        }


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

        @JsonProperty("endpoints")
        private String[] endpoints;
        /**
         * Any correct URL format can be specified, including IP addresses. This parameter is prevailing over `server_address`.Check the full list of <a target="_blank" href="supported network endpoints">supported network endpoints</a>(../ton-os-api/networks.md).
         */
        public String[] getEndpoints() {
            return endpoints;
        }
        /**
         * Any correct URL format can be specified, including IP addresses. This parameter is prevailing over `server_address`.Check the full list of <a target="_blank" href="supported network endpoints">supported network endpoints</a>(../ton-os-api/networks.md).
         */
        public void setEndpoints(String[] value) {
            this.endpoints = value;
        }

        @JsonProperty("network_retries_count")
        private Number networkRetriesCount;
        /**
         * You must use `network.max_reconnect_timeout` that allows to specify maximum network resolving timeout.
         */
        public Number getNetworkRetriesCount() {
            return networkRetriesCount;
        }
        /**
         * You must use `network.max_reconnect_timeout` that allows to specify maximum network resolving timeout.
         */
        public void setNetworkRetriesCount(Number value) {
            this.networkRetriesCount = value;
        }

        @JsonProperty("max_reconnect_timeout")
        private Number maxReconnectTimeout;
        /**
         * Must be specified in milliseconds. Default is 120000 (2 min).
         */
        public Number getMaxReconnectTimeout() {
            return maxReconnectTimeout;
        }
        /**
         * Must be specified in milliseconds. Default is 120000 (2 min).
         */
        public void setMaxReconnectTimeout(Number value) {
            this.maxReconnectTimeout = value;
        }

        @JsonProperty("reconnect_timeout")
        private Number reconnectTimeout;
        /**
         * 
         */
        public Number getReconnectTimeout() {
            return reconnectTimeout;
        }
        /**
         * 
         */
        public void setReconnectTimeout(Number value) {
            this.reconnectTimeout = value;
        }

        @JsonProperty("message_retries_count")
        private Number messageRetriesCount;
        /**
         * Default is 5.
         */
        public Number getMessageRetriesCount() {
            return messageRetriesCount;
        }
        /**
         * Default is 5.
         */
        public void setMessageRetriesCount(Number value) {
            this.messageRetriesCount = value;
        }

        @JsonProperty("message_processing_timeout")
        private Number messageProcessingTimeout;
        /**
         * Must be specified in milliseconds. Default is 40000 (40 sec).
         */
        public Number getMessageProcessingTimeout() {
            return messageProcessingTimeout;
        }
        /**
         * Must be specified in milliseconds. Default is 40000 (40 sec).
         */
        public void setMessageProcessingTimeout(Number value) {
            this.messageProcessingTimeout = value;
        }

        @JsonProperty("wait_for_timeout")
        private Number waitForTimeout;
        /**
         * Must be specified in milliseconds. Default is 40000 (40 sec).
         */
        public Number getWaitForTimeout() {
            return waitForTimeout;
        }
        /**
         * Must be specified in milliseconds. Default is 40000 (40 sec).
         */
        public void setWaitForTimeout(Number value) {
            this.waitForTimeout = value;
        }

        @JsonProperty("out_of_sync_threshold")
        private Number outOfSyncThreshold;
        /**
         * If client's device time is out of sync and difference is more than the threshold then error will occur. Also an error will occur if the specified threshold is more than`message_processing_timeout/2`.<p>Must be specified in milliseconds. Default is 15000 (15 sec).
         */
        public Number getOutOfSyncThreshold() {
            return outOfSyncThreshold;
        }
        /**
         * If client's device time is out of sync and difference is more than the threshold then error will occur. Also an error will occur if the specified threshold is more than`message_processing_timeout/2`.<p>Must be specified in milliseconds. Default is 15000 (15 sec).
         */
        public void setOutOfSyncThreshold(Number value) {
            this.outOfSyncThreshold = value;
        }

        @JsonProperty("sending_endpoint_count")
        private Number sendingEndpointCount;
        /**
         * Default is 1.
         */
        public Number getSendingEndpointCount() {
            return sendingEndpointCount;
        }
        /**
         * Default is 1.
         */
        public void setSendingEndpointCount(Number value) {
            this.sendingEndpointCount = value;
        }

        @JsonProperty("latency_detection_interval")
        private Number latencyDetectionInterval;
        /**
         * Library periodically checks the current endpoint for blockchain data syncronization latency.If the latency (time-lag) is less then `NetworkConfig.max_latency`then library selects another endpoint.<p>Must be specified in milliseconds. Default is 60000 (1 min).
         */
        public Number getLatencyDetectionInterval() {
            return latencyDetectionInterval;
        }
        /**
         * Library periodically checks the current endpoint for blockchain data syncronization latency.If the latency (time-lag) is less then `NetworkConfig.max_latency`then library selects another endpoint.<p>Must be specified in milliseconds. Default is 60000 (1 min).
         */
        public void setLatencyDetectionInterval(Number value) {
            this.latencyDetectionInterval = value;
        }

        @JsonProperty("max_latency")
        private Number maxLatency;
        /**
         * Must be specified in milliseconds. Default is 60000 (1 min).
         */
        public Number getMaxLatency() {
            return maxLatency;
        }
        /**
         * Must be specified in milliseconds. Default is 60000 (1 min).
         */
        public void setMaxLatency(Number value) {
            this.maxLatency = value;
        }

        @JsonProperty("query_timeout")
        private Number queryTimeout;
        /**
         * Is is used when no timeout specified for the request to limit the answer waiting time. If no answer received during the timeout requests ends witherror.<p>Must be specified in milliseconds. Default is 60000 (1 min).
         */
        public Number getQueryTimeout() {
            return queryTimeout;
        }
        /**
         * Is is used when no timeout specified for the request to limit the answer waiting time. If no answer received during the timeout requests ends witherror.<p>Must be specified in milliseconds. Default is 60000 (1 min).
         */
        public void setQueryTimeout(Number value) {
            this.queryTimeout = value;
        }

        @JsonProperty("queries_protocol")
        private NetworkQueriesProtocol queriesProtocol;
        /**
         * `HTTP` or `WS`. Default is `HTTP`.
         */
        public NetworkQueriesProtocol getQueriesProtocol() {
            return queriesProtocol;
        }
        /**
         * `HTTP` or `WS`. Default is `HTTP`.
         */
        public void setQueriesProtocol(NetworkQueriesProtocol value) {
            this.queriesProtocol = value;
        }

        @JsonProperty("first_remp_status_timeout")
        private Number firstRempStatusTimeout;
        /**
         * First REMP status awaiting timeout. If no status recieved during the timeout than fallback transaction scenario is activated.<p>Must be specified in milliseconds. Default is 1000 (1 sec).
         */
        public Number getFirstRempStatusTimeout() {
            return firstRempStatusTimeout;
        }
        /**
         * First REMP status awaiting timeout. If no status recieved during the timeout than fallback transaction scenario is activated.<p>Must be specified in milliseconds. Default is 1000 (1 sec).
         */
        public void setFirstRempStatusTimeout(Number value) {
            this.firstRempStatusTimeout = value;
        }

        @JsonProperty("next_remp_status_timeout")
        private Number nextRempStatusTimeout;
        /**
         * Subsequent REMP status awaiting timeout. If no status recieved during the timeout than fallback transaction scenario is activated.<p>Must be specified in milliseconds. Default is 5000 (5 sec).
         */
        public Number getNextRempStatusTimeout() {
            return nextRempStatusTimeout;
        }
        /**
         * Subsequent REMP status awaiting timeout. If no status recieved during the timeout than fallback transaction scenario is activated.<p>Must be specified in milliseconds. Default is 5000 (5 sec).
         */
        public void setNextRempStatusTimeout(Number value) {
            this.nextRempStatusTimeout = value;
        }

        @JsonProperty("access_key")
        private String accessKey;
        /**
         * At the moment is not used in production.
         */
        public String getAccessKey() {
            return accessKey;
        }
        /**
         * At the moment is not used in production.
         */
        public void setAccessKey(String value) {
            this.accessKey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((serverAddress==null?null:("\"server_address\":\""+serverAddress+"\"")),(endpoints==null?null:("\"endpoints\":\""+Arrays.toString(endpoints)+"\"")),(networkRetriesCount==null?null:("\"network_retries_count\":"+networkRetriesCount)),(maxReconnectTimeout==null?null:("\"max_reconnect_timeout\":"+maxReconnectTimeout)),(reconnectTimeout==null?null:("\"reconnect_timeout\":"+reconnectTimeout)),(messageRetriesCount==null?null:("\"message_retries_count\":"+messageRetriesCount)),(messageProcessingTimeout==null?null:("\"message_processing_timeout\":"+messageProcessingTimeout)),(waitForTimeout==null?null:("\"wait_for_timeout\":"+waitForTimeout)),(outOfSyncThreshold==null?null:("\"out_of_sync_threshold\":"+outOfSyncThreshold)),(sendingEndpointCount==null?null:("\"sending_endpoint_count\":"+sendingEndpointCount)),(latencyDetectionInterval==null?null:("\"latency_detection_interval\":"+latencyDetectionInterval)),(maxLatency==null?null:("\"max_latency\":"+maxLatency)),(queryTimeout==null?null:("\"query_timeout\":"+queryTimeout)),(queriesProtocol==null?null:("\"queries_protocol\":"+queriesProtocol)),(firstRempStatusTimeout==null?null:("\"first_remp_status_timeout\":"+firstRempStatusTimeout)),(nextRempStatusTimeout==null?null:("\"next_remp_status_timeout\":"+nextRempStatusTimeout)),(accessKey==null?null:("\"access_key\":\""+accessKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public enum NetworkQueriesProtocol {
        
        /**
         * 
         */
        HTTP,

        /**
         * 
         */
        WS
    }
    /**
     *  
     */
    public static class CryptoConfig  {

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


        @Override
        public String toString() {
            return "{"+Stream.of((mnemonicDictionary==null?null:("\"mnemonic_dictionary\":"+mnemonicDictionary)),(mnemonicWordCount==null?null:("\"mnemonic_word_count\":"+mnemonicWordCount)),(hdkeyDerivationPath==null?null:("\"hdkey_derivation_path\":\""+hdkeyDerivationPath+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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
    public static class BocConfig  {

        public BocConfig(Number cacheMaxSize) {

            this.cacheMaxSize = cacheMaxSize;

        }
        public BocConfig() {

        }


        @JsonProperty("cache_max_size")
        private Number cacheMaxSize;
        /**
         * Default is 10 MB
         */
        public Number getCacheMaxSize() {
            return cacheMaxSize;
        }
        /**
         * Default is 10 MB
         */
        public void setCacheMaxSize(Number value) {
            this.cacheMaxSize = value;
        }


        @Override
        public String toString() {
            return "{"+(cacheMaxSize==null?"":("\"cache_max_size\":"+cacheMaxSize))+"}";
        }
    }
    /**
     *  
     */
    public static class ProofsConfig  {

        public ProofsConfig(Boolean cacheInLocalStorage) {

            this.cacheInLocalStorage = cacheInLocalStorage;

        }
        public ProofsConfig() {

        }


        @JsonProperty("cache_in_local_storage")
        private Boolean cacheInLocalStorage;
        /**
         * Default is `true`. If this value is set to `true`, downloaded proofs and master-chain BOCs are saved into thepersistent local storage (e.g. file system for native environments or browser's IndexedDBfor the web); otherwise all the data is cached only in memory in current client's contextand will be lost after destruction of the client.
         */
        public Boolean getCacheInLocalStorage() {
            return cacheInLocalStorage;
        }
        /**
         * Default is `true`. If this value is set to `true`, downloaded proofs and master-chain BOCs are saved into thepersistent local storage (e.g. file system for native environments or browser's IndexedDBfor the web); otherwise all the data is cached only in memory in current client's contextand will be lost after destruction of the client.
         */
        public void setCacheInLocalStorage(Boolean value) {
            this.cacheInLocalStorage = value;
        }


        @Override
        public String toString() {
            return "{"+(cacheInLocalStorage==null?"":("\"cache_in_local_storage\":"+cacheInLocalStorage))+"}";
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


        @JsonProperty("name")
        private String name;
        /**
         * Usually it is a crate name.
         */
        public String getName() {
            return name;
        }
        /**
         * Usually it is a crate name.
         */
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("git_commit")
        private String gitCommit;
        /**
         * 
         */
        public String getGitCommit() {
            return gitCommit;
        }
        /**
         * 
         */
        public void setGitCommit(String value) {
            this.gitCommit = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((name==null?null:("\"name\":\""+name+"\"")),(gitCommit==null?null:("\"git_commit\":\""+gitCommit+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    public static abstract class AppRequestResult {

    /**
     *  
     */
    public static class Error extends AppRequestResult  {

        public Error(String text) {

            this.text = text;

        }
        public Error() {

        }


        @JsonProperty("text")
        private String text;
        /**
         * 
         */
        public String getText() {
            return text;
        }
        /**
         * 
         */
        public void setText(String value) {
            this.text = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Error\"",(text==null?null:("\"text\":\""+text+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Ok extends AppRequestResult  {

        public Ok(Object result) {

            this.result = result;

        }
        public Ok() {

        }


        @JsonProperty("result")
        private Object result;
        /**
         * 
         */
        public Object getResult() {
            return result;
        }
        /**
         * 
         */
        public void setResult(Object value) {
            this.result = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Ok\"",(result==null?null:("\"result\":"+result))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
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


        @JsonProperty("build_number")
        private Number buildNumber;
        /**
         * 
         */
        public Number getBuildNumber() {
            return buildNumber;
        }
        /**
         * 
         */
        public void setBuildNumber(Number value) {
            this.buildNumber = value;
        }

        @JsonProperty("dependencies")
        private BuildInfoDependency[] dependencies;
        /**
         * 
         */
        public BuildInfoDependency[] getDependencies() {
            return dependencies;
        }
        /**
         * 
         */
        public void setDependencies(BuildInfoDependency[] value) {
            this.dependencies = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((buildNumber==null?null:("\"build_number\":"+buildNumber)),(dependencies==null?null:("\"dependencies\":"+Arrays.toString(dependencies)))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    private TONContext context;

    public Client(TONContext context) {
        this.context = context;
    }

   /**
    * 
    *
    */
    public CompletableFuture<Object> getApiReference() {
        return context.requestJSON("client.get_api_reference", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("api"), Object.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<String> version() {
        return context.requestJSON("client.version", "{}")
            .thenApply(json -> TONContext.convertValue(json.findValue("version"), String.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<ClientConfig> config() {
        return context.requestJSON("client.config", "{}")
            .thenApply(json -> TONContext.convertValue(json, ClientConfig.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<ResultOfBuildInfo> buildInfo() {
        return context.requestJSON("client.build_info", "{}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfBuildInfo.class));
    }

   /**
    * 
    *
    * @param appRequestId 
    * @param result 
    */
    public CompletableFuture<Void> resolveAppRequest(Number appRequestId, AppRequestResult result) {
        return context.requestJSON("client.resolve_app_request", "{"+Stream.of((appRequestId==null?null:("\"app_request_id\":"+appRequestId)),(result==null?null:("\"result\":"+result))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

}
