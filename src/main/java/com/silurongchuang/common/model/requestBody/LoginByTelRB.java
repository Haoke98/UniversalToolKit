package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginByTelRB {
    private String tel;
    private String code;
}
