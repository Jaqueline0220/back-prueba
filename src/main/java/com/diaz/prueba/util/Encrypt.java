package com.diaz.prueba.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class Encrypt {
    private static String key = "qQwrABCOFIDEFG54669525PQRSTUVaServbcref85Secure2846otrpsWu01zvwzaAx";
  
  public static String harden(String unencryptedString) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
      /*
        Metodo que encripta un string formato MD5 - DES,ECB,5Padding.
        Utiliza una key para realizar la ecriptacion
        Retorna un String en base 16
        Jaqueline DB - 06/06/2022
       */
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
      byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

      for (int j = 0, k = 16; j < 8;) {
          keyBytes[k++] = keyBytes[j++];
      }
      SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
      Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);

      byte[] plainTextBytes = unencryptedString.getBytes("utf-8");
      byte[] buf = cipher.doFinal(plainTextBytes);
      byte[] base64Bytes = Base64.getEncoder().encode(buf);
      StringBuffer sb = new StringBuffer();
      for(int i = 0; i < base64Bytes.length; i++) {
	         String hexString = Integer.toHexString(base64Bytes[i]);
	         if(i>0) {
	        	 hexString = "00"+hexString;
	         }
	         if(i==base64Bytes.length -1) {
	        	 hexString = hexString+"00";
	         }
	         sb.append(hexString);
	    }
      String clave = sb.toString();
      return clave.toUpperCase();
  }

  public static String soften(String encryptedString) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
      /*
        Metodo que desencripta un string formato MD5 - DES,ECB,5Padding.
        Utiliza una key para realizar la desencriptacion
        Retorna la clave en untexto plano
        Jaqueline DB - 06/06/2022
       */
    if(encryptedString == null)
      {
          return "";
      }
      
      byte[] arreglo = null;
      String[] array = encryptedString.split("00");
      arreglo =new byte[array.length];
      for(int i = 0; i < array.length; i++) {
    	  String valor="";
    	  if(array[i].length()==1) {
    		  valor =array[i]+"0";
    	  }else {
    		  valor =array[i];
    	  }
    	  Integer byteInt = Integer.decode("0x"+valor);
    	  
    	  byte bayteInteger = byteInt.byteValue();
    	  arreglo[i] =bayteInteger;
	  }
      byte[] message = Base64.getDecoder().decode(arreglo);
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
      byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
      for (int j = 0, k = 16; j < 8;) {
          keyBytes[k++] = keyBytes[j++];
      }
      
      SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");

      Cipher decipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      decipher.init(Cipher.DECRYPT_MODE, secretKey);

      byte[] plainText = decipher.doFinal(message);

      return new String(plainText, "UTF-8");

  }
}
