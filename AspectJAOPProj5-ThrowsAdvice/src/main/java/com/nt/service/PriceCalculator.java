package com.nt.service;

public class PriceCalculator {
	
	public float  calcPrice(int qty,float rate) {
		if(qty==0 || rate==0)
			throw new IllegalArgumentException("Invalid Inputs");
		return qty*rate;
	}

}
