package com.dsa.practice;

import java.util.Arrays;

public class LeftandRightSumDifferences {

	public static int[] leftandRightSumDifferences(int[] nums) {
		int totalSum = 0;
		int rightSum = 0;
		int leftSum = 0;
		
		int[] result = new int[nums.length];
		
		for(int num : nums) {
			totalSum = totalSum + num;
		}
		
		for(int i=0; i<nums.length; i++) {
			rightSum = totalSum - leftSum - nums[i];
			result[i] = Math.abs(rightSum - leftSum);
			leftSum = leftSum + nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {2, 5, 1, 6, 1};
		int[] result1 = leftandRightSumDifferences(nums1);
		System.out.println(Arrays.toString(result1));
		
		int[] nums2 = {3, 3, 3};
		int[] result2 = leftandRightSumDifferences(nums2);
		System.out.println(Arrays.toString(result2));
		
		int[] nums3 = {1, 2, 3, 4, 5};
		int[] result3 = leftandRightSumDifferences(nums3);
		System.out.println(Arrays.toString(result3));
	}
}