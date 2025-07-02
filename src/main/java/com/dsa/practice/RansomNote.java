package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		
		Map<Character, Integer> freqMap = new HashMap<>();
		
		for(char ch : magazine.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
		}
		
		for(char ch : ransomNote.toCharArray()) {
			if(!freqMap.containsKey(ch) || freqMap.get(ch) == 0) {
				return false;
			}
			freqMap.put(ch, freqMap.get(ch)-1);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String ransomNote1 = "hello";
		String magazine = "hellworld";
		boolean result1 = canConstruct("hello", "hellworld");
		System.out.println(result1);
		
		String ransomNote2 = "notes";
		String magazine2 = "stoned";
		boolean result2 = canConstruct("notes", "stoned");
		System.out.println(result2);
		
		String ransomNote3 = "apple";
		String magazine3 = "pale";
		boolean result3 = canConstruct("apple", "pale");
		System.out.println(result3);
	}
}