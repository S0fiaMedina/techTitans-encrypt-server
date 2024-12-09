package com.security.encrypt.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Base64;
import java.util.concurrent.ExecutionException;

@Service
public class encryptService{

    @Autowired
    storingRepository storeService;
    PrivateKey privateKey;
    PublicKey publicKey;

    @PostConstruct
    public void getNewKeys(){
        try {
            this.generateKeys();
        }
        catch (NoSuchAlgorithmException e){
            System.out.println("ERROR");
        }
    }

    private void generateKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair =  generator.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }


    public String getPublicKey(){
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }


}
