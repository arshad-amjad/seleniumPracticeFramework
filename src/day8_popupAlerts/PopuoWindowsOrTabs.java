package day8_popupAlerts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopuoWindowsOrTabs {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		newTabDemo();
		windowHandleExample();

	}
	
	public static void newTabDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//go to http://practice.primetech-apps.com/practice/browser-windows
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		String mainWindowId = driver.getWindowHandle();
		System.out.println("Main Window id: " + mainWindowId);
		//Click on 'New Tab' button.
		driver.findElement(By.id("newTab")).click();
		//Then get the window handles and print what they are
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			System.out.println("Window Id is: " + windowId);
		}
		
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		String secondWindowId = ids.next();
		
		System.out.println("First window id: " + firstWindowId);
		System.out.println("Second window id: " + secondWindowId);
		
		driver.switchTo().window(secondWindowId);
		String newTabTextOnSecondWindow = 
				driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(newTabTextOnSecondWindow);
		
		driver.close(); //This closes the current window.
		driver.switchTo().window(firstWindowId);
		String mainWindowText = 
				driver.findElement(By.xpath("//h3[text()='Browser Windows']")).getText();
		System.out.println("Main Window browser text is: " + mainWindowText);
		
		if(driver.getWindowHandle().equals(mainWindowId)) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail!");
		}
		driver.quit();
	}
	
	public static void windowHandleExample() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//go to http://practice.primetech-apps.com/practice/browser-windows
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		//1. Get the main window ID and store it in a String called mainWindowId
		String mainWindowId = driver.getWindowHandle();
		System.out.println("Main Window ID is: " + mainWindowId);
		//2. Click on the 'New Tab' button
		driver.findElement(By.id("newTab")).click();
		//3. Get window IDs and store it into a Set
		Set<String> windowIds = driver.getWindowHandles();
		//4. Get the first window ID from the Set and Verify it matches with the main window id in step 1. 
		//Then get the second window id and store it in variable called secondWindowId.
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		String secondWindowId = ids.next();
		
		if(firstWindowId.equals(mainWindowId)) {
			System.out.println("It matches the Main Window ID");
		}else {
			System.out.println("It does not matches the Main Window ID");
		}
		//5. Switch to the second window
		driver.switchTo().window(secondWindowId);
		//6. Verify that there is a button called 'New Tab'
		String mainTextOnSecondWindow = 
				driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		if(mainTextOnSecondWindow.equals("New Tab")) {
			System.out.println("There is New Tab button");
		}else {
			System.out.println("There is no New Tab button");
		}
		//7. Close the window,  Switch back to the main window, Verify you are on the main window. 
		driver.close();
		driver.switchTo().window(mainWindowId);
		if(driver.getWindowHandle().equals(mainWindowId)) {
			System.out.println("We are back to the main window");
		}else {
			System.out.println("We are lost smomewhere!");
		}
	}
}