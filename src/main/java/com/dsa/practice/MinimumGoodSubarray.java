package com.dsa.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumGoodSubarray {
	
	public static int findMinimumLengthSubarray(List<Integer> arr, int k) {
		
		// If overall distinct elements < k → impossible
		Set<Integer> distinct = new HashSet<>(arr);
		if(distinct.size() < k) {
			return -1;
		}
		
		Map<Integer, Integer> freq = new HashMap<>();
		int left = 0;
		int minLength = Integer.MAX_VALUE;
		
		for(int right = 0; right<arr.size(); right++) {
			freq.put(arr.get(right), freq.getOrDefault(arr.get(right), 0) + 1);
			
			// While window has at least k distinct elements
			while(freq.size() >= k) {
				minLength = Math.min(minLength, right-left+1);
				
				freq.put(arr.get(left), freq.get(arr.get(left)) - 1);
				if(freq.get(arr.get(left)) == 0) {
					freq.remove(arr.get(left));
				}
				left++;
			}
		}
		return (minLength == Integer.MAX_VALUE ? -1 : minLength);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        System.out.println("Enter number of elements in array: ");
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        
        System.out.println("Enter " + arrCount + " array elements (one per line):");
        List<Integer> arr = IntStream.range(0, arrCount)
            .mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        
        System.out.println("Enter value of k: ");
        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = MinimumGoodSubarray.findMinimumLengthSubarray(arr, k);
        
        System.out.println("Minimum subarray length containing at least " + k + " distinct elements:");
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
	}
}