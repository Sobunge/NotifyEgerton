package com.notify.NotifyEgerton.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sobunge
 */
@Component
public class EmailService {

    /*

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) throws MailException{

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("noticeuniversity@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
     */

}
