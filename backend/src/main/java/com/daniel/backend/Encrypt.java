package com.daniel.backend;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encrypt {
  public static String encrypt(String cpf) {
    String res = "";
    MessageDigest md;
    try {
      md = MessageDigest.getInstance("MD5");
      BigInteger hash = new BigInteger(1, md.digest(cpf.getBytes()));
      // Aqui convertemos a senha para Hexadecimal
      res = hash.toString(16);
    } catch (Exception e) {
    }

    return res;
  }

}
