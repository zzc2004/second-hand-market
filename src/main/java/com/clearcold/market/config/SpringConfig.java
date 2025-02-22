package com.clearcold.market.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({MyBatisConfig.class, DataSourceConfig.class})
@ComponentScan("com")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfig {
}
