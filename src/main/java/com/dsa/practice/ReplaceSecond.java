package com.dsa.practice;

public class ReplaceSecond {
	
	public static String replaceSecondOccurence(String input, char target, char replacement) {
		StringBuilder sb = new StringBuilder();
		int count =0;
		
		for(char ch : input.toLowerCase().toCharArray()) {
			if(ch == target) {
				count++;
				if(count==2) {
					sb.append(replacement);
					continue;
				}	
			}
				sb.append(ch);
		}
			return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "Elephant Tree";
		char target = 'e';
		char replacement = '@';
		String result = replaceSecondOccurence(input, target, replacement);
		
		System.out.println("Original: " + input);
		System.out.println("Modified: " + result);
	}
}