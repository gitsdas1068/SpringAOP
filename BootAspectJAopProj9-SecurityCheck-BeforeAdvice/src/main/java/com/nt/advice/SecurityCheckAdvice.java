package com.nt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.manager.AuthenticationManager;
@Component("securityAdvice")
@Aspect	
public class SecurityCheckAdvice {
	@Autowired
	private AuthenticationManager manager;


    @Before(value="execution(* com.nt.service.BankServiceImpl.*(..))")	
	public void security(JoinPoint jp)throws Throwable{
       //perform Authentication
		if(!manager.validate())
			throw new IllegalArgumentException("Invalic Credentials");

	}

}
