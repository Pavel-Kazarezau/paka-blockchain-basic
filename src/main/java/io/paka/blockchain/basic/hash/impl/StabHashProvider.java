package io.paka.blockchain.basic.hash.impl;

import io.paka.blockchain.basic.hash.HashProvider;

public class StabHashProvider implements HashProvider {
    @Override
    public String applyEncryption(String input) {
       return "SUCCESS ENCRYPTION";
    }
}
