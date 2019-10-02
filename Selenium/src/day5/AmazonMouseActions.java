package day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonMouseActions {

	public static void main(String[] args) {
		ChromeDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.com");	
		
//		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
		
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")); 
		action.moveToElement(menu).click().perform();
		
		WebElement sportsOutdoors = driver.findElement(By.xpath("//li/a[@data-menu-id='21']"));
		action.moveToElement(sportsOutdoors).click().perform();
		
		WebElement golf = driver.findElement(By.xpath("//ul[@data-menu-id='21']/li[8]/a[@class='hmenu-item']"));
		action.moveToElement(golf).click().perform();
		
		driver.close();

	}

}
