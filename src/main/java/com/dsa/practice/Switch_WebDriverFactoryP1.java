package com.dsa.practice;

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

public class Switch_WebDriverFactoryP1 {
	public static WebDriver getDriver(String browser) {
        if (browser == null) throw new IllegalArgumentException("Browser type cannot be null");

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
	
	public static void main(String[] args) {
		WebDriver driver = getDriver("chrome");
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		// Enter search text
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Java");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement staySignedOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Stay signed out']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", staySignedOut);
			System.out.println("Stay signed out clicked.");
		} catch (TimeoutException e) {
			System.out.println("Stay signed out popup not present or not clickable.");
		}
		
		// Wait until the suggestions list appears
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='wM6W7d']")));
		
		// Now fetch suggestions
		List<WebElement> list =
				driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='wM6W7d']"));
		System.out.println("The total number of suggestions in the Search Box: " + list.size());
		
		for(WebElement we : list) {
			if(we.getText().contains("java 8 features")) {
				we.click();
				break;
			}
		}
		
		System.out.println("Title: " + driver.getTitle());
		//driver.quit();
	}
}