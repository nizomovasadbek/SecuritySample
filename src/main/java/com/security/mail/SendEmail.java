package com.security.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String message){
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo("nizomovasadbek1199@gmail.com");
        msg.setFrom("nizomovasadbekjava@gmail.com");
        msg.setSubject("Registration");
        msg.setText(message);

        javaMailSender.send(msg);
    }
    
    public void sendMailTo(String message, String to){
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(to);
        msg.setFrom("nizomovasadbejava@gmail.com");
        msg.setSubject("Confirm");
        msg.setText(message);

        javaMailSender.send(msg);
    }
}
