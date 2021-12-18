package com.silurongchuang.common.model.templates.tencent;

import java.text.MessageFormat;

public class LoginVerificationCodeTemplate implements TencentTemplate {
    private final String verificationCode;
    private final String validatePeriod;

    public LoginVerificationCodeTemplate(String verificationCode, String validatePeriod) {
        this.verificationCode = verificationCode;
        this.validatePeriod = validatePeriod;
    }

    @Override
    public String getId() {
        return "985802";
    }

    @Override
    public String getContent() {
        return MessageFormat.format("{1}为您的登录验证码，请于{2}分钟内填写。如非本人操作，请忽略本短信。", getParams());
    }

    @Override
    public String[] getParams() {
        return new String[]{verificationCode, validatePeriod};
    }
}
