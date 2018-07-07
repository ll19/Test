package com.example.demo.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.hqu.javaee.chapter7_1.Chapter71Application;
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.service.HquerService;
import cn.edu.hqu.javaee.chapter7_1.web.controller.FormEntity.User;

@Controller
@RequestMapping("/hquer")
public class HquerController {
	@Autowired 
	usersService hquerService;
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new users());
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegister(@Valid users users,Errors errors,RedirectAttributes model) throws IOException {
		if(errors.hasErrors())
			return "register";
		else if(!hquerService.register(hquer)) {
			errors.rejectValue("userName", "用户已存在");
			return "register";
		}
		else {
			Files.copy(hquer.getPic().getInputStream(), Paths.get(Chapter71Application.ROOT, hquer.getUserName()+".jpeg"),StandardCopyOption.REPLACE_EXISTING);
			model.addFlashAttribute(hquer);
			return "redirect:/hquer/"+hquer.getUserName();
		}
	}
	
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String hquerProfile(@PathVariable String userName,Model model) {
		if(!model.containsAttribute("users")) {
			Hquer hquer=hquerService.getUserDetail(userName);
			model.addAttribute(hquer);
		}
		return "hquer_profile";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new User());
		return "login";
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String processLogin(@Valid User user,Errors erros,RedirectAttributes model) {
		users users;
		if((users=usersService.login(user.getUserName(), user.getPassword()))==null)
			return "login";
		
		model.addFlashAttribute(users);
		return "redirect:/users/"+users.getUserName();
		
	}
}