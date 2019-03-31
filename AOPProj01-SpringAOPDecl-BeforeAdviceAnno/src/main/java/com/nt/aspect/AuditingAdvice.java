package com.nt.aspect;

import java.io.FileWriter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Aspect
@Component("auditAdvice")
public class AuditingAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
System.out.println("Target Calss name:"+target.getClass());
System.out.println("Target mathod name:"+method.getName());
System.out.println("Target mathod args name:"+Arrays.toString(args));

if((Integer)args[0]==0){
	throw new IllegalArgumentException("wrong Order id");
	                   }

if((Integer)args[0]<0){
	args[0]=((Integer)args[0])*-1;
	 }
FileWriter fw=new FileWriter("D:\\Sumit-D\\SpringPractice\\AOPProj01-SpringAOPDecl-BeforeAdvice\\logs\\log.txt");
fw.write(args[0]+"order has coe for approval at"+new Date()+"\n");
fw.flush();
fw.close();


	}

}
