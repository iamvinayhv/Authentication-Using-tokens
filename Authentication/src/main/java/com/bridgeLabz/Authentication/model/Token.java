package com.bridgeLabz.Authentication.model;

import java.util.Date;

public class Token {

	private String accessToken;
	private long accessExpireTime;
	private String refreshToken;
	private long refreshExpireTime;
	private UserData user;
	
	private Date createdOn = new Date();
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public long getAccessExpireTime() {
		return accessExpireTime;
	}
	public void setAccessExpireTime(long accessExpireTime) {
		this.accessExpireTime = accessExpireTime;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public long getRefreshExpireTime() {
		return refreshExpireTime;
	}
	public void setRefreshExpireTime(long refreshExpireTime) {
		this.refreshExpireTime = refreshExpireTime;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	@Override
	public String toString() {
		return "Token [accessToken=" + accessToken + ", accessExpireTime=" + accessExpireTime + ", refreshToken="
				+ refreshToken + ", refreshExpireTime=" + refreshExpireTime + ", user=" + user + ", createdOn="
				+ createdOn + "]";
	}
	
	
}
