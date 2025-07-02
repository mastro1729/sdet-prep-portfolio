package com.dsa.practice;

public class P2ShortestRepeatingSubstring {

	// We only check substring lengths up to half of the full string.
	// If a substring repeats to form the entire string, it must occur at least
	// twice.
	// So, its length must be less than or equal to half of the total string length.

	public static String shortestRepeatingSubstring(String str) {
		int n = str.length();
		for (int i = 1; i <= n / 2; i++) {
			String pattern = str.substring(0, i);

			// If a substring of length i is repeated k times to make the full string of length n, then:
			// i * k = n => so n % i == 0
			// If n % i != 0, then repeating the substring won't fill the full string exactly: there would be leftovers.
			StringBuilder sb = new StringBuilder();
			if (n % i == 0) {
				for (int j = 0; j < n / i; j++) {
					sb.append(pattern);
				}

				if (str.equals(sb.toString())) {
					return pattern;
				}
			}
		}
		return "-1";
	}

	public static void main(String[] args) {
		System.out.println(shortestRepeatingSubstring("abab")); // "ab"
		System.out.println(shortestRepeatingSubstring("abcabcabcabc")); // "abc"
		System.out.println(shortestRepeatingSubstring("aba")); // "-1"
	}
}