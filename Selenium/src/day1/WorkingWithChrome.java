package day1;

import org.openqa.selenium.Dimension;



import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {
	
	//Opening a browser//
	ChromeDriver driver; //ChromeDriver is constructor
	
	public void invokeBrowser() {
		 
		//webdriver is Interface
		//class is chrome (webdriver.chrome.driver)
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		
		driver = new ChromeDriver();
		//Opening a browser//

		Dimension dim = new Dimension(500, 500); // created instance of dimension class
		driver.manage().window().setSize(dim);; // pass dim argument in thiis manage option
		
		
//		driver.manage().window().maximize(); //maximize the browser
		
		driver.manage().deleteAllCookies(); //doesn't delete, it bypass all the cookies
		
		driver.get("http://qatechhub.com"); //navigate to particular URL. http is protocol, and protocol is important
		
	}
	
	public void getTitleOfThePage() {
		System.out.println("Title of the webpage : :" +driver.getTitle());
	}
	
	public void closeBrowser() {
//		driver.close(); //it closes the current active window
		
		driver.quit(); //it closes all window opened by Selenium
	}
	
	public void navigateCommands() {
		driver.navigate().to("http://facebook.com"); //.get
		
		driver.navigate().back(); //.back
		
		driver.navigate().forward(); //.forward one step forward
		
		driver.navigate().refresh(); // refresh reloading
	}

}




