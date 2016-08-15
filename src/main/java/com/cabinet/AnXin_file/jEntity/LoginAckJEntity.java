package com.cabinet.AnXin_file.jEntity;

public class LoginAckJEntity {

	private int err;
	private String msg;
	private String token;
	private int validTime;
	
	public LoginAckJEntity(int err, String msg, String token, int validTime) {
		this.err = err;
		this.msg = msg;
		this.token = token;
		this.validTime = validTime;
	}
	
	public int getErr() {
		return err;
	}
	public void setErr(int err) {
		this.err = err;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getValidTime() {
		return validTime;
	}

	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}		
	
}
