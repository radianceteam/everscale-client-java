package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import ton.sdk.TONContext;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Provides information about library.
 */
public class Client {

    /**
     *  
     */
    public static class ResultOfBuildInfo  {
        public ResultOfBuildInfo() {
        }

        public ResultOfBuildInfo(Number buildNumber, Object[] dependencies) {

            this.buildNumber = buildNumber;

            this.dependencies = dependencies;

        }



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
            buildNumber = value;
        }

        @JsonProperty("dependencies")
        private Object[] dependencies;
        /**
         * Fingerprint of the most important dependencies.
         */
        public Object[] getDependencies() {
            return dependencies;
        }
        /**
         * Fingerprint of the most important dependencies.
         */
        public void setDependencies(Object[] value) {
            dependencies = value;
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
    * @return  Core Library version
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
