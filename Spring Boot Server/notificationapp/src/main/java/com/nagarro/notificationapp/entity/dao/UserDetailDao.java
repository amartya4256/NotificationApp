package com.nagarro.notificationapp.entity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.notificationapp.entity.UserDetail;
import com.nagarro.notificationapp.repository.UserDetailRepository;

@Component
public class UserDetailDao {

	@Autowired
	private UserDetailRepository userDetailRepo;
	
	public UserDetail getUserDetailName(String username) {
		
		return userDetailRepo.findById(username).orElse(new UserDetail());
	}
	
	public UserDetail findByUsername(String username) {
		return userDetailRepo.findById(username).orElse(new UserDetail());
	}
	
	public Iterable<UserDetail> findAllUser() {
		Iterable<UserDetail> users = userDetailRepo.findAll();
		return users;
	}
}
