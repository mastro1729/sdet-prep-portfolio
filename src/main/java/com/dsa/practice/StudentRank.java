package com.dsa.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StudentRank {
	private String[] students;
	private int[] ranks;

	// Constructor
	public StudentRank(String[] students, int[] ranks) {
		this.students = students;
		this.ranks = ranks;
	}

	 // Returns student with highest rank (max value)
	public String highestRank() {
		int maxIndex = 0;
		for (int i = 1; i < ranks.length; i++) {
			if (ranks[i] > ranks[maxIndex]) {
				maxIndex = i;
			}
		}
		return students[maxIndex];
	}

	// Returns student with lowest rank (min value)
	public String lowestRank() {
		int minIndex = 0;
		for (int i = 1; i < ranks.length; i++) {
			if (ranks[i] < ranks[minIndex]) {
				minIndex = i;
			}
		}
		return students[minIndex];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // replaceAll("\\s+", "") removes all whitespace in the string, not just trailing ones.
        // replaceAll("\\s+$", "") removes only trailing spaces at the end of the line.
        // BufferedReader's readLine() always returns a String.
        
        // Read student names
        System.out.println("👉 Enter student names (comma-separated):");
        String[] students = bufferedReader.readLine().replaceAll("\\s+$", "").split(",");
        
        // Read ranks as strings and convert to int[]
        System.out.println("👉 Enter ranks (comma-separated integers):");
        String[] ranksStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(",");
        
        int[] ranks = new int[ranksStr.length];
        for (int i = 0; i < ranksStr.length; i++) {
            ranks[i] = Integer.valueOf(ranksStr[i]).intValue();
        }

        // Create StudentRank object
        StudentRank sr = new StudentRank(students, ranks);

        // Write result -> highestRank,lowestRank
        bufferedWriter.write("👉 Highest Rank Student: " + sr.highestRank());
        bufferedWriter.newLine();
        bufferedWriter.write("👉 Lowest Rank Student: " + sr.lowestRank());
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}