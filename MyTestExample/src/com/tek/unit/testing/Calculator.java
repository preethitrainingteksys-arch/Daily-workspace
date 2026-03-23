package com.tek.unit.testing;

public class Calculator {
	public int add(int a,int b)
	{
		return a+b;
	}
	public int divide(int a,int b)
	{
		if(b==0)
		{
			throw new ArithmeticException("Cannot be divided by zero");
		}
		return a/b;
	}

}
