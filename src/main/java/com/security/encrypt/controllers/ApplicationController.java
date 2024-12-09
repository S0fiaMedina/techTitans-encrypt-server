package com.security.encrypt.controllers;

import com.security.encrypt.services.encryptRepository;
import com.security.encrypt.services.encryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.security.PublicKey;

@RestController
@RequestMapping("/encrypt-server")
public class ApplicationController {



    @Autowired
    private encryptService eService;

    @GetMapping("/getKeys")
    public String generateANewPublicKey(){
        return this.eService.getPublicKey();
    }

    @PostMapping("/send-message")
    public  void generateANewPublicKey(@RequestBody String messageToEncrypt){

    }
}
