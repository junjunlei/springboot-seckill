package com.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-23 16:47
 * @Version 1.0
 **/
public class Md5Util {

    /**
     * md加密
     *
     * @param text 加密文本
     * @return
     */
    private static String md5(String text) {
        return DigestUtils.md5Hex(text);
    }

    /**
     * 根据指定盐值加密
     *
     * @param text
     * @param salt
     * @return
     */
    public static String encryptCode(String text, String salt) {
        String encrypt = "" + salt.charAt(0) + salt.charAt(2) + text + salt.charAt(5) + salt.charAt(4);
        return md5(encrypt);
    }
}
