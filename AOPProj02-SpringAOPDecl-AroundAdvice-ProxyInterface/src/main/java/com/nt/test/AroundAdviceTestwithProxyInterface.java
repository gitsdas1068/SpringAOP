package com.nt.test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Arrays;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.aspect.AroundLoggingAdvice;
import com.nt.target.IntrestAmountCalculator;
import com.nt.target.IntrestAmountCalculatorInterface;

public class AroundAdviceTestwithProxyInterface {

	

 
	public static void main(String[] args) {
		/*PropertyConfigurator.configure("main/java/com/nt/commons/log4j.properties");
		 
		*/
		
		ApplicationContext ctx=null;
		//IntrestAmountCalculator proxy=null;
		IntrestAmountCalculatorInterface proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy= ctx.getBean("pfb",IntrestAmountCalculatorInterface.class);
		System.out.println("Proxy obj class name::"+proxy.getClass()+"  --->super class"+proxy.getClass().getSuperclass()+"  inteerfaes"+Arrays.toString(proxy.getClass().getInterfaces()));
		//invoke taget/b.method
		try{
		System.out.println("Simple Intr Amount::"+proxy.calcSimpleIntrAmount(1000001,2,12));
		System.out.println(".....................................");
		System.out.println("Simple Intr Amount::"+proxy.calcSimpleIntrAmount(1000001,2,12));
          }
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------------------------");
		System.out.println("Compound Intr Amount::"+proxy.calcCompoundIntrAmount(1000001,2,12));
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
