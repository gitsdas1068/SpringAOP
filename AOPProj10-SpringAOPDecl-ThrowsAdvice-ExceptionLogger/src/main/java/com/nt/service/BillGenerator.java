package com.nt.service;

import org.springframework.stereotype.Service;

@Service("bGenerator")
public class BillGenerator {
	public float generateBill(String item,float price,float qty) {
	  if(price<=0 || qty<=0)
		  throw new IllegalArgumentException();
	  return price*qty;
	}

}
