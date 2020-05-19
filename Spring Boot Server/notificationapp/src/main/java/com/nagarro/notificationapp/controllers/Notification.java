package com.nagarro.notificationapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.notificationapp.entity.UserNotification;
import com.nagarro.notificationapp.responsetype.StatusResponse;
import com.nagarro.notificationapp.service.NotificationService;
import com.nagarro.notificationapp.util.JwtTokenUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class Notification {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping(value = "/is-unread")
	public StatusResponse isUnread( HttpServletRequest request) {
		
		StatusResponse response = new StatusResponse(false);
		
		String auth = request.getHeader("Authorization");
		String jwt = auth.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwt);
		
		Boolean unread = notificationService.isUnread(username);
		if(unread) {
			response.setStatus(true);
		}
		
		return response;
	}
	
	@GetMapping(value = "/read-notifications")
	public List<UserNotification> getNotifications(HttpServletRequest request){
		String auth = request.getHeader("Authorization");
		String jwt = auth.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwt);
		
		return notificationService.getNotifications(username);
	}
	
	@GetMapping(value = "/clear-notifications")
	public StatusResponse clearNotifications(HttpServletRequest request){
		String auth = request.getHeader("Authorization");
		String jwt = auth.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwt);
		
		notificationService.clearNotifications(username);
		
		return new StatusResponse(true);
	}
}
