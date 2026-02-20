package com.dsa.practice;

public class LPL_SentenceReverser {
	// Reverse sentence but keep word position unchanged
	public static String reverseCharactersInWords(String sentence) {
		String[] words = sentence.split("\\s+");
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<words.length; i++) {
			StringBuilder reversedWord = new StringBuilder(words[i]).reverse();
			result.append(reversedWord);
			
			if(i != words.length-1) {
				result.append(" ");
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String input = "this is automation testing";
        String output = reverseCharactersInWords(input);
        
        System.out.println("Original sentence: " + input);
        System.out.println("Reversed words (positions unchanged): " + output);
	}
}