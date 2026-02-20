package com.dsa.practice;

public class GradeChecker {
	
	public static String checkGrade(int score) {
		if(score >= 90) {
			return "Grade A";
		} else if(score >= 70){
			return "Grade B";
		} else if(score >= 50) {
			return "Grade C";
		} else if(score >= 35) {
			return "Grade D";
		} else {
			return "Fail";
		}
	}
	
	public static void main(String[] args) {
		String result1 = GradeChecker.checkGrade(93);
		System.out.println(result1);
		String result2 = GradeChecker.checkGrade(79);
		System.out.println(result2);
	}
}