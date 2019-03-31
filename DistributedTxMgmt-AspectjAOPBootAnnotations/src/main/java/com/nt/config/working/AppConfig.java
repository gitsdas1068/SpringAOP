package com.nt.config.working;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {AOPConfig.class,PersistenceConfig.class,ServiceConfig.class})
public class AppConfig {

}
