package com.test;

import java.lang.reflect.Constructor;

public class ClientPaste {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Class c=Class.forName(args[0]);
Object obj1=c.newInstance();
System.out.println("obj1..."+obj1);
//Object created using 0-parameter constructor
Constructor []cons=c.getDeclaredConstructors();

cons[0].setAccessible(true);
cons[1].setAccessible(true);

Object o2=cons[1].newInstance();
System.out.println("obj2.."+o2);

Object o3=cons[0].newInstance(10,20);
System.out.println("obj3.."+o3);
	}

}
