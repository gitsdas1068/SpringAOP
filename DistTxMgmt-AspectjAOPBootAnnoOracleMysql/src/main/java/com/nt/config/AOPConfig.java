package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.nt.service.BankService;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.icatch.jta.UserTransactionImp;
import org.springframework.transaction.jta.JtaTransactionManager;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
public class AOPConfig {
	@Autowired
	private UserTransactionManager txMgmr;
	@Autowired
	private UserTransactionImp txService;
	
	
	
	@Bean("jtaTxMgmr")
	public JtaTransactionManager createTxPFB() {
		UserTransactionManager un=new UserTransactionManager();
		JtaTransactionManager tfb=null;
		tfb=new JtaTransactionManager();
		tfb.setUserTransaction(txService);
		tfb.setTransactionManager(txMgmr);
		return tfb;
	}
	

}
