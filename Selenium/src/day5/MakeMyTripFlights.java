package day5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripFlights {

	public static void main(String[] args) {
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com/");
		
		
		//Round Trip
		driver.findElement(By.xpath("//ul[@class=\"fswTabs latoBlack greyText\"]/li[2]")).click();
		//FromCity
		driver.findElement(By.cssSelector(".fsw_inputBox.searchCity.inactiveWidget ")).click();
		
//		Scanner s1 = new Scanner(System.in);
//		System.out.println("Enter FROM city: ");
//		String fromCity = s1.next();
//		s1.close();
		
		Actions action = new Actions(driver);
		WebElement fromCity = driver.findElement(By.xpath("//div/div/input[@placeholder='From']"));
		action.moveToElement(fromCity).sendKeys("Mumbai").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		//ToCity
		driver.findElement(By.cssSelector(".fsw_inputBox.searchToCity.inactiveWidget ")).click();
		
		WebElement toCity = driver.findElement(By.xpath("//div/div/input[@placeholder='To']"));
		action.moveToElement(toCity).sendKeys("Delhi").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).build().perform();
		
		//Departure Calender
//		driver.findElement(By.xpath("//div/label[@for='departure']")).click();
		
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 2);
		String newDate = dateFormat.format(cal.getTime());
//		System.out.println(newDate);
		
		String command = String.format("//div[@class='DayPicker Selectable Range']/div/div[2]/div/div[3]/div[5]/div[@aria-label='%s']", newDate);
//		//div[@class='dateInnerCell']/p[text()='%s']
		System.out.println(command);
		driver.findElement(By.xpath(command)).click();

		
		//Return Calender
//		driver.findElement(By.xpath("//div/label[@for='return']"));
		
		cal.add(Calendar.DAY_OF_MONTH, 2);
		newDate = dateFormat.format(cal.getTime());
//		System.out.println(newDate);
		command = String.format("//div[@class='dateInnerCell']/p[text()='%s']", newDate);
		System.out.println(command);
		driver.findElement(By.xpath(command)).click();
		
		
	}

}
