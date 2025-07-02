package com.dsa.practice;

public class HighestTwoFinder {

	public static int[] highestTwoFinder(int[] array) {

		if (array == null || array.length < 2) {
			return null;
		}

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for (int num : array) {
			if (num > first) {
				second = first;
				first = num;
			} else if (num != first && num > second) {
				second = num;
			}
		}

		if (second == Integer.MIN_VALUE) {
			return new int[] { first, -1 };
		}
		return new int[] { first, second };
	}

	public static void main(String[] args) {
		// int[] array = null;
		// int[] array = {1};
		// int[] array = { 5, 5, 5 };
		 int[] array = {12, 35, 1, 10, 34, 1};
		int[] result = highestTwoFinder(array);

		if (result == null) {
			System.out.println("Invalid input or not enough elements");
		} else if (result[1] == -1) {
			System.out.println("Highest: " + result[0]);
			System.out.println("Second Highest Has Not Found");
		} else {
			System.out.println("Highest: " + result[0]);
			System.out.println("Second Highest: " + result[1]);
		}
	}
}