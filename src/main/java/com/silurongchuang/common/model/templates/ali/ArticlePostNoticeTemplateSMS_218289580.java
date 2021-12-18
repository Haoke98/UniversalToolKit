package com.silurongchuang.common.model.templates.ali;

import com.google.gson.JsonObject;

public class ArticlePostNoticeTemplateSMS_218289580 implements AliTemplate {
    private final String receiver;
    private final String time;
    private final String sender;
    private final String type;
    private final String token;

    public ArticlePostNoticeTemplateSMS_218289580(String receiver, String time, String sender, String token, String type) {
        this.receiver = receiver;
        this.time = time;
        this.sender = sender;
        this.type = type;
        this.token = token;
    }

    @Override
    public String getCode() {
        return "SMS_218289580";
    }

    @Override
    public String getContent() {
        return String.format("尊敬的%s，你于%s时收到来自%s（用户/企业/组织）的消息。详情点击https://m.xjip.info/#/%s?t=%s", receiver, time, sender, type, token);
    }

    @Override
    public String getParamsAsJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("receiver", receiver);
        jsonObject.addProperty("time", time);
        jsonObject.addProperty("sender", sender);
        jsonObject.addProperty("type", type);
        jsonObject.addProperty("token", token);
        return jsonObject.toString();
    }
}
