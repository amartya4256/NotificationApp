package com.nagarro.notificationapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
public class UserDetail {
	
	@Id
	@Column
	String username;
	
	@Column
	String Name;
	
	@Column
	String email;
	
	@OneToOne
	User user;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDetail(String username, String name, String email, User user) {
		super();
		this.username = username;
		Name = name;
		this.email = email;
		this.user = user;
	}

	public UserDetail() {
		super();
	}
	
}
