package com.lab.Lab1.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtil {
    public String Encryption(String password) {
        String salt = "adasfasfasf:sakdbkvjsvisd";
        password = password + salt;
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.encodeBase64String(md.digest(password.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public boolean equalEncode(String password){
        return Encryption(password).equals("");
    }
}
