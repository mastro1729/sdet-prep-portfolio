package com.dsa.practice;

public class IsNumberPalindrome {
	
	public static boolean isNumberPalindrome(int num) {
		if(num < 0) return false;
		
		int original = num;
		int reversed = 0; 
		
		while(num != 0) {
			int digit = num%10;
			reversed = reversed*10 + digit;
			num = num/10;
		}
		return original == reversed;
	}
	
	public static void main(String[] args) {
		int input = 10;
		boolean result = isNumberPalindrome(input);
		if(result) {
			System.out.println("The given num is a palindrome");
		} else {
			System.out.println("The given num is not a palindrome");
		}
	}
}