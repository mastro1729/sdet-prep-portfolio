package com.dsa.practice;

public class FibonacciSeries {
	
	public static String printFibonacci(int n) {
		int a = 0;
		int b = 1;
		
		StringBuilder result = new StringBuilder();
		result.append(a).append(" ").append(b).append(" ");
		
		for(int i=2; i<n; i++) {
			int c = a+b;
			result.append(c).append(" ");
		//System.out.print(c + " ");
			a = b;
			b = c;
		}
		return result.toString().trim();
	}
	
	public static void main(String[] args) {
		String fibonacciSeries = printFibonacci(10);
		System.out.println(fibonacciSeries);
	}
}