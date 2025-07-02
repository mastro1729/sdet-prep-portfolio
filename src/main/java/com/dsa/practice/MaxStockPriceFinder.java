package com.dsa.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxStockPriceFinder {
	private static WebDriver driver;
	
	public static double findMaxPriceFromTable() {
		List<WebElement> priceElements = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		List<Double> stockPrices = new ArrayList<>();
		
		for(WebElement element : priceElements) {
			String priceText = element.getText().replace(",", "").trim();
			if(!priceText.isEmpty()) {
				try {
					stockPrices.add(Double.parseDouble(priceText));
				} catch(NumberFormatException e) {
					System.err.println("Invalid price format: " + priceText);
				}
			}
		}
		
		if(stockPrices.isEmpty()) {
			throw new RuntimeException("No valid stock prices found in the table.");
		}
		
		double maxPrice = stockPrices.get(0);
		for(double price : stockPrices) {
			if(price > maxPrice) {
				maxPrice = price;
			}
		}
		return maxPrice;
	}

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://finance.yahoo.com/markets/stocks/trending/");
		double maxPrice = findMaxPriceFromTable();
		System.out.println("The Highest Stock Price is: " + maxPrice);
		driver.quit();
	}
}