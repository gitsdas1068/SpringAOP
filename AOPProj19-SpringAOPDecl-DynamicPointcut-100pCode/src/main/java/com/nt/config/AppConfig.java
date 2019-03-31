package com.nt.config;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt")
public class AppConfig {
	@Autowired
	private Advice advice;
	@Autowired
	private Pointcut ptc;
	
	/*@Bean
	public  Advisor createDPAdvisor() {
		DefaultPointcutAdvisor advisor=null;
		advisor=new DefaultPointcutAdvisor();
		advisor.setAdvice(advice);
		advisor.setPointcut(ptc);
		return advisor;
	}*/
	
	@Bean(name="pfb")
	public  ProxyFactoryBean createProxyFactoryBean() {
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		pfb.setTargetName("airthService");
		//pfb.addAdvisors(createDPAdvisor());
		pfb.addAdvice(advice);
		return pfb;
	}
	
	

}
