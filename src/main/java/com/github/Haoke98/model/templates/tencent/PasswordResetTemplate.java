package com.github.Haoke98.model.templates.tencent;

import java.text.MessageFormat;

public class PasswordResetTemplate implements TencentTemplate {
    private final static String ID = "904933";
    private final static String name = "修改密码";
    private final static String templateContent = "您的动态验证码为：{1}，您正在进行密码重置操作，如非本人操作，请忽略本短信！";
    private String verificationCode;

    public PasswordResetTemplate(String verificationCode) {
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
