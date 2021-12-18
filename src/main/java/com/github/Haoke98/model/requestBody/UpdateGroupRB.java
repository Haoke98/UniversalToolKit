package com.github.Haoke98.model.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateGroupRB {
    private Long key;//群ID决定更新

    private String name;//群名
    private Integer order;//排序

    private String remarks;//备注

    //莫名奇妙的值
    private Boolean isNew;
    private Integer status;
    private Boolean editable;
    private Integer companyCount;

}
