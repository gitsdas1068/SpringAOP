package com.nt.aspect;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;

public class DiscountCuponGenerator {
	
	public  void   generateCupon(JoinPoint jp,float bAmt)throws Throwable{
		System.out.println("Inside DiscountCuponGenerator class");
		String cuponMsg=null;
		FileWriter writer=null;
		if(bAmt >=50000)
			cuponMsg="Avail 30% discount on next purchase";
		else if(bAmt>=30000)
			cuponMsg="Avail 20% discount on next purchase";
		else
			cuponMsg="Avail 10% discount on next purchase";
		//write cuponMessage to the file...
		writer =new FileWriter("D:\\Sumit-D\\SpringPractice\\AspectJAOP17-Decl-AfterAuditAdvice\\cupon.txt",false);
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
	}

}
