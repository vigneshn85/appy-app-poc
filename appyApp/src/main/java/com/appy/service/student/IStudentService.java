package com.appy.service.student;

import java.util.List;

import com.appy.domain.StudentVO;

public interface IStudentService {

	public boolean addStudent(StudentVO student);
	public StudentVO findStudent(String studentId);
	public List<StudentVO> getStudents();
}
