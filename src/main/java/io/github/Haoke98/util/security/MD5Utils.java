package io.github.Haoke98.util.security;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具类
 */
public class MD5Utils {

    /**
     * 加密的盐值
     */
    private static final String SALT = "1a2b3c4d";

    /**
     * 加密传入的字符串
     *
     * @param src
     * @return
     */
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     * 对输入的字符串加盐值处理再加密
     *
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass) {
        String str = "" + SALT.charAt(0) + SALT.charAt(2) + inputPass + SALT.charAt(5) + SALT.charAt(4);
        return md5(str);
    }

    /**
     * 对输入的字符串通过输入的盐值先处理再加密
     *
     * @param formPass
     * @return
     */
    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 两次MD5加密
     *
     * @param inputPass
     * @param SALTDB
     * @return
     */
    public static String inputPassToDbPass(String inputPass, String SALTDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, SALTDB);
        return dbPass;
    }
}
