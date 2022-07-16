package io.paka.blockchain.basic.hash;

public interface HashProvider {

    /**
     * @param input string hash representation of object
     * @return hash value of encrypted object
     * @author paka
     * @since 0.1
     */
    String applyEncryption(String input);
}
