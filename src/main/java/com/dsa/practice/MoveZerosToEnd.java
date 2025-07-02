package com.dsa.practice;

import java.util.Arrays;

public class MoveZerosToEnd {
	
	public static int[] moveZerosToEnd(int[] array) {
		int counter = 0;
		
		for(int num : array) {
			if(num != 0) {
				array[counter] = num;
				counter++;
			}
		}
		
		while(counter < array.length) {
			array[counter] = 0;
			counter++;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0};
		int[] result = moveZerosToEnd(input);
		System.out.println("The result is: " + Arrays.toString(result));
	}
}