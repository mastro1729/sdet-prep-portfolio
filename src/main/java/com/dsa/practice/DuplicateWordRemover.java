package com.dsa.practice;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateWordRemover {
	
	public static String removeDuplicateWords(String input) {
		String[] words = input.trim().split("\\s+");
		Set<String> set = new LinkedHashSet<>();
		
		for(String word : words) {
			set.add(word);
		}
		
		return String.join(" ", set);
	}
	
	public static void main(String[] args) {
		String input = "My name is is name Mani";
		String result = removeDuplicateWords(input);
		System.out.println("The result is: " + result);
	}

}
