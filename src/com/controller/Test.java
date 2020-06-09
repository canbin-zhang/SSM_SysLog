package com.controller;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.ui.Model;



public class Test {
	
	private String id;
	private Integer inn;
	private Date time;
	
	public void test(String id,Integer inn,Date time,Model model) {
		System.out.println(id);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Test t=new Test();
		Class clazz=t.getClass();
		Method method=clazz.getMethod("test",String.class,Integer.class,Date.class,Model.class);
		System.out.println(method.getName());

	}

}
