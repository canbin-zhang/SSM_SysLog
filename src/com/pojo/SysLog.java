package com.pojo;

import java.lang.reflect.Method;
import java.util.Date;


public class SysLog {
	private int id;
	private Date visittime;
	private String ip;
	private String method;
	private String url;
	/**
	 * @param id
	 * @param vistitime
	 * @param ip
	 * @param user
	 * @param method
	 * @param url
	 */
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "SysLog [id=" + id + ", vistitime=" + visittime + ", ip=" + ip + ", method=" + method + ", url=" + url
				+ "]";
	}
	/**
	 * @param id
	 * @param vistitime
	 * @param ip
	 * @param method
	 * @param url
	 */
	
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 * @param visittime
	 * @param ip
	 * @param method
	 * @param url
	 */
	public SysLog(int id, Date visittime, String ip, String method, String url) {
		super();
		this.id = id;
		this.visittime = visittime;
		this.ip = ip;
		this.method = method;
		this.url = url;
	}
	public Date getVisittime() {
		return visittime;
	}
	public void setVisittime(Date visittime) {
		this.visittime = visittime;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @param id
	 * @param vistitime
	 * @param ip
	 * @param user
	 * @param method
	 */
	
	/**
	 * 
	 */
	public SysLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
