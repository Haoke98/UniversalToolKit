package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRB {
    String username;
    String password;
    Integer verify;//TODO:可以去掉了，可以通过Header-Referer来实现请求来自商汇通还是来自信息通道。

    @Override
    public String toString() {
        return "LoginRB{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verify=" + verify +
                '}';
    }
}
