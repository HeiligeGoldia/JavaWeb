package com.se.nhom6.detai.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource({"application.properties"})
public class DemoAppConfig {
//		implements WebMvcConfigurer

	@Autowired
	private Environment env;

	@Bean
	public DataSource securityDataSource() {

		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		try {
			myDataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		myDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		myDataSource.setUser(env.getProperty("spring.datasource.username"));
		myDataSource.setPassword(env.getProperty("spring.datasource.password"));

		return myDataSource;
	}

}