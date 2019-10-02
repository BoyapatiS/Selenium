package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99GetUrlCount {
	
	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); //doesn't delete, it bypass all the cookies
		driver.get("http://demo.guru99.com/v4/");
	}
	
	public int getLinkCount() { //important question
		List<WebElement> allLinks;
		allLinks = driver.findElements(By.tagName("a"));
		return allLinks.size();
	}
	
	public void getAllLinksDetail() {
		List<WebElement> allLinks;
		allLinks = driver.findElements(By.tagName("a"));
		for(WebElement link : allLinks) {    //allLinks is a list of web elements
			System.out.println("Text: " +link.getText()+ " and URL: " +link.getAttribute("href"));
		}
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
}
