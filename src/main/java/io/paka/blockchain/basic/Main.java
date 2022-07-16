package io.paka.blockchain.basic;

import io.paka.blockchain.basic.block.Block;
import io.paka.blockchain.basic.block.impl.SimpleBlock;
import io.paka.blockchain.basic.hash.HashProvider;
import io.paka.blockchain.basic.hash.impl.StabHashProvider;

public class Main {
    public static void main(String[] args) {

        HashProvider provider = new StabHashProvider();
        Block block = new SimpleBlock("Hello, I'm first block in the chain", null, provider);

        System.out.println(block);
    }
}
