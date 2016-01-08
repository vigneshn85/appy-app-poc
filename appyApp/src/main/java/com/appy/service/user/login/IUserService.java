package com.appy.service.user.login;

import java.util.List;

import com.appy.domain.UserCredentials;

public interface IUserService { //TODO: Rename to Login Service
	public boolean validateLogin(UserCredentials userCredentials);
	public boolean addNewUser(UserCredentials userCredentials);
	public String[] listUsers();
}
