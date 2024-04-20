/*package com.abc.formbased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeHttpRequests(
						authorize -> authorize
									.requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
									.requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
			                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
			                        .requestMatchers(HttpMethod.PUT,  "/employees").hasRole("MANAGER")
			                        .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
			                        )
				.httpBasic(AbstractHttpConfigurer::disable);
				

		return httpSecurity.build();

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
} */