package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Flipkart;

public class TightCouplingTest {

	public static void main(String[] args) {
		BeanFactory factory=null;
		Flipkart fpkt=null;
	//create IOC Container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
	 //get Bean
		fpkt=factory.getBean("fpkt",Flipkart.class);
		//invoke b.method
		System.out.println(fpkt.shopping(new String[]{"shirt","trouser","shoes"}));
	}//main
}//class
