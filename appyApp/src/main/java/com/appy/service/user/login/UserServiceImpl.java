package com.appy.service.user.login;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.appy.domain.UserCredentials;

public class UserServiceImpl implements IUserService{

	public UserServiceImpl(){
		super();
	}
	//TODO: user DB
	private static Map<String, UserCredentials> userDB = new HashMap<String, UserCredentials>();
//	static {
//		userDB.put("user1", "user1Password");
//		userDB.put("user2", "user2Password");
//	}
	public boolean validateLogin(UserCredentials userCredentials) {
		String username = userCredentials.getUsername();
		String password = userCredentials.getPassword();
		
		return UserServiceImpl.userDB.containsKey(username) && UserServiceImpl.userDB.get(username).equals(userCredentials);
	}
	
	public boolean addNewUser(UserCredentials userCredentials){
		String username = userCredentials.getUsername();
		String password = userCredentials.getPassword();
		
		if(!UserServiceImpl.userDB.containsKey(username)){
			UserServiceImpl.userDB.put(username, userCredentials);
			return true;
		}
		return false;
	}
	
	public String[] listUsers(){
		Set<String> set = UserServiceImpl.userDB.keySet();
		
		return set.toArray(new String[set.size()]);
		
	}

}
