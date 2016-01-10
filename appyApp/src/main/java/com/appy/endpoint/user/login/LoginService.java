package com.appy.endpoint.user.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.appy.business.user.exception.UserException;
import com.appy.business.user.form.UserFormBO;
import com.appy.domain.UserCredentials;
import com.appy.exception.BaseException;
import com.appy.exception.ExceptionCodes;
import com.appy.service.user.IUserService;

@Path("/user")
public class LoginService {

	private Logger LOGGER = Logger.getLogger(LoginService.class);
//	private IUserService userService;
	private IUserService userService;
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/list")
//	public Response listUsernames(){
//		return Response.status(200).entity(userService.listUsers()).build();
//	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/signup")
	public Response userSignup(@RequestParam("form") UserFormBO userSignupForm){
		LOGGER.debug("in createUser endpoint");
		if(userService.createUser(userSignupForm)){
			return Response.status(200).entity(userSignupForm).build();
		}
		return Response.status(403).entity(new BaseException(ExceptionCodes.APP_CODE_0002)).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/signup/{userId}")
	public Response userInfoUpdate(	@RequestParam("form") UserFormBO userInfoUpdateForm, 
									@PathParam("userId")long userId){
		LOGGER.debug("in userInfoUpdate endpoint for userID:" + userId);
		userInfoUpdateForm.setUserId(userId);
		try {
			userService.updateUserInfo(userInfoUpdateForm);
			return Response.status(200).entity(userInfoUpdateForm).build();			
		} catch (UserException e) {
			e.printStackTrace();
			ExceptionCodes code = null;
			if(e.getFieldFailure().equals("NO_USER_UPDATED"))
				code = ExceptionCodes.APP_CODE_0003;
			else if (e.getFieldFailure().equals("FORM_INVALID"))
				code = ExceptionCodes.APP_CODE_0004;
			BaseException b = new BaseException(code);
			return Response.status(403).entity(b).build();				
		}	
	}

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/login")
//	public Response login() {
//		UserCredentials user = new UserCredentials("user1", "user1Password", null);
//		System.out.println("in the login service...");
//		int returnStatus ;
//		if(userService.validateLogin(user))
//			returnStatus = 200;
//		else
//			returnStatus = 405;
//		System.out.println("Here.. ");
//		return Response.status(returnStatus).entity(user).build();
//	}
//	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/login")
//	public Response addUser(@RequestParam("form") UserCredentials user){	//@RequestParam("form")
//		int returnStatus ;
//		System.out.println("In addUser..");
//		System.out.println("username:"+user.getUsername());
//		System.out.println("password:"+user.getPassword());
//		System.out.println("email:"+user.getEmail());
//		if(userService.addNewUser(user))
//			returnStatus = 200;
//		else
//			returnStatus = 405;
//		return Response.status(returnStatus).entity(user).build();
//	}
	
//	public Response addUser(@FormParam("username") String username,
//			@FormParam("password") String password,
//			@FormParam("email")String email){
//		int returnStatus ;
//		
//		UserCredentials user = new UserCredentials(username, password, email);
//		System.out.println("in the add user service..."+user);
//		if(userService.addNewUser(user))
//			returnStatus = 200;
//		else
//			returnStatus = 405;
//		
//		System.out.println("Return status:"+returnStatus);
//		return Response.status(returnStatus).entity(user).build();
//	}
	
	/**
	 * Setters & Getters 
	 */
	
	
//	public IUserService getUserService() {
//		return userService;
//	}
//
//	@Autowired
//	public void setUserService(IUserService userService) {
//		System.out.println("in the setUserService..");
//		this.userService = userService;
//	}
	
	
}
