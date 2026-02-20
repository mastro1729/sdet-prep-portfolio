package com.dsa.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataProvider {
	
	private static final String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/Registration.xlsx";
	
	public static Object[][] readTestData(String sheetName) {
		
		/*Declares the variable outside the try block so it is visible when returning at the end.
		If declared inside the try, it would be out of scope after the block.
		Initially set to null because the real array size can only be known after reading the sheet.*/
		Object[][] data = null;
		
		/*try-with-resources is a Java feature (since Java 7).
		It automatically closes resources after the try block ends.
		A resource here means any object that implements the AutoCloseable (or Closeable) interface.
		Examples: 
			Streams, Readers/Writers, Sockets, JDBC connections, Libraries/Framework Objects.
			FileInputStream, BufferedReader, Connection, Socket, Workbook (Apache POI)
			Workbook (Apache POI) → Parsed in-memory representation of an Excel file.*/
		
		try (
			// Step 1: Open the Excel file using FileInputStream
			// FileInputStream is used to open and read the contents of a file in the form of a stream of bytes.
			// FileInputStream is only the “pipe” that delivers the raw binary data into memory.
			// fis does not store the Excel file, it stores a stream reference to read from.
			FileInputStream fis = new FileInputStream(TEST_DATA_SHEET_PATH);
			
			// Step 2: Create a Workbook object (represents the entire Excel file)
			// WorkbookFactory handles both .xls (HSSF) and .xlsx (XSSF) formats
			// When you pass fis to WorkbookFactory.create(fis), POI reads the Excel content from that stream.
			// Once POI parses the Excel into a Workbook, the stream is not needed anymore.
			Workbook workbook = WorkbookFactory.create(fis)) {
			
			// Step 3: Get the requested sheet by name
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				// Defensive check: throw error if sheet not found
                throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + TEST_DATA_SHEET_PATH);
            }
			
			// Step 4: Find number of rows (includes header row)
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			// Step 5: Find number of columns using the first row (header)
			int colCount = sheet.getRow(0).getLastCellNum();
			
			// Step 6: Initialize the 2D array
			// We skip the header row → so allocate (rowCount - 1) rows
			data = new Object[rowCount-1][colCount];
			
			// Step 7: Iterate over rows 
			// start from row index 1, because index 0 is header
			for(int i=1; i<rowCount; i++) {
				// get current row
				Row row = sheet.getRow(i);
				for(int j=0; j<colCount; j++) {
					// Provide a safe fallback if the requested item doesn’t exist.
					
					/*Cell Handling in Apache POI
					Default Behavior (row.getCell(j)):
					If the cell exists → returns the actual Cell object.
					If the cell is empty/missing → returns null.
					Accessing methods on null causes a NullPointerException.
					
					Using Row.MissingCellPolicy.CREATE_NULL_AS_BLANK:
					If the cell exists → returns the actual Cell.
					If the cell is missing → returns a dummy blank cell instead of null.
					Safe to use with formatters or getters, avoiding NullPointerException.*/
					
					// If a cell is missing, create it as blank (avoids NullPointerException)
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					
					// DataFormatter ensures values are read as strings (numeric, boolean, date → converted to text)
					String value = new DataFormatter().formatCellValue(cell).trim();
					
					// Assign value to 2D array
					data[i-1][j] = value;
				}
			}
		} catch(IOException | EncryptedDocumentException e) {
			// Wrap checked exceptions into a RuntimeException
			// so callers don't have to handle them directly
			throw new RuntimeException("Failed to read Excel file: " + TEST_DATA_SHEET_PATH, e);
		} 
		// Step 9: Return the 2D Object array
		return data;
	}
	
	public static void main(String[] args) {
		// Read data from sheet "Register"
		Object[][] testData = readTestData("Register");
		
		// Thumb rule:
		// When iterating a 2D array (T[][]):
		// The outer loop variable type should be T[] (each row).
		// The inner loop variable type should be T (each cell).

		// Object[][] testData → outer array contains rows.
		// Each row = Object[].
		// Each cell = Object.
		
		// Print Excel contents row by row
		for(Object[] row : testData) {
			for(Object val : row) {
				System.out.print(val + " | ");
			}
			System.out.println();
		}
	}
}