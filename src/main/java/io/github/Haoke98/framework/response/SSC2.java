package io.github.Haoke98.framework.response;

/**
 * 业务状态码2
 * 主要是用来后天管理
 * @author 萨达木（sadam)
 * @date 2021/10/22 16:44
 */
public class SSC2 {
    //业务状态码
    @RC(msg = "操作成功")
    public static int OK = 20000;
    public static int CREATED = 20001;
    public static int ACCEPTED = 20002;
    public static int NO_CONTENT = 20002;

    public static int INVALID_REQUEST = 40000;
    public static int UNAUTHORIZED = 40001;
    @RC(msg = "操作失败")
    public static int FAIL = 40002;
    public static int FORBIDDEN = 40003;
    @RC(msg = "用户名或密码错误")
    public static int INVALID_PASSWORD_AND_USER_NAME = 40004;
    public static int NOT_ACCEPTABLE = 40006;
    public static int GONE = 40010;
    public static int UN_PROSEABLE_ENTITY = 400022;
    @RC(msg = "资源没有找到")
    public static int NOT_FOUND = 40032;//资源没找到

    public static int INTERNAL_SERVER_ERROR = 50000;//内部错误
    public static int MISSING_PARAMS = 50001;//缺乏参数
    public static int EMPTY_PARAMS_EXCEPTION = 50002;//空参数
    public static int BUSY = 50003;
    public static int ES_SEARCH_EXCEPTION = 50004;
    @RC(msg = "空字段异常")
    public static int NULL_FIELD_EXCEPTION = 50005;
    @RC(msg = "请求体字段解密异常")
    public static int PARAMS_DECRYPT_EXCEPTION = 50006;
}
