package com.nagarro.notificationapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class UserNotification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer notificationId;
	
	private String message;
	
	private Date createdAt;
	
	private boolean isRead;
	
	@ManyToOne
	private UserDetail user;
	
	public UserNotification(){}
	
	public UserNotification(String message,Date createdAt,UserDetail user){
		this.message = message;
		this.createdAt = createdAt;
		this.user = user;
		this.isRead = false;
	}


	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}
	
	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

}