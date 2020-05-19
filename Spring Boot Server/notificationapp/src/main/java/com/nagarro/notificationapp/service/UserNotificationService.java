package com.nagarro.notificationapp.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.entity.UserDetail;
import com.nagarro.notificationapp.entity.UserNotification;
import com.nagarro.notificationapp.entity.dao.UserNotificationDao;
import com.nagarro.notificationapp.responsetype.NotificationResponse;

@Service
public class UserNotificationService {
	
	@Autowired
	UserNotificationDao userNotificationDao;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	public void saveAll(Event event, String template) {
		ArrayList<UserNotification> notificationList = new ArrayList<>();
		for(UserDetail user : event.getTarget()) {
			UserNotification userNotification = new UserNotification(template, new Date(), user);
			notificationList.add(userNotification);
		}
		userNotificationDao.saveAll(notificationList);
		
		/*
		 * This block is used to
		 * send the notification the 
		 * users for whom, the event was
		 * generated.
		 */
		SimpMessageHeaderAccessor accessor = SimpMessageHeaderAccessor.create();
		accessor.setContentType(MimeTypeUtils.APPLICATION_JSON);
		accessor.setLeaveMutable(true);
		MessageHeaders headers = accessor.getMessageHeaders();
		for(UserDetail user : event.getTarget()) {
			messagingTemplate.convertAndSendToUser(user.getUsername(), "/queue/feed", new NotificationResponse(template), headers);
		}
	}
}
