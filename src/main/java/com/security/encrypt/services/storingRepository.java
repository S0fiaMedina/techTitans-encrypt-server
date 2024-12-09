package com.security.encrypt.services;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Key;
import java.security.PublicKey;

@Repository
public interface storingRepository {
    public void storeKey(PublicKey key, String path);

    public PublicKey getKeyFromStorage(String path);
}
