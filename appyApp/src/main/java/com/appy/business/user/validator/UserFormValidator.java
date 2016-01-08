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
}
