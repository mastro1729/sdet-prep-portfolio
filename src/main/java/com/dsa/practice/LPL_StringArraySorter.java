package com.dsa.practice;

import java.util.Arrays;

public class LPL_StringArraySorter {
	
	// str1.compareTo(str2) returns:
		// < 0 → if str1 comes before str2
		// > 0 → if str1 comes after str2
		// 0 → if they are equal

	public static String[] sortStringArray(String[] array) {
		int n = array.length;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(array[i].compareTo(array[j]) > 0) {
					String temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		String[] input = {"cat", "apple", "dog", "banana"};
		System.out.println("Original array: " + Arrays.toString(input));
		String[] output = sortStringArray(input);
        System.out.println("Sorted array: " + Arrays.toString(output));
	}
}