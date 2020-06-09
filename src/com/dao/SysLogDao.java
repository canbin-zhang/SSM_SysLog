package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pojo.SysLog;

@Repository
@Mapper
public interface SysLogDao {
	public int addSysLog(SysLog syslog);
}
