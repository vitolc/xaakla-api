package com.vitulc.portfolio.app.services;

import com.vitulc.portfolio.app.dtos.EmailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailDto emailDto){
        var message =  new SimpleMailMessage();
        message.setFrom("");
        message.setTo("");
        message.setSubject(emailDto.subject());
        message.setReplyTo(emailDto.sender());
        String messageText = "Email sent by: " + emailDto.sender() + "\n\n" + emailDto.body();
        message.setText(messageText);
        mailSender.send(message);
    }
}
