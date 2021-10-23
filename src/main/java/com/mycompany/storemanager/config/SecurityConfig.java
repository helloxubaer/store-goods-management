package com.mycompany.storemanager.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// jdbc authentication
	// autowire secure-datasource
	@Autowired
	@Qualifier("StoreAppSecurityDataSource")
	private DataSource securityDatasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add in-memory authentication
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("Abdul").password("demopass").roles("MANAGER"))
//			.withUser(users.username("Helen").password("demopass").roles("MANAGER"))
//			.withUser(users.username("Karim").password("demopass").roles("SUPERVISOR"))
//			.withUser(users.username("Jena").password("demopass").roles("ADMIN","MANAGER"));
		
		// jdbc authentication
		
		/* ######################## */
		auth.jdbcAuthentication().dataSource(securityDatasource);
		/* ######################## */
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("MANAGER", "ADMIN","SUPERVISOR")
			.antMatchers("/products/list").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/products/deleteProduct").hasRole("ADMIN")
			//.antMatchers("/products/saveProduct").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	
			//.formLogin()
			//	.loginPage("/showLoginPage")
			//	.loginProcessingUrl("/authenticatTheUser")
			//	.permitAll();
	}
	

	
	
}
