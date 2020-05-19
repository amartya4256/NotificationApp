package com.nagarro.notificationapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.entity.UserDetail;
import com.nagarro.notificationapp.entity.UserNotification;
import com.nagarro.notificationapp.entity.dao.UserDetailDao;
import com.nagarro.notificationapp.entity.dao.UserNotificationDao;
import com.nagarro.notificationapp.notification.Notification;
import com.nagarro.notificationapp.notification.NotificationFactory;

@Service
public class NotificationService {
	
	@Autowired
	NotificationFactory notificationFactory;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	UserNotificationDao userNotificationDao;
	
	@Autowired
	UserDetailDao userDetailDao;
	
	public void sendNotification(Event event) {
		Notification notification = notificationFactory.getNotification(event);
		if(notification != null) {
			notification.setTemplate(event);
			notification.setEvent(event);
			notification.sendNotification();
		}
	}
	
	public boolean isUnread(String username) {
		UserDetail user = userDetailDao.findByUsername(username);
		return userNotificationDao.isUnread(user);
	}
	
	public List<UserNotification> getNotifications(String username){
		UserDetail user = userDetailDao.findByUsername(username);
		return userNotificationDao.getNotificationsByUsername(user);
	}
	
	public void clearNotifications(String username) {
		UserDetail user = userDetailDao.findByUsername(username);
		userNotificationDao.deleteNotificationsByUsername(user);
	}
}
