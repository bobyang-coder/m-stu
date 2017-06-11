package com.bob.stu.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Base64编码工具类
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/6/11
 */
public class Base64Util {
    private static final String CHARSETNAME_UTF_8 = "UTF-8";

    /**
     * UTF-8编码
     *
     * @param str
     * @return
     */
    public static String encodeByUTF8(String str) {
        return encode(str, null);
    }


    /**
     * 编码
     *
     * @param str         字符串
     * @param charsetName 编码字符集
     * @return
     */
    public static String encode(String str, String charsetName) {
        if (null == charsetName || "".equals(charsetName)) {
            charsetName = CHARSETNAME_UTF_8;
        }
        byte[] b = null;
        try {
            b = str.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode(b);
    }

    /**
     * 编码
     *
     * @param bytes 二进制数组
     * @return
     */
    public static String encode(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return new BASE64Encoder().encode(bytes);
    }


    /**
     * UTF-8解码
     *
     * @param str
     * @return
     */
    public static String decodeByUTF8(String str) {
        return decode(str, null);
    }

    /**
     * 解码成指定指定字符集编码字符串
     *
     * @param str         字符串
     * @param charsetName 编码字符集
     * @return
     */
    public static String decode(String str, String charsetName) {
        if (null == charsetName || "".equals(charsetName)) {
            charsetName = CHARSETNAME_UTF_8;
        }
        byte[] bytes = decode(str);
        if (null != bytes) {
            try {
                return new String(bytes, charsetName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 解码成二进制数组
     *
     * @param str
     * @return
     */
    public static byte[] decode(String str) {
        if (str != null) {
            try {
                return new BASE64Decoder().decodeBuffer(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String s = encodeByUTF8("bob love linln");
        System.out.println(s);
        byte[] decode = decode(s);
        System.out.println(decode(s, "UTF-8"));

    }
}
