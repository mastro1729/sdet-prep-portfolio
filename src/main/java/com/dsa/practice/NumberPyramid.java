package com.dsa.practice;

import java.util.Scanner;

public class NumberPyramid {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		int rows = scn.nextInt();
		
		for(int i=1; i<=rows; i++) {
			
			for(int j=1; j<=rows-i; j++) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=i; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}