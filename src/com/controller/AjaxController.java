package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.pojo.User;


@RestController
@RequestMapping("/Ajax")
public class AjaxController {
	
	@Autowired
	private UserDao userdao;
	
	@PostMapping("/verifyname")
	public String verifyname(String name) {
		User user=userdao.queryUserByName(name);
		if(user==null) {
			return "OK";
		}else return "该用户名已存在";
	
	}
	
	@PostMapping("/verifyemail")
	public String verifyemail(@Valid @ModelAttribute("User") User user,BindingResult result) {
		if(result.hasErrors()) {
			return result.getFieldErrors().get(0).getDefaultMessage();
		}
		User u=userdao.queryUserByEmail(user.getEmail());
		if(u==null) {
			return "OK";
		}
		else return "该邮箱已被注册";
	}
	
	@PostMapping("/verifyEmailByRegister")
	public String verifyEmailByRegister(String email) {
		User user=userdao.queryUserByEmail(email);
		if(user==null) {
			return "该邮箱尚未注册";
		}
		else return "OK";
	}
	@PostMapping("/verifypassword")
	public String verifypassword(@Valid @ModelAttribute("User") User user,BindingResult result) {
		if(result.hasErrors()) {
			return result.getFieldErrors().get(0).getDefaultMessage();
		}
		else return "OK";
	}
	@PostMapping("/verifypassword2")
	public String verifypassword2(String password,String password2) {
		if(password.equals(password2)) {
			return "OK";
		}
		else return "两个密码不一致";
	}
	
}
