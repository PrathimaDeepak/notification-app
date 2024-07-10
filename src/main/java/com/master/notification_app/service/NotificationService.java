package com.master.notification_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	@Value("${receiver.email}")
    private String receiverMailId;
	
	@Value("${spring.mail.username}")
    private String senderEmail;
	
	@Autowired
    private JavaMailSender emailSender;

    public void sendNotificationEmail(String subject, String text) {
    	try {
    		SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderEmail); 
            message.setTo(receiverMailId);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
            System.out.println("Email Sent");
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }
}
