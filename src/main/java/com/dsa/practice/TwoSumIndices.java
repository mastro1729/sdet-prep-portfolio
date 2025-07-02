package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIndices {
	
	public static int[] twoSumIndices(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				int first = i;
				int second = map.get(complement);
				return new int[] {Math.min(first, second), Math.max(first, second)};
				// return new int[] {i, map.get(complement)};
			}
			else {
				map.put(nums[i], i);
			}
		}
		 throw new IllegalArgumentException("No valid pair found");
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSumIndices(nums, target);
		System.out.println("Values: [" + result[0] + ", " + result[1] + "]");
		}
}