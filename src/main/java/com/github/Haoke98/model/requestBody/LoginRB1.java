package com.github.Haoke98.model.requestBody;

import com.github.Haoke98.util.security.RSAUtil;
import lombok.Data;
import org.json.JSONObject;

/**
 * 针对后台管理平台的登录接口做的请求体
 */
@Data
public class LoginRB1 {
    /**
     * 用户名和密码form通过公钥进行加密后生成的字符串
     */
    private String params;
    private String username;
    private String password;


    public void setParams(String param) throws Exception {
        this.params = param;
        String params = RSAUtil.decryptByPriKey(this.params, RSAUtil.privateKeyStr());
        System.out.println("params:" + params);
        JSONObject jsonObject = new JSONObject(params);
        this.username = jsonObject.getString("u");
        this.password = jsonObject.getString("p");
    }
}
