package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//Enter login details in flipkart modal

public class FlipkartProject {
	ChromeDriver driver;
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");
	}
	
	public void loginPage() {
//		driver.findElement(By.xpath("//div[@class = '_1XBjg- row']")).click();

		driver.findElement(By.xpath("//div[@class = '_1XBjg- row']//input[@class = '_2zrpKA _1dBPDZ']")).sendKeys("sri.p@gmail.com");
		driver.findElement(By.xpath("//div[@class = '_1XBjg- row']//input[@class = '_2zrpKA _3v41xv _1dBPDZ']")).sendKeys("Sritha");
		driver.findElement(By.xpath("//div[@class = '_1XBjg- row']//button[@class = '_2AkmmA _1LctnI _7UHT_c']")).click();
//		driver.findElement(By.xpath("//div[@class = '_1XBjg- row']//input[@class = '_2zrpKA _1dBPDZ']")).sendKeys("40986536789");

	}
	
	public void closeBrowser() {
		driver.close();
	}

}
