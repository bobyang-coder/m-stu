package com.bob.stu.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * 加解密工具类
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/6/11
 */
public class EncryptAndDecrytUtil {

    private static Random random = new Random();


    /**
     * 获取随机数
     *
     * @param length
     * @return
     */
    private static String getRandom(int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isChar = (random.nextInt(2) % 2 == 0);
            if (isChar) {
                int choice = (random.nextInt(2) % 2 == 0) ? 65 : 97;
                ret.append((char) (choice + random.nextInt(26)));
            } else {
                ret.append(Integer.toString(random.nextInt(10)));
            }
        }
        return ret.toString();
    }

    /**
     * 参数加密
     *
     * @return
     */
    public static Map<String, String> addkey(String json, String publicKeyString) throws Exception {
        System.out.println("数据=============>" + json);
        RSAPublicKey publicKey = RSAUtil.loadPublicKeyByString(publicKeyString);//获取公钥
        //随机生成16数字
        String key = getRandom(16);
        System.out.println("key=============>" + key);
        //对随机数进行加密
        String encryptkey = RSAUtil.encrypt(key, publicKey);
        String encryData = AESUtil.encryptToBase64(json, key);

        System.out.println("密文key============>" + encryptkey);
        System.out.println("密文数据===========>" + encryData);

        Map<String, String> map = new HashMap<String, String>();
        map.put("data", encryData);
        map.put("encryptkey", encryptkey);

        return map;
    }


    /**
     * 解密
     *
     * @param post
     * @return
     * @throws Exception
     */
    public static String pubkey(String post, String privateKeyString) throws Exception {
        System.out.println("密文================>" + post);
        // 将返回的json串转换为map
        TreeMap<String, String> map = JSON.parseObject(post, new TypeReference<TreeMap<String, String>>() {
        });
        String encryptkey = map.get("encryptkey");
        String data = map.get("data");
        System.out.println("输出data  = =" + data);
        RSAPrivateKey privateKey = RSAUtil.loadPrivateKeyByString(privateKeyString);//获取自己私钥解密
        String decryptData = RSAUtil.decrypt(encryptkey, privateKey);
        post = AESUtil.decryptFromBase64(data, decryptData);
        System.out.println("明文================>" + post);
        return post;
    }


    public static void main(String[] args) {
        System.out.println(getRandom(16));

        System.out.println(random.nextInt(2));
    }
}
