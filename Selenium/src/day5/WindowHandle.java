package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
	
		String parentWindow = driver.getWindowHandle(); //
		System.out.println(parentWindow);
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		
		//getWindowHandles() returns the sessionId/ windowHandle of all opened windows. it return in form os Sets.
		//Since Sets doen't have indexes, we convert into array and add index to it.
		//Convert index value into string using toString()
		String childWimdow = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(childWimdow);
		System.out.println(childWimdow);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	public static void main(String[] args) {
		WindowHandle wh = new WindowHandle();
		wh.invokeBrowser();
	}

}
