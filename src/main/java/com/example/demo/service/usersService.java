package com.example.demo.service;

import com.example.demo.domain.entity.users;

public interface usersService {
	public users login(String userName,String password);
	public boolean register(users hquer);
	public users getUserDetail(String userName);
}
