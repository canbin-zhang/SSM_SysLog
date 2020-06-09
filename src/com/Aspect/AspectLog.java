package com.Aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.SysLog;
import com.pojo.User;
import com.service.SysLogServiceImpl;

@Component
@Aspect
public class AspectLog {
	private Date visittime;
	private Class clazz;
	private Method method;
	private String ip;
	private String url;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private SysLogServiceImpl syslogserviceimpl;
	
	@Pointcut("execution(* com.controller.*.*(..))&&!execution(* com.controller.*.to*(..))")
	private void myPointCut() {
		
	}
	
	@Before("myPointCut()")
	public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException{
		 visittime=new Date();
		 clazz=jp.getTarget().getClass();
		 String methodname=jp.getSignature().getName();
		 Object[] args=jp.getArgs();
		 if(args==null||args.length==0) {
			 method=clazz.getMethod(methodname);
			 System.out.println(method);
		 }else {
			 Class[] classArgs=new Class[args.length];
			 for(int i=0;i<args.length;i++) {
				 classArgs[i]=args[i].getClass();
			 }
			 //method=clazz.getMethod(methodname, classArgs);
			 method=clazz.getMethod(methodname, User.class,Model.class,HttpServletResponse.class);
			 Method m=method;
		 }
		 
	}
	
	@After("myPointCut()")
	public void doAfter(JoinPoint jp) {
		
		//获取URL;
		String url="";
		System.out.println(method);
		if(clazz!=null&&method!=null&&clazz!=AspectLog.class) {
			RequestMapping classAnotation=(RequestMapping) clazz.getAnnotation(RequestMapping.class);
			if(classAnotation!=null) {
				String[] classAnotations=classAnotation.value();
				
				RequestMapping methodAnotation=method.getAnnotation(RequestMapping.class);
				if(methodAnotation!=null) {
					String[] methodAnotations=methodAnotation.value();
					url=classAnotations[0]+methodAnotations[0];
				}
			}
		}
		
		//获取ip
		String ip=request.getRemoteAddr();
		SysLog syslog=new SysLog();
		syslog.setIp(ip);
		syslog.setUrl(url);
		syslog.setVisittime(visittime);
		syslog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
		syslogserviceimpl.addSysLog(syslog);
		
		
	}
}
