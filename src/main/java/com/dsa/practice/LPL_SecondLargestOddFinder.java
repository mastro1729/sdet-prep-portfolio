package com.dsa.practice;

public class LPL_SecondLargestOddFinder {
	
	public static int findSecondLargestOddInString(String input) {
		
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		
		for(char character : input.toCharArray()) {
			if(Character.isDigit(character)) {
				int digit = character - '0';
				
				if(digit %2 == 1) {
					if(digit > first) {
						second = first;
						first = digit;
					} else if(digit > second && digit != first) {
						second = digit;
					}
				}
			}
		}
		return second;
	}
	
	public static void main(String[] args) {
		String input = "(97531),(g38@);";
		int result = findSecondLargestOddInString(input);
		
		if(result == Integer.MIN_VALUE) {
			System.out.println("Invalid Input: Less than two odd digits");
		} else {
			System.out.println("Second largest odd digit: " + result);
		}
	}
}