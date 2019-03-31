package com.nt.factory;

import com.nt.helper.CardPayment;
import com.nt.helper.NetBankingPayment;
import com.nt.helper.PaymentMode;
import com.nt.helper.WalletPayment;
import com.nt.target.OnlineShoppingStore;

public class OnlineShoppingStoreFactory {
	
	public static  OnlineShoppingStore  getInstance(String paymentMode) {
		PaymentMode mode=null;
		OnlineShoppingStore store=null;
		//create Dependent class object
		if(paymentMode.equalsIgnoreCase("netbanking")) {
			mode=new NetBankingPayment();
		}
		else if(paymentMode.equalsIgnoreCase("wallet")) {
			mode=new WalletPayment();
		}
		else if(paymentMode.equalsIgnoreCase("card")) {
			mode=new CardPayment();
		}
		else 
			throw new IllegalArgumentException("invalid payment mode option");
		//create taget class obj having depedent class object
		store=new OnlineShoppingStore(mode);
		return store;
		
	}

}
