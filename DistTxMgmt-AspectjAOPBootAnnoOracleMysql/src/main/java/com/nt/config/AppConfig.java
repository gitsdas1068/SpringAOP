package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig2.class,ServiceConfig.class,AOPConfig2.class})
public class AppConfig {

}
