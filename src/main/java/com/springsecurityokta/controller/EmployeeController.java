package com.springsecurityokta.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/test")
//	@RolesAllowed("USER")//have limited capabilities, use the PreAuthorize
	public String get() {
		return "test";
	}
}
