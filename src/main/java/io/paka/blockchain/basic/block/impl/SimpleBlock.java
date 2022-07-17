package io.paka.blockchain.basic.block.impl;

import com.google.gson.GsonBuilder;
import io.paka.blockchain.basic.block.Block;
import io.paka.blockchain.basic.hash.HashProvider;

import java.time.Instant;

public class SimpleBlock implements Block {
    private final String hash;
    private final String previousHash;
    private final Object data;
    private final Instant timestamp;

    public SimpleBlock(Object data, String previousHash, HashProvider hashProvider) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = Instant.now();
        this.hash = calculateHash(hashProvider);
    }

    @Override
    public String hash() {
        return this.hash;
    }

    @Override
    public String previousHash() {
        return this.previousHash;
    }

    @Override
    public String calculateHash(HashProvider hashProvider) {
        return hashProvider.applyEncryption(
                previousHash
                        + data.toString()
                        + timestamp.toString());
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
