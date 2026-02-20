package com.dsa.practice;

public class Matrix {
	private int[][] original;

	public Matrix(int[][] original) {
		this.original = original;
	}

	public Matrix transpose() {
		int rows = original.length;
		int cols = original[0].length;
		int[][] transpose = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				transpose[i][j] = original[j][i];
			}
		}
		return new Matrix(transpose);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int[] row : original) {
			for (int val : row) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[][] original = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Matrix matrix = new Matrix(original);

		System.out.println("Original:");
		System.out.println(matrix);

		System.out.println("Transpose:");
		System.out.println(matrix.transpose());
	}
}