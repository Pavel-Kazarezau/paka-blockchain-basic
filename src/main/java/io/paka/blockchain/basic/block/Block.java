package io.paka.blockchain.basic.block;

import io.paka.blockchain.basic.hash.HashProvider;

/**
 * This class represents basic functionality of block.
 * It uses HashProvider to create hash.
 * @see HashProvider#applyEncryption(String)
 */
public interface Block {

    /**
     * @return hash of block
     */
    String hash();
}
