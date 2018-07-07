package com.example.demo.repository;

import java.util.List;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Message;

public interface usersRepository {
	
	public List<users> findMessageByUserId(Long userId);
	public void save(users message);

}
