package com.mycompany.storemanager.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
@EnableJpaRepositories(basePackages = "spring.data.jpa.repository.packages")
public class DataSourceConfig {
	
	// Primary datasource-store-details
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "app.datasource")
	public DataSource StoreAppDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	// configure entity manager
	@Bean
	@ConfigurationProperties(prefix = "spring.data.jpa.entity")
	public LocalContainerEntityManagerFactoryBean appDataEntityManagerFactoryBean(
			EntityManagerFactoryBuilder factoryBuilder, 
			DataSource StoreAppDataSource ) {
		return factoryBuilder
				.dataSource(StoreAppDataSource)
				.build();
	}
	
	
	// security-info data source - store-mangement-security
	@Bean
	@ConfigurationProperties(prefix = "security.datasource")
	public DataSource StoreAppSecurityDataSource() {
		return DataSourceBuilder.create().build();
	}
	
}
