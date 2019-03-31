package com.nt.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;


@Component("exLogger")
public class CommonExceptionLogger implements ThrowsAdvice {

/*	 public void afterThrowing(Method method,Object[] args,Object target,IllegalArgumentException iae) {
		 System.out.println("1"+iae.toString()+" exception is raised in "+method.getName()+"  of target class"+target.getClass()+" having args"+Arrays.toString(args));
	 }
	 
	 public void afterThrowing(IllegalArgumentException iae) {
		 System.out.println("2"+iae.toString()+"is raised");
	 }
*/
	
/*	public void afterThrowing(Method method,Object[] args,Object target,Exception iae) {
		 System.out.println("3"+iae.toString()+" exception is raised in "+method.getName()+"  of target class"+target.getClass()+" having args"+Arrays.toString(args));
	 }
	 
	 public void afterThrowing(Exception iae) {
		 System.out.println("4"+iae.toString()+"is raised");
	 }*/
	
	/*public void afterThrowing(Method method,Object[] args,Object target,IllegalArgumentException iae) {
		 System.out.println("5"+iae.toString()+" exception is raised in "+method.getName()+"  of target class"+target.getClass()+" having args"+Arrays.toString(args));
	 }
	 */
	 public void afterThrowing(Exception iae) {
		 System.out.println("1"+iae.toString()+"is raised");
	 }
	 public void afterThrowing(Throwable iae) {
		 System.out.println("2"+iae.toString()+"is raised");
	 }
	 public void afterThrowing(IllegalArgumentException iae) {
		 System.out.println("2"+iae.toString()+"is raised");
	 }
	 
}
