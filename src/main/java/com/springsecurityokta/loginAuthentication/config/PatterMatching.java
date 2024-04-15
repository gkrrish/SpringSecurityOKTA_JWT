package com.springsecurityokta.loginAuthentication.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class PatterMatching {
	
	public void testMethod(String[] args) {
		String givenString = "ababababa";
		String subString = "aba";
		

		//ForLoop way
		int countOfOccurences = 0;
		for (short i = 0; i < givenString.length()-1; i++) {
			
			if (i < givenString.length()) {
				if (givenString.charAt(i+0) == subString.charAt(0) && 
					givenString.charAt(i+1) == subString.charAt(1) && 
					givenString.charAt(i+2) == subString.charAt(2)) {
					countOfOccurences++;
				}
			}
		}
		System.out.println("ForLoop : "+countOfOccurences);
		
		// StringUtils
		int countOccurrencesOf = StringUtils.countOccurrencesOf(givenString, subString);
		System.out.println("StringUtils :"+countOccurrencesOf);

		// using the patterns and Matchers
		Pattern pattern = Pattern.compile(subString);
		Matcher matcher = pattern.matcher(givenString);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		System.out.println("Matcher : "+count);
		
		//using SubString
		int subStringCount=0;
		for(short i=0; i<=givenString.length()-subString.length(); i++) {
			if(givenString.substring(i, i+subString.length()).equals(givenString)) {
				subStringCount++;
			}
		}
		System.out.println("SubString :"+subStringCount);
		
	}
}

/* Note :
ForLoop : 4
StringUtils :2
Matcher : 2
SubString :0

these are getting errors, need to check
*/
