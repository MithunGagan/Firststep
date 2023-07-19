package com.application.firststep.appsecurity;

import org.springframework.context.annotation.Bean;
/*
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity*/
public class AppSecurityConfig {
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceInfo();
	}

	@Bean
	public SecurityFilterChain userAuthorization(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/signup").permitAll()
		.and().authorizeHttpRequests().requestMatchers("/**").authenticated().and().formLogin().and().build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticator(){
		DaoAuthenticationProvider authenticated = new DaoAuthenticationProvider();
		authenticated.setUserDetailsService(userDetailsService());
		authenticated.setPasswordEncoder(passwordEncoder());
		return authenticated;
		
	}
*/
}
