package io.paka.blockchain.basic.chain;

import io.paka.blockchain.basic.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleBlockChain implements BlockChain{
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
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String toString() {
        return "SimpleBlockChain{" +
                "blocks=" + blocks +
                '}';
    }
}
