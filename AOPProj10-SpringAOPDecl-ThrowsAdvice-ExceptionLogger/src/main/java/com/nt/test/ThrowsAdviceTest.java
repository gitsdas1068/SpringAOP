package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BillGenerator;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BillGenerator proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		proxy=ctx.getBean("pfb",BillGenerator.class);
		//invoke method
		System.out.println("Bill amt::"+proxy.generateBill("wahsing machine",30000, 0));
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
