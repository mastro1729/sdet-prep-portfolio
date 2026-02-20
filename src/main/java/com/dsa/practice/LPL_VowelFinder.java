package com.dsa.practice;

import java.util.ArrayList;
import java.util.List;

public class LPL_VowelFinder {
	
	public static List<Character> findVowels(String input){
		List<Character> vowels = new ArrayList<>();
		for(char character : input.toCharArray()) {
			char ch = Character.toLowerCase(character);
			if(ch == 'a' || ch == 'e'  || ch == 'i'  || ch == 'o'  || ch == 'u' ) {
				vowels.add(character);
			}
		}
		return vowels;
	}
	
	public static void main(String[] args) {
		String input = "Automation";
        List<Character> result = findVowels(input);
        System.out.println("Vowels found: " + result);
	}
}