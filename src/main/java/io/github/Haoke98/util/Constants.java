package io.github.Haoke98.util;

/**
 * 通用常量信息
 *

 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 发文 （发送短信验证标识）
     */
    public static final int AUTHENTICATION = 2;


    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

//    /**
//     * 用户名称
//     */
//    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 用户权限-政府
     */
    public static final String JWT_AUTHORITIES_enter = "政";

    /**
     * 用户权限-企业
     */
    public static final String JWT_AUTHORITIES_enter1 = "企";

    /**
     * 邀请中
     */
    public static final Integer SEND_STATUS = 0;

    /**
     * 已同意
     */
    public static final Integer SEND_STATUS_ACCEPT = 1;

    public static final String RESOURCE_FILE = "/profiles/";
    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX_ART = "/profiles";


    /** 空字符串 */
    private static final String NULLSTR = "";

    public static final Integer PAGE_NO = 1;

    public static final Integer PAGE_SIZE = 10;
}

