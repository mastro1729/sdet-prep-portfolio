package com.dsa.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static int longestConsecutiveSequence(int[] nums) {
		// Step 1: Put all numbers in a set
		Set<Integer> set = new HashSet<>();
		
		for(int num : nums) {
			set.add(num);
		}
		
		int maxLength = 0;
		// Step 2: Loop through each number
		for(int num : set) {
			// Check if it's the start of a sequence
			// We skip num if its previous number already exists, 
			// because that means it's not the start of a new sequence.
			if(!set.contains(num - 1)) {
				int current = num;
				int count = 1;
				// Count all next numbers
				while(set.contains(current + 1)) {
					current ++;
					count ++;
				}
				maxLength = Math.max(maxLength, count);
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int[] input1 = {10, 11, 14, 12, 13};
		int result1 = longestConsecutiveSequence(input1);
		System.out.println(result1); // 5
		
		int[] input2 = {3, 6, 4, 100, 101, 102};
		int result2 = longestConsecutiveSequence(input2);
		System.out.println(result2); // 3
		
		int[] input3 = {7, 8, 10, 11, 15};
		int result3 = longestConsecutiveSequence(input3);
		System.out.println(result3); // 2
	}
}