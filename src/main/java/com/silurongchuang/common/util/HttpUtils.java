package com.silurongchuang.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("http.config")
public class HttpUtils {
    public static String url="http://p.xjip.info:8000/sms/notice";
    private static String result = "";
    /*String url;
    String mobile;
    String password;*/
    public static String httpPost(String token, String sendTime, String sender_id, List<String> receives_id){
        //CloseableHttpClient实现了HttpClient接口
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);

        //创建HttpClientBuilder设置属性
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(6000)
                .setSocketTimeout(6000)
                .setConnectTimeout(6000).build()).setRetryHandler(new DefaultHttpRequestRetryHandler(3, true));

        //设置请求头信息
        Map<String,String> map=new HashMap<>();
        map.put("Accept","multipart/form-data, */*");
        map.put("Accept-Encoding","gzip, deflate");
        map.put("Accept-Language","zh-CN,zh;q=0.9");
        map.put("Connection","keep-alive");
        map.put("Content-Type","multipart/form-data;charset=UTF-8");
        map.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36 Core/1.63.5024.400 QQBrowser/10.0.932.400");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpPost.setHeader(entry.getKey(), entry.getValue());
        }


        //传递参数为json数据
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("token",token);
        jsonObject.put("sendTime",sendTime);
        jsonObject.put("sender_id",sender_id);
        jsonObject.put("receives_id",receives_id);



        //创建指定内容和编码的字符串实体类
        StringEntity entity=new StringEntity(jsonObject.toJSONString(), Consts.UTF_8);
        //设置请求参数
        httpPost.setEntity(entity);
        // 创建HttpClient对象，CloseableHttpClient实例的生成器
        httpClient=httpClientBuilder.build();

        try {
            // 发送HttpPost请求，获取返回值
            CloseableHttpResponse response=httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //释放资源
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}

