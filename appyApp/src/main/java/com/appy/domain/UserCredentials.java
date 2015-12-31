package com.appy.domain;

public class UserCredentials {
	private String username;
	private String password;
	private String email;
	
	// It is a must to have a default no-args constructor
	public UserCredentials(){
		super();
	}
	public UserCredentials(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = (email == null || email.isEmpty() ? username + "@gmail.com" : email);
	}
	
	/** 
	 * Setters & Getters 
	 */
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString(){
		return "username: " + this.username + ", password:" + this.password;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof UserCredentials)) {
			return false;
		}
		
		UserCredentials userCredentials = (UserCredentials)o;
		return this.username.equals(userCredentials.username) && this.password.equals(userCredentials.password);
	}
}
