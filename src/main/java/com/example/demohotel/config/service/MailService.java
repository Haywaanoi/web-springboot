package com.example.demohotel.config.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MailService {
    private JavaMailSender javaMailSender;

    public void send(String to,String yourname,String content) throws MailException {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("Hotel@sona.com");
        message.setTo(to);
        message.setSubject("New mail from sona to"+yourname);
        message.setText(content);
        javaMailSender.send(message);

        System.out.println("Sended");
    }
}
