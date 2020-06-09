package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.User;
import com.service.UserserviceImpl;


@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserserviceImpl userserviceImpl;
	
	
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute("user")User user,BindingResult result,Model model,HttpServletResponse response) throws IOException{
		if(result.hasErrors()) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('请检查邮箱格式或者密码（长度8~16位）！');</script>");
			response.getWriter().flush();
			return "register";
		}
		return userserviceImpl.register(user, model,response);
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user,Model model,HttpServletResponse response) throws IOException {
		return userserviceImpl.login(user,model,response);
	}
	
	@RequestMapping("/")
	public String tologin() {
		return "login";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping("/forgetPwd")
	public String forgetPwd(){
		return "lookForPwd";
	}
	
	@RequestMapping("/resetPassword")
	public String resetPassword(@RequestParam String email,@RequestParam String password,Model model,HttpServletResponse response) throws IOException{
		if(userserviceImpl.resetPassword(email, password)!=0) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('密码重置成功，请登录！');</script>");
			response.getWriter().flush();
			return "login";
		}
		return "lookForPwd";
	}
	
	@RequestMapping("/users")
	public String users() {
		return "users";
	}
	
	
}
