package com.dsa.practice;

import java.util.HashSet;
import java.util.Set;

public class PairSum {
	public static Set<String> findPairs(int[] nums, int target) {
		Set<Integer> seen = new HashSet<>();
		Set<String> result = new HashSet<>();

		for (int num : nums) {
			int complement = target - num;
			if (seen.contains(complement)) {
				int min = Math.min(num, complement);
				int max = Math.max(num, complement);
				String pair = "(" + min + ", " + max + ")";
				result.add(pair);
			}
			seen.add(num);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 3, 5, 7, 8, 1, 9 };
		int target = 10;
		Set<String> pairs = findPairs(array, target);
		
		for(String pair : pairs) {
			System.out.println(pair);
		}
	}
}