package com.nt.service;

import java.util.Random;

import org.springframework.stereotype.Service;
@Service("pinGenerator")
public class ATMPinGenerator implements PinGenerator {

	public int generatePin() {
		int pin=0;
		Random rad=null;
		rad=new Random();
		pin=rad.nextInt(9999);
		return pin;
	}
}
