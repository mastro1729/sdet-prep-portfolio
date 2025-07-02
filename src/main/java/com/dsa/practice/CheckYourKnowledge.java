package com.dsa.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckYourKnowledge {

	public static String stringReverse(String str) {
		String[] words = str.trim().split("\\s+");
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=words.length-1; i>=0; i--) {
			sb.append(words[i]);
			if(i != 0) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String input = "I Love Java and Selenium WebDriver";
		String result = stringReverse(input);
		System.out.println("The reversed String is: " + result);
	}
}