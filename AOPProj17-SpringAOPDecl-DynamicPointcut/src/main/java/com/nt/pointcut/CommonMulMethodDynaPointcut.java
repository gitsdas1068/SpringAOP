package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.nt.service.AirthmeticOperations;

public class CommonMulMethodDynaPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if(method.getName().equals("mul") && targetClass==AirthmeticOperations.class && ((Integer)args[0])>=1000 && ((Integer)args[1])>=1000)
		  return true;
		else
			return false;
	}

	 

}
