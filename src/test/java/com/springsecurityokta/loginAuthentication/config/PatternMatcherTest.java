package com.springsecurityokta.loginAuthentication.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatternMatcherTest {

	PatterMatching example = new PatterMatching();

	@Test
	public void testCountSubstring() {

		example.testMethod(null);

	}
}
