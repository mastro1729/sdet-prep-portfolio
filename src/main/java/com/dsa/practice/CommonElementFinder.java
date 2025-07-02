package com.dsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElementFinder {
	
	public static List<String> findCommonElements(List<String> list1, List<String> list2) {
		List<String> result = new ArrayList<>(list1);
		result.retainAll(list2);
		return result;
	}
	
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("apple", "banana", "cherry", "mango");
		List<String> list2 = Arrays.asList("grape", "banana", "mango", "kiwi");
		List<String> result = findCommonElements(list1, list2);
		System.out.println("The common elements are: " + result);
	}
}