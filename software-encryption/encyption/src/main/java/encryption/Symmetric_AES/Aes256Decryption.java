package encryption.Symmetric_AES;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;

public class Aes256Decryption extends Aes256CBC {

    // 解密加密后的字符串, 128位加密的不能用256的Key来解密
    private static String base64CipherText = "+Bw3I8UrIOHZqJTezt6qgQ==";

    public static void main(String[] args) {
        Aes256Decryption aesDecryption = new Aes256Decryption();
        byte[] cipherTextBytes = aesDecryption.base64ToBytes(base64CipherText);
        SecretKey secretKey = aesDecryption.getSecretKey();
        byte[] ivBytes = aesDecryption.hexToBytes(USER_PASSWORD_IV);

        String originalText = aesDecryption.decrypt(cipherTextBytes, secretKey, ivBytes);
        System.out.println(originalText);
    }

    public String decrypt(byte[] cipherTextBytes, SecretKey secretKey, byte[] ivBytes) {
        try {
            Cipher aesCipher = Cipher.getInstance(ALGO_MODE_PADDING);
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));
            byte[] clearTextBytes = aesCipher.doFinal(cipherTextBytes);
            return new String(clearTextBytes, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
