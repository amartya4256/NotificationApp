package com.nagarro.notificationapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
	
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	String name;
	int id;
	@Autowired
	private Another another;
	public Test(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Test [name=" + name + ", id=" + id + "]" + another.getData();
	}
	
	
}
