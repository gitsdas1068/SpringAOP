package com.nt.test;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.nt.advice.CacheAdvice;
import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.service.AirthmeticOperations;

public class SpringAOPProgramaticTest3 {

	public static void main(String[] args) {
		AirthmeticOperations target=null,proxy=null;
		PerformanceMonitoringAdvice pmAdvice=null;
		CacheAdvice cacheAdvice=null;
		ProxyFactory factory=null;
		NameMatchMethodPointcutAdvisor pmAdvisor=null,cacheAdvisor=null;
		
		
	  //create Target class object 
		target=new AirthmeticOperations();
		//create Advice class objects
		pmAdvice=new PerformanceMonitoringAdvice();
		cacheAdvice=new CacheAdvice();
		//create Advisor objs
		pmAdvisor=new NameMatchMethodPointcutAdvisor(pmAdvice);
		pmAdvisor.setMappedNames("sum","mul");
		cacheAdvisor=new NameMatchMethodPointcutAdvisor(cacheAdvice);
		cacheAdvisor.setMappedName("sum");
	  //get Proxy object
		factory=new ProxyFactory();
		  //set target
		factory.setTarget(target);
		  //add Advisor
		 
		 factory.addAdvisor(0,pmAdvisor);
		 factory.addAdvisor(1,cacheAdvisor);
		 
		
		//gert Proxy object
		proxy=(AirthmeticOperations) factory.getProxy();
		//invoke method
		System.out.println("sum="+proxy.sum(10,20));
		System.out.println("sum="+proxy.sum(10,20));
		System.out.println(".................");
		System.out.println("sub="+proxy.sub(10,20));
		System.out.println(".................");
		System.out.println("mul="+proxy.mul(100,200));
		System.out.println(".................");
		System.out.println("div="+proxy.div(100,200));
		System.out.println(".................");
	}
}
