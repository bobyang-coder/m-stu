package com.bob.stu.security;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA算法工具类
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/6/11
 */
public class RSAUtil {

    /**
     * 指定key的大小
     */
    private static int KEYSIZE = 1024;
    public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";

    /**
     * 生成密钥对
     * Java生成的公私钥格式为 pkcs8, 而openssl默认生成的公私钥格式为 pkcs1，两者的密钥实际上是不能直接互用的
     */
    public static Map<String, String> generateKeyPair() throws Exception {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEYSIZE, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /** 得到公钥 */
        Key publicKey = kp.getPublic();
        byte[] publicKeyBytes = publicKey.getEncoded();
        String pub = Base64Util.encode(publicKeyBytes);
        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        byte[] privateKeyBytes = privateKey.getEncoded();
        String pri = Base64Util.encode(privateKeyBytes);
        Map<String, String> map = new HashMap<String, String>();
        map.put("publicKey", pub);
        map.put("privateKey", pri);
        RSAPublicKey rsp = (RSAPublicKey) kp.getPublic();
        BigInteger bint = rsp.getModulus();
        String retValue = Base64Util.encode(bint.toByteArray());
        map.put("modulus", retValue);
        return map;
    }


    /**
     * 加密
     *
     * @param source    目标数据
     * @param publicKey 公钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String source, PublicKey publicKey)
            throws Exception {
        Key key = publicKey;
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(source.getBytes());
        return Base64Util.encode(b1);
    }

    /**
     * 解密
     *
     * @param cryptograph 密文
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String cryptograph, PrivateKey privateKey)
            throws Exception {
        Key key = privateKey;
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] b1 = Base64Util.decode(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }


    /**
     * 加载公钥
     *
     * @param publicKeyString
     * @return
     * @throws Exception
     */
    public static RSAPublicKey loadPublicKeyByString(String publicKeyString) throws Exception {
        byte[] buffer = Base64Util.decode(publicKeyString);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 加载私钥
     *
     * @param privateKeyString
     * @return
     * @throws Exception
     */
    public static RSAPrivateKey loadPrivateKeyByString(String privateKeyString) throws Exception {
        byte[] buffer = Base64Util.decode(privateKeyString);
        //	PKCS12EncodedKeySpec keySpec=new PKCs1
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        }
    }




}