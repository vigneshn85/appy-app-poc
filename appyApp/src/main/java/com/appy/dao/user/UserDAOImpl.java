package com.appy.dao.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.appy.business.user.exception.UserException;
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

		String SELECT_USER_ID_SQL = "SELECT user_id from user where login=?";
		List<Map<String, Object>> userIdQueryResult = jdbcTemplate.queryForList(SELECT_USER_ID_SQL, new Object[]{
				userVO.getLogin()
		});

		for(Map<String, Object> row : userIdQueryResult){
			userVO.setUserId((Integer)row.get("user_id"));			
		}
		LOGGER.debug("After the update statement.."+ userVO.getLogin());


		return true;
	}

	public void createUserRole(long userId, int roleId){
		LOGGER.debug("In create user role. UserId: " + userId + ", roleId:" + roleId);
		String CREATE_USER_ROLE_SQL = "INSERT INTO user_role "+
				"(user_id, role_id) VALUES "+
				"(?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(CREATE_USER_ROLE_SQL, new Object[] { userId, roleId });
		LOGGER.debug("After the creating user role..");
	}

	public int[] createUserSpecialties(final long userId, final List<Integer> specialties){
		LOGGER.debug("In create user specialties");
		String CREATE_USER_SPECIALITES = "INSERT INTO USER_SPECIALTIES (USER_ID, SPECIALTY_ID) VALUES (?, ?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		return jdbcTemplate.batchUpdate(CREATE_USER_SPECIALITES, new BatchPreparedStatementSetter(){
			public void setValues(PreparedStatement ps, int i) throws SQLException
					 {
				ps.setLong(1, userId);
				ps.setInt(2, specialties.get(i));
				
			}

			public int getBatchSize() {
				return specialties.size();
			}
		});		
	}

	public boolean updateUserInfo(UserVO userVO) throws UserException{
		LOGGER.debug("In create user DAO Impl:" + userVO.getLogin());
		String USER_INFO_UPDATE_SQL = "UPDATE user SET "+
				"firstname = ?, " +
				"lastname = ?, " +
				"email = ? " +
				"WHERE user_id=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		int numberOfRowsUpdated = -1;
		try{
			numberOfRowsUpdated = jdbcTemplate.update(USER_INFO_UPDATE_SQL, new Object[] { 
					userVO.getFirstname(),
					userVO.getLastname(),
					userVO.getEmail(),
					userVO.getUserId()
			});
		}catch(DataAccessException da){
			da.printStackTrace();

		}
		if(numberOfRowsUpdated == 0){
			throw new UserException("UPDATE_USER", "NO_USER_UPDATED");
		}
		LOGGER.debug("After the update statement.."+ userVO.getUserId());
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
