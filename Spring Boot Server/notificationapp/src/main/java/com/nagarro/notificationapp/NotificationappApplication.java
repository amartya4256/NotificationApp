package com.nagarro.notificationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nagarro.notificationapp.util.Test;

@SpringBootApplication
public class NotificationappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NotificationappApplication.class, args);
		System.out.println(context.getBean(Test.class));
	}

}
