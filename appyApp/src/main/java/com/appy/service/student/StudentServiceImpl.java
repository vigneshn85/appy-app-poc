package com.appy.service.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.appy.domain.StudentVO;

public class StudentServiceImpl implements IStudentService{

	public StudentServiceImpl(){
		super();
	}
	//TODO: user DB
	private static Map<String, StudentVO> studentDB = new HashMap<String, StudentVO>();
	
	public boolean addStudent(StudentVO student) {
		String studentId = student.getStudentId();
		if(StudentServiceImpl.studentDB.containsKey(studentId))
			return false;
		StudentServiceImpl.studentDB.put(studentId, student);
		return true;		
	}

	public StudentVO findStudent(String studentId) {
		return StudentServiceImpl.studentDB.get(studentId);
	}
	
	public List<StudentVO> getStudents(){
		Set<String> set = StudentServiceImpl.studentDB.keySet();
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		for(String key : set){
			studentList.add(StudentServiceImpl.studentDB.get(key));
		}
		return studentList;
		
	}

}
