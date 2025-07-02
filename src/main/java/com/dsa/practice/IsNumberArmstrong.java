package com.dsa.practice;

public class IsNumberArmstrong {
	
	public static boolean isNumberArmstrong(int num) {
		if(num < 0) {
			return false;
		}
		int original = num;
		int n = String.valueOf(num).length();
		int sum = 0;
		
		while(num != 0) {
			int digit = num%10;
			sum = sum + power(digit, n);
			num = num/10;
		}
		return original == sum;
	}
	
	public static int power(int base, int exp) {
		int result = 1;
		for(int i=0; i<exp; i++) {
			 result = result*base;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int input = 153;
		boolean result = isNumberArmstrong(input);
		if(result) {
			System.out.println("The given number is an Armstrong");
		} else {
			System.out.println("The given number is not an Armstrong");
		}
	}
}