package com.nagarro.notificationapp.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.service.MailService;
import com.nagarro.notificationapp.service.MessageService;
import com.nagarro.notificationapp.service.UserNotificationService;

@Component
public class PolicyNotification extends Notification {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserNotificationService userNotificationService;
	
	String template;
	Event event;

	@Override
	public void sendNotification() {
		
		mailService.sendMail(template, event);
		userNotificationService.saveAll(event, template);
	}

	public PolicyNotification() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTemplate() {
		// TODO Auto-generated method stub
		return template;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setTemplate(Event event) {
		this.template = "Hi All,\n\n"
				+ "This is to inform you that a new policy '" + event.getSubject()
				+ "' has been proposed on " + event.getDate().toGMTString() + ".\n"
						+ "Details : " + event.getContent()
						+ "\n\nThanks and regards,\n"
						+ event.getHost();
		
	}

	@Override
	public Event getEvent() {
		// TODO Auto-generated method stub
		return event;
	}

	@Override
	public void setEvent(Event event) {
		this.event = event;
		
	}
	

}
