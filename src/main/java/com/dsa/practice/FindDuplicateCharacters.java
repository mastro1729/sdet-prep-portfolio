package com.dsa.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateCharacters {
	
	public static List<Character> findDuplicates(String str) {
		Map<Character,Integer> charCount = new HashMap<>();
		List<Character> duplicateList = new ArrayList<>();
		
		for(char ch : str.toCharArray()) {
			charCount.put(ch, charCount.getOrDefault(ch, 0)+1);
		}
		
		// Looping thru each key-value pair in the map
		for(Map.Entry<Character, Integer> entry : charCount.entrySet()) {
			if(entry.getValue() > 1) {
				duplicateList.add(entry.getKey());
			}
		}
		return duplicateList;
	}
	
	public static void main(String[] args) {
		String input = "Beautiful Day";
		List<Character> duplicateList = findDuplicates(input);
		System.out.println(duplicateList);
	}
}