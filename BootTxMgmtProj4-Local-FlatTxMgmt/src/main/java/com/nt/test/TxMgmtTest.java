package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class TxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=SpringApplication.run(TxMgmtTest.class, args);
		//get Bean
		proxy=ctx.getBean("tpfb",BankService.class);
		System.out.println("proxy obj class name::"+proxy.getClass());
		try {
			//invoke method
			System.out.println(proxy.transferMoney(101,102,500));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
//Description	Resource	Path	Location	Type
//Archive for required library: 'C:/Users/welcome/.m2/repository/org/yaml/snakeyaml/1.23/snakeyaml-1.23.jar' in project 'BootTxMgmtProj4-Local-FlatTxMgmt' cannot be read or is not a valid ZIP file	BootTxMgmtProj4-Local-FlatTxMgmt		Build path	Build Path Problem

//