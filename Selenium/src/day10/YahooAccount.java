package day10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
 * STEP 1: go to this URL https://login.yahoo.com/account/create?.src=fpctx&.intl=us&.lang=en-US&.done=https%3A%2F%2Fwww.yahoo.com&specId=yidReg
STEP 2: Enter all the dummy details 
STEP 3: Navigate back to the previous page and click on help 
STEP 4: In that page go and do Mouse hover to "MAIL" button.
STEP 5: Perform all the actions.
 */

public class YahooAccount {
	
	public static void main(String[] args) {
		ChromeDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://login.yahoo.com/account/create?.src=fpctx&.intl=us&.lang=en-US&.done=https%3A%2F%2Fwww.yahoo.com&specId=yidReg");
		
		Actions action = new Actions(driver);
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Sritha");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Paladugu");
		
		WebElement element = driver.findElement(By.id("usernamereg-yid"));
		action.moveToElement(element).click().sendKeys("psritha").sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.name("password")).sendKeys("Yahoo@123");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("4085065832");
		
		WebElement bDropdown = driver.findElement(By.id("usernamereg-month"));
		Select birthMonth = new Select(bDropdown);
		birthMonth.selectByVisibleText("August");
		
		driver.findElement(By.id("usernamereg-day")).sendKeys("22");
		driver.findElement(By.id("usernamereg-year")).sendKeys("1992");
		
//		WebElement gDropdown = driver.findElement(By.name("freeformGender"));
//		action.moveToElement(gDropdown).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.name("freeformGender")).click();
		driver.findElement(By.xpath("//ul[@class='reg-gender-list']/li")).click();
		
		driver.findElement(By.linkText("Help")).click();
		
		WebElement element1 = driver.findElement(By.xpath("//div/a/span[2]"));
		action.moveToElement(element1).build().perform();
		
		List<WebElement> myframes=driver.findElements(By.tagName("iframe"));
		System.out.println("no of frames are :"+myframes.size());
		
	}

}
