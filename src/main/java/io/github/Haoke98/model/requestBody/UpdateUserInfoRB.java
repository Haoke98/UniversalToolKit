package io.github.Haoke98.model.requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserInfoRB {
    private String nickname;//绰号
    private String email;//邮箱
    private String profiles;//简介
}
