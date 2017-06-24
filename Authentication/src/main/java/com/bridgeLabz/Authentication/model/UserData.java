package com.bridgeLabz.Authentication.model;

public class UserData {

	private String userName;
	private String password;
	
	
	public UserData(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "UserData [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
