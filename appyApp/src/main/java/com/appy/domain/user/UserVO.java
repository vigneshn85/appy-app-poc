package com.appy.domain.user;

import java.sql.Timestamp;

public class UserVO {

	private long userId;
	private String login;
	private String password;
	private String email;
	private String imgLocation;
	private String firstname;
	private String lastname;
	
	private Timestamp createdTimestamp;
	private Timestamp lastLoginTimestamp;
	
	public UserVO(){
		super();
	}
	
	public UserVO(long userId, String login, String password, String email,
			String imgLocation, String firstname, String lastname,
			Timestamp createdTimestamp, Timestamp lastLoginTimestamp) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.email = email;
		this.imgLocation = imgLocation;
		this.firstname = firstname;
		this.lastname = lastname;
		this.createdTimestamp = createdTimestamp;
		this.lastLoginTimestamp = lastLoginTimestamp;
	}



	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Timestamp getLastLoginTimestamp() {
		return lastLoginTimestamp;
	}

	public void setLastLoginTimestamp(Timestamp lastLoginTimestamp) {
		this.lastLoginTimestamp = lastLoginTimestamp;
	}
	
	
	
}
