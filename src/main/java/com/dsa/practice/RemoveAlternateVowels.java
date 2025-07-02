package com.dsa.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveAlternateVowels {
	
	public static String removeAlternateVowels(String str) {
		Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int vowelCount=0;
		StringBuilder sb = new StringBuilder();
		
		for(char ch : str.toCharArray()) {
			char lowerCh = Character.toLowerCase(ch);
			if(vowels.contains(lowerCh)) {
				vowelCount++;
				
				if(vowelCount % 2 != 0) {
					sb.append(ch);
				}
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "Beautiful Day";
		String result = removeAlternateVowels(input);
		System.out.println("Original: " + input);
		System.out.println("Modified: " + result);
	}
}