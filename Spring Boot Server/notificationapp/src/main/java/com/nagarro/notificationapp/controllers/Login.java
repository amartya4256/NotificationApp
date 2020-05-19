package com.nagarro.notificationapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.notificationapp.entity.User;
import com.nagarro.notificationapp.responsetype.GeneralResponse;
import com.nagarro.notificationapp.service.ClientUserDetailService;
import com.nagarro.notificationapp.service.LoginService;
import com.nagarro.notificationapp.util.JwtTokenUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class Login {
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	ClientUserDetailService clientUserDetails;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(value = "/authenticate")
	public GeneralResponse createAuthenticationToken(@RequestBody User user) throws Exception{
		System.out.println(user.getUsername() + user.getPassword());
		GeneralResponse response = loginservice.login(user);
		if(response.isSuccess()) {
			final UserDetails userDetails = clientUserDetails.loadUserByUsername(user.getUsername());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			response.setJwt(jwt);
		}
		return response;
		
	}
}
