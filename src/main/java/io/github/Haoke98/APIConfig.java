package io.github.Haoke98;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * API 基本信息配置文件
 *
 * @author 萨达木(sadam)
 * @date 2021/3/29 3:42
 */
@Component
public class APIConfig {
    /**
     * 接口版本
     */
    public static String VERSION = "你开心了吗";
    @Value("${api.version}")
    private String _version;
    /**
     * UTF-8 字符集
     */
    public static final String ENCODING = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final int SUCCESS = 0;

    /**
     * 通用失败标识
     */
    public static final int FAIL = 1;



    /**
     * 解决properties文件中的变量在静态文件中无法加载的问题（注：只能用@Autowired注解来实例化才能加载，否则只能用如下方法）
     * 注：该方法加载的不是该依赖包中的properties文件，而是添加该依赖包的住SpringBoot Application包中的properties文件。
     *
     * @lastModifiedBy 萨达木(sadam)
     * @lastModifiedDate 2021/12/1 17:58
     */
    @PostConstruct
    void init() {
            VERSION = this._version;
            System.out.println("API Version: " + VERSION);
    }

    @Override
    public String toString() {
        return "APIConfig{version:" + VERSION + "}";
    }
}
