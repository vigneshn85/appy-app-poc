package com.appy.service.user.login;

import java.util.List;

import com.appy.domain.UserCredentials;

public interface IUserService {
	public boolean validateLogin(UserCredentials userCredentials);
	public boolean addNewUser(UserCredentials userCredentials);
	public String[] listUsers();
}
