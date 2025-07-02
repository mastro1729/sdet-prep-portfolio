package com.dsa.practice;

public class NullPointerVsCompileTimeError {
	
	// If any variable is a class-level variable (static or instance level), it defaults to null,
	// and calling s.length() on it will cause a NullPointerException at runtime.
	static String classLevelString; // Class-level variable (defaults to null)

	public static void main(String[] args) {
		
		// If any variable is a local variable and not initialized, it will give a compile-time error.
		
		// -------- Case 1: Local Variable - Compile-Time Error Example --------
		
		/*
		String localString;  // Local variable declared but not initialized
		// ❌ Compile-time error: variable localString might not have been initialized
		System.out.println(localString.length());
		*/

		// -------- Case 2: Class-level Variable - Runtime NullPointerException Example --------
		try {
			System.out.println("Class Level String Length: " + classLevelString.length()); // ❌ Runtime error
		} catch (NullPointerException e) {
			System.out.println("Caught NullPointerException: classLevelString is null");
		}
	}
}