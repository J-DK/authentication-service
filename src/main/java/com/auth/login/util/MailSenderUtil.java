package com.auth.login.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSenderUtil {
    private JavaMailSender javaMailSender;

    @Autowired
    public MailSenderUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String emailId, String subject, String content) throws MailException {

        /*
         * This JavaMailSender Interface is used to send Mail in Spring Boot. This
         * JavaMailSender extends the MailSender Interface which contains send()
         * function. SimpleMailMessage Object is required because send() function uses
         * object of SimpleMailMessage as a Parameter
         */

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailId);
        mail.setSubject(subject);
        mail.setText(content);
        javaMailSender.send(mail);
    }
}
