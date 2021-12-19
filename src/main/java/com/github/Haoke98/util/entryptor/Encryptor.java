package com.github.Haoke98.util.entryptor;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 加密工具
 *
 * @author shadikesadamu
 * @date 2021/12/19 10:49
 */
@Component
public class Encryptor {
    private BasicTextEncryptor encryptor;
    /***
     * 加密盐
     */
    @Value("${jasypt.encryptor.password}")
    private String SALT;

    public Encryptor() {
    }

    public Encryptor(String SALT) {
        this.SALT = SALT;
        this.encryptor = new BasicTextEncryptor();
        this.encryptor.setPassword(SALT);
    }

    @PostConstruct
    void init(){
        this.encryptor = new BasicTextEncryptor();
        this.encryptor.setPassword(SALT);
    }

    public void encrypt(String targetPassword) {
        System.out.println(targetPassword + ":" + "ENC(" + this.encryptor.encrypt(targetPassword) + ")");
    }

    /**
     * 获取SpringBoot的MySQL数据库连接配置以及加密配置
     *
     * @param host                  数据库服务器ip
     * @param port                  数据库端口
     * @param database              数据库
     * @param username              用户名
     * @param password              访问密码
     * @param characterEncodingUTF8 连接是否要用UTF-8编码
     */
    public void mysql(String host, Integer port, String database, String username, String password, Boolean characterEncodingUTF8, Boolean useSSL) {
        String url = "jdbc:mysql://${spring.datasource.host}:${spring.datasource.port}/${spring.datasource.database}?useSSL=" + useSSL;
        if (characterEncodingUTF8) {
            url += "&characterEncoding=utf8";
        }
        System.out.println("----------------------------Before Encrypted---------------------------------");
        System.out.println("spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver");
        System.out.println("spring.datasource.host=" + host);
        System.out.println("spring.datasource.port=" + port);
        System.out.println("spring.datasource.database=" + database);
        System.out.println("spring.datasource.url=" + url);
        System.out.println("spring.datasource.username=" + username);
        System.out.println("spring.datasource.password=" + password);
        System.out.println("spring.jpa.database=mysql");
        System.out.println("spring.jpa.show-sql=true");
        System.out.println("spring.jpa.hibernate.ddl-auto=update");
        System.out.println("spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        System.out.println("spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect");

        System.out.println("----------------------------Aftere Encrypted---------------------------------");
        System.out.println("jasypt.encryptor.password=" + SALT);
        System.out.println("spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver");
        System.out.println("spring.datasource.host=ENC(" + encryptor.encrypt(host) + ")");
        System.out.println("spring.datasource.port=ENC(" + encryptor.encrypt(port+"") + ")");
        System.out.println("spring.datasource.database=ENC(" + encryptor.encrypt(database) + ")");
        System.out.println("spring.datasource.url=" + url);
        System.out.println("spring.datasource.username=ENC(" + encryptor.encrypt(username) + ")");
        System.out.println("spring.datasource.password=ENC(" + encryptor.encrypt(password) + ")");
        System.out.println("spring.jpa.database=mysql");
        System.out.println("spring.jpa.show-sql=true");
        System.out.println("spring.jpa.hibernate.ddl-auto=update");
        System.out.println("spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        System.out.println("spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect");
    }


    public void elasticSearch(String host, Integer port, String username, String password) {
        String uri = "http://" + host + ":" + port;
        System.out.println("----------------------------Before Encrypted---------------------------------");
        System.out.println("spring.data.elasticsearch.repositories.enabled=true");
        System.out.println("spring.elasticsearch.rest.uris=" + uri);
        System.out.println("spring.elasticsearch.rest.username=" + username);
        System.out.println("spring.elasticsearch.rest.password=" + password);
        System.out.println("----------------------------Aftere Encrypted---------------------------------");
        System.out.println("jasypt.encryptor.password=" + SALT);
        System.out.println("spring.data.elasticsearch.repositories.enabled=true");
        System.out.println("spring.elasticsearch.rest.uris=ENC(" + encryptor.encrypt(uri) + ")");
        System.out.println("spring.elasticsearch.rest.username=ENC(" + encryptor.encrypt(username) + ")");
        System.out.println("spring.elasticsearch.rest.password=ENC(" + encryptor.encrypt(password) + ")");
    }
}

