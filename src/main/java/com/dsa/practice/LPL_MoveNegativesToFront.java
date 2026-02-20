package com.dsa.practice;

import java.util.Arrays;

public class LPL_MoveNegativesToFront {
	
	public static int[] moveNegativesToFront(int[] array) {
		int[] result = new int[array.length];
		
		int i=0;
		// Add negatives
		for(int num : array) {
			if(num < 0) {
				result[i]=num;
				i++;
			}
		}
		
		// Add positives
		for(int num : array) {
			if(num >= 0) {
				result[i]=num;
				i++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] input = {5,-10,2,8,-15,-9,12,6};
		System.out.println("Array before moving negatives to the front: " + Arrays.toString(input));
		int[] result = moveNegativesToFront(input);
		System.out.println("Array after moving negatives to the front: " + Arrays.toString(result));
	}
}