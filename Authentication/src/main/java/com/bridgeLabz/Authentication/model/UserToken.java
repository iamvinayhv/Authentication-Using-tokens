package com.bridgeLabz.Authentication.model;

public class UserToken {

	private UserData user;
	private Token token;
	
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	
	
}
