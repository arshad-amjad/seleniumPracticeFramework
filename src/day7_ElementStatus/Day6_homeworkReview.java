package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6_homeworkReview {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		radioButtonHomework();
		checkboxHomework();
		amazonHomework();
		
	}
	
	public static void radioButtonHomework() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//go to http://practice.primetech-apps.com/practice/radio-button
		driver.get("http://practice.primetech-apps.com/practice/radio-button");
        //Find those available radio buttons
		List<WebElement> radioButtons = 
				driver.findElements(By.xpath("//input[@class='form-check-input']"));
		for (WebElement singleRadio : radioButtons) {
			//Check if it's displayed and enabled,
			if(singleRadio.isDisplayed() && singleRadio.isEnabled()) {
				//if true, check if it's selected,
				if(singleRadio.isSelected()) {
					System.out.println("Radio Button is Selected!");
				}else {
					System.out.println("Radio Button is not Selected!");
					//if false select the button
					singleRadio.click();
				}
			}else {
				System.out.println("Something is not right!");
			}
			//check if it's selected
			System.out.println("Is radio Button selected? " + singleRadio.isSelected());
		}
	}
	
	public static void checkboxHomework() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//go to http://practice.primetech-apps.com/practice/check-box
		driver.get("http://practice.primetech-apps.com/practice/check-box");
	    //find the check boxes and verify if it's displayed
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));
		for (WebElement singleCheckbox : checkboxes) {
			if(singleCheckbox.isDisplayed()) {
				//if true, then verify if it's enabled,
				if(singleCheckbox.isEnabled()) {
					if(singleCheckbox.isSelected()) {
						//if true, verify if it's selected, if false, then check the boxes
						System.out.println("Check boxes are Displayed, Enabled and Selected");
					}else {
						System.out.println("Check boxes are not Displayed, Enabled and Selected");
						singleCheckbox.click();
						Thread.sleep(1000);
					}
				}else {
					System.out.println("Check Boxes are not Enabled");
				}
			}else {
				System.out.println("Check Boxes are not Displayed. Something is not right!");
			}
			Thread.sleep(1000);
			//Then verify if it's checked
			System.out.println("Is Check Boxes selected? " + singleCheckbox.isSelected());
		}
	}
	
	public static void amazonHomework() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 //go to amazon.com    
		driver.get("https://amazon.com");
		 //click on sign in 
		driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]")).click();
	     //verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page.");
		}else {
			System.out.println("I am not on the sign in page.");
		}
	     //navigate back, and navigate forward
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
	     //verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page on the second time.");
		}else {
			System.out.println("I am not on the sign in page on the second time.");
		}
	     //click on create new account, verify you are on new account create page.
		driver.findElement(By.id("createAccountSubmit")).click();
		WebElement createAccountText = 
				driver.findElement(By.xpath("//h1[contains(text(), \"Create account\")]"));
		if (createAccountText.isDisplayed()) {
			System.out.println("I am on the account creation page.");
		}else {
			System.out.println("I am not on the account creation page.");
		}
	     //navigate back, verify you are on the sign-in page.
		driver.navigate().back();
		Thread.sleep(1000);
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page on the third time.");
		}else {
			System.out.println("I am not on the sign in page on the third time.");
		}
	     //navigate forward, verify you are on the create account page.
		driver.navigate().forward();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h1[contains(text(), \"Create account\")]")).isDisplayed()) {
			System.out.println("I am on the account creation page second time.");
		}else {
			System.out.println("I am not on the account creation page second time.");
		}
	     //click on the Continue button without filling the form
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
	     //verify error messages displayed and get text to verify:
	      //Enter your name
		WebElement nameErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		if (nameErrorMessage.isDisplayed()) {
			if (nameErrorMessage.getText().equals("Enter your name")) {
				System.out.println("Name error message displays and it matches.");
			}else {
				System.out.println("Name error message does not display or it doesn't match.");
			}
		}
	      //Enter your email or mobile phone number
		WebElement emailErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
		if (emailErrorMessage.isDisplayed()) {
			if (emailErrorMessage.getText().equals("Enter your email or mobile phone number")) {
				System.out.println("Email error message displays and it matches.");
			}else {
				System.out.println("Email error message does not display or it doesn't match.");
			}
		}
	     //Minimum 6 characters required
		WebElement passwordErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
		if (passwordErrorMessage.isDisplayed()) {
			if (passwordErrorMessage.getText().equals("Minimum 6 characters required")) {
				System.out.println("Password error message displays and it matches.");
			}else {
				System.out.println("Password error message does not display or it doesn't match.");
			}
		}

	}
}