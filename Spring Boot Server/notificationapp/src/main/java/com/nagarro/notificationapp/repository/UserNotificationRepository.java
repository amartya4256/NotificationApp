package com.nagarro.notificationapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.notificationapp.entity.UserDetail;
import com.nagarro.notificationapp.entity.UserNotification;

@Repository
public interface UserNotificationRepository extends CrudRepository<UserNotification, Integer>{
	
	List<UserNotification> findByUserAndIsRead(UserDetail user, boolean isRead);
	
	List<UserNotification> findByUser(UserDetail user);
}
