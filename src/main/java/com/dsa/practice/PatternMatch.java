package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class PatternMatch {
	
	public static boolean wordPattern(String pattern, String str) {
		
		String[] words = str.split(" ");
		
		// Step 1: Check if pattern length matches number of words
		if(pattern.length() != words.length) {
			return false;
		}
		
		// Two maps are needed to ensure both uniqueness and consistency in both directions — 
		// character to word, and word to character — which is essential for correct pattern matching.
		
		// Step 2: Create two maps
		Map<Character, String> charToWord = new HashMap<>();
		Map<String, Character> wordToChar = new HashMap<>();
		
		// Step 3: Check pattern-word mapping
		for(int i=0; i<words.length; i++) {
			char ch = pattern.charAt(i);
			String word = words[i];
			
			// If character is already mapped
			if(charToWord.containsKey(ch)) {
				if(!charToWord.get(ch).equals(word)) {
					return false;
				}
			} else {
				// If word is already mapped to some other character
				if(wordToChar.containsKey(word)) {
					return false;
				}
			}
			 // New valid mapping
			charToWord.put(ch, word);
			wordToChar.put(word, ch);
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Result: " + wordPattern("abba", "dog cat cat dog"));   // true
        System.out.println("Result: " + wordPattern("abba", "dog cat cat fish"));  // false
        System.out.println("Result: " + wordPattern("aaaa", "dog cat cat dog"));   // false
        System.out.println("Result: " + wordPattern("abba", "dog dog dog dog"));   // false
	}
}