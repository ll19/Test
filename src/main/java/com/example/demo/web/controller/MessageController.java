package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Message;
import cn.edu.hqu.javaee.chapter7_1.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	messageService messageService;
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String getMessageList(@PathVariable String userName,Model model) {
		List<users> msgList=messageService.getMessageByUserName(userName);
		model.addAttribute("msgList", msgList);
		model.addAttribute("userName",userName);
		return "msg_list";
	}

}
