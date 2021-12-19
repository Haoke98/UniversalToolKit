package io.github.Haoke98.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

/**
 * @author hjljy@outlook.com
 * @date 2020/1/6 15:39
 * @apiNote //TODO
 */
public class EmailSender {
    @Autowired
    JavaMailSender javaMailSender;

    public void main(String[] args) throws Exception {
//        Properties properties = new Properties();
//        // 连接协议
//        properties.put("mail.transport.protocol", "smtps");
//        // 主机名
//        properties.put("mail.smtp.host", "smtp.qq.com");
//        // 端口号
//        properties.put("mail.smtp.port", 465);
//        //开启权限校验
//        properties.put("mail.smtp.auth", "true");
//
//
//        // 得到回话对象
//        Session session = Session.getInstance(properties);
//        // 获取邮件对象
//        Message message = new MimeMessage(session);
//        // 设置发件人邮箱地址
//        message.setFrom(new InternetAddress("callme_0920@qq.com"));
//        // 设置收件人邮箱地址
//        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("1903249375@qq.com")});
//        // 设置邮件标题
//        message.setSubject("xmqtest");
//        // 设置邮件内容
//        message.setText("邮件内容邮件内容邮件内容xmqtest");
//        // 得到邮差对象
//        Transport transport = session.getTransport();
//        // 连接自己的邮箱账户
//        transport.connect("callme_0920@qq.com", "bhwuenurolvldjga");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
//        // 发送邮件
//        transport.sendMessage(message, message.getAllRecipients());
//        transport.close();


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("this is Subject.");
        simpleMailMessage.setFrom("callme_0920@qq.com");
        simpleMailMessage.setTo("1903249375@qq.com");
        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("12****32*qq.com");
//         设置隐秘抄送人，可以有多个
//        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        simpleMailMessage.setSentDate(new Date());
        // 设置邮件的正文
        simpleMailMessage.setText("这是测试邮件的正文");
        // 发送邮件
        javaMailSender.send(simpleMailMessage);
    }
}

