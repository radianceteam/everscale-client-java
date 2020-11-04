package com.radiance.tonclient;

public abstract class Signer {

    public static final None None = new None();

    public static class Keys extends Signer {
        private KeyPair keys;

        public Keys(KeyPair keys) {
            this.keys = keys;
        }

        @Override
        public String toString() {
            return "{\"type\":\"Keys\", \"keys\":" + keys + "}";
        }
    }

    public static class External extends Signer {
        String publicKey;

        public External(String publicKey) {
            this.publicKey = publicKey;
        }

        @Override
        public String toString() {
            return "{\"type\":\"External\", \"public_key\":\"" + publicKey + "\"}";
        }
    }

    public static class None extends Signer {
        None() {}

        @Override
        public String toString() {
            return "{\"type\":\"None\"}";
        }
    }
}
