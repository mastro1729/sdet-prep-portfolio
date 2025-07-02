package com.dsa.practice;

public class NextGreaterPermutation {
	// 0123
	public static int findNextPermutation(int num) { // 2543

		char[] digits = String.valueOf(num).toCharArray();
		int length = digits.length;

		int pivotIndex = length - 2;
		while (pivotIndex >= 0 && digits[pivotIndex] >= digits[pivotIndex + 1]) {
			pivotIndex--;
		}

		if (pivotIndex < 0) {
			return -1;
		}

		int swapIndex = length - 1;
		while (digits[swapIndex] <= digits[pivotIndex]) {
			swapIndex--;
		}

		swap(digits, pivotIndex, swapIndex);

		reverse(digits, pivotIndex + 1, length - 1);

		long result = Long.parseLong(new String(digits));
		return result <= Integer.MAX_VALUE ? (int) result : -1;
	}

	public static void swap(char[] array, int start, int end) {
		char temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}

	public static void reverse(char[] array, int start, int end) {
		while (start < end) {
			swap(array, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		NextGreaterPermutation ngp = new NextGreaterPermutation();

		int[] testCases = { 123, 321, 534976, 124653, 111, 987654321 };

		for (int num : testCases) {
			int result = ngp.findNextPermutation(num);
			System.out.println("Next permutation of " + num + " is: " + result);
		}
	}
}