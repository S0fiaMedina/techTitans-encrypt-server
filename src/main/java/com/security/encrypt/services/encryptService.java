package com.security.encrypt.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class encryptService implements  encryptRepository{

    @Autowired
    storingRepository storeService;
    PrivateKey privateKey;
    PublicKey publicKey;

    @Override
    public String getPublicRSAKey() {
        try {
            // generación de las llaves
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();

            // obtención de las llaves
            this.privateKey = pair.getPrivate();
            this.publicKey = pair.getPublic();

            // guardado de las llaves
            this.storeService.storeKey(publicKey, "../keys/public.key");

            return "";
        } catch (Exception e){
            System.out.println("Error");
        }

    }

    @Override
    public String encryptMessage(String secretMessage) {
        String encodedMessage = "";
        try {
            // Se configura el encriptador con la llave publica
            Cipher cipherEncrypt = Cipher.getInstance("RSA");
            cipherEncrypt.init(Cipher.ENCRYPT_MODE, this.publicKey);

            // se pone en bytes para encriptar
            byte[] seccretMessageInBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageInBytes = cipherEncrypt.doFinal(seccretMessageInBytes);

            // Se pone en base 64, asi se trabaja más facil
            encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageInBytes);
        } catch (Exception e ){

        }
        return encodedMessage;
    }

    public String decryptMessage(String ecodedMessage){
        String decryptedMessage = "";
        try {
            byte[] encodedMessageInBytes = ecodedMessage.getBytes();

            // configurar el descrifrador
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, this.privateKey);

            // descifrar e mensaje
            byte[] decryptedMessageInBytes = decryptCipher.doFinal(encodedMessageInBytes);
            decryptedMessage = new String(decryptedMessageInBytes, StandardCharsets.UTF_8);

        } catch (Exception e){

        }
        return decryptedMessage;
    }

    @Override
    public boolean verifyRSAKey() {
        return false;
    }
}
