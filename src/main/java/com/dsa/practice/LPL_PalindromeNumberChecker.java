package com.dsa.practice;

public class LPL_PalindromeNumberChecker {
	
	public static boolean isPalindromeNumber(int num) {
		// Negative numbers can't be palindromes
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
		int ip = -121;
        boolean result = isPalindromeNumber(ip);
        if(result) {
			System.out.println("The given num " + ip + " is a palindrome");
		} else {
			System.out.println("The given num " + ip + " is not a palindrome");
		}
	}
}