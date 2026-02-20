package com.dsa.practice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class LPL_DuplicateWordRemover  {
	
	public static String removeDuplicateWords(String input) {
		String[] words = input.trim().split("\\s+");
		Set<String> uniqueWords = new LinkedHashSet<>();
		for(String word : words) {
			uniqueWords.add(word);
		}
		return String.join(" ", uniqueWords);
	}
	
	public static void main(String[] args) {
		String input = "I am Manideep and I am an engineer";
        String result = removeDuplicateWords(input);
        System.out.println("Result after removing duplicate words (order preserved): " + result);
	}
}