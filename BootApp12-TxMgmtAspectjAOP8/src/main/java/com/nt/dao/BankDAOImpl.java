package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository("bankDAO")
public class BankDAOImpl implements BankDAO {
	private static final String  WITHDRAW_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String  DEPOSITE_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
    @Autowired		
	private JdbcTemplate jt;

	public BankDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDAOImpl(JdbcTemplate jt) {
		
		this.jt = jt;
	}

	@Override
	public int withdraw(int acno, int amount) {
		 int count=0;
		 count=jt.update(WITHDRAW_QUERY,amount,acno);
		return count;
	}

	@Override
	public int deposite(int acno, int amount) {
		 int count=0;
		 count=jt.update(DEPOSITE_QUERY,amount,acno);
		return count;	
		}

}
