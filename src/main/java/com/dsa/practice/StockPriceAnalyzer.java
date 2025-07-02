package com.dsa.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StockPriceAnalyzer {
	private static WebDriver driver;

	public static double getMaxPriceByColumnName(String columnName) {
		int columnIndex = -1;

		// Get all column headers
		List<WebElement> headers = driver.findElements(By.xpath("//thead/tr/th"));
		for (int i = 0; i < headers.size(); i++) {
			if (headers.get(i).getText().trim().equalsIgnoreCase(columnName)) {
				// XPath is 1-based index
				columnIndex = i + 1;
				break;
			}
		}

		if (columnIndex == -1) {
			throw new RuntimeException("Column '" + columnName + "' not found in the table header.");
		}

		// Construct dynamic XPath based on column index
		String columnXPath = "//tbody/tr/td[" + columnIndex + "]";
		List<WebElement> priceElements = driver.findElements(By.xpath(columnXPath));
		List<Double> prices = new ArrayList<>();
		
		for (WebElement element : priceElements) {
			String text = element.getText().replace(",", "").trim();

			if (!text.isEmpty()) {
				try {
					double value = Double.parseDouble(text);
					prices.add(value);
				} catch (NumberFormatException e) {
					System.err.println("Invalid price format: " + text);
				}
			}
		}

		if (prices.isEmpty()) {
			throw new RuntimeException("No valid numeric values found in column '" + columnName + "'.");
		}

		// Find max
		double maxPrice = prices.get(0);
		for (double value : prices) {
			if (value > maxPrice) {
				maxPrice = value;
			}
		}

		return maxPrice;
	}

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://finance.yahoo.com/markets/stocks/trending/");

		double highestPrice = getMaxPriceByColumnName("Market Cap");
		System.out.println("The Highest Stock Price is: " + highestPrice);

		driver.quit();
	}
}