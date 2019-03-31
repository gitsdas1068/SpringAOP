package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.advice.CacheAdvice;
import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.pointcut.CommonMulMethodDynaPointcut;
import com.nt.service.AirthmeticOperations;


public class SpringAOPProgramaticTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AirthmeticOperations proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("pfb",AirthmeticOperations.class);
		
		//invoke method
		/*System.out.println("sum="+proxy.sum(10,20));
		System.out.println(".................");
		System.out.println("sum=Repit"+proxy.sum(10,20));
		System.out.println(".................");
		
		System.out.println("sub="+proxy.sub(10,20));
		System.out.println(".................");
		System.out.println("sub=Repit"+proxy.sub(10,20));
		System.out.println(".................");
		
		System.out.println("mul="+proxy.mul(100,200));
		System.out.println("_____");
		System.out.println("mul=Repit"+proxy.mul(100,200));
		System.out.println("_____");
		
		System.out.println("mul="+proxy.mul(1100, 1200));
		System.out.println(".................");
		System.out.println("mul=Repit"+proxy.mul(1100, 1200));
		System.out.println(".................");
		
		System.out.println("div="+proxy.div(100,200));
		System.out.println(".................");
		System.out.println("div=Repit"+proxy.div(100,200));
		System.out.println(".................");
*/
		System.out.println("sum="+proxy.sum(10,20));
		System.out.println(".................");
		System.out.println("sub="+proxy.sub(10,20));
		System.out.println(".................");
		System.out.println("mul="+proxy.mul(100,200));
		System.out.println("_____");
	
		System.out.println("mul="+proxy.mul(1100, 1200));
		System.out.println(".................");
		System.out.println("div="+proxy.div(100,200));
		System.out.println(".................");
	
		
	}
}
