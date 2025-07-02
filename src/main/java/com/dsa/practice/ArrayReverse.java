package com.dsa.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Arrays.copyOf() method belongs to Java's java.util.Arrays utility class.
	It takes two arguments:
		nums	Source array you want to copy
		nums.length	Length of the new array*/

public class ArrayReverse {
	
	public static int[] arrayReverse(int[] nums) {
		int left=0;
		int right=nums.length-1;
		
		/*Creates a new array called reversed, 
		which is a copy of the original array (nums), with the same length and same elements.*/
		int[] reversed = Arrays.copyOf(nums, nums.length);
		
		while(left<right) {
			int temp = reversed[left];
			reversed[left] = reversed[right];
			reversed[right] = temp;
			
			left++;
			right--;
		}
		return reversed;
	}
	
	public static void main(String[] args) {
		int[] input = {4, 5, 2, 6}; 
		int[] result = arrayReverse(input);
		System.out.println("The original Array is: " + Arrays.toString(input));
		System.out.println("The reversed Array is: " + Arrays.toString(result));
	}
}