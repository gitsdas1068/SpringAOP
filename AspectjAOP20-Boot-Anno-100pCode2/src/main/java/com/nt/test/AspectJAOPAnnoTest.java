package com.nt.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.IntrestAmountCalculator;
@SpringBootApplication
@Import(AppConfig.class)
public class AspectJAOPAnnoTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrestAmountCalculator proxy=null;
		//create IOC container
		//ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		ctx=SpringApplication.run(AspectJAOPAnnoTest.class, args);
		//get Proxy object
		proxy=ctx.getBean("iac",IntrestAmountCalculator.class);
		//invoke methods
		System.out.println("Simple Intrest Amount::"+proxy.calcSimpleIntrAmount(100000,2,10));
		System.out.println("__________");
		System.out.println("Simple Intrest Amount::"+proxy.calcSimpleIntrAmount(100000,2,10));
		System.out.println(".............................");
		System.out.println("Compound Intrest Amount::"+proxy.calcCompoundIntrAmount(100000, 2,10));
		System.out.println("__________");
		System.out.println("Compound Intrest Amount::"+proxy.calcCompoundIntrAmount(100000, 2,10));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
