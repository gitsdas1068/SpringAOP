package com.nt.service;

public class BillGenerator {
	public float generateBill(String item,float price,float qty)throws IllegalArgumentException {
	  if(price<=0 || qty<=0)
		  throw new IllegalArgumentException();
	  return price*qty;
	}

}
