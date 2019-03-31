package com.nt.service;

import java.sql.SQLException;

public interface BankService {
	public  boolean withdrawMoney(int acno,float amt);
	public  boolean depositeMoney(int acno,float amt);
	//public String transferMoney(int srcAcno,int destAcno,float amt)throws SQLException;
	public String transferMoney(int srcAcno,int destAcno,float amt);

}
