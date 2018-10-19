package com.infogain;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT username, password, 1 AS enabled, first_name, last_name FROM users WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT username, role FROM users LEFT OUTER JOIN user_roles ON users.id = user_roles.user_id WHERE username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/h2/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/signup").not().authenticated()
		.antMatchers("/login").not().authenticated()
		.antMatchers("/logout").authenticated()
		.antMatchers("/user/avg").hasRole("USER")
		.antMatchers("/user/admin").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/user/dashboard").loginProcessingUrl("/processLogin").permitAll()
		.and().logout().permitAll();
		http.csrf().ignoringAntMatchers("/h2/**");
		http.headers().frameOptions().disable();
	}
}
