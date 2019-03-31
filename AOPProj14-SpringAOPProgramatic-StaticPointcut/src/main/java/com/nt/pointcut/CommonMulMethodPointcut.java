package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.service.AirthmeticOperations;

public class CommonMulMethodPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("CommonMulMethodPointcut.matches(-,-)");
		if(targetClass==AirthmeticOperations.class && method.getName().equalsIgnoreCase("mul"))
			return true;
		else
			return false;
	}

}
