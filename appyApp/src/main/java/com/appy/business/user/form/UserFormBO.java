package com.appy.business.user.form;

public class UserFormBO {
	private long userId;
	private String login;
	private String password;
	private String confirmPassword;
	private String email;
	private String firstname;
	private String lastname;
	
	public UserFormBO(){
		super();
	}
	
	public UserFormBO(long userId, String login, String password,
			String confirmPassword, String email, String firstname,
			String lastname) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
}
