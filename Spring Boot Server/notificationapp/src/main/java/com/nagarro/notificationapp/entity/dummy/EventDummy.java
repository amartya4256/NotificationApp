package com.nagarro.notificationapp.entity.dummy;

import java.util.Date;

import com.nagarro.notificationapp.enums.NotificationType;

public class EventDummy {
	String subject;
	String content;
	Date date;
	NotificationType type;
	String[] target;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public NotificationType getType() {
		return type;
	}
	public void setType(NotificationType type) {
		this.type = type;
	}
	public String[] getTarget() {
		return target;
	}
	public void setTarget(String[] target) {
		this.target = target;
	}
	public EventDummy(String subject, String content, Date date, NotificationType type, String[] target) {
		super();
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.type = type;
		this.target = target;
	}
	public EventDummy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
