package com.dsa.practice;

public class LPL_VowelRemover {

	public static String removeVowels(String input) {

		StringBuilder sb = new StringBuilder();
		for (char character : input.toCharArray()) {
			if (Character.isLetter(character)) {
				char ch = Character.toLowerCase(character);
				if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
					sb.append(character);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String input = "AautoMmation";
        String result = removeVowels(input);
        System.out.println("Original: " + input);
        System.out.println("Without vowels: " + result);
	}
}