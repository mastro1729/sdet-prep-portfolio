package com.dsa.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		List<Node> boughtItems = new ArrayList<>();
		Map<String, Double> prices = new HashMap<>();
		Map<String, Integer> discounts = new HashMap<>();

		// Read prices
		System.out.println("Enter number of fruits with prices:");
		int n = Integer.parseInt(reader.readLine().trim());
		System.out.println("Enter fruit name and price (e.g., Apple 34):");
		for (int i = 0; i < n; i++) {
			String[] a = reader.readLine().trim().split(" ");
			prices.put(a[0], Double.parseDouble(a[1]));
		}

		// Read discounts
		System.out.println("Enter number of fruits with discounts:");
		int m = Integer.parseInt(reader.readLine().trim());
		if (m > 0) {
			System.out.println("Enter fruit name and discount percentage (e.g., Orange 10):");
		}
		for (int i = 0; i < m; i++) {
			String[] a = reader.readLine().trim().split(" ");
			discounts.put(a[0], Integer.parseInt(a[1]));
		}

		// Read shopping list
		System.out.println("Enter number of items in shopping list:");
		int b = Integer.parseInt(reader.readLine().trim());
		System.out.println("Enter fruit name and quantity (e.g., Apple 2):");
		for (int i = 0; i < b; i++) {
			String[] a = reader.readLine().trim().split(" ");
			boughtItems.add(new Node(a[0], Integer.parseInt(a[1])));
		}

		// Calculate receipt
		GroceryReceipt g = new GroceryReceipt(prices, discounts);
		List<Grocery> result = g.Calculate(boughtItems);

		// Print result
		System.out.println("\nFinal Invoice:");
		for (Grocery x : result) {
			writer.printf("%s %.1f %.1f\n", x.fruit, x.price, x.total);
		}

		writer.flush();
		writer.close();
		reader.close();
	}
}