package io.github.Haoke98.framework.response;

import io.github.Haoke98.APIConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * 响应体Data结构
 * @author 萨达木（sadam)
 * @date 2021/3/24 1:31
 */
@Data
@ApiModel(description = "请求返回体基本结构")
public class RestResponse<T> {
    @ApiModelProperty(name = "状态码")
    private int status;
    @ApiModelProperty(name = "提示消息")
    private String msg;
    @ApiModelProperty(name = "数据对象", notes = "有可能是Object,也有可能是List<Object>")
    private T result;
    @ApiModelProperty(name = "数据对象数量")
    private int count = 1;
    @ApiModelProperty(name = "接口版本")
    private String version = APIConfig.VERSION;
    @ApiModelProperty(name = "接口编码")
    private String encoding = APIConfig.ENCODING;

    public RestResponse() {
    }

    public RestResponse(Integer code) {
        this.status = code;
        Field[] fields = SSC.class.getDeclaredFields();
        for (Field field :
                fields) {
            try {
                int x = field.getInt(new SSC());
                if (x == code) {
                    boolean fieldHasAnnotation = field.isAnnotationPresent(RC.class);
                    if (fieldHasAnnotation) {
                        RC rc = field.getAnnotation(RC.class);
                        this.msg = rc.msg();
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
    public RestResponse(int code, String msg) {
        this(code);
        this.msg = msg;
    }

    public RestResponse(int code, T data) {
        this(code);
        if (data != null) {
            this.result = data;
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public RestResponse(int code, String msg, T data) {
        this(code, msg);
        if (data != null) {
            this.result = data;
        }
    }


    public RestResponse(int code, String msg, T data, int count) {
        this(code, msg);
        if (data != null) {
            this.result = data;
        }
        this.count = count;
    }


    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static RestResponse success() {
        return new RestResponse(SSC.OK);
    }


    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public RestResponse<T> success(T data) {
        return new RestResponse<>(SSC.OK, data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static RestResponse success(String msg) {
        return new RestResponse(SSC.OK, msg);
    }


    /**
     * 返回成功消息
     *
     * @param msg    返回内容
     * @param result 数据对象
     * @return 成功消息
     */
    public RestResponse<T> success(String msg, T result) {
        return new RestResponse<>(SSC.OK, msg, result);
    }

    /**
     * 返回成功消息
     *
     * @param msg    返回内容
     * @param result 数据对象
     * @param count  数据数量
     * @return 成功消息
     */
    public RestResponse<T> success(String msg, T result, int count) {
        return new RestResponse<T>(SSC.OK, msg, result, count);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static RestResponse error() {
        return new RestResponse(SSC.FAIL);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static RestResponse error(String msg) {
        return new RestResponse(SSC.FAIL, msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @return 警告消息
     */
    public static RestResponse error(Integer code) {
        return new RestResponse(code);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static RestResponse error(int code, String msg) {
        return new RestResponse(code, msg);
    }

    public RestResponse<T> error(int status, String msg, T result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
        return this;
    }

    public RestResponse<T> error(int status, T result) {
        RestResponse<T> restResponse = new RestResponse<>(status);
        restResponse.result = result;
        return restResponse;
    }
}
