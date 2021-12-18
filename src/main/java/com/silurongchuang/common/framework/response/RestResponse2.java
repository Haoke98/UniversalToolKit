package com.silurongchuang.common.framework.response;

import com.silurongchuang.common.APIConfig;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * 响应体
 * 专门为后天管理所用
 * @author 萨达木（sadam)
 * @date 2021/3/24 1:31
 * @lastModifiedAt 2021/12/15 23:57
 */
public class RestResponse2 extends HashMap<String, Object> {
    /**
     * 状态码
     */
    public static final String KEY_CODE = "code";
    /**
     * 返回内容
     */
    public static final String KEY_MSG = "msg";
    /**
     * 数据对象
     */
    public static final String KEY_DATA = "data";
    /**
     * 接口版本
     */
    public static final String KEY_VERSION = "version";
    public static final String KEY_ENCODING = "encoding";
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public RestResponse2() {
        super.put(KEY_VERSION, APIConfig.VERSION);
        super.put(KEY_ENCODING,APIConfig.ENCODING);
    }

    public RestResponse2(Integer code) {
        this();
        super.put(KEY_CODE, code);
        Field[] fields = SSC2.class.getDeclaredFields();
        for (Field field :
                fields) {
            try {
                int x = field.getInt(new SSC2());
                if (x == code) {
                    boolean fieldHasAnnotation = field.isAnnotationPresent(RC.class);
                    if (fieldHasAnnotation) {
                        RC rc = field.getAnnotation(RC.class);
                        super.put(KEY_MSG, rc.msg());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public RestResponse2(Integer code, String msg) {
        this(code);
        super.put(KEY_MSG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public RestResponse2(Integer code, String msg, Object data) {
        this(code, msg);
        if (data != null) {
            super.put(KEY_DATA, data);
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public RestResponse2(Integer code, String msg, String dataTag, Object data) {
        this(code, msg);
        if (data != null) {
            super.put(dataTag, data);
        }
    }

    public RestResponse2(int code, Object data) {
        this(code);
        if (data != null) {
            super.put(KEY_DATA, data);
        }
    }


    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static RestResponse2 success() {
        return new RestResponse2(SSC2.OK);
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static RestResponse2 success(Object data) {
        return new RestResponse2(SSC2.OK, data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static RestResponse2 success(String msg) {
        return new RestResponse2(SSC2.OK,msg);
    }


    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static RestResponse2 success(String msg, Object data) {
        return new RestResponse2(SSC2.OK, msg, data);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static RestResponse2 success(String msg, String dataTag, Object data) {
        return new RestResponse2(SSC2.OK, msg, dataTag, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static RestResponse2 error() {
        return new RestResponse2(SSC2.FAIL);
    }

    public static RestResponse2 error(int errorCode) {
        return new RestResponse2(errorCode);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static RestResponse2 error(String msg) {
        return new RestResponse2(SSC2.FAIL, msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static RestResponse2 error(int code, String msg) {
        return new RestResponse2(code, msg);
    }

}

