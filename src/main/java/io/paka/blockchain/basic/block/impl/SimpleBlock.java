package io.paka.blockchain.basic.block.impl;

import io.paka.blockchain.basic.block.Block;
import io.paka.blockchain.basic.hash.HashProvider;

import java.time.Instant;

public class SimpleBlock implements Block {
    private String hash;

    private final String previousHash;
    private final Object data;
    private final Instant timestamp;

    public SimpleBlock(Object data, String previousHash, HashProvider hashProvider) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = Instant.now();
        this.completeBlock(hashProvider);
    }

    @Override
    public String hash() {
        return this.hash;
    }

    private void completeBlock(HashProvider hashProvider) {
        hash = hashProvider.applyEncryption(
                previousHash
                        + data.getClass()
                        + timestamp.toString());
    }

    @Override
    public String toString() {
        return "SimpleBlock{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}
