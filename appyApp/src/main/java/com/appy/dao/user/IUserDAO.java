package com.appy.dao.user;

import com.appy.business.user.exception.UserException;
import com.appy.domain.user.UserVO;

public interface IUserDAO {

	public boolean createUser(UserVO userVO);
	public boolean updateUserInfo(UserVO UserVO) throws UserException;
}
