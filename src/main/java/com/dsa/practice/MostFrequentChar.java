package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentChar {
	
	public static char findMostFrequentChar(String str) {
		Map<Character, Integer> map = new HashMap<>();
		
		for(char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		char mostFrequentChar = '\0';
		int max = 0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > max) {
				max =  entry.getValue();
				mostFrequentChar = entry.getKey();
			}
		}
		return mostFrequentChar;
	}
	
	public static void main(String[] args) {
		String str = "banana";
        char result = findMostFrequentChar(str);
        System.out.println("Most frequent character: " + result);
	}
}