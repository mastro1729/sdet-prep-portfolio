package com.dsa.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonrepeatingCharacterIndex {
	
	public static int firstNonrepeatingCharacterIndex(String str) {
		
		Map<Character, Integer> freqMap = new LinkedHashMap<>();
		
		// Step 1: Count frequencies while preserving order
		for(char ch : str.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
		}
		
		// Step 2: Find first index with frequency 1
		for(int i=0; i<str.length(); i++) {
			if(freqMap.get(str.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String input1 = "apple";
		int result1 = firstNonrepeatingCharacterIndex(input1);
		System.out.println("Index of first non-repeating character: " + result1);
		
		String input2 = "abcab";
		int result2 = firstNonrepeatingCharacterIndex(input2);
		System.out.println("Index of first non-repeating character: " + result2);
		
		String input3 = "abab";
		int result3 = firstNonrepeatingCharacterIndex(input3);
		System.out.println("Index of first non-repeating character: " + result3);
	}
}