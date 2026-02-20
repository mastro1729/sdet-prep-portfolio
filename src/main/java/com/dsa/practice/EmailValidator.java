package com.dsa.practice;

// Q: Validate an Email Address with the Following Rules:
// You are required to validate if an email address string meets all of the following conditions:
// 	(a) @ exists in the email and it is not the first or last character.
// 	(b) . exists in the email and it comes after the @ symbol.
// 	(c) The . is not the last character of the email.

public class EmailValidator {
	
	public static boolean isValidEmail(String email) {
		// Find the position of '@'
		int atIndex  = email.indexOf('@');
		// 1. @ should not be at the beginning or end
		if(atIndex <= 0 || atIndex == email.length()-1 || atIndex != email.lastIndexOf('@')) {
			return false;
		}
		
		// 2. There must be a dot after the '@'
		// The method indexOf returns the position (index) of the first occurrence of the dot, 
		// starting from the given index, atIndex, which is the position of the @ symbol in the email address.
		// If no dot is found after the @ symbol (i.e., dotIndex == -1), the function returns false, indicating that 
		// the email is invalid because there must be a dot after the @ in a properly formatted email address.
		int dotIndex = email.indexOf('.', atIndex);
		if(dotIndex == -1) {
			return false;
		}
		
		// 3. Dot should not be the last character
		if(dotIndex == email.length() - 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String email = "mastro1729@gmail.com@";
		boolean result = isValidEmail(email);
		
		if(result) {
			System.out.println("Valid Email");
		} else {
			System.out.println("Invalid Email");
		}
	}
}
