package io.github.Haoke98.model.templates.tencent;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.MessageFormat;

public class NoticeTemplateWithUrl implements TencentTemplate {
    private final static String name = "系统收到消息通知";
    private final static String templateContent = "尊敬的{1}，你于北京时间{2}时收到来自{3}的一条通知，通知主题是：“{4}”，为了不错过重要的消息，请你尽快到我们的网站，登录自己的企业账号，查看此消息详情内容，请查阅： https://dllzff.cn/NfKgnTUL";
    private final String receiverRealManName;
    private final String senderCompanyName;
    private final String theme;

    public NoticeTemplateWithUrl(String receiverRealManName, String senderCompanyName, String theme) {
        this.receiverRealManName = receiverRealManName;
        this.senderCompanyName = senderCompanyName;
        this.theme = theme;
    }


    @Override
    public String getId() {
        return "908720";
    }

    @Override
    public String getContent() {
        return MessageFormat.format(templateContent, null, this.receiverRealManName, LocalDateTime.now().toString(DateTimeFormat.forPattern("yyyy年MM月dd日,HH:mm")), this.senderCompanyName, this.theme);
    }

    @Override
    public String[] getParams() {
        return new String[]{this.receiverRealManName, LocalDateTime.now().toString(DateTimeFormat.forPattern("yyyy年MM月dd日,HH:mm")), this.senderCompanyName, this.theme};
    }
}
