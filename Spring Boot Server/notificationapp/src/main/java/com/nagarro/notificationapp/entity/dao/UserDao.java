package com.nagarro.notificationapp.entity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.notificationapp.entity.User;
import com.nagarro.notificationapp.repository.UserRepository;

@Service
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	
	public boolean validateCredentials(User user) {
		
		boolean retVal = false;
		
		User result = userRepository.findById(user.getUsername()).orElse(new User());
		if(user.getPassword().equals(result.getPassword())) {
			retVal = true;
		}
		return retVal;
	}
	
	public User findByUsername(String username) {
		return userRepository.findById(username).orElse(new User());
	}
}
