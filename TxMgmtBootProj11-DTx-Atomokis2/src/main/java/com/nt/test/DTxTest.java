package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@Import(AppConfig.class)
public class DTxTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create  IOC container
		ctx=SpringApplication.run(DTxTest.class, args);
		//get Bean
		proxy= ctx.getBean("bankService",BankService.class);
		//invoke methods
		try {
			System.out.println("TransferedMoney? :::"+proxy.transferMoney(1003, 1002, 1000));
			System.out.println("TX committed");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("TX rolledback");
		}
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}//main
}//class

/*
 Description	Resource	Path	Location	Type
Archive for required library: 'C:/Users/welcome/.m2/repository/org/assertj/assertj-core/3.11.1/assertj-core-3.11.1.jar' in project 'TxMgmtBootProj11-DTx-Atomokis2' cannot be read or is not a valid ZIP file	TxMgmtBootProj11-DTx-Atomokis2		Build path	Build Path Problem

 * 
 */
