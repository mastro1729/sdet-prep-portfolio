package com.dsa.practice;

public class LPL_NumberConcatenator {
	
	public static String concatenateNumbers(String input) {
		StringBuilder result = new StringBuilder();
		
		for(char ch : input.toCharArray()) {
			if(ch >= '0' && ch <= '9') {
				result.append(ch);
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String input = "C6L9B4M7Y3";
        String output = concatenateNumbers(input);
        System.out.println("Concatenated Digits: " + output); // Output: 69473
	}
}