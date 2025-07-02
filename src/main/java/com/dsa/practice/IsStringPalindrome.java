package com.dsa.practice;

public class IsStringPalindrome {
	
	public static boolean isStringPalindrome(String str) {
		if(str == null) {
			return false;
		}
		if(str.length() < 2) {
			return true;
		}
		// Remove non-alphanumeric characters and convert to lowercase
		String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		StringBuilder reversed = new StringBuilder();
		for(int i=cleaned.length()-1; i>=0; i--) { //madam
			reversed.append(cleaned.charAt(i));
		}
		return cleaned.equals(reversed.toString());
	}
	
	public static void main(String[] args) {
		String input = "A man, a plan, a canal, Panama";
		boolean result = isStringPalindrome(input);
		if(result) {
			System.out.println("The given String is palindrome");
		} else {
			System.out.println("The given String is not a palindrome");
		}
	}
}