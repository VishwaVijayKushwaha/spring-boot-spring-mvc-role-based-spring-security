package com.vishwavijay.sample.springbootspringmvcspringsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AccessControll extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void setApplicationContext(AuthenticationManagerBuilder authBuilder) {
		try {
			authBuilder.inMemoryAuthentication().withUser("admin").password("password").roles("admin");
			authBuilder.inMemoryAuthentication().withUser("user").password("password").roles("user");
			authBuilder.inMemoryAuthentication().withUser("tester").password("password").roles("tester");
		} catch (Exception e) {
			throw new RuntimeException("Unable to create inMemoryAuthentication.", e);
		}
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	        .antMatchers("/page/**")
	        .antMatchers("/resources/**")
	        .antMatchers("/publics/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    	.csrf().disable()
	        .authorizeRequests()
	        .antMatchers("/api/data/admin").hasRole("admin")
	        .antMatchers("/api/data/user").hasRole("user")
	        .antMatchers("/api/data/tester").hasRole("tester")
	        .antMatchers("/page/**", "/api/logout").anonymous()
	        .anyRequest().authenticated()
	        .and()
				.formLogin().loginPage("/page/login")
				.defaultSuccessUrl("/page/home")
				.failureUrl("/page/error")
				.usernameParameter("username").passwordParameter("password")
				.loginProcessingUrl("/checkMyCredential")
			.and()
				.logout().logoutSuccessUrl("/api/logout");
	    		
	}
}
