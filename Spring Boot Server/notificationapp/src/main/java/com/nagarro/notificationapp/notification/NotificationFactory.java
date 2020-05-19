package com.nagarro.notificationapp.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.notificationapp.entity.Event;

@Component
public class NotificationFactory {
	
	@Autowired
	EventNotification eventNotification;
	
	@Autowired
	HelpNotification helpNotification;
	
	@Autowired
	HolidayNotification holidayNotification;
	
	@Autowired
	NewsNotification newsNotification;
	
	@Autowired
	PolicyNotification policyNotification;

	public Notification getNotification(Event event) {
		switch(event.getType()) {
		case EVENT : return eventNotification;
		
		case HELP : return helpNotification;
		
		case HOLIDAY : return holidayNotification;
		
		case NEWS : return newsNotification;
		
		case POLICY : return policyNotification;
		
		default : return null;
		}
	}
}
