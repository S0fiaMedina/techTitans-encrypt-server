package com.security.encrypt.services;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class storingService implements  storingRepository{



    @Override
    public void storeKey(PublicKey key, String path) {
        try(FileOutputStream fos = new FileOutputStream(path)){
            // Escribe la llave en el archivo
            fos.write(key.getEncoded());
        } catch (Exception e ){
            System.out.println(e);

        }
    }

    @Override
    public PublicKey getKeyFromStorage(String path) {
        PublicKey pKey = null;
        try {
            // Obtiene la llave (en bytes)
            File keyFile = new File(path);
            byte[] keyBytes = Files.readAllBytes(keyFile.toPath());

            // Se rearma la llave publica a partir de su representacion binaria
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
            pKey = keyFactory.generatePublic(publicKeySpec);

        } catch (Exception e){
            System.out.println(e);
        }
        return pKey;
    }
}
