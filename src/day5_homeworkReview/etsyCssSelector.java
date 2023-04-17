package day5_homeworkReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class etsyCssSelector {

public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/arshad/Documents/SeleniumTools/ChromeDriver/chromedriver_mac_arm64/chromedriver");
		textBox();
		webTable();
	}

public static void textBox() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	//Go to http://practice.primetech-apps.com/practice/text-box
	driver.get("http://practice.primetech-apps.com/practice/text-box");
	Thread.sleep(2000);
	
	//Create variables for those information and pass the variable to the send key() method
	String firstName = "Arshad";
	String lastName = "Amjad";
	String email = "email@gmail.com";
	String password = "hjhgasd65";
	String address = "10009 brittany commons blvd";
	
	//Find first name, last name, email, password, address fields, and type relevant information
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	driver.findElement(By.cssSelector("input[id=password]")).sendKeys(password);
	driver.findElement(By.xpath("//button[contains(text(), 'Enable')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[contains(@id, 'address')]")).sendKeys(address);
	
	//Then click on submit button. (your inputs displays under user info section)
	driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
	Thread.sleep(1000);
	
	//Find your inputs and get text of each and store them into variables
	String firstNameActual = driver.findElement(By.xpath("//div[contains(@class, 'firstName')]")).getText();
	System.out.println("Actual First Name: " + firstNameActual);
	String lastNameActual = driver.findElement(By.xpath("//div[contains(@class, 'lastName')]")).getText();
	System.out.println("Actual Last Name: " + lastNameActual);
	String emailActual = driver.findElement(By.xpath("//div[contains(@class, 'email')]")).getText();
	System.out.println("Actual Email: " + emailActual);
	String passwordActual = driver.findElement(By.xpath("//div[contains(@class, 'password')]")).getText();
	System.out.println("Actual Password: " + passwordActual);
	String addressActual = driver.findElement(By.xpath("//div[contains(@class, 'address')]")).getText();
	System.out.println("Actual Address: " + addressActual);
	Thread.sleep(1000);
	
	//Then compare your input with the displayed user information if they match
	if(firstNameActual.equals(firstName)) {
		System.out.println("Test Pass!");
	}else {
		System.out.println("Test Fail!");
	}
	
	if(lastNameActual.equals(lastName)) {
		System.out.println("Test Pass!");
	}else {
		System.out.println("Test Fail!");
	}
	
	if(emailActual.equals(email)) {
		System.out.println("Test Pass!");
	}else {
		System.out.println("Test Fail!");
	}
	
	if(passwordActual.equals(password)) {
		System.out.println("Test Pass!");
	}else {
		System.out.println("Test Fail!");
	}
	
	if(addressActual.equals(address)) {
		System.out.println("Test Pass!");
	}else {
		System.out.println("Test Fail!");
	}
	driver.quit();
}

	public static void webTable() throws InterruptedException {
	
WebDriver driver = new ChromeDriver();
//Go to http://practice.primetech-apps.com/practice/web-tables
driver.get("http://practice.primetech-apps.com/practice/web-tables");
Thread.sleep(1000);
//Verify that you see Web Tables text
String webTablePage = driver.findElement(By.xpath("//h3[contains(text(), 'Web Tables')]")).getText();
if(webTablePage.equals("Web Tables")) {
	System.out.println("We are on the Web Table Page.");
}else {
	System.out.println("We are not on the Web Table Page.");
}
//Find id, first name, last name, salary fields and give a relevant input. (store the information into variables, then pass the variable to sendKeys() method) 
int id = 123;
String firstName = "Arshad";
String lastName = "Amjad";
int salary = 120000;

driver.findElement(By.xpath("//input[@id='Id']")).sendKeys(String.valueOf(id));
driver.findElement(By.xpath("//input[@id='First Name']")).sendKeys(firstName);
driver.findElement(By.xpath("//input[@id='Last Name']")).sendKeys(lastName);
driver.findElement(By.xpath("//input[@id='Salary']")).sendKeys(String.valueOf(salary));
Thread.sleep(1000);

//Click on Add button
driver.findElement(By.xpath("//button[@type='submit']")).click();
Thread.sleep(1000);

//Then your inputs will display under the table. (use x path text() contains() functions to locate those elements. get text and store them into variables)
String actualId = driver.findElement(By.xpath("//td[text()='" + id + "']")).getText();
System.out.println(actualId);
String actualFirstName = driver.findElement(By.xpath("//td[text()='" + firstName + "']")).getText();
System.out.println(actualFirstName);
String actualLastName = driver.findElement(By.xpath("//td[text()='" + lastName + "']")).getText();
System.out.println(actualLastName);
String actualSalary = driver.findElement(By.xpath("//td[text()='" + salary + "']")).getText();
System.out.println(actualSalary);

//Verify your input under the table match the input you added.
if(Integer.parseInt(actualId)== id) {
	System.out.println("Test Pass!");
}else {
	System.out.println("Test Fail!");
}

if(actualFirstName.equals(firstName)) {
	System.out.println("Test Pass!");
}else {
	System.out.println("Test Fail!");
}

if(actualLastName.equals(lastName)) {
	System.out.println("Test Pass!");
}else {
	System.out.println("Test Fail!");
}

if(Integer.parseInt(actualSalary)==salary) {
	System.out.println("Test Pass!");
}else {
	System.out.println("Test Fail!");
}
driver.quit();

}
}
