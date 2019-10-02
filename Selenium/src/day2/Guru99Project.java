package day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {
	
	ChromeDriver driver; //ChromeDriver is constructor
	
	public void invokeBrowser() {
		 
		
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize(); //maximize the browser
		
		driver.manage().deleteAllCookies(); //doesn't delete, it bypass all the cookies
				
		driver.get("http://demo.guru99.com/v4/"); //navigate to particular URL. http is protocol, and protocol is important
	
	}
	
	public void login(String userId, String userPassword)  {
		
		WebElement usernameElement = driver.findElement(By.name("uid"));  // defining web element and performing operation onit
		
		usernameElement.sendKeys(userId);
		
		driver.findElement(By.name("password")).sendKeys(userPassword);
		
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	public void addCustomer() {
		driver.findElement(By.linkText("New Customer")).click(); // findElement is Method. By is class
		driver.findElement(By.name("name")).sendKeys("Sri");
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.name("dob")).sendKeys("06/11/2019");
		driver.findElement(By.name("addr")).sendKeys("Norwalk dr");
		driver.findElement(By.name("city")).sendKeys("San Jose");
		driver.findElement(By.name("state")).sendKeys("California");
		driver.findElement(By.name("pinno")).sendKeys("951292");
		driver.findElement(By.name("telephoneno")).sendKeys("5307108516");
		
		String emailId = "Sri" + System.currentTimeMillis() + "@xyz.com";
		driver.findElement(By.name("emailid")).sendKeys(emailId);
		driver.findElement(By.name("password")).sendKeys("Random");
		driver.findElement(By.name("sub")).click();
		
		
	}
	
	
	public String getCustomer() {
//		return driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText(); // getText is to get text of that column
		return driver.findElement(By.xpath("//table[@id='customer']//td[text()='Customer ID']//following::td")).getText(); // by using axes
	
	}
	
	public void addAccount(String customerId) {
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.name("cusid")).sendKeys(customerId);
		
		WebElement dropdown = driver.findElement(By.name("selaccount")); //First identify the drop down as Web Element
		Select selAccount = new Select(dropdown); // pass Web element in select argument
		boolean statusFlag = selAccount.isMultiple(); // returns true or false
		System.out.println(statusFlag);
		selAccount.selectByVisibleText("Current");
		//Deselect -- when dropdown allows multi-select option (like two selections)
		
		driver.findElement(By.name("inideposit")).sendKeys("100000");
		driver.findElement(By.name("button2")).click();
	}
	
	public void editCustomer() {
		driver.findElement(By.linkText("Edit Customer")).click();
		driver.findElement(By.name("cusid")).sendKeys("12345");
		driver.findElement(By.name("AccSubmit")).click();
	}
	
	public void logOut() {
		driver.findElement(By.linkText("Log out")).click();
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		Thread.sleep(3000);
//		alert.dismiss();
	}
	
	public void alertAndFrameHandling() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.dismiss();
	}
	
	
	public void closeBrowser() {
		driver.close();
	}

}
