package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.nt.service.BankService;

@Configuration
public class AOPConfig {
	@Autowired
	private DataSourceTransactionManager dsTxMgmr;
	@Autowired
	private BankService service;
	
	
	
	@Bean("tpfb")
	public TransactionProxyFactoryBean createTxPFB() {
		TransactionProxyFactoryBean tfb=null;
		Properties props=null;
		
		tfb=new TransactionProxyFactoryBean();
		tfb.setTarget(service);
		tfb.setTransactionManager(dsTxMgmr);
		props=new Properties();
		props.setProperty("transferMoney","PROPAGATION_REQUIRED");
		tfb.setTransactionAttributes(props);
		return tfb;
	}
	

}
