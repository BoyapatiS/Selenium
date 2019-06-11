package day1;

import org.openqa.selenium.safari.SafariDriver;

public class WorkingWithSafari {
	
	SafariDriver driver;
	
	public void invokeBrowser() {
		
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://google.com");
	}
	
	public void getTitleOfThePage() {
		System.out.println("Title of the page : :" +driver.getTitle());
	}
	
	public void navigateCommands() {
		driver.navigate().to("http://yahoo.com");
		driver.navigate().to("https://www.instagram.com");
		driver.navigate().back();
//		driver.navigate().forward();
//		driver.navigate().refresh();
	}
	
	public void closeBrowser() {
		driver.close();
	}

	
	
}
