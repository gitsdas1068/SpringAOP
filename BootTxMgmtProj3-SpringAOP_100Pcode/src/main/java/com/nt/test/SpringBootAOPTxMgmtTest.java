package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;
@SpringBootApplication
@Import(AppConfig.class)
public class SpringBootAOPTxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService  proxy=null;
		//create IOC container
		//ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		ctx=SpringApplication.run(SpringBootAOPTxMgmtTest.class, args);
		
		//get Proxy object
		proxy=ctx.getBean("tpfb1Proxy",BankService.class);
		try{
		//invoke method..
		System.out.println("Money Transffered?"+proxy.transferMoney(101,102,300));
		System.out.println("Transaction Committed and Money Transffered");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Transaction Rolled back and Money not  Transffered");
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
