package io.paka.blockchain.basic;

import io.paka.blockchain.basic.block.Block;
import io.paka.blockchain.basic.block.impl.SimpleBlock;
import io.paka.blockchain.basic.chain.BlockChain;
import io.paka.blockchain.basic.chain.SimpleBlockChain;
import io.paka.blockchain.basic.hash.HashProvider;
import io.paka.blockchain.basic.hash.impl.Sha256HashProvider;

public class Main {
    public static void main(String[] args) {

        HashProvider provider = new Sha256HashProvider();
        Block genesisBlock = new SimpleBlock("Hello, I'm first block in the chain", "Genesis", provider);
        Block secondBlock = new SimpleBlock("Hello, I'm second block in the chain", genesisBlock.hash(), provider);
        Block thirdBlock = new SimpleBlock("Hello, I'm third block in the chain", secondBlock.hash(), provider);
        Block fourthBlock = new SimpleBlock("Hello, I'm fourth block in the chain", thirdBlock.hash(), provider);

        System.out.println(genesisBlock);
        System.out.println(secondBlock);

        BlockChain chain = new SimpleBlockChain();
        chain.add(genesisBlock);
        chain.add(secondBlock);
        chain.add(thirdBlock);
        chain.add(fourthBlock);
        System.out.println(chain);


        if (chain.isChainValid()) {
            System.out.println("VALID!");
        } else {
            System.out.println("CHAIN INVALID");
        }
    }
}
