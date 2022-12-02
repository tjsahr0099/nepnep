package com.nepnep.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	/**
	 * https://gksdudrb922.tistory.com/217#MemberRepository
	 */

	private final JwtTokenProvider jwtTokenProvider;

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.httpBasic().disable().csrf().disable()
//		.headers().frameOptions().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.requestMatchers("/api/**").permitAll().anyRequest().authenticated().and().addFilterBefore(
						new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
//				.and().logout().disable();

		return http.build();
	}

}
