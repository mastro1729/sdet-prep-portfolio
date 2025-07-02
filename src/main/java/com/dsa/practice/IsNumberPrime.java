package com.dsa.practice;

public class IsNumberPrime {
	
	public static boolean isNumberPrime(int num) {
		if(num < 2) return false;
		
		if(num ==2) return true;
		
		if(num%2 == 0) return false;
		
		// Non-trivial factors are the factors of a number excluding 1 and the number itself."
		// We use i <= Math.sqrt(num) because of a mathematical property of factors:
		// If a number num has any non-trivial factor (other than 1 and itself), 
		// at least one of its factors will definitely be less than or equal to the square root of num.
		
		// Using i <= num would work logically, but it’s not time efficient.
		// For large numbers, the unnecessary iteration up to num would degrade performance 
		// from O(√n) time complexity to O(n), which is not good especially for large inputs.
		
		for(int i=3; i<=Math.sqrt(num); i=i+2) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int input = 5;
		boolean result = isNumberPrime(input);
		if(result) {
			System.out.println("The given num is a prime");
		} else {
			System.out.println("The given num is not a prime");
		}
	}
}