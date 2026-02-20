package com.dsa.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LPL_RepeatingCharacterFinder {

	public static Map<Character, Integer> getCharacterFrequencyMap(String input){
		Map<Character,Integer> map = new LinkedHashMap<>();
		for(char ch : input.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		return map;
	}
	
	public static void main(String[] args) {
		String ip = "dallas";
		Map<Character, Integer> map = getCharacterFrequencyMap(ip);
		
		List<Character> repeating = new ArrayList<>();
		List<Character> nonRepeating = new ArrayList<>();
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				nonRepeating.add(entry.getKey());
			} else {
				repeating.add(entry.getKey());
			}
		}
		
		System.out.println("Repeating Characters: " + repeating);
		System.out.println("Non-Repeating Characters: " + nonRepeating);
	}
}