package com.dsa.practice;

import java.util.HashSet;
import java.util.Set;

public class P1LongestSubstring {
	
	public static String longestSubstring(String str) {
		int left=0;
		int startIndex=0;
		int maxLen=0;
		Set<Character> set = new HashSet<>();
		for(int right=0; right<str.length(); right++) {
			while(set.contains(str.charAt(right))) {
				set.remove(str.charAt(left));
				left++;
			}
				set.add(str.charAt(right));
				
				if(right-left+1 > maxLen) {
					maxLen = right-left+1;
					startIndex=left;
				}
		}
		return str.substring(startIndex, startIndex+maxLen);
	}
	public static void main(String[] args) {
		String input = "abcdabg";
		 System.out.println("Longest Substring: " + longestSubstring(input));
	}
}