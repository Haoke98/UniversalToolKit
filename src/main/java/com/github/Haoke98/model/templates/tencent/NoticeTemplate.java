package com.github.Haoke98.model.templates.tencent;

import java.text.MessageFormat;

public class NoticeTemplate implements TencentTemplate {
    private final static String name = "通知短信";
    private final static String templateContent = "尊敬的{1}，您收到{2}的一条通知，请查阅{3}。";
    private String receiverRealManName;
    private String senderCompanyName;
    private String paramThird;

    public NoticeTemplate(String receiverRealManName, String senderCompanyName, String paramThird) {
        this.receiverRealManName = receiverRealManName;
        this.senderCompanyName = senderCompanyName;
        this.paramThird = paramThird;
    }


    @Override
    public String getId() {
        return "871749";
    }

    @Override
    public String getContent() {
        return MessageFormat.format(templateContent, null, this.receiverRealManName, this.senderCompanyName, this.paramThird);
    }

    @Override
    public String[] getParams() {
        return new String[]{this.receiverRealManName, this.senderCompanyName, this.paramThird};
    }
}
