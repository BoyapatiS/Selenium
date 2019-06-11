package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookProject {
	
	ChromeDriver driver; //ChromeDriver is constructor
	
	public void invokeBrowser() {
		 
		
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize(); //maximize the browser
		
		driver.manage().deleteAllCookies(); //doesn't delete, it bypass all the cookies
		
		driver.get("http://facebook.com"); //navigate to particular URL. http is protocol, and protocol is important
	
	}
	
	public void login(String userId, String userPassword)  {
		
		WebElement usernameElement = driver.findElement(By.name("email"));
		
		usernameElement.sendKeys(userId);
		
		driver.findElement(By.name("pass")).sendKeys(userPassword);
		driver.findElement(By.id("loginbutton")).click();
		
	}

}
