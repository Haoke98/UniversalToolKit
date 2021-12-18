package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupSendRB {

    private Long groupId;

    private String title;

    private String content;

    private String link;

    private Integer type = 1; //是否 给自己发文  1给自己发  0不给自己发

    @Override
    public String toString() {
        return "GroupSendParam{" + '\'' +
                ", groupId=" + groupId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
