package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.entity.message;

public interface messageService {
	public List<message> getMessageByUserName(String userName);
	public void saveMessage(message message);

}
