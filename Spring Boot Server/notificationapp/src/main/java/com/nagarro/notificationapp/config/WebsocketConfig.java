package com.nagarro.notificationapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Autowired
	private CustomHandshakeHandler customHandshakeHandler;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		System.out.println("web socket running");
		registry.addEndpoint("/greeting").setAllowedOrigins("http://localhost:4200")
		.setHandshakeHandler(customHandshakeHandler);
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {

		System.out.println("websocket configured");
		registry.enableSimpleBroker("/queue");
		registry.setApplicationDestinationPrefixes("/app");
	}
}
