package com.example.demo.repository.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.message;
import com.example.demo.repository.messageRepository;

@Repository
public class usersRepositoryImpl implements usersRepository {

	private static final String SQL_SAVE_MESSAGE = "insert into message (hquerId,message,postedTime) values(?,?,?)";
	private static final String SQL_FIND_MESSAGE_BY_HQUERID = "select id,hquerId,message,postedTime from message where hquerId=?";
	@Autowired
	private JdbcOperations jdbcOperations;
	@Override
	public List<users> findMessageByUserId(Long userId) {
		List<users> list=new ArrayList<users>();
		list=jdbcOperations.query(SQL_FIND_MESSAGE_BY_HQUERID, new RowMapper<users>() {

			@Override
			public users mapRow(ResultSet rs, int rowNum) throws SQLException {
				users message=new users();
				message.setHquerId(rs.getLong("hquerId"));
				message.setMessage(rs.getString("message"));
				message.setPostedTime(rs.getDate("postedTime"));
				return message;
			}
			
		}, userId);
		return list;
	}
	@Override
	public void save(users message) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_SAVE_MESSAGE, message.getHquerId(),message.getMessage(),message.getPostedTime());
	}

}
