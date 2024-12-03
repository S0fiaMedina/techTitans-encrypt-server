package com.security.encrypt.services;

import org.springframework.stereotype.Repository;

@Repository
public interface encryptRepository {

     /** Metodo para generar una llave publica RSA */
    public  String getPublicRSAKey();

    /**Metodo para encriptar  mensajes*/
    public String encryptMessage();

    /**metodo para verificar una llave RSA*/
    public boolean verifyRSAKey();


}
