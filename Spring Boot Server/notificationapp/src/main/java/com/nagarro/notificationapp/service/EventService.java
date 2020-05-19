package com.nagarro.notificationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.entity.dao.EventDao;

@Service
public class EventService {

	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private NotificationService notificationService;
	
	
	public int saveEvent(Event event) {
		
		int id = eventDao.saveEvent(event);
		notificationService.sendNotification(event);
		
		return id;
	}
}
