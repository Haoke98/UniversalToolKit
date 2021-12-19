package io.github.Haoke98.model.templates.ali;

import com.google.gson.JsonObject;

public class VerificationCodeTemplateSMS_222460540 implements AliTemplate {
    private final String verificationCode;

    public VerificationCodeTemplateSMS_222460540(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String getCode() {
        return "SMS_222460540";
    }

    @Override
    public String getContent() {
        return String.format("您的验证码为：%s ，该验证码在5分钟内有效，请勿泄露于他人！", this.verificationCode);
    }

    @Override
    public String getParamsAsJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", this.verificationCode);
        return jsonObject.getAsString();
    }
}
