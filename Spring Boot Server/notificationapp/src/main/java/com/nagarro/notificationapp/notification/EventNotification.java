package com.nagarro.notificationapp.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.service.MailService;
import com.nagarro.notificationapp.service.MessageService;
import com.nagarro.notificationapp.service.UserNotificationService;

@Component
public class EventNotification extends Notification {
	
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

	public EventNotification() {
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
				+ "This is to inform you that an event '" + event.getSubject()
				+ "' is scheduled on " + event.getDate().toGMTString() + ".\n"
						+ "Details : " + event.getContent()
						+ "\nYou are invited for the same.\n\n"
						+ "Thanks and regards,\n"
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
