package com.cabinet.AnXin_file.beans;

import com.cabinet.AnXin_file.entity.UserEntity;

public class LoginInfo {

	private UserEntity user;
	private String token;
	private long loginTime;
	
	public LoginInfo(UserEntity user, String token, long loginTime) {
		this.user = user;
		this.token = token;
		this.loginTime = loginTime;
	}
	
	public void refresh(String token, long loginTime) {
		this.token = token;
		this.loginTime = loginTime;
	}
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	
}
