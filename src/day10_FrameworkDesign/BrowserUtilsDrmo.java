package day10_FrameworkDesign;

import org.openqa.selenium.Keys;

import pages.IndeedPage;
import utils.DataReader;
import utils.Driver;

public class BrowserUtilsDrmo {

	public static void main(String[] args) throws InterruptedException {

		indeedTest();
	}
	static IndeedPage indeedpage;

	public static void indeedTest() throws InterruptedException {
		indeedpage = new IndeedPage();
		//go to indeed
		Driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		Thread.sleep(1000);
		
		//find the where field and clear the text
		indeedpage.whereField.sendKeys(Keys.COMMAND + "a");
		indeedpage.whereField.sendKeys(Keys.DELETE);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
