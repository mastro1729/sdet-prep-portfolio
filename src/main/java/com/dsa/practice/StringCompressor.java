package com.dsa.practice;

public class StringCompressor {
	public static String compressString(String str) {
		if(str == null || str.length() == 0)
			throw new IllegalArgumentException("Input string cannot be null or empty.");
		
		int counter = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<str.length(); i++) {
			char current = str.charAt(i);
			char previous = str.charAt(i-1);
			
			if(current == previous) {
				counter++;
			} else {
				sb.append(previous).append(counter);
				counter = 1;
			}
		}
		sb.append(str.charAt(str.length()-1)).append(counter);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "AAABBBCCCaaa";
		String result = compressString(input);
		System.out.println("Compressed String: " + result);
	}
}