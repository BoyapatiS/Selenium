package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleImageUpload {

	ChromeDriver driver;
	
	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://images.google.com/");
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void uploadImage() {
		driver.findElement(By.xpath("//div[@class='FiqGxd']")).click();
		driver.findElement(By.xpath("//a[@class='qbtbha qbtbtxt qbclr']")).click();
		driver.findElement(By.xpath("//div/input[@id='qbfile']")).click();
	}
	
	public static void main(String[] args) {
		GoogleImageUpload gi = new GoogleImageUpload();
		gi.invokeBrowser();
		gi.uploadImage();

	}

}
