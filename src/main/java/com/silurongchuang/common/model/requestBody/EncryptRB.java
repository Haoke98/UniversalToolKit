package com.silurongchuang.common.model.requestBody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@ApiModel(description = "加密请求体:加密工具所需请求体")
public class EncryptRB {
    @ApiModelProperty(name = "要加密内容", required = true, notes = "明文形式，json格式的字符串中要这样处理\\\"")
    private String content;
}
