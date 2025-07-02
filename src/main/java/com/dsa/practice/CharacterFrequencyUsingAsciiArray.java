package com.dsa.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterFrequencyUsingAsciiArray {

	public static Map<Character, Integer> characterFrequency(String str) {

		// Assuming we are dealing with ASCII characters (Total 256 characters)
		int[] freq = new int[256];

		// Count frequency of each character
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// Increase count at ASCII index
			freq[ch]++;
		}

		// Prepare result map
		Map<Character, Integer> freqMap = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				freqMap.put((char) i, freq[i]);
			}
		}

		return freqMap;
	}

	public static void main(String[] args) {
		String str = "Programming12123%%%";
		Map<Character, Integer> resultMap = characterFrequency(str);

		System.out.println("Character Frequencies:");
		for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}