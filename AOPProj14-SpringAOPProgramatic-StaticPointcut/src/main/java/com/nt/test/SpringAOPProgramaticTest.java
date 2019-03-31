package com.nt.test;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.pointcut.CommonMulMethodPointcut;
import com.nt.service.AirthmeticOperations;

public class SpringAOPProgramaticTest {

	public static void main(String[] args) {
		AirthmeticOperations target=null,proxy=null;
		PerformanceMonitoringAdvice pmAdvice=null;
		ProxyFactory factory=null;
		CommonMulMethodPointcut ptc1=null;
		DefaultPointcutAdvisor pmAdvisor=null;
	  //create Target class object 
		target=new AirthmeticOperations();
		//create Advice class object
		pmAdvice=new PerformanceMonitoringAdvice();
		//create PointcutClass obj
		ptc1=new CommonMulMethodPointcut();
		//create Advisor obj
		pmAdvisor=new DefaultPointcutAdvisor(ptc1,pmAdvice);
	  //get Proxy object
		factory=new ProxyFactory();
		  //set target
		factory.setTarget(target);
		  //add Advisor
		 factory.addAdvisor(pmAdvisor);
		
		proxy=(AirthmeticOperations) factory.getProxy();
		Method methods[]=proxy.getClass().getDeclaredMethods();
		for(Method m:methods) {
			System.out.println(m.getName());
		}
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
