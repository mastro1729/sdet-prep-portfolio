package com.dsa.practice;

public class LongestPalindromeFlexible {
	static int resultStart;
	static int resultLength;
	
	public static String longestPalindrome(Object input) {
		String str = String.valueOf(input);
		
		if(str.length()<2)
			return str;
		
		int length = str.length()-1;
		for(int i=0; i<length; i++) {
			expandAroundCenter(str, i, i);
			expandAroundCenter(str, i, i+1);
		}
		// If you want N characters starting from start, you must go up to (but not including) start + N.
		// That's why: s.substring(start, start + length)
		return str.substring(resultStart, resultStart+resultLength);
	}
	
	// The loop runs as long as str.charAt(begin) == str.charAt(end).
	// When it finds a mismatch (or goes out of bounds), it breaks, so:
   //  	begin is now one step before the start of the palindrome
	// 	end is now one step after the end of the palindrome
	// So the actual palindrome range is: from begin + 1 to end - 1 (inclusive)
	// To get the length of that substring: (end - 1) - (begin + 1) + 1 = end - begin - 1
	
	public static void expandAroundCenter(String s, int begin, int end) {
		while(begin>=0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		
		if(resultLength < end-begin-1) {
			resultStart = begin+1;
			resultLength = end-begin-1;
		}
	}
	
	public static void main(String[] args) {
		// int num = 123454321;
		String input = "abcdedcba";
        String result = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
	}
}