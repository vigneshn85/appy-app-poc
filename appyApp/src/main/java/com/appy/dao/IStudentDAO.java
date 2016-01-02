package com.appy.dao;

import java.util.List;

import com.appy.domain.StudentVO;

public interface IStudentDAO {
	public StudentVO findStudentById(String studentId);
	public void addStudent(StudentVO student);
	public List<StudentVO> findAllStudents();
}
