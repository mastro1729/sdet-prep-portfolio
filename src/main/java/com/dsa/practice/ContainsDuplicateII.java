package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	
	/*Given an array of integers nums and an integer k, 
	return true if there are any two different indices i and j in the array 
				where nums[i] == nums[j] and abs(i - j) <= k. 
	Otherwise, return false.*/
	
	public static boolean containsDuplicateII(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int current = i;
				int previous = map.get(nums[i]);
				
				if(Math.abs(current - previous) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] nums1 = {10, 20, 30, 40, 50, 10};
		int k1 = 7;
		System.out.println(containsDuplicateII(nums1, k1));
		
		int[] nums2 = {7, 8, 9, 7, 10, 11};
		int k2 = 1;
		System.out.println(containsDuplicateII(nums2, k2));
		
	}
}