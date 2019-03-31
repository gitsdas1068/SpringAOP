package com.nt.test;

import com.nt.factory.OnlineShoppingStoreFactory;
import com.nt.target.OnlineShoppingStore;

public class ShoppingCustomer {
	public static void main(String[] args) {
		OnlineShoppingStore store=null;
		store=OnlineShoppingStoreFactory.getInstance("wallet");
		//invoke method
		System.out.println(store.doShopping(new String[] {"kites","manza","roller","sweets"},new float[] {300.0f,1000.0f,500.0f,1000.0f}));
	}
}
