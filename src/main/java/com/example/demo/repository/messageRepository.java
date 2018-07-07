package com.example.demo.repository;

import com.example.demo.domain.entity.users;

public interface messageRepository {
	public void save(message stu);
	public message findByUserName(String userName);
}
