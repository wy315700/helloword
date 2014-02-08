package com.example.manager.vo;

public class User {
	private int userId;

	private String userName;

	private String userPwd;

	private String userEmail;

	public User() {
		super();
	}

	public User(int userId, String userName, String userPwd, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}
