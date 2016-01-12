package com.appy.dao.user;

import java.util.List;

import com.appy.business.user.exception.UserException;
import com.appy.domain.user.UserVO;

public interface IUserDAO {

	public boolean createUser(UserVO userVO);
	public boolean updateUserInfo(UserVO UserVO) throws UserException;
	public void createUserRole(long userId, int roleId);
	
	public int[] createUserSpecialties(long userId, List<Integer> specialties);
}
