package com.nt.config.working;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	

	@Bean(name="mysqlXADs")
	public  DataSource createDataSource1() {
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
		return new JdbcTemplate(createDataSource1());
	}
	
	@Bean(name="oraXADs")
	public  DataSource createDataSource2() {
		AtomikosDataSourceBean bds=null;
		bds=new AtomikosDataSourceBean();
		bds.setUniqueResourceName("XAmysql1");
		bds.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		Properties props=new Properties();
		props.setProperty("databaseName","spring2");
		props.setProperty("user","root");
		props.setProperty("password","1068");
		props.setProperty("URL","jdbc:mysql://localhost:3306/spring2");
		bds.setXaProperties(props);
		bds.setPoolSize(10);
		return bds;
	}
	
	@Bean(name="template2")
	public  JdbcTemplate createJT2(){
		return new JdbcTemplate(createDataSource2());
	}
}
