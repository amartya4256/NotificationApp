package com.nagarro.notificationapp.notification;

import com.nagarro.notificationapp.entity.Event;

public abstract class Notification {
	public String template;
	public Event event;
	public abstract String getTemplate();
	public abstract void setTemplate(Event event);
	public abstract Event getEvent();
	public abstract void setEvent(Event event);
	public abstract void sendNotification();
}
