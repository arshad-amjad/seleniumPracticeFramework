package day1_seleniumLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1_selenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
		"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		System.out.println("Home page title is: " + driver.getTitle());
		System.out.println("Home page URL is: " + driver.getCurrentUrl());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Customer Service")).click();
		
		
	}
}
