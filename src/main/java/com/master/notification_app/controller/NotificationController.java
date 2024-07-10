package com.master.notification_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.master.notification_app.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	
	@GetMapping("/send-email")
    public String sendEmail(@RequestParam String subject, @RequestParam String text) {
		notificationService.sendNotificationEmail(subject, text);
        return "Email sent successfully";
    }

}
