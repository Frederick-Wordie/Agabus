package com.frederickwordie;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
	
	/*@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setPoolName(env.getRequiredProperty("spring.datasource.hikari.pool-name"));
		config.setJdbcUrl(env.getRequiredProperty("datasource.jdbcUrl"));
		config.setUsername(env.getRequiredProperty("datasource.username"));
		config.setPassword(env.getRequiredProperty("datasource.password"));
		config.setDriverClassName(env.getRequiredProperty("datasource.driver-class-name"));

		return new HikariDataSource(config);
	}*/
}
