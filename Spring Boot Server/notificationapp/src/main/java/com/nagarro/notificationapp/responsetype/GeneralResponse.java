package com.nagarro.notificationapp.responsetype;

public class GeneralResponse {

	String message;
	boolean success;
	String jwt;
	public GeneralResponse(String message, boolean success, String jwt) {
		super();
		this.message = message;
		this.success = success;
		this.jwt = jwt;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public GeneralResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	public GeneralResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
