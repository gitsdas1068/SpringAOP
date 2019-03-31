package com.nt.aspect;

import java.io.FileWriter;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;

public class LoanAuditAspect {

	/*public  void audit(JoinPoint jp)throws Throwable{
		Writer writer=null;
		String auditMsg=null;
		Object args[]=null;
		args=jp.getArgs();
		//prepare Audit Message
		auditMsg=args[0]+" loan has come for approval to manager "+args[1]+" for the amount "+args[2];
		//write Audit message
		writer=new FileWriter("E:/auditLog.txt",true);
		writer.write(auditMsg+"\n");
		writer.flush();
		writer.close();
	}*/
	
	/*public  void audit(int id,String manager,double amt)throws Throwable{
		Writer writer=null;
		String auditMsg=null;
		Object args[]=null;
		//prepare Audit Message
		auditMsg=id+" loan has come for approval to manager "+manager+" for the amount "+amt;
		//write Audit message
		writer=new FileWriter("E:/auditLog.txt",true);
		writer.write(auditMsg+"\n");
		writer.flush();
		writer.close();
	}*/
	
	public  void audit(JoinPoint jp,int id,String manager,double amt)throws Throwable{
		Writer writer=null;
		String auditMsg=null;
		Object args[]=null;
		//prepare Audit Message
		auditMsg=id+" loan has come for approval to manager "+manager+" for the amount "+amt;
		//write Audit message
		writer=new FileWriter("E:/auditLog.txt",true);
		writer.write(auditMsg+"\n");
		writer.flush();
		writer.close();
	}
	
}
