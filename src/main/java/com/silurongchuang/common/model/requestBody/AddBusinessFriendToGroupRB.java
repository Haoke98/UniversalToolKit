package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBusinessFriendToGroupRB {
    private Long key;// 群Id
    private Long userId;// 成员Id
    private String fullName;// 姓名
    private String phone;// 手机
    private String company;// 企业
    private String positions;// 职位
    private String email;// 邮件
    private String weChat;// 微信
    private String remarks;// 备注

    private Integer type = 1;// 是否使用企业库数据  1 采用 0 拒绝采用
}