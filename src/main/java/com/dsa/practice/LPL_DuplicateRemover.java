package com.dsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LPL_DuplicateRemover {
	
	public static Map<Integer,Integer> removeDuplicates(List<Integer> numbers) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : numbers) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		return map;
	}
	
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 1, 2, 2, 9, 9, 56, 7, 5);
		Map<Integer,Integer> freqMap = removeDuplicates(input);
		
		List<Integer> duplicates = new ArrayList<>();
		int totalDuplicateCount =0;
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if(entry.getValue() > 1) {
				duplicates.add(entry.getKey());
				totalDuplicateCount = totalDuplicateCount + (entry.getValue()-1);
			}
		}
		System.out.println("Duplicate Elements: " + duplicates);
		System.out.println("Total Duplicate Count: " + totalDuplicateCount);
	}
}