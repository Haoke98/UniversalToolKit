package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class JoinGroupRB {

    private Long id;

//    private Long userId;

    private Long groupId;

    private String groupName;

    private Integer order;

    private String remarks;

    @Override
    public String toString() {
        return "UserRecommend{" +
                "id=" + id +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", order=" + order +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
