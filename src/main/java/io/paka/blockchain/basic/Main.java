package io.paka.blockchain.basic;

import io.paka.blockchain.basic.block.Block;
import io.paka.blockchain.basic.block.impl.SimpleBlock;
import io.paka.blockchain.basic.hash.HashProvider;
import io.paka.blockchain.basic.hash.impl.Sha256HashProvider;
import io.paka.blockchain.basic.hash.impl.StabHashProvider;

public class Main {
    public static void main(String[] args) {

        HashProvider provider = new Sha256HashProvider();
        Block genesisBlock = new SimpleBlock("Hello, I'm first block in the chain", "Genesis", provider);
        Block secondBlock = new SimpleBlock("Hello, I'm second block in the chain", genesisBlock.hash(), provider);

        System.out.println(genesisBlock);
        System.out.println(secondBlock);
    }
}
