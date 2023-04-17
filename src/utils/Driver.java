package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		if(driver == null) {
		   driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void quitDriver() {
		if(driver != null) {
		   driver.quit();
		   driver = null;
		}
	}
}
