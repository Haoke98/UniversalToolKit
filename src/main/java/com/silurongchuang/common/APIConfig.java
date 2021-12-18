package com.silurongchuang.common;

import com.squareup.okhttp.internal.framed.Http2;
import com.tencentcloudapi.tiems.v20190416.models.ServiceStatus;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Component;

import javax.xml.ws.Service;
import javax.xml.ws.spi.http.HttpContext;
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
    public static final String HIGHLIGHT_TAG_PRE = "<em>";
    public static final String HIGHLIGHT_TAG_POST = "</em>";


    static {
    }

    /**
     * 解决properties文件中的变量在静态文件中无法加载的问题（注：只能用@Autowired注解来实例化才能加载，否则只能用如下方法）
     * 注：该方法加载的不是该依赖包中的properties文件，而是添加该依赖包的住SpringBoot Application包中的properties文件。
     *
     * @lastModifiedBy 萨达木(sadam)
     * @lastModifiedDate 2021/12/1 17:58
     */
    private static void init() {
        Properties properties = new Properties();
        try {
            InputStream is = APIConfig.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(is);
            is.close();
            VERSION = properties.getProperty("VERSION");
            System.out.println("API Version: " + VERSION);
//            HTTP.UTF_8

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "APIConfig{version:" + VERSION + "}";
    }
}
