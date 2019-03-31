package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CachingAdvice implements MethodInterceptor {
private Map<String,Object> cacheMap=new HashMap<String,Object>();
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object retVal=null;
		String key=invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
		if(!cacheMap.containsKey(key)) {
			retVal=invocation.proceed();
			System.out.println("calling target method");
			cacheMap.put(key, retVal);
			return retVal;
			}else {
				System.out.println("From Cache");
				return cacheMap.get(key);
			}
		
		
	}

}
