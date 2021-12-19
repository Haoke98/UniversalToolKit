package io.github.Haoke98.model.templates.tencent;

import java.text.MessageFormat;

public class ActivateVerificationCodeTemplate implements TencentTemplate {
    private String verificationCode;

    public ActivateVerificationCodeTemplate(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String getId() {
        return "1158099";
    }

    @Override
    public String getContent() {
        return MessageFormat.format("您的动态验证码为：{1}，您正在进行账号激活操作，如非本人操作，请忽略本短信！", getParams());
    }

    @Override
    public String[] getParams() {
        return new String[]{verificationCode};
    }
}
