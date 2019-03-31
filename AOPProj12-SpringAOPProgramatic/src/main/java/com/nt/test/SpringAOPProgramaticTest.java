package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;

import com.nt.advice.CachingAdvice;
import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.service.AirthmeticOperations;
import com.nt.service.IArithmaticOperation;

public class SpringAOPProgramaticTest {

	public static void main(String[] args) {
		//AirthmeticOperations target=null,
		IArithmaticOperation target=null,proxy=null;
		
		PerformanceMonitoringAdvice advice1=null;
		CachingAdvice advice2=null;
		ProxyFactory factory=null;
	  //create Target class object 
		target=new AirthmeticOperations();
		//create Advice class object
		advice1=new PerformanceMonitoringAdvice();
		advice2=new CachingAdvice();
	  //get Proxy object
		factory=new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice1);
		factory.addAdvice(advice2);
		factory.addInterface(IArithmaticOperation.class);
		proxy=(IArithmaticOperation) factory.getProxy();
		System.out.println("Proxy Class="+proxy.getClass());
		//invoke method
		System.out.println("sum="+proxy.sum(10,20));
		System.out.println(".................");
		System.out.println("sum="+proxy.sum(10,20));
		System.out.println(".................");
		
		/*System.out.println("sub="+proxy.sub(10,20));
		System.out.println(".................");
		System.out.println("mul="+proxy.mul(100,200));
		System.out.println(".................");
		System.out.println("div="+proxy.div(100,200));
		System.out.println(".................");
*/	}
}
