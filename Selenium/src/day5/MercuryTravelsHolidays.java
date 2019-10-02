package day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercuryTravelsHolidays {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.mercurytravels.co.in/indian-holidays");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		Actions action = new Actions(driver);
//		WebElement customerLogin = driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/a"));
//		action.moveToElement(customerLogin).build().perform();
//		
//		WebElement userLogin = driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/ul/li[1]/a"));
//		action.moveToElement(userLogin).click().build().perform();
//		
//		driver.findElement(By.id("sign_user_email")).sendKeys("sri@gmail.com");
//		driver.findElement(By.id("sign_user_password")).sendKeys("password@123");
		
		WebElement destination = driver.findElement(By.id("holiday_category_d"));
		action.moveToElement(destination).click().sendKeys("Pondicherry").perform();
		driver.findElement(By.xpath("//ul[@id=\"ui-id-1\"]")).click();
//		WebElement destDropdown = driver.findElement(By.xpath("//ul[@id=\"ui-id-1\"]"));
//		action.moveToElement(destDropdown).click().build().perform();
		
//		action.moveToElement(driver.findElement(By.xpath("//select[@id=\"duration_d\"]/option[8]"))).click().perform();
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		action.moveToElement(driver.findElement(By.xpath("//form[@id=\"dom_auto_comp_param\"]/div/div/div/div[3]/button"))).click().perform();
		
//		waitTillElementVisible(driver, 10, By.xpath("//div/div[3]/div/input[@id=\"dphh1\"]"));
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//div/div[3]/div/input[@id=\"dphh1\"]"))).click().sendKeys("06/10/2019").build().perform();
		
		action.moveToElement(driver.findElement(By.id("themes"))).click().perform();
		Select s1 = new Select(driver.findElement(By.id("themes")));
		s1.selectByVisibleText("Beach");
		
		action.moveToElement(driver.findElement(By.xpath("//div/button[@type='submit']"))).click().build().perform();
		
	}
	
//	public static void waitTillElementVisible(WebDriver driver, int timeout, By by) {
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}

}
