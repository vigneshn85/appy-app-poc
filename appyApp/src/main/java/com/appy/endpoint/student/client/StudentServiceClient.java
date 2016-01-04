package com.appy.endpoint.student.client;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.appy.domain.Address;
import com.appy.domain.StudentVO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class StudentServiceClient {
	private String studentServiceEndPoint = "http://localhost:8080/appyApp/rest/studentApi/student";
	private String contentType = "application/json";
	
	final Logger log = Logger.getLogger(StudentServiceClient.class);
	
	private void getAllStudents(){		
		
		Client client = Client.create();
		WebResource webResource = client.resource(studentServiceEndPoint);
		
		ClientResponse response = webResource.type(contentType).get(ClientResponse.class);
		String studentOutput = response.getEntity(String.class);
		log.info("Student output:"+studentOutput);
	}
	
	private void addStudent(){
		Client client = Client.create();
		WebResource webResource = client.resource(studentServiceEndPoint);
		Address address = new Address("2101", "westford", "MA", "01886");
		StudentVO studentObj = new StudentVO("1", "vignesh", "natesan", address);
		String input = "";
		try {
			input = (new ObjectMapper()).writeValueAsString(studentObj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Creating student::" + input);
		ClientResponse response = webResource.type(contentType).post(ClientResponse.class, input);
	}
	
	private void getStudentById(String studentId){
		Client client = Client.create();
		WebResource webResource = client .resource(studentServiceEndPoint+"1"); //student created by addStudent()
		ClientResponse response = webResource.type(contentType).get(ClientResponse.class);
		String studentOutput = response.getEntity(String.class);
		log.info("Student out for Student ID - 1: " + studentOutput);
	}
	
	StudentServiceClient(){		
	}
	public static void main(String args[]){
		StudentServiceClient client = new StudentServiceClient();
		
		//Create a student
		client.addStudent();
		
		//Print all students
		client.getAllStudents();
		
		//Get student details by ID
		client.getStudentById("1");
	}
}
