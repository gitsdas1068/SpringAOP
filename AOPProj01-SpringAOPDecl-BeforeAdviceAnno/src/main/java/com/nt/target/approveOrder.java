package com.nt.target;

import java.util.Calendar;

import org.springframework.stereotype.Component;
@Component("approver")
public class approveOrder {

	public String approveOrder(int orderid) {
		Calendar cal=Calendar.getInstance();
		int month=cal.get(Calendar.MONTH);
		if(month>=7 && month <=10) {
			return orderid+"order is not approved";
		}else {
			return orderid+"order is  approved";

		}
	}
}
