package com.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class User {
	private int id;
	private String name;
	
	@Length(min = 8,max = 16,message = "密码长度不是8~16位")
	private String password;
	
	@Email(message = "不是正确的邮箱格式")
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 */
	public User(int id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
