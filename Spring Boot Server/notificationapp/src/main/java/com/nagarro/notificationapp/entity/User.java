package com.nagarro.notificationapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_credentials")
public class User {

		@Id
		@Column(name = "username")
		String username;
		
		@Column(name = "password")
		String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public User() {
			super();
		}
		
		
}
