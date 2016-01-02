package com.appy.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.appy.domain.Address;
import com.appy.domain.StudentVO;

@SuppressWarnings("rawtypes")
public class StudentRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("in student row mapper..");
		StudentVO student = new StudentVO(
				rs.getString("STUDENT_ID"),
				rs.getString("FIRST_NAME"),
				rs.getString("LAST_NAME"),
				new Address()
				);
		return student;
	}

}
