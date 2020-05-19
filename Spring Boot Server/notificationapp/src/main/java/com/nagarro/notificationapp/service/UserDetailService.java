package com.nagarro.notificationapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.notificationapp.entity.UserDetail;
import com.nagarro.notificationapp.entity.dao.UserDetailDao;

@Service
public class UserDetailService {
	@Autowired
	private UserDetailDao userDetailDao;
	
	public String getNameByUserName(String username) {
		
		return userDetailDao.getUserDetailName(username).getName();
	}
	
	public UserDetail getUserDetail(String username) {
		
		return userDetailDao.getUserDetailName(username);
	}
	
	public List<UserDetail> getAllUsers(UserDetail host){
		Iterable<UserDetail> userIterable = userDetailDao.findAllUser();
		List<UserDetail> userList = new ArrayList<UserDetail>();
		userList = StreamSupport.stream(userIterable.spliterator(), false) 
	            .collect(Collectors.toList());
		userList.remove(host);
		return userList;
	}
}
