package com.dsa.practice;

public class FirstLastOccurrence {
	
	public static int[] firstLastOccurrence(int[] array, int target) {
		int firstIndex=-1;
		int lastIndex=-1;
		
		for(int i=0; i<array.length; i++) {
			if(array[i] == target) {
				if(firstIndex == -1) {
					firstIndex = i;
				}
				lastIndex = i;
			}
		}
		return new int[] {firstIndex, lastIndex};
	}
	
	public static void main(String[] args) {
		int[] input = {5, 3, 7, 3, 9, 3, 1};
		int target = 3;
		int[] result = firstLastOccurrence(input, target);
		
		if(result[0]==-1) {
			System.out.println("Element " + target + " not found in the array.");
		} else {
			System.out.println("First occurrence of " + target + " is at an index " + result[0]);
			System.out.println("Last occurrence of " + target + " is at an index " + result[1]);
		}
	}
}