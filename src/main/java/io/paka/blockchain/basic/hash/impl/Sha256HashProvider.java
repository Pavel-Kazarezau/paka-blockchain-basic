package io.paka.blockchain.basic.hash.impl;

import io.paka.blockchain.basic.hash.HashProvider;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class Sha256HashProvider implements HashProvider {
    public static final String ALGORITHM = "SHA-256";

    @Override
    public String applyEncryption(String input) {
        String hashOfBlock = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            final byte[] hash = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte el : hash) {
                Optional.of(Integer.toHexString(0xff & el))
                        .filter(hexEl -> hexEl.length() != 1)
                        .ifPresentOrElse(hexString::append,
                                () -> hexString.append('0'));
            }

            hashOfBlock = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error finding algorithm " + ALGORITHM + ";\n" + e);
        }
        return hashOfBlock;
    }
}
