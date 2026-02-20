package com.dsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LPL_ArrayRearranger {
	
	public static int[] rearrangeAlternatingPosNeg(int[] array) {
		List<Integer> posList = new ArrayList<>();
		List<Integer> negList = new ArrayList<>();
		
		// Separate positive and negative numbers
		for(int num : array) {
			if(num < 0) {
				negList.add(num);
			} else if(num >= 0) {
				posList.add(num);
			}
		}
		
		int[] result = new int[array.length];
		
		// Merge alternately
		int i=0, p=0, n=0;
		while(n<negList.size() && p<posList.size()) {
			if(i%2==0) {
				result[i]=negList.get(n);
				i++;
				n++;
			} else {
				result[i]=posList.get(p);
				i++;
				p++;
			}
		}
		
		 // Add remaining positive numbers
        while (p < posList.size()) {
        	result[i]=posList.get(p);
			i++;
			p++;
        }
        
		// Add remaining negative numbers
        while (n < negList.size()) {
        	result[i]=negList.get(n);
			i++;
			n++;
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		int[] input = {1, -2, 3, -4, 5, -6};
		System.out.println("Array before rearranging: " + Arrays.toString(input));
		int[] output = rearrangeAlternatingPosNeg(input);
		System.out.println("Array after rearranging: " + Arrays.toString(output));
	}
}