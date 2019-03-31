package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public  DataSource createDataSource() {
		HikariDataSource bds=null;
		bds=new HikariDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
		bds.setUsername("root");
		bds.setPassword("1068");
		return bds;
	}
	
	@Bean
	public  JdbcTemplate createJT() {
		return new JdbcTemplate(createDataSource());
	}

}
