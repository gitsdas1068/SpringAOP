package com.nt.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;

import com.nt.exception.WrongInputsException;

public class CommonExceptionGraphingAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method,Object[] args,Object target,IllegalArgumentException iae) {
		throw new WrongInputsException("Exception in Target method "+Arrays.toString(args));
	}
	 
}
