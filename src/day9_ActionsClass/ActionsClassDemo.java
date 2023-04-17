package day9_ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		actionsDemo();
		dragAndDropDemo();
	}
	
	public static void actionsDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Actions letsdo = new Actions(driver);
		//go to Etsy.com
		driver.get("https://etsy.com");
		//Hover Over on Jewelry & Accessories
		WebElement jewelaryTab = 
				driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		letsdo.moveToElement(jewelaryTab).build().perform();
		Thread.sleep(1000);
		//Mouse over on Bags & Purses
		WebElement bagsPurses = 
				driver.findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));
		letsdo.moveToElement(bagsPurses).build().perform();
		Thread.sleep(1000);
		//Mouse over to Shoulder Bags
		WebElement shoulderBags = 
				driver.findElement(By.xpath("//a[contains(text(), 'Shoulder Bags')]"));
		letsdo.moveToElement(shoulderBags).build().perform();
		//Click on the shoulder bags
		shoulderBags.click();
		//Verify you are on the Shoulder bags page
		if (driver.findElement(By.xpath("//h1[text()='Shoulder Bags']")).isDisplayed()) {
			System.out.println("We are on the Bag page.");
		}else {
			System.out.println("We are NOT on the Bag page.");
		}
	}
	
	public static void dragAndDropDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Actions letsdo = new Actions(driver);
		
		// go to "http://practice.primetech-apps.com/practice/drag-and-drop"
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		//  drag the Text element to next window
		WebElement sourceElement = driver.findElement(By.id("text"));
		WebElement targetElement = driver.findElement(By.id("dropzone"));
		letsdo.dragAndDrop(sourceElement, targetElement).build().perform();
		
	}
}