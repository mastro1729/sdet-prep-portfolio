package com.dsa.practice;

import java.util.HashSet;
import java.util.Set;

public class P2LengthOfLongestSubstring {
	
	public static int lengthOfLongestSubstring(String str) {
		int left=0;
		int maxLen = 0;
		Set<Character> set = new HashSet<>();
		for(int right=0; right<str.length()-1; right++) {
				while(set.contains(str.charAt(right))) {
					set.remove(str.charAt(left));
					left++;
				}
			set.add(str.charAt(right));
			maxLen = Math.max(maxLen, right-left+1);
		}
			return maxLen;
	}
	
	public static void main(String[] args) {
		String input = "abcdabg";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(input));
	}
}