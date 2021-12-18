package com.silurongchuang.common.framework.response;

/**
 * 业务状态码表
 * @author 萨达木（sadam)
 * @date 2021/3/29 17:58
 */
public class SSC {
    //业务状态码
    @RC(msg = "操作成功")
    public static final int OK = 0;
    @RC(msg = "操作失败")
    public static final int FAIL = 1;
    @RC(msg = "资源没有找到")
    public static final int NOT_FOUND = 2;
    @RC(msg = "缺乏必要参数")
    public static final int MISSING_PARAMS = 3;
    @RC(msg = "ES查询异常")
    public static final int ES_SEARCH_EXCEPTION = 4;
    @RC(msg = "解析JSON数据时发生异常")
    public static final int JSON_PARSING_EXCEPTION = 5;
    @RC(msg = "发起二次HTTP请求失败")
    public static final int SECOND_HTTP_REQUEST_FAILED = 6;
    @RC(msg = "解析二次HTTP请求响应体异常")
    public static final int PARSING_SECOND_HTTP_REQUEST_RESPONSE_EXCEPTION = 7;
    @RC(msg = "该微信用户还没绑定系统账号，需要及时进行绑定操作！")
    public static final int WECHAT_WITHOUT_BINDING_SYSTEM_ACCOUNT = 8;
    @RC(msg = "参数私钥解密异常，请联系管理员")
    public static final int DECRYPT_PARAMS_EXCEPTION = 9;
    @RC(msg = "公钥加密失败")
    public static final int PUBLIC_KEY_ENCRYPT_FAIL = 10;
    @RC(msg = "用户不存在")
    public static final int USER_NOT_EXIST = 11;
    @RC(msg = "资源不存在")
    public static final int SOURCE_NOT_EXIST = 12;
    @RC(msg = "请求头部Header(Referer)不匹配 或 不正确")
    public static final int HEADER_REFERER_NOT_MATCH = 13;
    @RC(msg = "未登录状态，请登录")
    public static final int UN_AUTHORIZED = 14;
    @RC(msg = "Token已过期，不存在的邀请，该用户未正常登录")
    public static final int TOKEN_EXPIRED = 15;
    @RC(msg = "邀请函接收人空指针异常")
    public static final int INVITATION_RECEIVER_NULL_POINT_EXCEPTION = 16;
    @RC(msg = "未知错误（错误信息将在result里标注）")
    public static final int UN_KNOWN_EXCEPTION = 17;
    @RC(msg = "用户名和密码错误")
    public static final int INVALID_USERNAME_AND_PASSWORD = 18;
    @RC(msg = "没有权限")
    public static final int NO_PERMISSION = 19;
    @RC(msg = "参数取值异常")
    public static final int INVALID_PARAM_VALUE = 20;
    @RC(msg = "空字段异常")
    public static final int NULL_FIELD_EXCEPTION = 21;
    @RC(msg = "请求体字段解密异常")
    public static final int PARAMS_DECRYPT_EXCEPTION = 22;
    @RC(msg = "积分不足")
    public static final int CREDITS_ARE_LACK_OFF = 23;
    @RC(msg = "空群异常")
    public static final int EMPTY_GROUP_EXCEPTION = 24;
    @RC(msg = "该用户没有关联的任何（企业 或者 商友）")
    public static final int NO_ASSOCIATED_INFO = 25;
    @RC(msg = "用户名和密码序列化异常")
    public static final int USER_NAME_AND_PASSWORD_SERIALIZATION_EXCEPTION = 26;
    @RC(msg = "已登录")
    public static final int ALREADY_LOGIN = 27;
    @RC(msg = "无法查询即将绑定的微信信息,请先尝试微信登录（产生绑定微信信息）")
    public static final int BINDING_WECHAT_NOT_FOUND = 28;
    @RC(msg = "请求体字段取值异常")
    public static final int INVALID_FIELD_VALUE = 29;
    @RC(msg = "验证码错误")
    public static final int INCORRECT_VERIFICATION_CODE = 30;
    @RC(msg = "空参数值异常")
    public static final int EMPTY_PARAMS_EXCEPTION = 31;
    @RC(msg= "参数空指针异常")
    public static final int NULL_PARAMS_EXCEPTION = 32;
    @RC(msg = "请求体空字段值异常")
    public static final int EMPTY_FIELD_EXCEPTION = 33;
    @RC(msg = "当前手机号和发送验证码的手机号不一致")
    public static final int TEL_NOT_CORRECT_EXCEPTION = 34;
    @RC(msg = "该手机号还未发送验证码,请先进行发送验证码操作")
    public static final int TEL_NOT_SEND_VERIFICATION_CODE = 35;
    @RC(msg = "发送验证码次数过多，请稍后再试")
    public static final int SENDING_LOGIN_VERIFICATION_TIMES_EXCEED = 36;
    @RC(msg = "验证码已发送，请在1分钟后再试")
    public static final int VERIFICATION_CODE_SEND = 37;
    @RC(msg = "用户民已存在")
    public static final int USERNAME_ALREADY_EXIST = 38 ;
    @RC(msg = "两个密码不一致，请纠正后重新提交")
    public static final int TWO_PASSWORD_INCONSISTENT = 39 ;



    public static int CREATED = 20001;
    public static int ACCEPTED = 20002;
    public static int NO_CONTENT = 20002;
    public static int INVALID_REQUEST = 40000;
    public static int FORBIDDEN = 40003;
    public static int NOT_ACCEPTABLE = 40006;
    public static int GONE = 40010;
    public static int UN_PROSEABLE_ENTITY = 400022;
    public static int INTERNAL_SERVER_ERROR = 50000;//内部错误
}
