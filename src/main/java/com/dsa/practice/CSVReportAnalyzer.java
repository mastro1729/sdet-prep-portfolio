package com.dsa.practice;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVReportAnalyzer {

    // Reads all rows from CSV with configurable delimiter
    public static List<String[]> readCSV(String filePath, char delimiter) {
    	CSVParser parser = new CSVParserBuilder()
    	        .withSeparator(delimiter)
    	        .build();

        try (FileReader fr = new FileReader(filePath);
        	    CSVReader reader = new CSVReaderBuilder(fr)
        	            .withCSVParser(parser)
        	            .build()) {
            return reader.readAll();
        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }
    }

    // Finds the index of a given column in header
    private static int findColumnIndex(String[] header, String columnName) {
        for (int i = 0; i < header.length; i++) {
            if (header[i].trim().equalsIgnoreCase(columnName.trim())) {
                return i;
            }
        }
        return -1; // not found
    }

    // Filters rows by column name and value (e.g., Status = Fail)
    public static List<String[]> filterRows(List<String[]> rows, String columnName, String matchValue) {
        if (rows.isEmpty()) return new ArrayList<>();

        String[] header = rows.get(0);
        int columnIndex = findColumnIndex(header, columnName);

        if (columnIndex == -1) {
            throw new IllegalArgumentException("Column not found: " + columnName);
        }

        List<String[]> filtered = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) { // skip header
            String[] row = rows.get(i);
            if (row[columnIndex].trim().equalsIgnoreCase(matchValue.trim())) {
                filtered.add(row);
            }
        }
        return filtered;
    }

    // Prints rows nicely
    public static void printRows(List<String[]> rows) {
        for (String[] row : rows) {
        	// String.join takes the array and joins its elements 
            // into one single String with " | " as separator.
            System.out.println(String.join(" | ", row));
        }
    }

    public static void main(String[] args) {
        String filePath = "./src/test/resources/testdata/TestExecutionReport.csv";

        // 🔑 Change delimiter here (',' or '|' or ';')
        List<String[]> rows = readCSV(filePath, '|');

        List<String[]> failedRows = filterRows(rows, "Status", "Fail");
        printRows(failedRows);
    }
}