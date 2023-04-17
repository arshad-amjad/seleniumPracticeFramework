package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		//facebook1();
		//facebook2();
		indeed();
	}
	
	public static void facebook1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//go to facebook.com
		driver.get("https://facebook.com");
		Thread.sleep(1000);
		//find the Email or phone number field and type Automation
		driver.findElement(By.xpath("//input[@placeholder='Email or phone number']")).sendKeys("Automation");
	    //find the Password field and type Automation
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Automation");
	    //find the Login button and click on it
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
	}
	
	public static void facebook2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//go to facebook.com
		driver.get("https://facebook.com");
	    //find the Create New Account button and click on it
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	    Thread.sleep(2000);
		//find the FirstName,  LastName, Email and Password fields and type Automation
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Automation");
	    //find the Sign Up button and click on it
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	}
	
	public static void indeed() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//go to indeed.com
		driver.get("https://indeed.com");
		//get the current URL and store it in a variable called homeURL
		String homeURL = driver.getCurrentUrl();
		System.out.println("Home Page URL: " + homeURL);
		//get the web site title and store it in a variable homeTitle
		String homeTitle = driver.getTitle();
		System.out.println("Home Page Title: " + homeTitle);
		//find the input field for WHAT and type SDET
		String jobSearchName = "SDET";
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(jobSearchName);
		//find the input field for where, clear the field first and type Washington DC
		WebElement whereField = driver.findElement(By.xpath("//input[@name='l']"));
		whereField.sendKeys(Keys.COMMAND + "a");
		whereField.sendKeys(Keys.DELETE);
		whereField.sendKeys("Washington, DC");
		//find the Search button and click on it
		driver.findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
		Thread.sleep(1000);
		//get the current URL and store it as a variable searchURL
		String searchURL = driver.getCurrentUrl();
		System.out.println(searchURL);
		//get the web site title and store it in a variable searchTitle
		String searchTitle = driver.getTitle().toUpperCase();
		System.out.println(searchTitle);
		//verify that searchURL does not equal to homeURL and contains the search criteria
		if(!searchURL.equals(homeURL) && searchURL.contains(jobSearchName)) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail");
		}
		
		//verify that searchTitle does not equal to homeTitle and has the search criteria
		
		//Get Text of the JobsInLocation field, store it in a variable
		
		//then verify if it's equal to your search criteria
		

	}
}