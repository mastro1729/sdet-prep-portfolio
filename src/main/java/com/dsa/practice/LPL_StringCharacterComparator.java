package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class LPL_StringCharacterComparator {
	
	public static boolean areStringsCharacterEqual(String str1, String str2){
		if (str1.length() != str2.length()) return false;
		Map<Character,Integer> map1 = getCharCountMap(str1);
		Map<Character,Integer> map2 = getCharCountMap(str2);
		return map1.equals(map2);
	}
	
	private static Map<Character,Integer> getCharCountMap(String str){
		Map<Character, Integer> map = new HashMap<>();
		for(char character : str.toCharArray()) {
			map.put(character, map.getOrDefault(character, 0)+1);
		}
		return map;
	}
	
	public static void main(String[] args) {
		String str1 = "Automation1";
        String str2 = "1Automation";
        
        boolean res = areStringsCharacterEqual(str1, str2);
        if(res) {
        	System.out.println("Strings have the same characters");
        } else {
        	System.out.println("Strings differ in characters");
        }
	}
}