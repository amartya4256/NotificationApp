package com.nagarro.notificationapp.config;

import java.security.Principal;

public class StompPrincipal implements Principal {

	private String name;

	public StompPrincipal(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
