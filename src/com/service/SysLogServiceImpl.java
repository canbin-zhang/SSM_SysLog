package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SysLogDao;
import com.pojo.SysLog;
import com.sun.xml.internal.ws.developer.Serialization;

@Service
public class SysLogServiceImpl implements SysLogService{
	@Autowired
	private SysLogDao syslogdao;
	@Override
	public void addSysLog(SysLog syslog) {
		// TODO Auto-generated method stub
		syslogdao.addSysLog(syslog);
	}

}
