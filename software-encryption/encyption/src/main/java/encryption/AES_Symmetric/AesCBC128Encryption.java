package encryption.AES_Symmetric;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;

public class AesCBC128Encryption extends AesCBC128 {

    // private static String origianlStr = "batch"; // Password string
    private static String origianlStr = "FMM4.12FIRCOSOFTFRANCEFMM1010NEVER111"; // License String

    public static void main(String[] args) {
        AesCBC128Encryption aesEncryption = new AesCBC128Encryption();
        byte[] ivBytes = aesEncryption.hexToBytes(USER_LICENSE_IV);
        SecretKey secretKey = aesEncryption.getSecretKey();

        byte[] cipherTextBytes = aesEncryption.encrypt(origianlStr, secretKey, ivBytes);
        String passwordEncrypted = aesEncryption.base64BytesToString(cipherTextBytes);
        System.out.println("Clear text: " + origianlStr);
        System.out.println("Encrypted text: " + passwordEncrypted);
    }

    public byte[] encrypt(String clearText, SecretKey secretKey, byte[] iv) {
        try {
            Cipher aesCipher = Cipher.getInstance(ALGO_MODE_PADDING);
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
            byte[] clearTextBytes = clearText.getBytes(StandardCharsets.UTF_8);
            return aesCipher.doFinal(clearTextBytes);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
