package com.dsa.practice;

import java.util.*;

public class ArrayElementClassifier {

    public static int[] findDuplicates(int[] array) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : array) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        
		/*duplicates.stream() returns Stream<Integer>
		.mapToInt(Integer::intValue) converts a Stream<Integer> (object stream) into an IntStream (primitive stream).
		.toArray() collects the elements of the IntStream into a primitive int[] array.*/
        return duplicates.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] findNonDuplicates(int[] array) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> nonDuplicates = new ArrayList<>();

        for (int num : array) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                nonDuplicates.add(entry.getKey());
            }
        }
        
		/*nonDuplicates.stream() returns Stream<Integer>
		.mapToInt(Integer::intValue) converts a Stream<Integer> (object stream) into an IntStream (primitive stream).
		.toArray() collects the elements of the IntStream into a primitive int[] array.*/
        return nonDuplicates.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5, 5, 6, 7};

        int[] duplicates = findDuplicates(array);
        int[] nonDuplicates = findNonDuplicates(array);

        System.out.println("Duplicates: " + Arrays.toString(duplicates));
        System.out.println("Non-Duplicates: " + Arrays.toString(nonDuplicates));
    }
}