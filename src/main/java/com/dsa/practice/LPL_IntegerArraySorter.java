package com.dsa.practice;

import java.util.Arrays;

public class LPL_IntegerArraySorter {
	
	public static int[] sortIntegerArray(int[] array) {
		int n = array.length;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] input = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("Original array: " + Arrays.toString(input));
		int[] output = sortIntegerArray(input);
        System.out.println("Sorted array: " + Arrays.toString(output));
	}
}