package com.dsa.practice;

public class ReverseSmallestAndLargest {

	public static String reverseSmallestAndLargest(String str) {
		if (str == null || str.trim().isEmpty())
			return "Input String can't be null or empty";

		String[] words = str.trim().split("\\s+");

		String smallest = words[0];
		String largest = words[0];

		// Find the smallest and largest word based on length
		for (String word : words) {
			if (word.length() < smallest.length())
				smallest = word;
			if (word.length() > largest.length())
				largest = word;
		}

		StringBuilder sb = new StringBuilder();

		// Reconstruct the sentence with reversed smallest and largest words
		for (String word : words) {
			if (word.length() == smallest.length() || word.length() == largest.length()) {
				sb.append(new StringBuilder(word).reverse()).append(" ");
			} else {
				sb.append(word).append(" ");
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		String input = "Java is beautiful programming language";
		String result = reverseSmallestAndLargest(input);
		System.out.println("The result is: " + result);
	}
}