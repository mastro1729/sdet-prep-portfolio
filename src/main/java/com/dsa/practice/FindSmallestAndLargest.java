package com.dsa.practice;

public class FindSmallestAndLargest {
	
	public static int[] findSmallestAndLargest(int[] array) {
		
		if(array == null || array.length == 0)
			throw new IllegalArgumentException("Array must not be null or empty");
		
		int smallest = array[0];
		int largest = array[0];
		
		for(int i=1; i<array.length; i++) {
			if(array[i] < smallest)
				smallest = array[i];
			
			if(array[i] > largest)
				largest = array[i];
		}
		return new int[] {smallest, largest};
	}
	
	public static void main(String[] args) {
		int[] input = {85, 70, 61, 55, 0, 42, 33, 28, 15};
		int[] result = findSmallestAndLargest(input);
		System.out.println("The smallest is: " + result[0]);
		System.out.println("The highest is: " + result[1]);
	}
}
