package com.dsa.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonrepeatingCharacter {
	
	public static char firstNonrepeatingCharacter(String str) {
		Map<Character, Integer> freqMap = new LinkedHashMap<>();
		
		// Count frequency of each character
		for(char ch : str.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
		}
		
		// Find first character with frequency 1
		for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		// Null character if no non-repeating character found
		return '\0';
	}
	
	public static void main(String[] args) {
		String input1 = "apple";
		char result1 = firstNonrepeatingCharacter(input1);
		System.out.println("Largest unique number: " + result1);
		
		String input2 = "abcab";
		char result2 = firstNonrepeatingCharacter(input2);
		System.out.println("Largest unique number: " + result2);
		
		String input3 = "abab";
		char result3 = firstNonrepeatingCharacter(input3);
		System.out.println("Largest unique number: " + result3);
	}
}