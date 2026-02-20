package com.dsa.practice;

public class LPL_LargestOddFinder {
	
	public static int findLargestOddInString(String input) {
		
		int maxOdd = -1;
		for(char character : input.toCharArray()) {
			if(Character.isDigit(character)) {
				// In Java, char is really just a number (ASCII/Unicode value).
				// character - '0' converts a digit character to its integer value, by subtracting the ASCII value of '0'.
				// It's a common and efficient trick used in character-to-digit conversion in Java.
				int digit = character - '0';
				if(digit%2 == 1 && digit > maxOdd) {
					maxOdd = digit;
				}
			}
		}
		return maxOdd;
	}
	
	public static void main(String[] args) {
		String s = "1357913579";
        int result = findLargestOddInString(s);
        
        if (result == -1) {
            System.out.println("Invalid Input: No odd digits found");
        } else {
            System.out.println("Largest odd digit: " + result);
        }
	}
}