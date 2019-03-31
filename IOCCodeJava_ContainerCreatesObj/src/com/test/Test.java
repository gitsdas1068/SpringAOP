package com.test;

public class Test {
static {
	System.out.println("Test class loaded from static block");
}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test(int x,int y) {
		
	}

	@Override
	public String toString() {
		return "Test [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
