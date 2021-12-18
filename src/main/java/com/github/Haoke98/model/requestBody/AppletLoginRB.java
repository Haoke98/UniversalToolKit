package com.github.Haoke98.model.requestBody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@ApiModel(description = "小程序登录请求体")
public class AppletLoginRB {
    @ApiModelProperty(name = "js_code", required = true, notes = "凭借该js_code可以从Auth2接口中获取用户的openid,unionId,sessionKey等信息。")
    private String code;
}
