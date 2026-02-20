package com.dsa.practice;

public class LargestNumberChecker {
	
	public static String findLargest(int num1, int num2, int num3) {
		if(num1 > num2 && num1 > num3) {
			return num1 + " is the largest among the given 3";
		} else if (num2 > num1 && num2 > num3) {
			return num2 + " is the largest among the given 3";
		} else if (num3 > num1 && num3 > num2) {
			return num3 + " is the largest among the given 3";
		} else {
			return "Two or more numbers are equal and largest.";
		}
	}
	
	public static void main(String[] args) {
		int a1 = 10, b1 = 20, c1 = 30;
		String result1 = LargestNumberChecker.findLargest(a1, b1, c1);
		System.out.println(result1);
		
		int a2 = 45, b2 = 12, c2 = 9;
		String result2 = LargestNumberChecker.findLargest(a2, b2, c2);
		System.out.println(result2);
		
		int a3 = 10, b3 = 10, c3 = 10;
		String result3 = LargestNumberChecker.findLargest(a3, b3, c3);
		System.out.println(result3);
	}
}