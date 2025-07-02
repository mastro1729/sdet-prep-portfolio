package com.dsa.practice;

import java.util.HashSet;
import java.util.Set;

public class TwoSumValues {
	
	public static int[] twoSumValues(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		
		for(int num : nums) {
			int complement = target - num;
			if(set.contains(complement)) {
				return new int[] {num, complement};
			}
			else {
				set.add(num);
			}
		}
		 throw new IllegalArgumentException("No two sum values found");
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSumValues(nums, target);
		System.out.println("Values: [" + result[0] + ", " + result[1] + "]");
		}
}