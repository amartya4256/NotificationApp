package com.nagarro.notificationapp.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.nagarro.notificationapp.enums.NotificationType;

@Entity
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	int id;
	
	@Enumerated(EnumType.STRING)
	@Column
	NotificationType type;
	
	@Column
	String subject;
	
	@Column
	String content;
	
	@Column
	Date date;
	
	@Column
	String host;
	
	@ManyToMany
	Set<UserDetail> target;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Set<UserDetail> getTarget() {
		return target;
	}

	public void setTarget(Set<UserDetail> target) {
		this.target = target;
	}

	public Event(NotificationType type, String subject, String content, Date date, String host, Set<UserDetail> target) {
		super();
		this.type = type;
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.host = host;
		this.target = target;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
}
