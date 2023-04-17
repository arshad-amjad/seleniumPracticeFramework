package day6_workingwithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateClassActivity {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		navigateActivity();
		listElement();
		elementStatus();
		
	}

	public static void navigateActivity() {
		//Test case 
		WebDriver driver = new ChromeDriver();
	    //maximize browser
		driver.manage().window().maximize();
	     //declare implicitly wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     //go to amazon.com
		driver.get("https://amazon.com");
	     //Search coffee mug.
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
	     //Navigate back then search pretty coffee mug. 
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Pretty Coffee mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
	     //Navigate back then navigate forward
		driver.navigate().back();
		driver.navigate().forward();
	     //Refresh the page.
		driver.navigate().refresh();
		driver.quit();
	}
	
	public static void listElement() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//go to https://saucedemo.com
		driver.get("https://saucedemo.com");
		//log in with user name = standard_user   password = secret_sauce
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		//find all the results and get them in a list, and print the size of the list
		List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_description"));
		int listSize = items.size();
		System.out.println(listSize);
		
		List<WebElement> itemPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
		for (int i = 0; i < itemPrices.size(); i++) {
			System.out.println(itemPrices.get(i).getText());
		driver.quit();
		}
	}
	
	public static void elementStatus() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//go to https://indeed.com
		driver.get("https:indeed.com");
		//check if the search fields are enabled and displayed
		WebElement whatField = driver.findElement(By.xpath("//input[@name='q']"));
		WebElement whereField = driver.findElement(By.xpath("//input[@id='text-input-where']"));
		
		System.out.println(whatField.isEnabled());
		System.out.println(whatField.isDisplayed());
		
		System.out.println(whereField.isEnabled());
		System.out.println(whereField.isDisplayed());
		
		if(whatField.isEnabled() && whatField.isDisplayed()) {
			System.out.println("What Field is enabled and displayed");
		}else {
			System.out.println("What Field is not enabled or displayed");
		}
		
		if(whereField.isEnabled() && whereField.isDisplayed()) {
			System.out.println("Where Field is enabled and displayed");
		}else {
			System.out.println("Where Field is not enabled or displayed");
		}
		
	}
}