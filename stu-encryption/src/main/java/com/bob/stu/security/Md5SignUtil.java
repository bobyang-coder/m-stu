package com.bob.stu.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Md5签名工具类
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/6/11
 */
public class Md5SignUtil {


    /**
     * 签名
     *
     * @param params      需要签名的数据
     * @param secretKey   秘钥
     * @param charsetName 字符集名称
     * @return
     */
    public static String sign(HashMap<String, String> params, String secretKey, String charsetName) {
        if (null == charsetName || "".equals(charsetName)) {
            charsetName = "UTF-8";
        }
        //使用MD5对待签名串求签
        byte[] bytes = null;
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            try {
                bytes = md5.digest(sortAscBy(params, secretKey).getBytes(charsetName));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //将MD5输出的二进制结果转换为小写的十六进制
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        return sign.toString();
    }

    /**
     * 按字典顺序排序
     *
     * @param params    需要签名的数据
     * @param secretKey 秘钥
     * @return
     */
    private static String sortAscBy(HashMap<String, String> params, String secretKey) {
        //将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<String, String>(params);
        Set<Entry<String, String>> entrys = sortParams.entrySet();
        //遍历排序的字典,并拼接"key=value"格式
        StringBuilder baseString = new StringBuilder();
        for (Entry<String, String> entry : entrys) {
            String key = entry.getKey();
            if ("sign".equalsIgnoreCase(key) || "sign_type".equalsIgnoreCase(key)) {
                continue;
            }
            baseString.append(key).append("=").append(entry.getValue()).append("&");
        }
        baseString.append(secretKey);
        System.out.println(baseString);
        return baseString.toString();
    }


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "bob");
        map.put("age", "18");
        map.put("sign_type", "UTF-8");
        map.put("Sign", "0000");

        System.out.println(sign(map, "123456", null));
    }
}
