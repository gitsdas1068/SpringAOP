package com.nt.target;

import java.util.Arrays;
import java.util.Random;

import com.nt.helper.PaymentMode;
import com.nt.helper.WalletPayment;

public class OnlineShoppingStore {
	private PaymentMode mode;

	public OnlineShoppingStore(PaymentMode mode) {
		this.mode = mode;
	}
	
	public  String doShopping(String items[],float prices[]) {
		float billAmt=0.0f;
		float discount=0.0f;
		float finalBillAmt=0.0f;
		String txMsg=null;
		int orderId=0;
		for(float price:prices) {
			billAmt=billAmt+price;
		}
		if(mode   instanceof WalletPayment) {
			discount=billAmt *0.05f;
		    finalBillAmt=billAmt-discount;
		}
		else {
			finalBillAmt=billAmt;
		}
		//generate OrderId
		orderId=new Random().nextInt(20000);
		txMsg=mode.doPayment(finalBillAmt,orderId);
		String billReciept="items are"+Arrays.toString(items)+
				                         "prices are"+Arrays.toString(prices)+
				                         "Bill Amount::"+billAmt+
				                         "Discount ::"+discount+
				                         "Final bill Amount::"+finalBillAmt+
				                         "......"+txMsg;
		return billReciept;
	}

}
