package com.nagarro.notificationapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.entity.UserDetail;


@Service
public class MailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendMail(String template, Event event) {
		ArrayList<String> recipient = new ArrayList<>();
		for(UserDetail userDetail : event.getTarget()) {
			recipient.add(userDetail.getEmail());
		}
		String[] recipientList = recipient.stream().toArray(String[]::new);
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(recipientList);
		msg.setSubject(event.getSubject());
		msg.setText(template);
		
		javaMailSender.send(msg);
	}
}
