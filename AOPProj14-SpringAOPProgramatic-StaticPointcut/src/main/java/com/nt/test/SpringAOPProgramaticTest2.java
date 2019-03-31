package com.nt.test;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.service.AirthmeticOperations;

public class SpringAOPProgramaticTest2 {

	public static void main(String[] args) {
		AirthmeticOperations target=null,proxy=null;
		PerformanceMonitoringAdvice pmAdvice=null;
		ProxyFactory factory=null;
		NameMatchMethodPointcutAdvisor pmAdvisor=null;
	  //create Target class object 
		target=new AirthmeticOperations();
		//create Advice class object
		pmAdvice=new PerformanceMonitoringAdvice();
		//create Advisor obj
		pmAdvisor=new NameMatchMethodPointcutAdvisor(pmAdvice);
		pmAdvisor.setMappedNames("div","mul");
	  //get Proxy object
		factory=new ProxyFactory();
		  //set target
		factory.setTarget(target);
		  //add Advisor
		 factory.addAdvisor(pmAdvisor);
		//gert Proxy object
		proxy=(AirthmeticOperations) factory.getProxy();
		//invoke method
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
