package com.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;

@Service
public class UserserviceImpl implements UserService {
	
	

	@Autowired
	private UserDao userdao;


	@Override
	public String login(User user,Model model,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		User u=userdao.queryUserByName(user.getName());
		if(u==null) {
			response.getWriter().write("<script>alert('无该用户信息，请检查用户名或者重新登录！');</script>");
			response.getWriter().flush();
			return "/login";
		}
		if(u.getPassword().equals(user.getPassword())) {
			model.addAttribute("User",user);
			return "/success";
		}
		response.getWriter().write("<script>alert('密码错误，请重新登录！');</script>");
		response.getWriter().flush();
		return "/login";
	}

	@Override
	public String register(User user, Model model,HttpServletResponse response) throws IOException {
		//判断用户名是否已被使用
		User u=userdao.queryUserByName(user.getName());
		if(u!=null) {
			response.getWriter().write("<script>alert('该用户名已存在！');</script>");
			response.getWriter().flush();
			return "/register";
		}
		//判断邮箱是否已被使用
		User u2=userdao.queryUserByEmail(user.getEmail());
		if((u2!=null)) {
			response.getWriter().write("<script>alert('该邮箱已被使用！');</script>");
			response.getWriter().flush();
			return "/register";
		}
		userdao.addUser(user);
		response.getWriter().write("<script>alert('注册成功，请登录！');</script>");
		response.getWriter().flush();
		return "/login";
	}
	@Override
	public int resetPassword(String email, String password) {
		return userdao.resetPassword(email, password);
	}
}
