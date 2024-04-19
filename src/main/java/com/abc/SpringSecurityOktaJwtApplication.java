package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityOktaJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOktaJwtApplication.class, args);
		
		System.out.println("http://localhost:8288/employees/customlogin");
	}

}
