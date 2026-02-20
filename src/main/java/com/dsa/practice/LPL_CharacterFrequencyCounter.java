package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class LPL_CharacterFrequencyCounter {
	
	public static Map<Character, Integer> countCharacters(String input){
		Map<Character, Integer> map = new HashMap<>();
		
		for(char ch : input.toCharArray()) {
			if(Character.isLetter(ch)) {
				char character = Character.toLowerCase(ch); 
				map.put(character, map.getOrDefault(character, 0)+1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		String ip = "this is automation testing";
		Map<Character, Integer> map = countCharacters(ip);
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " appears " + entry.getValue() + " times.");
		}
	}
}