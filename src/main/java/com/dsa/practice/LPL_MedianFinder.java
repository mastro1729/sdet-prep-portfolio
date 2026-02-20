package com.dsa.practice;

public class LPL_MedianFinder {
	
	public static double findMedian(int[] array) {
		
		int n = array.length;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		double median = 0;
			if(n%2 == 0) {
				median = (array[n/2] + array[n/2-1])/2.0;
			} else {
				median = array[n/2];
		}
			return median;
	}
	
	public static void main(String[] args) {
		int[] input1 = {1, 2, 3, 4, 5};
	    int[] input2 = {2, 3, 4, 6};
	    
	    System.out.println("If the array has odd length: median is the middle element: " + findMedian(input1));
	    System.out.println("If the array has even length: median is avg of two middle elements: " + findMedian(input2));
	}
}