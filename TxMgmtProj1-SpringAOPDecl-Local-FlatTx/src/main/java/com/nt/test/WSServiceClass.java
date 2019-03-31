package com.nt.test;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;
@WebService
public class WSServiceClass {


	@WebMethod
	public String transfer(int Accno1,int Accno2,int amount) {
		String status="";
		ApplicationContext ctx=null;
			BankService proxy=null;
			//create IOC container
			ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
			//get Bean
			proxy=ctx.getBean("tpfb",BankService.class);
			System.out.println("proxy obj class name::"+proxy.getClass());
			try {
				/*//invoke method
				System.out.println("********Deposite Money********");
				System.out.println("Depositing amount Account no @ 101:"+proxy.depositeMoney(101, 50000));
				System.out.println("Depositing amount Account no @ 102:"+proxy.depositeMoney(102, 20000));

				
				System.out.println("********Withdraw Money********");
			    System.out.println("Withdraw amount Account no @ 101:"+proxy.withdrawMoney(101, 5000));
				System.out.println("Withdraw amount Account no @ 102:"+proxy.withdrawMoney(102, 22000));
	*/	
				
				
				System.out.println("**********Transfer money**************");
				status=proxy.transferMoney(Accno1,Accno1,amount);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close container
			((AbstractApplicationContext) ctx).close();
			
			return status;

		}//main
	}//class


