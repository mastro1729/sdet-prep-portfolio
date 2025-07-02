package com.dsa.practice;

import java.util.Scanner;

public class PyramidPattern {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows = scn.nextInt();

		//Outer loop for each row
		for (int i = 1; i <= rows; i++) {
			// Inner loop for spaces
			for (int j = 1; j <= rows - i; j++) {
				System.out.print(" ");
			}
			// Inner loop for stars
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scn.close();
	}
}