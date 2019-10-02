package day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndFrameHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver; //ChromeDriver is constructor
		

			 
			
			System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
			
			driver = new ChromeDriver();
			
			
			driver.manage().window().maximize(); //maximize the browser
			
			driver.manage().deleteAllCookies(); //doesn't delete, it bypass all the cookies
			
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert"); //navigate to particular URL. http is protocol, and protocol is important
		
		driver.switchTo().frame("iframeResult"); //from our page, we switch to frame and adding Id
		
		//To come back from an alert
//		driver.switchTo().defaultContent();
		
		driver.findElement(By.tagName("button")).click();
		
		Alert alert = driver.switchTo().alert(); // switch to alert
		
//		Thread.sleep(3000);
		
		System.out.println(alert.getText());
		alert.accept(); //accepting the popup alert
		
	}

}
