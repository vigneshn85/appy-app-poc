package com.appy.service.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.appy.business.user.form.UserFormBO;
import com.appy.business.user.form.transformer.UserObjectTransformer;
import com.appy.business.user.validator.UserFormValidator;
import com.appy.dao.user.IUserDAO;
import com.appy.domain.user.UserVO;

public class UserServiceImpl implements IUserService{
	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	private IUserDAO userDAO; 
	public boolean createUser(UserFormBO userSignupForm){
		LOGGER.debug("In create new user");
		if(UserFormValidator.isUserSignupFormValid(userSignupForm)){
			UserVO userVO = new UserVO();			
			UserObjectTransformer.createUserVO(userSignupForm, userVO); // copy contents from Form
			if(userDAO.createUser(userVO)){
				LOGGER.debug("Created user successfully");
			} else {
				LOGGER.error("Failed to create user");
			}
		}
		return true;
	}
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}
	
	@Autowired
	public void setUserDAO(IUserDAO userDAO) {
		LOGGER.debug("In setUserDAO in UserServiceImpl");
		this.userDAO = userDAO;
	}
	
	
}
