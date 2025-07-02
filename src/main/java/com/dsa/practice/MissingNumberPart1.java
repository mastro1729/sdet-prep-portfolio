package com.dsa.practice;

// You are given an array nums of n distinct integers in the range [0, n].
// Exactly one number is missing from the range.
// Return the missing number.

// Case 1: Range is 0 to n
// Total numbers in the full range = n + 1
// If 1 number is missing, you'll be given n elements.
// The formula n * (n + 1) / 2 gives the sum of all numbers from 0 to n

public class MissingNumberPart1 {
	public static int missingNumber(int[] array) {
		int n = array.length+1;
		int expectedSum = n * (n+1)/2;
		int actualSum = 0;
		
		for(int num : array) {
			actualSum = actualSum + num;
		}
		return expectedSum - actualSum;
	}
	
	public static void main(String[] args) {
		int[] array = {8, 2, 4, 5, 3, 7, 1};
		int result = missingNumber(array);
		System.out.println("The Missing number is: " + result);
	}
}