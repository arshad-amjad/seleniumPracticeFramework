package day9_ActionsClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day8_homeworkReview {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		guru99Homework();
		iframeHomework();

	}
	
	public static void iframeHomework() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//go to http://practice.primetech-apps.com/practice/frames
		driver.get("http://practice.primetech-apps.com/practice/frames");
		//Verify that there is a page header text as "Frames".
		String headerText = driver.findElement(By.xpath("//h3[@class='mb-5']")).getText();
		if(headerText.equals("Frames")) {
			System.out.println("There is a header named Frames");
		}else {
			System.out.println("No header named Frames found");
		}
		//Find the iFrame element and switch into it
		driver.switchTo().frame("iframe1");
		//Find first name, last name, address, city, state, and zip code, and type relative information
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Smith");
		driver.findElement(By.id("address")).sendKeys("1234 main street");
		driver.findElement(By.id("city")).sendKeys("FairFax");
		driver.findElement(By.id("zipCode")).sendKeys("12345");
		//Select letsSelect = new Select(driver.findElement(By.id("state")));
		//letsSelect.selectByVisibleText("Virginia");
		driver.findElement(By.id("state")).sendKeys("Virginia");
		//Click on submit button.
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		//Verify you see "You have submitted below information:" message.
		boolean messageText =
				driver.findElement(By.xpath("//h3[contains(text(), 'You have submited')]")).isDisplayed();
		if(messageText) {
			System.out.println("There is information message");
		}else {
			System.out.println("There's NO information message");
		}
		//Switch back to main frame
		driver.switchTo().defaultContent();
		//Verify that there is a page header text as "Frames".
		String headerText2 = driver.findElement(By.xpath("//h3[@class='mb-5']")).getText();
		if(headerText2.equals("Frames")) {
			System.out.println("There is a header named Frames");
		}else {
			System.out.println("No header named Frames found");
		}
		driver.quit();
	}
	
	public static void guru99Homework() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//go to http://demo.guru99.com/popup.php
		driver.get("http://demo.guru99.com/popup.php");
		//Get title and store it in a variable.
		String mainPageTitle = driver.getTitle();
		String mainPageWindowId = driver.getWindowHandle();
		//Click on Click Here button and switch over to next window
		driver.findElement(By.xpath("//a[@style='font-size:16px;']")).click();
		Set<String> windowIds = driver.getWindowHandles();
		for (String str : windowIds) {
			if(!str.equals(mainPageWindowId)) {
				driver.switchTo().window(str);
			}
		}
		//provide an email click Submit
		driver.findElement(By.xpath("//input[@name='emailid']"))
		.sendKeys("jon.dow@hotmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		//Get text of the user ID and password and store them in variables, print them out
		String userId =
				driver.findElement(By.xpath("(//td[@align='center'])[3]")).getText();
		String password =
				driver.findElement(By.xpath("(//td[@align='center'])[5]")).getText().trim();
		System.out.println("User id: " + userId);
		System.out.println("Password: " + password);
		//Then verify the text "This access is valid only for 20 days."
		String actualText =
				driver.findElement(By.xpath("//h3[contains(text(), 'This access')]")).getText();
		if(actualText.equals("This access is valid only for 20 days.")) {
			System.out.println("The access message is passed!");
		}else {
			System.out.println("The access message failed!");
		}
		//Close the window
		driver.close();
		//Go back to main window, and get title then verify it equals to your stored title
		driver.switchTo().window(mainPageWindowId);
		if(driver.getTitle().equals(mainPageTitle)) {
			System.out.println("Title Verified!");
		}else {
			System.out.println("Title Verification failed!");
		}
		//Quit driver
		driver.quit();
	}

}
