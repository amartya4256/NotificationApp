package com.nagarro.notificationapp.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.notificationapp.entity.Event;
import com.nagarro.notificationapp.entity.UserDetail;
import com.nagarro.notificationapp.entity.dummy.EventDummy;
import com.nagarro.notificationapp.responsetype.GeneralResponse;
import com.nagarro.notificationapp.service.EventService;
import com.nagarro.notificationapp.service.UserDetailService;
import com.nagarro.notificationapp.util.JwtTokenUtil;

@RestController
public class EventCreator {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@PostMapping(value = "/create-event")
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
	public GeneralResponse createEvent(@RequestBody EventDummy eventDummy, HttpServletRequest request) {
		String auth = request.getHeader("Authorization");
		String jwt = auth.substring(7);
		String username = jwtUtil.getUsernameFromToken(jwt);
		
		String name = userDetailService.getNameByUserName(username);
		Set<UserDetail> target = new HashSet<>();
		for(String targetUsername : eventDummy.getTarget()) {
			UserDetail targetUser = userDetailService.getUserDetail(targetUsername);
			if(targetUser.getUsername() == null) {
				return new GeneralResponse("One or more target user not found.", false);
			}
			target.add(targetUser);
		}
		
		Event event = new Event(eventDummy.getType(), eventDummy.getSubject(), 
				eventDummy.getContent(), 
				eventDummy.getDate(), name, target);
		
		int id = eventService.saveEvent(event);
		
		
		return new GeneralResponse("Your event id is "+id, true);
	}
	
	@GetMapping("/user-list")
	public List<UserDetail> getUserList(HttpServletRequest request) {
		String auth = request.getHeader("Authorization");
		String jwt = auth.substring(7);
		String username = jwtUtil.getUsernameFromToken(jwt);
		
		UserDetail host = userDetailService.getUserDetail(username);
		
		return userDetailService.getAllUsers(host);
	}
}
