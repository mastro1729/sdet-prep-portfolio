package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
	
	public static int largestUniqueNumber(int[] array) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		
		// Count the frequency of each number
		for(int num : array) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		}
		
		int maxUnique = -1;
		// Find the largest number with frequency 1
		for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			if(entry.getValue() == 1) {
				maxUnique = Math.max(maxUnique, entry.getKey());
			}
		}
		return maxUnique;
	}
	
	public static void main(String[] args) {
		int[] input1 = {5, 7, 3, 7, 5, 8};
		int result1 = largestUniqueNumber(input1);
		System.out.println("Largest unique number: " + result1);
		
		int[] input2 = {1, 2, 3, 2, 1, 4, 4};
		int result2 = largestUniqueNumber(input2);
		System.out.println("Largest unique number: " + result2);
		
		int[] input3 = {9, 9, 8, 8, 7, 7};
		int result3 = largestUniqueNumber(input3);
		System.out.println("Largest unique number: " + result3);
	}
}