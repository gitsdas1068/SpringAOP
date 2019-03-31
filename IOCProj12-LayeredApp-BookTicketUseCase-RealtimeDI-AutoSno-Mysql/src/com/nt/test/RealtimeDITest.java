package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.TicketVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		BeanFactory factory=null;
		MainController controller=null;
		String result=null;
		TicketVO  vo=null;
		Scanner sc=null;
		String name=null,addrs=null,m1=null,m2=null,m3=null;
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter Passenger name::");
		name=sc.next();
		System.out.println("Enter Passenger address::");
		addrs=sc.next();
		System.out.println("Enter Train fare::");
		m1=sc.next();
		/*System.out.println("Enter Total::");
		m2=sc.next();*/
		System.out.println("Enter TrainNuber::");
		m3=sc.next();
		//create PassengerVO class object
		vo=new TicketVO();
		vo.setSname(name);
		vo.setSadd(addrs);
		vo.setTotal(m1);
		vo.setTrainNumber(m3);
		vo.setFare((m1));
		
		//create IOC container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get Bean Controller class object
		controller=factory.getBean("controller",MainController.class);
		try {
			result=controller.processTicket(vo);
			System.out.println(result);
			String fare=controller.getTotalTrainFare(vo);
			System.out.println("Total Train Fare wiith .49% as insurence is="+ Integer.parseInt(fare)+(Integer.parseInt(fare)*(0.49/100)));
		}
		catch(Exception e) {
			System.out.println("Internal Problem ----> try again..");
			e.printStackTrace();
		}
	}//main
}//class
