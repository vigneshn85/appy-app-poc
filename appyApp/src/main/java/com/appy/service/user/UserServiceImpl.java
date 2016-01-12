package com.appy.service.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.appy.business.user.exception.UserException;
import com.appy.business.user.form.UserFormBO;
import com.appy.business.user.form.transformer.UserObjectTransformer;
import com.appy.business.user.validator.UserFormValidator;
import com.appy.dao.user.IUserDAO;
import com.appy.domain.user.UserVO;
import com.appy.exception.BaseException;
import com.appy.exception.ExceptionCodes;
import com.appy.utils.AppyAppConstants;

public class UserServiceImpl implements IUserService{
	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	private IUserDAO userDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean createUser(UserFormBO userSignupForm){
		LOGGER.debug("In create new user");
		if(UserFormValidator.isUserSignupFormValid(userSignupForm)){
			UserVO userVO = new UserVO();			
			UserObjectTransformer.createUserVO(userSignupForm, userVO); // copy contents from Form
			
			userDAO.createUser(userVO);
			LOGGER.debug("UserID in the service.. " + userVO.getUserId());
			userDAO.createUserRole(userVO.getUserId(), userSignupForm.getRoleId());
			if(userSignupForm.getRoleId() == AppyAppConstants.DOCTOR_ROLE_ID){
				if(userSignupForm.getSpecialties().size() > 0){
					LOGGER.debug("Has specialties..");
					/* TODO: Check below
					 * Below line will do a batch insert of all the specialties.
					 * Since this code is wrapped in a transaction, if an invalid specialtyID is passed in, the entire
					 * transaction is rolled back i.e, the user, user_role etc..
					 * 
					 * If we don't want that behavior (i.e, ignore the invalid specialtyID's) then wrap the below line
					 * in a try catch and eat the exception
					 */
					userDAO.createUserSpecialties(userVO.getUserId(), userSignupForm.getSpecialties());
					
					LOGGER.debug("created user specialities: ");
				}
				
			}
			
		}
		return true;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean updateUserInfo(UserFormBO userUpdateInfoForm) throws UserException{
		LOGGER.debug("In user info");
		if(UserFormValidator.isUserUpdateInfoFormValid(userUpdateInfoForm)){
			UserVO userVO = new UserVO();			
			UserObjectTransformer.createUserVOForUserInfoUpdate(userUpdateInfoForm, userVO); // copy contents from Form
		
			if(userDAO.updateUserInfo(userVO))
				LOGGER.debug("User info updated successfully");
			return true;
		}
		
		throw new UserException("UPDATE", "FORM_INVALID");
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
