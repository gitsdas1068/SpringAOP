package com.test;

public class TestPvt {
static {
	System.out.println("TestPvt class loaded from static block");
}
public TestPvt() {
		System.out.println("0-param constructor");
		// TODO Auto-generated constructor stub
	}

	private TestPvt(int x,int y) {
		System.out.println("sum="+sum(x,y));
	}
	private int sum(int x,int y) {
		return x+y;
	}
	

	@Override
	public String toString() {
		return "Test [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
