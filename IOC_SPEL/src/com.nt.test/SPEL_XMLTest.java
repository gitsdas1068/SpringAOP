package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.AmoghaBillCounter;

public class SPEL_XMLTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AmoghaBillCounter billCounter=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		billCounter=ctx.getBean("agCounter",AmoghaBillCounter.class);
		//invoke the method
		System.out.println(billCounter);
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}

}
