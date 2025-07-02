package com.dsa.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearch {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Step 1: Open Google
		driver.get("https://www.google.com");

		// Optional: Handle Google cookie popup if shown
		try {
			WebElement rejectButton = driver.findElement(By.xpath("//span[text()='Stay signed out']"));
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", rejectButton);

		} catch (Exception e) {
			System.out.println("Google cookie popup not found!");
		}

		// Step 2: Type "WebDriver" in search box
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchBox.sendKeys("WebDriver");

		// Small wait for suggestions to load
		Thread.sleep(3000);

		// Step 3: Click on the 5th autosuggestion
		WebElement suggestion = driver.findElement(By.xpath("//ul//li[@role='presentation']"));
		// suggestion.click();

		driver.get("https://www.amazon.in/");
		Actions actions = new Actions(driver);
		
		// Step 4: Right-click first link and open in new tab (using CTRL + Click)
		WebElement first = driver.findElement(By.linkText("Sell"));
		actions.keyDown(Keys.CONTROL).click(first).keyUp(Keys.CONTROL).build().perform();

		// Step 5: Right-click second link and open in new tab (using SHIFT + Click)
		WebElement second = driver.findElement(By.linkText("Bestsellers"));
		actions.keyDown(Keys.SHIFT).click(second).keyUp(Keys.SHIFT).build().perform();
		
		String originalWindow = driver.getWindowHandle();
		
		for(String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			
			if(driver.getTitle().contains("Bestsellers")) {
				System.out.println("The Title is: " + driver.getTitle());
				break;
			}
		}
	}

}
