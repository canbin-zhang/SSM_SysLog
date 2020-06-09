package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.pojo.User;

@Repository
@Mapper
public interface UserDao {
	public User queryUserByName(String name);
	public User queryUserByEmail(String email);
	public int addUser(User user);
	public int resetPassword(@Param("email")String email,@Param("password")String password);
}
