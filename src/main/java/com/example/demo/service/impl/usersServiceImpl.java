package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.users;
import com.example.demo.repository.usersRepository;
import com.example.demo.service.usersService;

@Service
public class usersServiceImpl implements usersService{
	@Autowired
	usersRepository usersRepository;

	@Override
	public users login(String userName, String password) {
		users users;
		
		if((users=usersRepository.findByUserName(userName))!=null 
				&& users.getPassword().equals(password)) {
			System.out.println(users.getUserName());
			return users;
		}
		return null;
	}

	@Override
	public boolean register(users hquer) {
		if(usersRepository.findByUserName(hquer.getUserName()))==null) {
			usersRepository.save(hquer);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public users getUserDetail(String userName) {
		return usersRepository.findByUserName(userName);
	}

}
