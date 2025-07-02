package com.dsa.practice;

import java.util.Arrays;

public class MoveZerosToFront {
	
	public static int[] moveZerosToFront(int[] array) { 
		int counter = array.length-1; 
		
		for(int i=array.length-1; i >= 0; i--) {
			if(array[i] != 0) {
				array[counter] = array[i];
				counter --;
			}
		}
		
		while(counter >= 0) {
			array[counter] = 0;
			counter --;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0};
		int[] result = moveZerosToFront(input);
		System.out.println(Arrays.toString(result));
	}
}