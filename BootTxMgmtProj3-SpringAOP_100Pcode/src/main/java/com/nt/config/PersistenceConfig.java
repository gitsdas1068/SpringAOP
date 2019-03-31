package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public  DataSource createDataSource() {
		BasicDataSource bds=null;
		bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/spring");
		bds.setUsername("root");
		bds.setPassword("1068");
		return bds;
	}
	
	@Bean
	public  JdbcTemplate createJT() {
		return new JdbcTemplate(createDataSource());
	}
}
