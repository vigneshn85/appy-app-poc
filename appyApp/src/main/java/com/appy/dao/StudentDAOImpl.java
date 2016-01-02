package com.appy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.appy.dao.rowMapper.StudentRowMapper;
import com.appy.domain.StudentVO;

public class StudentDAOImpl implements IStudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public StudentVO findStudentById(String studentId) {
		
		String sql = "SELECT * FROM student_tbl WHERE student_id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		StudentVO student = null;
		try{
			student = (StudentVO)jdbcTemplate.queryForObject(sql, new Object[] { studentId }, new StudentRowMapper());
		}catch(Exception e){
			System.out.println("Student not found with ID:"+studentId);
			//TODO: Handle error conditions..
		}
		System.out.println("Received student info from jdbcTemplate:"+student);
		return student;
	}
	public void addStudent(StudentVO student){
		String sql = "INSERT INTO student_tbl "+
				"(student_id, first_name, last_name) VALUES "+
				"(?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { student.getStudentId(),
				student.getFirstname(), student.getLastname() 
				});
	}
	public List<StudentVO> findAllStudents(){
		System.out.println("Find all student..");
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM student_tbl";
		
		List<StudentVO> studentVOList = new ArrayList<StudentVO>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for(Map row : rows){
			StudentVO student = new StudentVO();
			student.setStudentId((String) row.get("STUDENT_ID"));
			student.setFirstname((String) row.get("FIRST_NAME"));
			student.setLastname((String) row.get("LAST_NAME"));
			
			studentVOList.add(student);
		}
		System.out.println("Found "+ studentVOList.size() + " student records..");
		return studentVOList;
	}
	
	
	/**
	 * Setters & getters
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
}
