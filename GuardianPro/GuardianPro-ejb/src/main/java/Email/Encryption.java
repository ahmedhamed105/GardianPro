/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ahmed.elemam
 */
public class Encryption {
    
      private static byte[] key = {
    0x2d, 0x2a, 0x2d, 0x42, 0x55, 0x49, 0x4c, 0x44, 0x41, 0x43, 0x4f, 0x44, 0x45, 0x2d, 0x2a, 0x2d
};
     
     public static String encrypt(String plainText) {
    try {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherText = cipher.doFinal(plainText.toString().trim().getBytes("UTF8"));
        String encryptedString = new String(Base64.getEncoder().encode(cipherText),"UTF-8");
        return encryptedString;
    } catch (Exception e) {
        e.printStackTrace();
        /*start mohammed.ayad*/
      //  Messages.addInfoMessage(e.getMessage(), 3, 3);
        /*end mohammed.ayad*/
    }
    return null;
}
     
     
     public static String decrypt(String encryptedText) {
    try {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] cipherText = Base64.getDecoder().decode(encryptedText.toString().trim().getBytes("UTF8"));
        String decryptedString = new String(cipher.doFinal(cipherText),"UTF-8");
        return decryptedString;
    } catch (Exception e) {
        e.printStackTrace();
        /*start mohammed.ayad*/
      //  Messages.addInfoMessage(e.getMessage(), 3, 3);
        /*end mohammed.ayad*/
    }
    return null;
}
     

    
}


