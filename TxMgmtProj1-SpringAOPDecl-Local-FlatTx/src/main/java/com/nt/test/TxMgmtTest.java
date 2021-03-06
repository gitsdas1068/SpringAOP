package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class TxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/Application_Context.xml");

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
			System.out.println("Transfer amount from  Account no 101 to 102:"+proxy.transferMoney(101,102,2000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
