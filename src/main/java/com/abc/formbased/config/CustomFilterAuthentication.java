package com.abc.formbased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.abc.customfilter.BrowserFilter;

@Configuration
@EnableWebSecurity
public class CustomFilterAuthentication {
	
	
	/*
	 * This Class will be commented after once everything works, without comment we can find one more class
	 */
	

	//Initially HttpRequest from client --->ServletDispatcher--->Filters--->FilterChain-->SecurityFilterChain-->if Errors-->Exception
	//SecurityFilterChain---internally following steps will do 
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		//1. Http request checking Filter of it, this request what can access the Resources
		httpSecurity
		//2. First we need to filter if we have the customized filter are there based on before or after the some other filters
					.addFilterBefore(new BrowserFilter(), BasicAuthenticationFilter.class)
		//3. after custom filter we need to validate (authenticate) for that we are using the authorizeHttpRequest
					.authorizeHttpRequests(
		//4.this is lamda Customizer interface it implemented by AuthorizeHttpRequestsConfigurer or Manager for that in our implementation
		//telling which end point should be allowed
							configure-> configure
										.requestMatchers(HttpMethod.GET, "/employees/**").hasRole("ADMIN")
		//if we use the requestMatcher (String) then permitAll comes, here already we are restricting ADMIN, so permit all wont come
										.anyRequest() 
		//5. if any request comes to /employess as ADMIN role members only we are AUTHENTICATING.
										.authenticated())
					
		//6. to validate whether the user is ADMIN or other ROLES giving the Login page sending them
		//7. NOTE : how we are validing the USER, by using the basic authentication or LoginPage or some other stuff we need to give here
		//Basic Authentication means Spring security given Login page will come
										
									//.formLogin(
		//8. instead of the httpBasic(Customizer.withDefaults()) we used the form based authentication
										//	formLoginConfigurer->formLoginConfigurer
		//9. form login takes Customizer has the Functional interface and gives formLoginConfigurer class
											//.loginPage("/customlogin")
		//10. login page controller name I have given here , once the any person comes this page, there we are telling that
		//give the username and password, so for this we are permitting the all 
											//.permitAll()
										//	)
							.httpBasic(Customizer.withDefaults())
		//Note : 1. we restricted the URL 2. once the authentication correct then only allowing. 3. for authentication purpose login page created
									.csrf(
											//because internally we are calling the AbstractHttpconfigrer disabled only
//									  csrfConfigurer->csrfConfigurer.disable()
											AbstractHttpConfigurer::disable
										);
				
		return httpSecurity.build();

	}
}
