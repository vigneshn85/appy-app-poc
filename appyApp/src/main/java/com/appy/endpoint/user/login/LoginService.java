package com.appy.endpoint.user.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.appy.domain.UserCredentials;
import com.appy.service.user.login.IUserService;

@Path("/user")
public class LoginService {

	private IUserService userService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response listUsernames(){
		return Response.status(200).entity(userService.listUsers()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response login() {
		UserCredentials user = new UserCredentials("user1", "user1Password", null);
		System.out.println("in the login service...");
		int returnStatus ;
		if(userService.validateLogin(user))
			returnStatus = 200;
		else
			returnStatus = 405;
		System.out.println("Here.. ");
		return Response.status(returnStatus).entity(user).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response addUser(@RequestParam("form") UserCredentials user){	//@RequestParam("form")
		int returnStatus ;
		System.out.println("In addUser..");
		System.out.println("username:"+user.getUsername());
		System.out.println("password:"+user.getPassword());
		System.out.println("email:"+user.getEmail());
		if(userService.addNewUser(user))
			returnStatus = 200;
		else
			returnStatus = 405;
		return Response.status(returnStatus).entity(user).build();
	}
	
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
	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		System.out.println("in the setUserService..");
		this.userService = userService;
	}
	
	
}
