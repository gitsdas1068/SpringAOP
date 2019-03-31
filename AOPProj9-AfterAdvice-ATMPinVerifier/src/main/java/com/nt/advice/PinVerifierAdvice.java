package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component("PinVerifierAdvice")
public class PinVerifierAdvice implements AfterReturningAdvice {

	public void afterReturning(Object retVal, Method method, Object[] args, Object target) throws Throwable {
		boolean sameDigitsflag=false;
		float result=0.0f;
		
		result=((Integer)retVal)/1111.0f;
		if(Math.floor(result)==Math.ceil(result))
			throw new IllegalArgumentException("All digits must not be same in PIN Number");
		
		
		if((Integer)retVal<1000)
			throw new IllegalArgumentException("Weak Pin number is generated ,So it is rejected");
		

	}

}
