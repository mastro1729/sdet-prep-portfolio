package com.dsa.practice;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksChecker {
	private WebDriver driver;
	
	public BrokenLinksChecker() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void checkBrokenLinks(String pageUrl) {
		driver.get(pageUrl);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The total no of links present is: " + links.size());
		
		for(WebElement link : links) {
			String href = link.getAttribute("href");
			
			// null ::: means there is no attribute at all (e.g., <a> without href).
			// isEmpty() ::: means there is an href="" but it’s an empty string.
			if(href == null || href.isEmpty())
				continue;
			
			try {
				// Note:: The constructor URL(String) is deprecated since version 20
				// Since Java 20, new URL(String) is deprecated because it can silently accept malformed URLs. 
				// I use URI first to strictly validate the format, 
				// and then call toURL() to safely create a URL object for opening a connection.
				URI uri = new URI(href);
				URL url = uri.toURL();
				
				URLConnection urlconnection = url.openConnection();
				HttpURLConnection connection = (HttpURLConnection) urlconnection;
				
				connection.setRequestMethod("HEAD");
				connection.connect();
				
				int statusCode = connection.getResponseCode();
				
				if (statusCode == HttpURLConnection.HTTP_BAD_METHOD) { // 405
		            connection = (HttpURLConnection) url.openConnection();
		            connection.setInstanceFollowRedirects(true);
		            connection.setRequestMethod("GET");
		            connection.connect();
		            statusCode = connection.getResponseCode();
		        }

				if(statusCode >= 400) {
					System.out.println("Broken link: " + href + "(Status: " + statusCode + ")");
				} /*else {
					System.out.println("The link is found working");
					}*/
				connection.disconnect();
			} catch(Exception e) {
				System.out.println("Error with link: " + href + "--> " + e.getMessage());
			}
		}
	}
	
	public void closeDriver() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		BrokenLinksChecker checker = new BrokenLinksChecker();
		String url = "https://www.amazon.in/";
		checker.checkBrokenLinks(url);
        checker.closeDriver();
	}
}