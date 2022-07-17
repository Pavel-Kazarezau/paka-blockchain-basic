package io.paka.blockchain.basic.chain;

import com.google.gson.GsonBuilder;
import io.paka.blockchain.basic.block.Block;
import io.paka.blockchain.basic.hash.impl.Sha256HashProvider;

import java.util.ArrayList;
import java.util.List;

public class SimpleBlockChain implements BlockChain {
    public static boolean isInitialized = false;

    private final List<Block> blocks;

    {
        if (isInitialized) {
            throw new RuntimeException("Chain is already started");
        }
        this.blocks = new ArrayList<>();
        isInitialized = true;
    }

    @Override
    public void add(Block block) {
        this.blocks.add(block);
    }

    @Override
    public boolean isChainValid() {
        System.out.println("Block validation");
        for (int i = 1; i < blocks.size(); i++) {
            Block currentBlock = blocks.get(i);
            Block previousBlock = blocks.get(i - 1);

            if (!currentBlock.hash().equals(currentBlock.calculateHash(new Sha256HashProvider()))) {
                System.out.println("Block is not valid");
                return false;
            }

            if (!previousBlock.hash().equals(currentBlock.previousHash())) {
                System.out.println("Block is not valid");
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
