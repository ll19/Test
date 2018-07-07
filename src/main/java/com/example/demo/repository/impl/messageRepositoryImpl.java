package com.example.demo.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.users;
import com.example.demo.repository.usersRepository;

@Repository
public class messageRepositoryImpl implements messageRepository {
	private static final String SQL_INSERT_HQUER = "insert into hquer (firstname,lastname,username,email,password) values(?,?,?,?,?)";
	private static final String SQL_FIND_HQUER = "select id,firstname,lastname,username,email,password from hquer where username=?";
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public void save(users users) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_HQUER, users.getFirstName(), users.getLastName(), host.getUserName(),
				users.getEmail(), users.getPassword());
	}

	@Override
	public users findByUserName(String userName) {
		List<users> list = new ArrayList<users>();
		list = jdbcOperations.query(SQL_FIND_HQUER, new RowMapper<users>() {

			@Override
			public users mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				users host = new users();
				users.setId(rs.getLong("id"));
				users.setFirstName(rs.getString("firstname"));
				users.setLastName(rs.getString("lastname"));
			    users.setUserName(rs.getString("username"));
				users.setEmail(rs.getString("email"));
				users.setPassword(rs.getString("password"));
				return users;
			}

		}, userName);
		
		if (list.size() >= 1) {
			return list.get(0);
		} else
			return null;
	}
}
