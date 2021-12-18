package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMembersRB {
    private Integer pageNo = 1;
    private Integer pageSize = 10;

    private Long key;//群ID
    /**
     * 查询方式
     * 全部:3 or null
     * 商友:0
     * 企业:1
     */
    private Integer ways;
}
