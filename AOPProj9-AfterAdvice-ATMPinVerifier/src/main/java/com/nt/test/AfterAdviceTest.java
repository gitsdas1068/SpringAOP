package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.PinGenerator;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PinGenerator proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		proxy=ctx.getBean("pfb",PinGenerator.class);
		//invoke b.method
		System.out.println("Generated Pin::"+proxy.generatePin());
		System.out.println("proxy obj class name::"+proxy.getClass());
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
