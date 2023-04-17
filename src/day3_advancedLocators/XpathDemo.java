package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		//amazonSearch();
		etsySearch();
	}
	
	public static void amazonSearch() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon']")).sendKeys("Coffee mug");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	
	public static void etsySearch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("jon");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("3551a3bbd");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
		Thread.sleep(3000);
		String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
		
		if(actualErrorMessage.equals(expectedErrorMessage)) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail!");
		}
	}
}