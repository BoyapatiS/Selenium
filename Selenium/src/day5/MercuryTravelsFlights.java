package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MercuryTravelsFlights {

	public static void main(String[] args) {
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.mercurytravels.co.in/flights");
		
		Actions action = new Actions(driver);
		WebElement fromCity = driver.findElement(By.name("fromCity"));
		action.moveToElement(fromCity).click().sendKeys("Delhi").sendKeys(Keys.ENTER).click().build().perform();
		
//		action.moveToElement(driver.findElement(By.id("ui-id-288"))).click().build().perform();
		
		action.moveToElement(driver.findElement(By.name("toCity"))).click().sendKeys("Mumbai").sendKeys(Keys.ENTER).build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/tbody/tr[4]/td[6]"))).click().build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("/html/body/div[16]/div[1]/table/tbody/tr[6]/td[1]"))).click().build().perform();
		
		Select s1 = new Select(driver.findElement(By.id("Adults")));
		s1.selectByVisibleText("4");
		
		Select s2 = new Select(driver.findElement(By.id("Childs")));
		s2.selectByVisibleText("0");
		
		Select s3 = new Select(driver.findElement(By.id("Infants")));
		s3.selectByVisibleText("0");
		
		Select s4 = new Select(driver.findElement(By.name("cabinClass")));
		s4.selectByVisibleText("Economy");
		
		action.moveToElement(driver.findElement(By.id("searchFlightsBtn"))).click().build().perform();
	}

}
