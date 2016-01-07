package Main;

import com.appy.domain.StudentVO;
import com.appy.domain.UserCredentials;
import com.appy.exception.BaseException;
import com.appy.exception.ExceptionCodes;
import com.appy.service.user.login.IUserService;
import com.appy.service.user.login.UserServiceImpl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Main {
	public static void main(String args[]){
		BaseException baseException = new BaseException();
		baseException.setCode(ExceptionCodes.APP_CODE_0001);
		
		System.out.println(baseException);
	}

}
