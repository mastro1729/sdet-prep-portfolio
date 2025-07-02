package com.dsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayListConversion {
	
	public static ArrayList<String> convertListToArrayList(List<String> list) {
		return new ArrayList<>(list);
	}
	
	public static List<String> convertArrayListToList(ArrayList<String> arrayList) {
		return arrayList;
	}
	
	public static void main(String[] args) {
		List<String> list = List.of("Apple", "Banana", "Cherry");
		ArrayList<String> resultArrayList = convertListToArrayList(list);
		System.out.println("Converted ArrayList: " + resultArrayList);
		
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("Dog", "Cat", "Rabbit"));
		List<String> resultList = convertArrayListToList(arrayList);
		System.out.println("Converted List: " + resultList);
	}
}