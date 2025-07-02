package com.dsa.practice;

import java.util.Arrays;

public class StringReverseWithSpaces {
	
	public static String reverseKeepingSpaces(String input) {
		char[] inputArray = input.toCharArray();
		char[] resultArray = new char[inputArray.length];
		
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] == ' ') {
				resultArray[i] = ' ';
			}
		}
		
		int j = inputArray.length-1;
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] != ' ') {
				while(j >= 0 && resultArray[j] == ' ') {
					j--;
				}
				resultArray[j] = inputArray[i];
				j--;
			}
		}
		return new String(resultArray);
	}
	
	public static void main(String[] args) {
		String input = "I am a boy!";
		String output = reverseKeepingSpaces(input);
		System.out.println("The output is: " + output);
	}
}