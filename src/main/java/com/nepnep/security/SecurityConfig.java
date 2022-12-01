package com.nepnep.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		 http
         .csrf().disable()
         .headers().frameOptions().disable()
         .and().authorizeRequests() 
         .requestMatchers("/api/**").permitAll()  
         .anyRequest().authenticated()
         .and().addFilter(null)
//         .logout()
//         .logoutSuccessUrl("/")
         ;

         return http.build();
	}
	
	
}
