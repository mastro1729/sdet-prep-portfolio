package com.dsa.practice;

public class LPL_FullStringReverser {
	
	public static String reverseString(String sentence) {
		String[] words = sentence.split("//s+");
		StringBuilder result = new StringBuilder();
		
		for(int i=words.length-1; i>=0; i--) {
			StringBuilder reversed = new StringBuilder(words[i]).reverse();
			result.append(reversed);
			
			if(i != 0) {
				result.append(" ");
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String input = "this is automation testing";
        String output = reverseString(input);
        
        System.out.println("Original sentence: " + input);
        System.out.println("Reversed sentence: " + output);
	}
}