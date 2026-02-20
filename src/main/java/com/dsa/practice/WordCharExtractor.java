package com.dsa.practice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WordCharExtractor {

	public static char getNthFromLastChar(String word, int n) {
		if (word == null || word.length() < n) {
			throw new IllegalArgumentException("Word is too short for requested index: " + word);
		}
		return word.charAt(word.length() - n);
	}

	public static String extractUniqueNthFromLastChars(String sentence, int n) {
		String[] words = sentence.split("\\s+");
		Set<Character> uniqueChars = new LinkedHashSet<>();

		for (String word : words) {
			if (word.length() < n)
				continue;
			char ch = getNthFromLastChar(word, n);
			uniqueChars.add(ch);
		}

		// Convert characters to string list for joining
		List<String> result = new ArrayList<>();
		for (char ch : uniqueChars) {
			result.add(String.valueOf(ch));
		}
		return String.join(" ", result);
	}

	public static void main(String[] args) {
		String input = "I am an automation tester";

		System.out.println("Sentence: " + input);
		System.out.println("Last chars:        " + extractUniqueNthFromLastChars(input, 1));
		System.out.println("Second last chars: " + extractUniqueNthFromLastChars(input, 2));
		System.out.println("Third last chars:  " + extractUniqueNthFromLastChars(input, 3));
	}
}