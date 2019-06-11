package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		driver.findElement(By.name("name")).sendKeys("Sri");;
		driver.findElement(By.name("dob")).sendKeys("06/11/2019");
		driver.findElement(By.name("addr")).sendKeys("Norwalk dr");
		driver.findElement(By.name("city")).sendKeys("San Jose");
		driver.findElement(By.name("state")).sendKeys("California");
		driver.findElement(By.name("pinno")).sendKeys("951292");
		driver.findElement(By.name("telephoneno")).sendKeys("5307108516");
		driver.findElement(By.name("emailid")).sendKeys("random@yahoo.com");
		driver.findElement(By.name("password")).sendKeys("Random");
		driver.findElement(By.name("sub")).click();
	}
	
	public void editCustomer() {
		driver.findElement(By.linkText("Edit Customer")).click();
		driver.findElement(By.name("cusid")).sendKeys("12345");
		driver.findElement(By.name("AccSubmit")).click();
	}
}
