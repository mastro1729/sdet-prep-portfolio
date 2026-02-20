package com.dsa.practice;

public class AgeChecker {
	
	public static String checkAgeCategory(int age) {
		if(age >= 18) {
			return "Adult";
		} else {
			return "Teen";
		}
	}
	
	public static void main(String[] args) {
		String result1 = AgeChecker.checkAgeCategory(31);
		System.out.println(result1);
		String result2 = AgeChecker.checkAgeCategory(9);
		System.out.println(result2);
	}
}