package com.nt.aspect;



import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger {
	Logger logger=Logger.getLogger(CommonExceptionLogger.class);
	static {
		PropertyConfigurator.configure("src/main/java/com/nt/commons/log4j.properties");
	}
	
	public void exceptionLogging(JoinPoint jp,IllegalArgumentException ex) {
		System.out.println("1");
		logger.error(ex.toString()+" exception is raised  in"+jp.getSignature()+" method with args"+Arrays.toString(jp.getArgs()));
	}
	
	/*public void exceptionLogging(Exception ex) {
		System.out.println("2");
		logger.error(ex.toString()+" exception is raised  ");
	}*/

}
