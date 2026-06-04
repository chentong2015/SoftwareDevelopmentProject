package encryption.Symmetric_AES;

import jakarta.xml.bind.DatatypeConverter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public abstract class Aes256CBC {

    static final int KEY_LENGTH = 256;
    static final String ALGORITHM = "AES";
    static final String ALGO_MODE_PADDING = "AES/CBC/PKCS5PADDING";

    // TODO. 加密和解密的Key密钥必须一致
    // 256 bits = 64 Hex 十六进制 = 32 bytes
    static final String USER_PASSWORD_SECRET_KEY = "11535AF31C94F18C7EAAC2E320637E8F11535AF31C94F18C7EAAC2E320637E8F";

    // IV length: must be 16 bytes long
    static final String USER_PASSWORD_IV = "CEEA74A4915C47FA619E50C7D2255464";

    // TODO. Secret Key密钥的长度决定AES加密的复杂度
    SecretKey getSecretKey() {
        byte[] secretKeyBytes = hexToBytes(USER_PASSWORD_SECRET_KEY);
        return new SecretKeySpec(secretKeyBytes, 0, KEY_LENGTH / 8, ALGORITHM);
    }

    // 十六进制解析成byte数组
    byte[] hexToBytes(String hexString) {
        return DatatypeConverter.parseHexBinary(hexString);
    }

    // base64编码结果转成byte数组
    byte[] base64ToBytes(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    // base64编码的字节数组转成字符串
    String base64BytesToString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
