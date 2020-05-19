package com.nagarro.notificationapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.notificationapp.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
