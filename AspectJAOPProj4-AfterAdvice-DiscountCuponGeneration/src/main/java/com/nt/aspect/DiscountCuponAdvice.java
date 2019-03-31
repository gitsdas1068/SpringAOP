package com.nt.aspect;

import java.io.FileWriter;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;

public class DiscountCuponAdvice {
	
/*	public  void  cuponGeneration(JoinPoint jp,float bAmt) throws Throwable{
		String cuponMsg=null;
		Writer writer=null;
		if(bAmt<10000)
			cuponMsg="Avail 5% discount on next Purchase";
		else if(bAmt<20000)
			cuponMsg="Avail 10% discount on next Purchase";
		else if(bAmt<30000)
			cuponMsg="Avail 20% discount on next Purchase";
		else
			cuponMsg="Avail 25% discount on next Purchase";
		//Generate cupon
		writer=new FileWriter("E:\\cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
	}//method
*/
	
	/*public  void  cuponGeneration(float bAmt) throws Throwable{
		String cuponMsg=null;
		Writer writer=null;
		if(bAmt<10000)
			cuponMsg="Avail 5% discount on next Purchase";
		else if(bAmt<20000)
			cuponMsg="Avail 10% discount on next Purchase";
		else if(bAmt<30000)
			cuponMsg="Avail 20% discount on next Purchase";
		else
			cuponMsg="Avail 25% discount on next Purchase";
		//Generate cupon
		writer=new FileWriter("E:\\cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
	}//method
	*/
	
	public  void  cuponGeneration(String[] items,float[] prices,float bAmt) throws Throwable{
		String cuponMsg=null;
		Writer writer=null;
		if(bAmt<10000)
			cuponMsg="Avail 5% discount on next Purchase";
		else if(bAmt<20000)
			cuponMsg="Avail 10% discount on next Purchase";
		else if(bAmt<30000)
			cuponMsg="Avail 20% discount on next Purchase";
		else
			cuponMsg="Avail 25% discount on next Purchase";
		//Generate cupon
		writer=new FileWriter("E:\\cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
	}//method
	
	}//class
