package com.silurongchuang.common.util.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

public class HttpClientHelper {
    public static String senPost(String urlParams) {
        PostMethod postMethod = new PostMethod(urlParams);
        return sendHttpMethod(postMethod);
    }

    public static String sendGet(String urlParam) {
        GetMethod getMethod = new GetMethod(urlParam);
        return sendHttpMethod(getMethod);
    }

    private static HttpClient createHttpClient() {
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        return httpClient;
    }

    private static String sendHttpMethod(HttpMethodBase httpMethodBase) {
        httpMethodBase.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 600000);
        httpMethodBase.addRequestHeader("Content-Type", "application/json");
        httpMethodBase.getParams().setContentCharset("utf-8");
        try {
            createHttpClient().executeMethod(httpMethodBase);
            String res = httpMethodBase.getResponseBodyAsString();
            httpMethodBase.releaseConnection();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

