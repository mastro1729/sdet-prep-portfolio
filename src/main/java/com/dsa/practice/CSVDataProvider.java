package com.dsa.practice;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVDataProvider {

	private static final String CSV_PATH = "./src/test/resources/testdata/";

	public static Object[][] csvData(String csvName) {
		// Construct the full file path.
		String csvFile = CSV_PATH + csvName + ".csv";

		// Local variable: holds CSV data after reading
		Object[][] data = null;

		// try-with-resources ensures CSVReader is closed automatically
		try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
			
			// readAll() is a method of the CSVReader class from the OpenCSV library
			// reader.readAll() reads the entire CSV file at once.
			// Returns a List where each element represents one row.
			// Each row is stored as a String[] (array of strings), because every cell in CSV is read as text.
			// List → Collection holding all rows.
			// String[] → One row, containing all cell values.
			List<String[]> rows = reader.readAll();

			// Initialize 2D Object array of size = number of rows
			data = new Object[rows.size()][];

			// Copy each String[] row into Object[][] array
			for (int i = 0; i < rows.size(); i++) {
				data[i] = rows.get(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return the data
		return data;
	}

	public static void main(String[] args) {
		// Read data from CSV file "TestExecutionReport.csv"
		Object[][] testData = csvData("TestExecutionReport");

		// Thumb rule:
		// When iterating a 2D array (T[][]):
		// The outer loop variable type should be T[] (each row).
		// The inner loop variable type should be T (each cell).

		// Object[][] testData → outer array contains rows.
		// Each row = Object[].
		// Each cell = Object.

		// Print Excel contents row by row
		for (Object[] row : testData) {
			for (Object val : row) {
				System.out.print(val + " | ");
			}
			System.out.println();
		}
	}
}