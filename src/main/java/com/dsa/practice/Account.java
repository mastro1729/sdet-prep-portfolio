package com.dsa.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// If you want to sort a list of objects of class X using Collections.sort(list), 
// then class X should implement Comparable<X> and override the compareTo(X other) method.
public class Account implements OnlineAccount, Comparable<Account> {
	String ownerName;
	int noOfRegularMovies;
	int noOfExclusiveMovies;

	// 1. Parameterized constructor
	public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
		this.ownerName = ownerName;
		this.noOfRegularMovies = noOfRegularMovies;
		this.noOfExclusiveMovies = noOfExclusiveMovies;
	}

	// 2. Method to calculate monthly cost
	public int monthlyCost() {
		return basePrice + (noOfRegularMovies * regularMoviePrice) + (noOfExclusiveMovies * exclusiveMoviePrice);
	}

	// 3. Compare accounts based on monthly cost
	@Override
	public int compareTo(Account other) {
		return Integer.compare(this.monthlyCost(), other.monthlyCost());
	}
	
	// Every class in Java inherits a method called toString() from Object.
	// By default, toString() returns: the class name + memory hash.
	
	// 4. toString method
	@Override
	public String toString() {
		return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Prompt for number of accounts
        System.out.print("Enter number of accounts: ");
		int t = Integer.parseInt(sc.nextLine());

		ArrayList<Account> list = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			System.out.println("\nEnter details for Account " + (i + 1) + ":");
            System.out.println("Format: <OwnerName> <NoOfRegularMovies> <NoOfExclusiveMovies>");
			String[] input = sc.nextLine().split(" ");
			String ownerName = input[0];
			int noOfRegularMovies = Integer.parseInt(input[1]);
			int noOfExclusiveMovies = Integer.parseInt(input[2]);
			
			// If the list holds simple objects (Integer, String, etc.), we can add directly:
			// list.add(10);
			// list.add("abc");

			// If the list holds custom objects (Account, Student, etc.) that are made up of multiple fields, 
			// we must use new (or a factory method) to wrap those values into one object:
			list.add(new Account(ownerName, noOfRegularMovies, noOfExclusiveMovies));
		}

		// Sorts by monthly cost in ascending order
		Collections.sort(list);

		System.out.println("\n==== Results ====");
        System.out.println("Most valuable account details (highest monthly cost):");
        System.out.println(list.get(list.size() - 1));

        System.out.println("\nLeast valuable account details (lowest monthly cost):");
        System.out.println(list.get(0));
	}
}