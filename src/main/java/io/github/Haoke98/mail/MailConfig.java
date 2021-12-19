package io.github.Haoke98.mail;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

@Component
public class MailConfig {
    private static final String PROPERTIES_DEFAULT = "mailConfig.properties";
    public static String host;
    public static Integer port;
    public static String userName;
    public static String password;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static Properties properties;

    static {
        init();
    }

    private static void init() {
        properties = new Properties();
        try {
            InputStream inputStream = MailConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_DEFAULT);
            properties.load(inputStream);
            inputStream.close();
            host = properties.getProperty("mailHost");
            port = Integer.parseInt(properties.getProperty("mailPort"));
            userName = properties.getProperty("mailUserName");
            password = properties.getProperty("mailPassword");
            emailForm = properties.getProperty("mailUserName");
            timeout = properties.getProperty("mailTimeout");
            //发送人
            personal = properties.getProperty("mailSender");

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
