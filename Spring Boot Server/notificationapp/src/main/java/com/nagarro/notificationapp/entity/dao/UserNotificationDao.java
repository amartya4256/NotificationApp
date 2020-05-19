package com.nagarro.notificationapp.entity.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.notificationapp.entity.UserDetail;
import com.nagarro.notificationapp.entity.UserNotification;
import com.nagarro.notificationapp.repository.UserNotificationRepository;

@Component
public class UserNotificationDao {

	@Autowired
	UserNotificationRepository userNotificationRepository;
	
	public void saveAll(ArrayList<UserNotification> notifications) {
		for (UserNotification notification : notifications) {
			userNotificationRepository.save(notification);
		}
		
	}
	
	public boolean isUnread(UserDetail user) {
		List<UserNotification> notifications = userNotificationRepository.findByUserAndIsRead(user, false);
		if(notifications.size()!=0) {
			return true;
		}
		return false;
	}
	
	public List<UserNotification> getNotificationsByUsername(UserDetail user){
		List<UserNotification> notifications = userNotificationRepository.findByUser(user);
		for(UserNotification notification : notifications) {
			notification.setRead(true);
		}
		userNotificationRepository.saveAll(notifications);
		return notifications;
	}
	
	public void deleteNotificationsByUsername(UserDetail user) {
		List<UserNotification> notifications = userNotificationRepository.findByUser(user);
		userNotificationRepository.deleteAll(notifications);
	}
}
