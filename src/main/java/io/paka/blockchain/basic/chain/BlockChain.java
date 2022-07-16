package io.paka.blockchain.basic.chain;

import io.paka.blockchain.basic.block.Block;

import java.util.List;

public interface BlockChain {

    void add(Block block);

    List<Block> getBlocks();
}
