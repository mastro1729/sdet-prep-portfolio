package com.dsa.practice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class LPL_ArrayDuplicateRemover {
	
	public static int[] removeDuplicatesAndSort(int[] array) {
		Set<Integer> set = new LinkedHashSet<>();
		for(int num : array) {
			set.add(num);
		}
		
		// Convert Set<Integer> to int[]
		int i=0;
		int[] result = new int[set.size()];
		for(int num : set) {
			result[i] = num;
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 1, 1, 2, 2, 2, 2, 9, 9, 56, 7, 5};
		System.out.println("Original array: " + Arrays.toString(input));
		int[] output = removeDuplicatesAndSort(input);
		System.out.println("Original array without duplicates: " + Arrays.toString(output));
		
		int n = output.length;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(output[i] < output[j]) {
					int temp = output[i];
					output[i] = output[j];
					output[j] = temp;
				}
			}
		}

        System.out.println("Sorted array: " + Arrays.toString(output));
	}
}