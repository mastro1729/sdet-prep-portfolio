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
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MakeMyTripFareSelection {
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
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

		// 1. Locate "Regular" visible card
		WebElement regularFareCard = driver.findElement(By.xpath("//input[@type='radio' and @checked]"));

		// 2. Use Relative Locator to find Student card to the right of Regular
		WebElement studentFareCard = driver.findElement(with(By.className("fareCardItem")).toRightOf(regularFareCard));

		// 3. Click on it
		studentFareCard.click();
		Thread.sleep(5000);

		// 4. Use Relative Locator to find Student card to the right of Regular
		WebElement seniorCitizenFareCard = driver
				.findElement(with(By.className("fareCardItem")).toRightOf(studentFareCard));

		// 5. Click on it
		seniorCitizenFareCard.click();
		Thread.sleep(3000);

		// 6. Use Relative Locator to find Student card to the right of Regular
		WebElement armedForcesFareCard = driver
				.findElement(with(By.className("fareCardItem")).toRightOf(seniorCitizenFareCard));

		// 7. Click on it
		armedForcesFareCard.click();
		Thread.sleep(3000);

		//8. Use Relative Locator to find Student card to the right of Regular
		WebElement doctorsAndNursesFareCard = driver
				.findElement(with(By.className("fareCardItem")).toRightOf(armedForcesFareCard));

		// 9. Click on it
		doctorsAndNursesFareCard.click();
		Thread.sleep(3000);

		driver.quit();
	}
}