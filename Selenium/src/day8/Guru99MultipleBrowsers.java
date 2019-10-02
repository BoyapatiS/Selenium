package day8;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99MultipleBrowsers {
	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	public void invokeBrowser(String browsertype) throws MalformedURLException {
		
		if(browsertype.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
			driver = new ChromeDriver();
			
		} else if (browsertype.equalsIgnoreCase("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/geckodriver");
			driver = new FirefoxDriver();
			
		} else if (browsertype.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		
		}else if(browsertype.equalsIgnoreCase("remote-chrome")) {
				
				ChromeOptions options = new ChromeOptions();
				
				options.addArguments("platform=any"); //any OS
				
				URL hubUrl = new URL("http://192.168.103.143:12212/wd/hub"); //Clients should connect to http://192.168.103.143:12212/wd/hub
				
				driver = new RemoteWebDriver(hubUrl, options); // it means you want to conn. through grid
				
			
//		} else if(browsertype.equalsIgnoreCase("chrome-headless")) {
//			
//			System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
//			
//			ChromeOptions options = new ChromeOptions();
//			
//			options.addArguments("--headless"); //any OS
//			
//			driver = new ChromeDriver(options);
//			
		} 
		
		else {
			System.out.println("Invalid browser. Give a valid browser name.");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/v4/");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@Test(priority=0)
	public void login()  {
		String userId = "mngr201392";
		String userPassword = "zazYbEs";
		
		WebElement usernameElement = driver.findElement(By.name("uid"));  // defining web element and performing operation onit
		
		usernameElement.sendKeys(userId);
		
		driver.findElement(By.name("password")).sendKeys(userPassword);
		
		driver.findElement(By.name("btnLogin")).click();
	}
	
	@Test(priority=1)
	public void logOut() {
		driver.findElement(By.linkText("Log out")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alert.dismiss();
	}

}
