package com.dsa.practice;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_WebDriverFactoryP2 {
	public static WebDriver getDriver(String browser) {
		if (browser == null)
			throw new IllegalArgumentException("Browser type cannot be null");

		switch (browser.toLowerCase()) {
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "edge":
			return new EdgeDriver();
		case "safari":
			return new SafariDriver();
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}

	public static void main(String[] args) throws Exception {
		WebDriver driver = getDriver("chrome");
		driver.get("https://google.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			WebElement staySignedOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Stay signed out']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", staySignedOut);
		} catch(TimeoutException e) {
			System.out.println("Could not find or interact with the 'Stay signed out' element: " + e.getMessage());
		}
		
		// Wait and type in search
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@title='Search']")));
		searchBox.sendKeys("Cricbuzz");
		
		// Use relative locator to find "Google Search" to the left of LuckyBtn 
		WebElement luckyBtn = driver.findElement(By.xpath("//input[@aria-label=\"I'm Feeling Lucky\"]"));
		
		try {
			WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable
					(with(By.xpath("//input[@value='Google Search']")).toLeftOf(luckyBtn)));
			searchBtn.click();
			System.out.println("Clicked using Solution 1: WebDriverWait with relative locator");
		} catch (Exception e1) {
			System.out.println("Solution 1 failed: " + e1.getMessage());
		}
		System.out.println("Title: " + driver.getTitle());
	}
}