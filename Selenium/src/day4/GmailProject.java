package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailProject {
	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.gmail.com/");
	}
	
	public void loginPage() {
		driver.findElement(By.id("identifierId")).sendKeys("itspaladugusritha@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println(e.toString());
		}
		driver.findElement(By.xpath("//div[@class='aXBtI I0VJ4d Wic03c']/div/input[@name='password']")).sendKeys("Dummy@123");
		driver.findElement(By.id("passwordNext")).click();
	}
	
	public void composeMail() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println(e.toString());
		}
		driver.findElement(By.xpath("//div[@class='z0']/div[@role='button']")).click();
		driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea[@id=':b2']"))
		.sendKeys("itspaladugusritha@gmail.com", " ");
		driver.findElement(By.xpath("//div/input[@name='subjectbox']")).sendKeys("Automation test mail");
		driver.findElement(By.xpath("//div[@id=':bp']")).sendKeys("My first automated mail.");
		driver.findElement(By.xpath("//div[@class='dC']/div[@id=':aa']")).click();
	}
}
