package com.nagarro.notificationapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.notificationapp.entity.User;
import com.nagarro.notificationapp.entity.dao.UserDao;
import com.nagarro.notificationapp.responsetype.GeneralResponse;
import com.nagarro.notificationapp.util.PwdDigester;

@Service
public class LoginService {
	
	@Autowired
	PwdDigester digester;
	
	@Autowired
	UserDao userDao;
	

	@Transactional
	public GeneralResponse login(User user) {
		
		user = digester.disgestPassword(user);
		boolean loggedIn = userDao.validateCredentials(user);
		GeneralResponse response;
		if(loggedIn) {
			response = new GeneralResponse("User Successfully Logged In", true);
		}
		else {
			response = new GeneralResponse("Wrong Credentials.", false);
		}
		return response;
	}

}
