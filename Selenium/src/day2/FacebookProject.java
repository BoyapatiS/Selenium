package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookProject {
	
	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies(); //doesn't delete, it bypass all the cookies
		driver.get("http://facebook.com"); 
	}
	
	public void login(String userId, String userPassword)  {
		
		WebElement usernameElement = driver.findElement(By.name("email"));
		usernameElement.sendKeys(userId);
		
		driver.findElement(By.name("pass")).sendKeys(userPassword);
		driver.findElement(By.id("loginbutton")).click();
		
	}
	
	public void signUp() {
		driver.findElement(By.name("firstname")).sendKeys("Sri");
		driver.findElement(By.name("lastname")).sendKeys("P");
		driver.findElement(By.name("reg_email__")).sendKeys("sri.p@xyz.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("sri.p@xyz.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Sritha");
	
		WebElement monthDropdown = driver.findElement(By.name("birthday_month"));
		Select birthMonth = new Select(monthDropdown);
//		boolean statusFlag = birthMonth.isMultiple();
//		System.out.println(statusFlag);
		birthMonth.selectByVisibleText("Aug");
		
		WebElement dayDropdown = driver.findElement(By.name("birthday_day"));
		Select birthDay = new Select(dayDropdown);
//		boolean statusFlag1 = birthDay.isMultiple();
//		System.out.println(statusFlag1);
		birthDay.selectByVisibleText("22");
		
		WebElement yearDropdown = driver.findElement(By.name("birthday_year"));
		Select birthYear = new Select(yearDropdown);
		birthYear.selectByVisibleText("1992");
		
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.name("websubmit"));
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
