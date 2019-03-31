package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		System.out.println("prxoy obj class name::"+proxy.getClass());
		//invokemethod
		System.out.println("simple Intr Amount::"+proxy.calcSimpleIntrAmount(10000,2, 12));
		System.out.println("simple Intr Amount::"+proxy.calcSimpleIntrAmount(100000,2, 12));

		System.out.println("...............");
		System.out.println("Compound Intr Amount::"+proxy.calcCompoundIntrAmount(10000,2, 12));
		System.out.println("Compound Intr Amount::"+proxy.calcCompoundIntrAmount(100000,-2, 12));
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
