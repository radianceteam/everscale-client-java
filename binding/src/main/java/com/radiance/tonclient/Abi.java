package com.radiance.tonclient;

import java.io.*;
import java.util.Scanner;

public abstract class Abi {
    public static class Serialized extends Abi {

        private String data;

        public Serialized(InputStream input) {
            Scanner s = new Scanner(input).useDelimiter("\\A");
            data = s.hasNext() ? s.next() : "";
            s.close();
        }

        @Override
        public String toString() {
            return "{\"type\": \"Serialized\", \"value\": " + data + "}";
        }
    }
}