package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class obj
		proxy=ctx.getBean("sStore",ShoppingStore.class);
		System.out.println("proxy obj class name::"+proxy.getClass());
		//invoke method
		System.out.println("Bill Amount::"+proxy.shopping(new String[] {"tv", "ac"},
				                                          new float[] {80000,90000}));
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
