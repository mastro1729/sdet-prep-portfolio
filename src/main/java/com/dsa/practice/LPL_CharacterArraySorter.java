package com.dsa.practice;

import java.util.Arrays;

public class LPL_CharacterArraySorter {
	
	public static char[] sortCharArray(char[] array) {
		int n = array.length;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(array[i] > array[j]) {
					char temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		char[] input = {'c', 'y', 'z', 'n','c', 'y', 'z', 'n'};
		System.out.println("Original array: " + Arrays.toString(input));
		char[] output = sortCharArray(input);
        System.out.println("Sorted array: " + Arrays.toString(output));
	}
}