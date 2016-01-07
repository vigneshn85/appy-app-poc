package com.appy.endpoint.student;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.appy.domain.StudentVO;
import com.appy.exception.BaseException;
import com.appy.exception.ExceptionCodes;
import com.appy.service.student.IStudentService;

@Path("/studentApi")
public class StudentService {

	private IStudentService studentService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/student")
	public Response addStudent(@RequestParam("form") StudentVO student){	//@RequestParam("form")
		System.out.println("In add Student rest endpoint.." + student);
		int returnStatus = 200;
		System.out.println("studentService null?" + (studentService == null));		
		if(!studentService.addStudent(student))
			returnStatus = 405;
		System.out.println("Return status: "+ returnStatus);
		return Response.status(returnStatus).entity(student).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/student/{studentId}")
	public Response getStudent(@PathParam("studentId")String studentId){
		System.out.println("Student ID:"+studentId);
		StudentVO studentObj = studentService.findStudent(studentId);
		if(studentObj == null){
			BaseException baseException = new BaseException(ExceptionCodes.APP_CODE_0001);			
			return Response.status(203).entity(baseException).build(); //TODO:check the correct code
		}		
		return Response.status(200).entity(studentObj).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/student")
	public Response getStudents(){
		
		return Response.status(200).entity(studentService.getStudents()).build();
	}
	
	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
		System.out.println("In setStudentService..");
	}
	
}
