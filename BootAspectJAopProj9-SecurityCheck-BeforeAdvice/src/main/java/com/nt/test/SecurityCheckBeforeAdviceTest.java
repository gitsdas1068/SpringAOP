package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.manager.AuthenticationManager;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class SecurityCheckBeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankService proxy=null;
		//create IOC container
		ctx=SpringApplication.run(SecurityCheckBeforeAdviceTest.class, args);
		//get AuthenticationManager Bean class object
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		//perform SignIn Operation
		manager.signIn("raja","rani");
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		System.out.println("Proxy obj class name::"+proxy.getClass());
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
