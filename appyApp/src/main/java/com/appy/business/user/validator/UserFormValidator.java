package com.appy.business.user.validator;



import org.apache.commons.lang.StringUtils;

import com.appy.business.user.form.UserFormBO;

public class UserFormValidator {

	public static boolean isUserSignupFormValid(UserFormBO userSignupForm){
		//TODO: validate email pattern
		return 	StringUtils.isNotBlank(userSignupForm.getLogin()) && 
				StringUtils.equals(userSignupForm.getPassword(), userSignupForm.getConfirmPassword()) &&			
				StringUtils.isNotBlank(userSignupForm.getEmail());
	}
	
	public static boolean isUserUpdateInfoFormValid(UserFormBO updateUserInfoForm){
		return 	updateUserInfoForm.getUserId() != -1 &&
				StringUtils.isNotBlank(updateUserInfoForm.getFirstname()) &&
				StringUtils.isNotBlank(updateUserInfoForm.getLastname()) &&
				StringUtils.isNotBlank(updateUserInfoForm.getEmail());
	}
}
