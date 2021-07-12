package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *  
 */
public class Utils {

    public static abstract class AddressStringFormat {

        public static final AccountId AccountId = new AccountId();

    /**
     *  
     */
    public static class AccountId extends AddressStringFormat  {

        public AccountId() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"AccountId\""+"}";
        }
    }

        public static final Hex Hex = new Hex();

    /**
     *  
     */
    public static class Hex extends AddressStringFormat  {

        public Hex() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"Hex\""+"}";
        }
    }

    /**
     *  
     */
    public static class Base64 extends AddressStringFormat  {

        public Base64(Boolean url, Boolean test, Boolean bounce) {

            this.url = url;

            this.test = test;

            this.bounce = bounce;

        }
        public Base64(Boolean url, Boolean test) {

            this.url = url;

            this.test = test;

        }
        public Base64(Boolean url) {

            this.url = url;

        }
        public Base64() {

        }


        @JsonProperty("url")
        private Boolean url;
        /**
         * 
         */
        public Boolean getUrl() {
            return url;
        }
        /**
         * 
         */
        public void setUrl(Boolean value) {
            this.url = value;
        }

        @JsonProperty("test")
        private Boolean test;
        /**
         * 
         */
        public Boolean getTest() {
            return test;
        }
        /**
         * 
         */
        public void setTest(Boolean value) {
            this.test = value;
        }

        @JsonProperty("bounce")
        private Boolean bounce;
        /**
         * 
         */
        public Boolean getBounce() {
            return bounce;
        }
        /**
         * 
         */
        public void setBounce(Boolean value) {
            this.bounce = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Base64\"",(url==null?null:("\"url\":"+url)),(test==null?null:("\"test\":"+test)),(bounce==null?null:("\"bounce\":"+bounce))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    private TONContext context;

    public Utils(TONContext context) {
        this.context = context;
    }

   /**
    * 
    *
    * @param address 
    * @param outputFormat 
    */
    public CompletableFuture<String> convertAddress(String address, AddressStringFormat outputFormat) {
        return context.requestJSON("utils.convert_address", "{"+Stream.of((address==null?null:("\"address\":\""+address+"\"")),(outputFormat==null?null:("\"output_format\":"+outputFormat))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("address"), String.class));
    }

   /**
    * Address types are the following<p>`0:919db8e740d50bf349df2eea03fa30c385d846b991ff5542e67098ee833fc7f7` - standart TON address mostcommonly used in all cases. Also called as hex addres`919db8e740d50bf349df2eea03fa30c385d846b991ff5542e67098ee833fc7f7` - account ID. A part of fulladdress. Identifies account inside particular workchain`EQCRnbjnQNUL80nfLuoD+jDDhdhGuZH/VULmcJjugz/H9wam` - base64 address. Also called "user-friendly".Was used at the beginning of TON. Now it is supported for compatibility
    *
    * @param address 
    */
    public CompletableFuture<Object> getAddressType(String address) {
        return context.requestJSON("utils.get_address_type", "{"+(address==null?"":("\"address\":\""+address+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("address_type"), Object.class));
    }

   /**
    * 
    *
    * @param account 
    * @param period 
    */
    public CompletableFuture<String> calcStorageFee(String account, Number period) {
        return context.requestJSON("utils.calc_storage_fee", "{"+Stream.of((account==null?null:("\"account\":\""+account+"\"")),(period==null?null:("\"period\":"+period))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("fee"), String.class));
    }

   /**
    * 
    *
    * @param uncompressed Must be encoded as base64.
    * @param level 
    * @return Must be encoded as base64.
    */
    public CompletableFuture<String> compressZstd(String uncompressed, Number level) {
        return context.requestJSON("utils.compress_zstd", "{"+Stream.of((uncompressed==null?null:("\"uncompressed\":\""+uncompressed+"\"")),(level==null?null:("\"level\":"+level))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("compressed"), String.class));
    }

   /**
    * 
    *
    * @param compressed Must be encoded as base64.
    * @return Must be encoded as base64.
    */
    public CompletableFuture<String> decompressZstd(String compressed) {
        return context.requestJSON("utils.decompress_zstd", "{"+(compressed==null?"":("\"compressed\":\""+compressed+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("decompressed"), String.class));
    }

}
