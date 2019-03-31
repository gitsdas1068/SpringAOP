package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;
@SpringBootApplication
@Import(AppConfig.class)
public class DTxMgmtTestBoot {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService  proxy=null;
		//create IOC container
			//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
			//get Proxy object
			//create IOC container
			ctx=SpringApplication.run(com.nt.test.DTxMgmtTestBoot.class, args);
			//get Bean
			proxy=ctx.getBean("bankService",BankService.class);
			
			try{
				System.out.println("TransferMoney??"+proxy.transferMoney(101, 102, 10000));
				System.out.println("DTX Committed--->Money Transffered");
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("DTx  rolledBack and Money not transffered");
			}
			
			//close container
			((AbstractApplicationContext) ctx).close();
	}//main
}//class
