package com.security.encrypt.controllers;

import com.security.encrypt.services.encryptRepository;
import com.security.encrypt.services.encryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encrypt-server")
public class ApplicationController {

    @Autowired
    private encryptRepository service  ;

    @GetMapping("/get-public-key")
    public  String generateANewPublicKey(){
        return this.service.getPublicRSAKey();
    }

    @PostMapping("/send-message")
    public  void generateANewPublicKey(@RequestBody String messageToEncrypt){

    }
}
