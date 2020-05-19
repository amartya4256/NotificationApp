package com.nagarro.notificationapp.entity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.repository.EventRepository;

@Component
public class EventDao {

	@Autowired
	EventRepository eventRepo;
	
	public int saveEvent(Event event) {
		
		Event savedEvent = eventRepo.save(event);
		return savedEvent.getId();
	}
}
