package com.nagarro.notificationapp.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.service.MailService;
import com.nagarro.notificationapp.service.MessageService;

@Component
public class HelpNotification extends Notification {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	MessageService messageService;
	
	String template;
	Event event;

	public HelpNotification() {
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
		// TODO Auto-generated method stub
		this.template = "Hi All,\n\n"
		+ "Required urgent help for - '" + event.getSubject()
		+ "', dated on - " + event.getDate().toGMTString() + ".\n"
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
		// TODO Auto-generated method stub
		this.event = event;
		
	}

	@Override
	public void sendNotification() {
		// TODO Auto-generated method stub
		mailService.sendMail(template, event);
		messageService.sendMessage();
		
	}


}
