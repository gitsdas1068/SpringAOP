package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.BankService;

public class SecurityCheckBeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get AuthenticationManager Bean class object
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		//perform SignIn Operation
		manager.signIn("raja","rani");
		//get Proxy object
		proxy=ctx.getBean("pfb",BankService.class);
		//invoke b.methods
		System.out.println(proxy.withdrawMoney(101,9000));
		System.out.println(".................");
		System.out.println(proxy.depositeMoney(101,6000));
		//signOut
		manager.signOut();
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
