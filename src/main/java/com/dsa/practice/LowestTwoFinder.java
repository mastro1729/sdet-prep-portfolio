package com.dsa.practice;

public class LowestTwoFinder {
	public static int[] lowestTwoFinder(int[] array) {
		if(array == null || array.length < 2) {
			return null;
		}
		
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		for(int num : array) {
			if(num < first) {
				second = first;
				first = num;
			} else if (num < second && num > first) {
				second = num;
			}
		}
		
		if(second == Integer.MAX_VALUE) {
			return new int[] {first, -1};
		}
		return new int[] {first, second};
	}
	
	public static void main(String[] args) {
		// int[] array = null;
		// int[] array = {1};
		// int[] array = {1, 1, 1};
		 int[] array = {12, 35, 1, 10, 34, 1};
		
		int[] result = lowestTwoFinder(array);
		
		if(result == null) {
			System.out.println("Invalid input or not enough elements");
		} else if(result[1] == -1) {
			System.out.println("Smallest: " + result[0]);
			System.out.println("Second Smallest Has Not Found");
		} else {
			System.out.println("Smallest: " + result[0]);
			System.out.println("Second Smallest: " + result[1]);
		}

	}

}
