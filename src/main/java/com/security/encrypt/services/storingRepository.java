package com.security.encrypt.services;

import java.security.Key;
import java.security.PublicKey;

public interface storingRepository {
    public void storeKey(PublicKey key, String path);

    public PublicKey getKeyFromStorage(String path);
}
