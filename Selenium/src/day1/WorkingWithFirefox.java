package day1;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkingWithFirefox {
	
	FirefoxDriver driver; 
	
	public void invokeBrowser() {
		 
		
		System.setProperty("webdriver.gecko.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/geckodriver");
		
		driver = new FirefoxDriver();
		

		driver.manage().window().maximize(); 
		
		driver.manage().deleteAllCookies(); 
		
		driver.get("http://qatechhub.com"); 
		
	}
	
	public void getTitleOfThePage() {
		System.out.println("Title of the page : :" +driver.getTitle());
	}
	
	public void closeBrowser() {
		
		driver.quit(); 
	}
	
	public void navigateCommands() {
		driver.navigate().to("http://facebook.com"); //.get
		
		driver.navigate().back(); //.back
		
		driver.navigate().forward(); //.forward one step forward
		
		driver.navigate().refresh(); // refresh reloading
	}

}
