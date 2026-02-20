package com.dsa.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterClassifier {
	
	public static List<List<Character>> classifyAndReverse(String str){
		List<Character> letters = new ArrayList<>();
		List<Character> digits = new ArrayList<>();
		List<Character> specials = new ArrayList<>();
		
		for(char ch : str.toCharArray()) {
			if(Character.isLetter(ch))
				letters.add(ch);
			else if(Character.isDigit(ch))
				digits.add(ch);
			else
				specials.add(ch);
		}
		
		// Reverse each category
		Collections.reverse(letters);
		Collections.reverse(digits);
		Collections.reverse(specials);
		
		List<List<Character>> result = new ArrayList<>();
		result.add(letters);
		result.add(digits);
		result.add(specials);
		
		return result;
	}
	
	public static void main(String[] args) {
		String str = "ASFFF @#$@#5";
        List<List<Character>> output = classifyAndReverse(str);

        System.out.println("Letters: " + output.get(0));
        System.out.println("Digits: " + output.get(1));
        System.out.println("Specials: " + output.get(2));
	}
}