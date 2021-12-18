package com.silurongchuang.common.model.requestBody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@ApiModel(description = "企业账号激活请求请求体")
public class ActivateRB {
    @ApiModelProperty(value = "企业ES中的ID", required = true)
    String company_es_id;
    @ApiModelProperty(value = "6位验证码", required = true)
    String code;
    @ApiModelProperty(value = "新设用户名", required = true)
    String username;
    @ApiModelProperty(value = "新设密码1", required = true)
    String password1;
    @ApiModelProperty(value = "新设密码2", required = true)
    String password2;
}
