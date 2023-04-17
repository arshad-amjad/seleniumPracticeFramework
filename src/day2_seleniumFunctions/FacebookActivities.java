package day2_seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookActivities {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		FacebookActivities fb = new FacebookActivities();
		fb.testcase1();
		//fb.testcase2();
		//fb.getTextPractice();
		//fb.etsyHomework();
		//fb.indeedHomework();
	}
	
	public void testcase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("Automation");
		driver.findElement(By.id("pass")).sendKeys("Automation");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
//		driver.close();
		
	}

	public void testcase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Automation");
		driver.findElement(By.name("lastname")).sendKeys("Automation");
		driver.findElement(By.name("reg_email__")).sendKeys("Automation");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Automation");
		driver.findElement(By.name("websubmit")).click();
	}
	
	public void getTextPractice() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		String loginText = driver.findElement(By.name("login")).getText();
		System.out.println("Log in button text is: " + loginText);
		if(loginText.equals("Log In")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail! Text doesn't equal");
		}
	}
	
	public void etsyHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		Thread.sleep(2000);
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("join_neu_email_field")).sendKeys("Automation");
		driver.findElement(By.id("join_neu_password_field")).sendKeys("Automation");
		driver.findElement(By.name("submit_attempt")).click();
	}
	
	public void indeedHomework() {
		
		String searchCriteria = "SDET";
		WebDriver driver = new ChromeDriver();
		driver.get("https://indeed.com");
		String homeURL = driver.getCurrentUrl();
		System.out.println("Home Page URL: " + homeURL);
		String homeTitle = driver.getTitle();
		System.out.println("Home Page Title: " + homeTitle);
		driver.findElement(By.id("text-input-what")).sendKeys(searchCriteria);
		driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
		String searchURL = driver.getCurrentUrl();
		System.out.println("Search Page URL: " + searchURL);
		String searchTitle = driver.getTitle().toUpperCase();
		System.out.println("Search Page Title: " + searchTitle);
		//verify that searchURL does not equal to homeURL and contains the search criteria.
		if(searchURL!=homeURL && searchURL.contains(searchCriteria)) {
			System.out.println("Search URL doesn't match and contains the search criteria. Test Pass!");
		}else {
			System.out.println("Search URL matches or doesn't contain the search Criteria. Test Fail!");
		}
		//verify that searchTitle does not equal to homeTitle and has the search criteria
		if(!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {
			System.out.println("Search Title doesn't match and contains the search criteria. Test Pass!");
		}else {
			System.out.println("Search Title matches and doesn't contain the search criteria. Test Fail!");
		}
		//Get Text of the JobsInLocation field, store it in a variable, then verify if it's equals to your search criteria.
		String jobsInLocationText = driver.findElement(By.className("jobsearch-SerpTitle")).getText();
		System.out.println("Jobs in the location text: " + jobsInLocationText);
		if(jobsInLocationText.contains(searchCriteria)) {
			System.out.println("Jobs in location matches with Search Criteria. Test Pass!");
		}else {
			System.out.println("Jobs in location does not match Search Criteria. Test Fail!");
		}
		
		System.out.println(jobsInLocationText.substring(0, searchCriteria.length()));
	}
}