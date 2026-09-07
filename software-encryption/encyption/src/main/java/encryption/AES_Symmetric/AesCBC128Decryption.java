package encryption.AES_Symmetric;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;

// 解密加密后的字符串, 128位加密的不能用256的Key来解密
public class AesCBC128Decryption extends AesCBC128 {

    // static String base64CipherText = "+ai7dQc5eHvziEgMsqr7mw=="; // 128 Password encrypted str
    // static String base64CipherText = "+Bw3I8UrIOHZqJTezt6qgQ=="; // 256 Password encrypted str

    // 128 License encrypted str
    static String base64CipherText = "K6hmiIgQ6R+erjapkK8CHjmULhwufAxWYERLlXZUcBwqMjV6rUOIjzKfsNoOCkxt";

    public static void main(String[] args) {
        AesCBC128Decryption aesDecryption = new AesCBC128Decryption();
        byte[] cipherTextBytes = aesDecryption.base64ToBytes(base64CipherText);
        SecretKey secretKey = aesDecryption.getSecretKey();
        byte[] ivBytes = aesDecryption.hexToBytes(USER_LICENSE_IV);

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
