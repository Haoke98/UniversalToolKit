package com.silurongchuang.common.model.templates.tencent;

import java.text.MessageFormat;

public class RegisterVerificationTemplate implements TencentTemplate {
    private final static String ID = "904931";
    private final static String name = "中心注册";
    private final static String templateContent = "您的注册验证码：{1}，30分钟内有效，如非本人操作，请忽略本短信！";
    private String verificationCode;

    public RegisterVerificationTemplate(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getContent() {
        return MessageFormat.format(templateContent, null, verificationCode);
    }

    @Override
    public String[] getParams() {
        return new String[]{this.verificationCode};
    }
}
