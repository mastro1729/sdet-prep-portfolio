package com.dsa.practice;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValidParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		// Iterate through each character in the string
		for (char ch : s.toCharArray()) {
			// If it's an opening bracket: push to stack
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else {
				// If stack is empty: No matching opening bracket
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				// Check if the current closing bracket matches the top of the stack
				if (ch == ')' && top != '(')
					return false;
				if (ch == '{' && top != '{')
					return false;
				if (ch == ']' && top != '[')
					return false;
			}
		}
		// If stack is empty, all brackets were matched
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s1 = "(]";
		boolean result1 = isValidParentheses(s1);
		System.out.println(isValidParentheses(s1));

		String s2 = "{[]}";
		boolean result2 = isValidParentheses(s2);
		System.out.println(isValidParentheses(s2));

		String s3 = "[{]}";
		boolean result3 = isValidParentheses(s3);
		System.out.println(isValidParentheses(s3));
	}
}