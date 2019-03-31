package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.nt.advice.CacheAdvice;
import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.pointcut.CommonMulMethodDynaPointcut;
import com.nt.service.AirthmeticOperations;

public class SpringAOPProgramaticTest {

	public static void main(String[] args) {
		AirthmeticOperations target=null,proxy=null;
		PerformanceMonitoringAdvice pmAdvice=null;
		CacheAdvice cacheAdvice=null;
		ProxyFactory factory=null;
		DefaultPointcutAdvisor pmAdvisor=null,cacheAdvisor=null;
		CommonMulMethodDynaPointcut ptc1=null;
	  //create Target class object 
		target=new AirthmeticOperations();
		//create Advice class object
		pmAdvice=new PerformanceMonitoringAdvice();
		//create cache advice
		cacheAdvice=new CacheAdvice();
		//create Pointcut class obj
		ptc1=new CommonMulMethodDynaPointcut();
		cacheAdvisor=new DefaultPointcutAdvisor(ptc1, cacheAdvice);
		//create  Advisor
		pmAdvisor=new DefaultPointcutAdvisor(ptc1,pmAdvice);
	  //get Proxy object
		factory=new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvisor(0,cacheAdvisor);
		factory.addAdvisor(1,pmAdvisor);
		proxy=(AirthmeticOperations) factory.getProxy();
		//invoke method
		System.out.println("sum="+proxy.sum(10,20));
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

	}
}
