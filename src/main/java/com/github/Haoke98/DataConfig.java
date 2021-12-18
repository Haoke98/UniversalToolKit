package com.github.Haoke98;

import javax.servlet.http.HttpSession;

/**
 * 全局静态变量Global Constants
 *
 * @author 萨达木（sadam)
 * @date 2021/5/27 0:07
 */
public class DataConfig {
    public static final String INDEX_NAME_COMPANY = "company";
    public static final String INDEX_NAME_UN_SENSITIVE = "company_classified_un_sensitive4";
    public static final String INDEX_NAME_SENSITIVE = "company_classified_sensitive4";


    public static final String TAG_TEL_VALIDITY_FIELD = "telValidity";
    public static final String TAG_TEL_TY_VALIDITY_FIELD = "tel-tyValidity";


    public static final String TAG_IS_HIGH_TECH = "isHighTech";
    public static final String TAG_HIGH_TECH_INFO = "highTechPeriod";
    public static final String TAG_HAS_SOFTWARE_COPYRIGHT = "hasSoftwareCopyright";
    public static final String TAG_HAS_TRADE_MARK = "hasTradeMark";
    public static final String TAG_HAS_TRADE_MARK_INFO = "hasTradeMarkInfo";
    public static final String TAG_HAS_PATENT_INFO = "hasPatentInfo";
    public static final String TAG_HAS_PRODUCT_COPYRIGHT = "hasProductCopyright";


    public static final class SESSION {
        public static final String KEY_USER_ID = "userID";
        public static final String KEY_CURR_POSITION = "curr_position";
        public static final String KEY_ACTIVATE_COMPANY_ES = "activate_company_es";

        public static final String KEY_LOGIN_TEL = "login_tel";//发送验证码的手机号

        public static final String KEY_LOGIN_USER = "login_user";//即将要登录的用户
        public static final String KEY_LOGGED_IN_USER = "logged_in_user";//已登录用户
        public static final String KEY_LOGGED_IN_USER_ID = "logged_in_user_id";//已登录用户
        public static final String KEY_WECHAT_WITHOUT_BINDING_SYSTEM_ACCOUNT = "wechat_without_binding_system_account";//第一次微信登录时，把微信信息存储在
        public static final String KEY_LOGIN_DTO = "login_DTO";
        /**
         * 当前会话中已经登录的管理员对象
         */
        public static final String KEY_LOGIN_ADMIN = "login_admin";

        public static String KEY_SMS_VERIFY_CODE(HttpSession session) {
            return "sms_verify_code:" + session.getId();
        }
    }

    public static final class REDIS {
        public static final String KEY_ACCESS_TOKEN = "redis_key_access_token";
    }
}
