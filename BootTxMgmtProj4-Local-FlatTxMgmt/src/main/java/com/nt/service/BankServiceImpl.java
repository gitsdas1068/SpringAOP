package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO dao;

	

	@Override
	public boolean withdrawMoney(int acno, float amt) {
		int count=0;
		//use DAO
		count=dao.withdraw(acno, amt);
		if(count==0)
		   return false;
		else
			return true;
	}

	@Override
	public boolean depositeMoney(int acno, float amt) {
		int count=0;
		//use DAO
		count=dao.deposite(acno, amt);
		if(count==0)
		   return false;
		else
			return true;
	}

	/*@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)throws SQLException {
		boolean result1=false,result2=false;
		//use withdrawMoney and depositeMoney methods
		result1=withdrawMoney(srcAcno, amt);
		result2=depositeMoney(destAcno, amt);
		if(result1 && result2) 
			return "MoneyTransfered from "+srcAcno+" to "+ destAcno;
		else
			throw new SQLException("Money not transfered");
			
	}
*/
	@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)  {
		boolean result1=false,result2=false;
		/*try {
			Thread.sleep(30000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}*/
		//use withdrawMoney and depositeMoney methods
		result1=withdrawMoney(srcAcno, amt);
		result2=depositeMoney(destAcno, amt);
		if(result1 && result2) 
			return "MoneyTransfered from "+srcAcno+" to "+ destAcno;
		else
			throw new IllegalArgumentException("Money not transfered");
			
	}
}
