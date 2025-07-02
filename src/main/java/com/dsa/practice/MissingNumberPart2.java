package com.dsa.practice;

public class MissingNumberPart2 {
	// You are given an array nums of n distinct integers in the range [1, n].
	// Exactly one number is missing from the range.
	// Return the missing number.
	
   // Case 2: Range is 1 to n
   // Total numbers = n
  // If 1 number is missing, you'll be given n - 1 elements.
  // But the formula n * (n + 1) / 2 requires the full n, so:
		
	public static int missingNumber(int[] array) {
		int n = array.length+1;
		int expectedSum = n*(n+1)/2;
		int actualSum = 0;
		
		for(int num : array) {
			actualSum = actualSum + num;
		}
		return expectedSum-actualSum;
	}
	
	public static void main(String[] args) {
		int[] array = {8, 2, 4, 5, 3, 7, 1};
		int missing = missingNumber(array);
		System.out.println("The Missing number is: " + missing);
	}
}