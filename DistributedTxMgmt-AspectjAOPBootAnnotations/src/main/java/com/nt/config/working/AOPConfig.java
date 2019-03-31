package com.nt.config.working;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AOPConfig {
	
	//create userTxService 
	@Bean("userTxService")
	public UserTransactionImp createUserTxService() throws Exception {
		UserTransactionImp userTxService=new UserTransactionImp();
		
		userTxService.setTransactionTimeout(400);
		return userTxService;
	}
	//transactionManager
	
	@Bean("userTxMgmr")
	public UserTransactionManager createUserTxMgmr() {
		UserTransactionManager userTxMgmr =new UserTransactionManager();
		
		userTxMgmr.setForceShutdown(true);
		
		return userTxMgmr;
	}
	//jtaTxmgmr
	
	@Bean("jtaTxMgmr")
	public JtaTransactionManager createJtaTxMgmr() throws Exception {
		JtaTransactionManager jtaTxmgmr=new JtaTransactionManager();
		
		jtaTxmgmr.setUserTransaction(createUserTxService());
		jtaTxmgmr.setTransactionManager(createUserTxMgmr());
		return jtaTxmgmr;
	}
	
}
