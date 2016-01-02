package com.appy.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appy.dao.IStudentDAO;
import com.appy.domain.StudentVO;

public class StudentServiceImpl implements IStudentService{

	private IStudentDAO studentDAO ;
	public StudentServiceImpl(){
		super();
	}
	public boolean addStudent(StudentVO student) {
		studentDAO.addStudent(student);
		System.out.println("Added student");
		return true;		
	}

	public StudentVO findStudent(String studentId) {
		System.out.println("Finding student by id.."+studentId);
		StudentVO student = studentDAO.findStudentById(studentId);
		System.out.println("Received Student info from DB:" + student );
		return student;
	}
	
	public List<StudentVO> getStudents(){
		System.out.println("In getStudents..");
		return studentDAO.findAllStudents();
	}

	public IStudentDAO getStudentDAO() {
		return studentDAO;
	}

	@Autowired
	public void setStudentDAO(IStudentDAO studentDAO) {
		System.out.println("in setStudentAO");
		this.studentDAO = studentDAO;
	}

	
}
