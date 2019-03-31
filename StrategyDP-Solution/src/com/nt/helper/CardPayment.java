package com.nt.helper;

import java.util.Random;

public final class CardPayment implements PaymentMode {

	@Override
	public String doPayment(float amount, int orderId) {
		int txId=0;
		txId=new Random().nextInt(10000);
		return  orderId+" order id payment of  amount "+amount+" is done through Debit/CreditCard and Transaction Id is::"+txId;
	}

}
