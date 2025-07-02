package com.dsa.practice;

public class LargestNumberWithoutIf {
	public static int findLargestNumber(int[] nums) {
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input array cannot be null or empty");
		
		int largestNumber = Integer.MIN_VALUE;
		
		for(int num : nums) {
			largestNumber = Math.max(num, largestNumber);
		}
		return largestNumber;
	}
	
	public static void main(String[] args) {
		int[] inputArray = {12, 45, 7, 89, 34};
		int largestNumber = findLargestNumber(inputArray);
		System.out.println("Largest Number: " + largestNumber);
	}
}