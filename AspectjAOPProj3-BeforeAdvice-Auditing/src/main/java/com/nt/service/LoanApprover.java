package com.nt.service;

import java.util.Calendar;

public class LoanApprover {
	
	public String  approveLoan(int loanId,String manager,double loanAmount) {
		  Calendar cal=null;
		  int month=0;
		  //get system date
		  cal=Calendar.getInstance();
		  month=cal.get(Calendar.MONTH);
        
		if(loanAmount<=50000 &&(month>=6 && month<=9))
			return loanId+" is Loan Approved by "+manager+"for the amount ::"+loanAmount;
		else 
			return loanId+" is Loan not Approved by "+manager+"for the amount ::"+loanAmount;
	}

}
