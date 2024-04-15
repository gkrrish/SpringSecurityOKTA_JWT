package com.springsecurityokta.loginAuthentication.config;

public class DivyaTest {
	public static void main(String[] args) {
		String statment = "ababababa";
		String matcher = "aba";
		int countOfOccurences = 0;

		for (short i = 0; i < statment.length()-1; i++) {
			
			if (i < statment.length()) {
				if (statment.charAt(i+0) == matcher.charAt(0) && 
					statment.charAt(i+1) == matcher.charAt(1) && 
					statment.charAt(i+2) == matcher.charAt(2)) {
					countOfOccurences++;
				}
			}
		}
		System.out.println(countOfOccurences);
	}
}