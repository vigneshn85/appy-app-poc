package com.appy.dao.user;

import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.appy.domain.user.UserVO;

public class UserDAOImpl implements IUserDAO{
	private Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public boolean createUser(UserVO userVO) {
		LOGGER.debug("In create user DAO Impl:" + userVO.getLogin());
		String INSERT_SQL = "INSERT INTO user "+
				"(login,firstname,lastname,password,email,date_joined,last_login) VALUES "+
				"(?,?,?,?,?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(INSERT_SQL, new Object[] { 
				userVO.getLogin(),
				userVO.getFirstname(),
				userVO.getLastname(),
				userVO.getPassword(),
				userVO.getEmail(),
				new Date(),
				new Date()
				});
		LOGGER.debug("After the update statement.."+ userVO.getLogin());
		
		
		return true;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		LOGGER.debug("in setDataSource in UserDAOImpl..");
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}
