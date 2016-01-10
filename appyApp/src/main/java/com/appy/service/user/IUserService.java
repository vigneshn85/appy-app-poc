package com.appy.service.user;

import com.appy.business.user.exception.UserException;
import com.appy.business.user.form.UserFormBO;
import com.appy.exception.BaseException;

public interface IUserService {

	public boolean createUser(UserFormBO userSignupForm);
	public boolean updateUserInfo(UserFormBO userUpdateInfoForm) throws UserException;
}
