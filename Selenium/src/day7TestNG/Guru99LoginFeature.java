package day7TestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99LoginFeature {
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/v4/");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@Test(priority=0)
	public void verifyTheTitleOfTheLoginPage() {
		
		System.out.println("Title of the login page: " +driver.getTitle());
		
		//Verification using assertion
		String expectedTitle = "Guru99 Bank Home Page";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		//If first assert stmt is true then it wont execute the further assert stmts.
		Assert.assertTrue(actualTitle.equals(expectedTitle)); 
	}
	
	@Parameters({"userid", "userPassword"})
	@Test(priority=1000)
	public void verifyLoginToGuru99(String userId, String userPassword) {
		
		// defining web element and performing operation on it 
		WebElement usernameElement = driver.findElement(By.name("uid"));  
		usernameElement.sendKeys(userId);
		driver.findElement(By.name("password")).sendKeys(userPassword);
		driver.findElement(By.name("btnLogin")).click();
		System.out.println("Title of the home page: " +driver.getTitle());
		
		//Verification of login page using managerId
		String expectedManagerId = "Manager ID : " +userId;
		String actualManagerId = driver.findElement(By.xpath("//td[contains(text(), 'Manger Id')]")).getText();
		Assert.assertEquals(actualManagerId, expectedManagerId);
	}
	
	@Test(priority=3000)
	public void verifyLogout() throws InterruptedException {
		driver.findElement(By.linkText("Log out")).click();
		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.dismiss();
		System.out.println("Title of the logout page: " +driver.getTitle());
	}

}
