package com.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
@ComponentScan("com.security")
@PropertySource("classpath:mailConfig.properties")
public class MailConfig {

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private int port;

    @Value("${mail.properties.protocol}")
    private String protocol;

    @Value("${mail.properties.auth}")
    private String auth;

    @Value("${mail.properties.ssl.enable}")
    private String sslEnable;

    @Value("${mail.properties.debug}")
    private String debug;

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties p = new Properties();

        p.put("mail.transport.protocol", protocol);
        p.put("mail.smtp.auth", auth);
        p.put("mail.smtp.ssl.enable", sslEnable);
        p.put("mail.debug", debug);

        mailSender.setJavaMailProperties(p);

        return mailSender;
    }
}
