package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPayLinkText {
ChromeDriver driver; //ChromeDriver is constructor
	
	public void invokeBrowser() {
		 
		
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize(); //maximize the browser
		
		driver.manage().deleteAllCookies(); //doesn't delete, it bypass all the cookies
		
		driver.get("https://www.amazon.in/");
	
	}
		
	public String getUrl() {
		
		 WebElement link = driver.findElement(By.linkText("Amazon Pay"));
		 String url = link.getAttribute("href");
		 return url;
	}
	
	
	public void closeBrowser() {
		driver.close();
	}

}

