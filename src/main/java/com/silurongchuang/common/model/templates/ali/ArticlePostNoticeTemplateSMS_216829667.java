package com.silurongchuang.common.model.templates.ali;

import com.google.gson.JsonObject;

public class ArticlePostNoticeTemplateSMS_216829667 implements AliTemplate {
    private final String receiver;
    private final String time;
    private final String sender;
    private final String token;

    public ArticlePostNoticeTemplateSMS_216829667(String receiver, String time, String sender, String token) {
        this.receiver = receiver;
        this.time = time;
        this.sender = sender;
        this.token = token;
    }

    @Override
    public String getCode() {
        return "SMS_216829667";
    }

    @Override
    public String getContent() {
        return String.format("尊敬的%s，你于%s时收到来自%s账号的消息。详情点击https://xjip.info/m?t=%s", receiver, time, sender, token);
    }

    @Override
    public String getParamsAsJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("receiver", receiver);
        jsonObject.addProperty("time", time);
        jsonObject.addProperty("sender", sender);
        jsonObject.addProperty("token", token);
        return jsonObject.getAsString();
    }
}
