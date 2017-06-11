package com.bob.stu.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * Created by bob on 2017/6/11.
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/6/11
 */
public class AESUtil {
    public static final String CHAR_ENCODING = "UTF-8";
    public static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @param key  加密密码
     * @return
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        if (key.length != 16) {
            throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
        }
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec seckey = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, seckey);// 初始化
            byte[] result = cipher.doFinal(data);
            return result; // 加密
        } catch (Exception e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /**
     * 解密
     *
     * @param data 待解密内容
     * @param key  解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        if (key.length != 16) {
            throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
        }
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec seckey = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, seckey);// 初始化
            byte[] result = cipher.doFinal(data);
            return result; // 加密
        } catch (Exception e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

    public static String encryptToBase64(String data, String key) {
        try {
            byte[] valueByte = encrypt(data.getBytes(CHAR_ENCODING), key.getBytes(CHAR_ENCODING));
            return Base64Util.encode(valueByte);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encrypt fail!", e);
        }

    }


    public static String decryptFromBase64(String data, String key) {
        try {
            byte[] originalData = Base64Util.decode(data);
            byte[] valueByte = decrypt(originalData, key.getBytes(CHAR_ENCODING));
            return new String(valueByte, CHAR_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }
}
