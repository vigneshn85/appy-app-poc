package com.appy.business.user.form.transformer;

import com.appy.business.user.form.UserFormBO;
import com.appy.domain.user.UserVO;

public class UserObjectTransformer {

	/**
	 * 
	 * @param userFormBO Source User Form BO received from the User Service
	 * @param userVO Copies the fields from user form BO to this VO
	 */
	public static void createUserVO(UserFormBO userFormBO, UserVO userVO){
		userVO.setLogin(new String(userFormBO.getLogin()));
		userVO.setFirstname(new String(userFormBO.getFirstname()));
		userVO.setLastname(new String(userFormBO.getLastname()));
		userVO.setEmail(new String(userFormBO.getEmail()));
		userVO.setPassword(new String(userFormBO.getPassword())); // TODO: Check if the hash should be generated here or in filter itself
	}
	
	public static void createUserVOForUserInfoUpdate(UserFormBO userFormBO, UserVO userVO){
		userVO.setFirstname(new String(userFormBO.getFirstname()));
		userVO.setLastname(new String(userFormBO.getLastname()));
		userVO.setEmail(new String(userFormBO.getEmail()));
		userVO.setUserId(userFormBO.getUserId());
	}
}
