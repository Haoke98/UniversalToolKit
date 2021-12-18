package com.github.Haoke98.model.requestBody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@ApiModel(description = "分页请求请求体")
public class PageRB {
    @ApiModelProperty(notes = "页码大于等于1")
    private Integer pageNo = 1;

    @ApiModelProperty(notes = "每一页上item的数量")
    private Integer pageSize = 10;

    public Integer getPageNo() {
        return pageNo-1;
    }
}
