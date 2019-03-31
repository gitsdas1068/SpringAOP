package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO dao;

	

	@Override
	public String withdrawMoney(int acno, int amount) {
		int count=0;
		//use DAO
		count=dao.withdraw(acno, amount);
		if(count==0)
			return "Problem in withdrawing money";
		else
			return amount+" is withdrawn from account number"+acno;
	}

	@Override
	public String depositeMoney(int acno, int amount) {
		int count=0;
		//use DAO
		count=dao.deposite(acno, amount);
		if(count==0)
			return "Problem in depositing money";
		else
			return amount+" is deposited from account number "+acno;
	}

}
