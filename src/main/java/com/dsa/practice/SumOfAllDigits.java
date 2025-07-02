package com.dsa.practice;

public class SumOfAllDigits {
	
	public static int sumOfAllDigits(int number) {
		String input = String.valueOf(number);
		int sum = 0;
		
		for(char ch : input.toCharArray()) {
			sum = sum + Character.getNumericValue(ch);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int input = 12345;
		int result = sumOfAllDigits(input);
		System.out.println("The Sum of All Digits is: " + result);
	}
}