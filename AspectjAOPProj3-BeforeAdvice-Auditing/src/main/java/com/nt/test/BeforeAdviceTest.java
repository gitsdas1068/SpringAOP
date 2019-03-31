package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.LoanApprover;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoanApprover proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		proxy=ctx.getBean("loanApprover",LoanApprover.class);
		//invoke target method
		System.out.println(proxy.approveLoan(1001,"raja",80000));
		System.out.println("....");
		System.out.println(proxy.approveLoan(1002,"raja",8000));
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
