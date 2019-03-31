package com.nt.test;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.approveOrder;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		approveOrder proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("pfb",approveOrder.class);
		System.out.println("Proxy obj class name::"+proxy.getClass()+"  --->super class"+proxy.getClass().getSuperclass());
		//invoke taget/b.method
		try{
		System.out.println("Simple Intr Amount::"+proxy.approveOrder(1234));
		System.out.println(".....................................");
		System.out.println("Simple Intr Amount::"+proxy.approveOrder(-4567));
		System.out.println(".....................................");
		System.out.println("Simple Intr Amount::"+proxy.approveOrder(0));
        
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
