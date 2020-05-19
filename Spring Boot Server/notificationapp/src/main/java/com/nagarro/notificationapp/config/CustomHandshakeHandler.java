package com.nagarro.notificationapp.config;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import com.nagarro.notificationapp.util.JwtTokenUtil;

@Component
class CustomHandshakeHandler extends DefaultHandshakeHandler {
	
	@Autowired
	JwtTokenUtil jwtTokenUtil; 
	
    // Custom class for storing principal
   @Override
   protected Principal determineUser(ServerHttpRequest request,
		WebSocketHandler wsHandler, Map<String, Object> attributes) {
	   
	   String jwt = request.getHeaders().getFirst("Cookie").toString().substring(10);
	   System.out.println(jwt);
	   String username = jwtTokenUtil.getUsernameFromToken(jwt);
	   
	   return new StompPrincipal(username);
}
}
