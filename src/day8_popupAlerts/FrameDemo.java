package day8_popupAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		frameDemo();
		
	}
	
	public static void frameDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		driver.switchTo().frame("iframe1");
		driver.findElement(By.id("firstName")).sendKeys("Hello");
		
		driver.switchTo().parentFrame(); //goes back to one step out of the i frame.
		driver.switchTo().defaultContent(); // goes back to original page.
		
		System.out.println(driver.findElement(By.xpath("//h3[text()='Frames']")).getText());
		
		
	}

}
