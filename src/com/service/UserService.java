package com.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.pojo.User;

public interface UserService {
	public String login(User user,Model model,HttpServletResponse response) throws IOException;
	public String register(User user,Model model,HttpServletResponse response) throws IOException;
	public int resetPassword(String email,String password);
}
