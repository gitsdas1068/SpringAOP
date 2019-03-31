package com.nt.test;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;

import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.service.AirthmeticOperations;

public class SpringAOPProgramaticTest {

	public static void main(String[] args) {
		AirthmeticOperations target=null,proxy=null;
		PerformanceMonitoringAdvice advice=null;
		ProxyFactory factory=null;
	  //create Target class object 
		target=new AirthmeticOperations();
		//create Advice class object
		advice=new PerformanceMonitoringAdvice();
	  //get Proxy object
		factory=new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		proxy=(AirthmeticOperations) factory.getProxy();
		/*Method methods[]=proxy.getClass().getDeclaredMethods();
		for(Method m:methods) {
			System.out.println(m.getName());
		}*/
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
