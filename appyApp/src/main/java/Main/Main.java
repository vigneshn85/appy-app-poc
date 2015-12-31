package Main;

import com.appy.domain.StudentVO;
import com.appy.domain.UserCredentials;
import com.appy.service.user.login.IUserService;
import com.appy.service.user.login.UserServiceImpl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Main {
	public static void main(String args[]){
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/appyApp/rest/studentApi/student/121");
		
		ClientResponse response = webResource.type("application/json")
                .get(ClientResponse.class);
		String studentOutput = response.getEntity(String.class);
		System.out.println("Student output:"+studentOutput);
//		IUserService userService = new UserServiceImpl();
//		UserCredentials userCredential = new UserCredentials("use", "userPassword", null);
//		if(userService.validateLogin(userCredential))
//			System.out.println("Valid user credentials");
//		else
//			System.out.println("Invalid user credentials");
	}
}
