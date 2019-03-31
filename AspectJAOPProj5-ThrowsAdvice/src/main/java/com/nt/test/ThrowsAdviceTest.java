package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.PriceCalculator;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PriceCalculator proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		proxy=ctx.getBean("priceCalculator",PriceCalculator.class);
		//invoke method
		try {
		System.out.println("price::"+proxy.calcPrice(2,10000));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("...........");
		try {
			System.out.println("price::"+proxy.calcPrice(0,10000));
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}

	}

}
