package com.nt.cfgs;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig2 {
	

	@Bean(name="mysqlXADs")
	public  DataSource createDataSource() {
		AtomikosDataSourceBean bds=null;
		bds=new AtomikosDataSourceBean();
		bds.setUniqueResourceName("XAmysql");
		bds.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		Properties props=new Properties();
		props.setProperty("databaseName","spring");
		props.setProperty("user","root");
		props.setProperty("password","1068");
		props.setProperty("URL","jdbc:mysql://localhost:3306/spring");
		bds.setXaProperties(props);
		bds.setPoolSize(10);
		return bds;
	}
	
	@Bean(name="template1")
	public  JdbcTemplate createJT1() {
		return new JdbcTemplate(createDataSource());
	}
	
	@Bean(name="oraXADs")
	public   AtomikosDataSourceBean  createXADSForOracle() {
		Properties props=null;
		AtomikosDataSourceBean  xaDs=new AtomikosDataSourceBean();
		xaDs.setUniqueResourceName("xaOra");
		xaDs.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		props=new Properties();
		props.put("databaseName","xe");
		props.put("user","system");
		props.put("password","1068");
		props.put("URL","jdbc:oracle:thin:@localhost:1521:xe");
		xaDs.setXaProperties(props);
		xaDs.setPoolSize(10);
		return xaDs;
	}
	
	@Bean(name="template2")
	public  JdbcTemplate createJT2(){
		return new JdbcTemplate(createXADSForOracle());
	}
}
