package day10_FrameworkDesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day9_actionsClassHomework {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		dragdrop();
		
	}
	
	public static void dragdrop() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		
		// go to "http://practice.primetech-apps.com/practice/drag-and-drop"
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		// Verify Drag And Drop text displays
		WebElement textShowed =
					driver.findElement(By.xpath("//h3[contains(text(), 'Drag And Drop')]"));
		if(textShowed.isDisplayed()) {
			System.out.println("Text is displayed");
		}else {
			System.out.println("Text is NOT displayed");
		}
		// drag the Text element to target window
		WebElement textDrop = driver.findElement(By.xpath("//a[@id='text']"));
		WebElement textTarget = driver.findElement(By.id("dropzone"));
		action.dragAndDrop(textDrop, textTarget).build().perform();
		Thread.sleep(1000);
		// drag the Text area element to target window
		WebElement textAreaDrop = driver.findElement(By.id("textarea"));
		action.dragAndDrop(textAreaDrop, textTarget).build().perform();
		Thread.sleep(1000);
		// drag the Number element to target window
		WebElement numberDrop = driver.findElement(By.id("Number"));
		action.dragAndDrop(numberDrop, textTarget).build().perform();
		Thread.sleep(1000);
		// delete all those dragged items from target window
		driver.findElement(By.xpath("(//i[@class='bi bi-trash'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='bi bi-trash'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='bi bi-trash'])[3]")).click();
		Thread.sleep(1000);
		
		driver.quit();
	}
}
