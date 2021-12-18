package com.github.Haoke98.model.templates.tencent;

import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

@Getter
@Setter
public class InvitationNoticeTemplate implements TencentTemplate {
    private String receiver;
    private String time;
    private String sender;
    private String title;

    public InvitationNoticeTemplate(String receiver, String time, String sender, String title) {
        this.receiver = receiver;
        this.time = time;
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String getId() {
        return "1158086";
    }

    @Override
    public String getContent() {
        return MessageFormat.format("尊敬的{1}，你于北京时间{2}时收到来自{3}的一条通知，通知主题是：“{4}”，详情点击：https://m.xjip.info/#/a", getParams());
    }

    @Override
    public String[] getParams() {
        return new String[]{receiver, time, sender, title};
    }
}
