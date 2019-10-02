package day6;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonScrollDown {

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in");
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public String searchProduct(String product, String category) {

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select selCategory = new Select(dropdown);

		selCategory.selectByVisibleText(category);

		driver.findElement(By.xpath("//input[@value='Go' and @class='nav-input']")).click();

		String result = driver.findElement(By.xpath("(//span[@data-component-type='s-result-info-bar']//div[@class='sg-col-inner']//span)[1]")).getText();

		return result;
		
	}
	
	public void printAllProductViaScrolldownUsingJs() {

		List<WebElement> allProducts = driver
				.findElements(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div"));

		
		int xCor, yCor;
		for (WebElement product : allProducts) {
			
			xCor = product.getLocation().x;
			yCor = product.getLocation().y;
			
			scrollDown(xCor, yCor);
			
			System.out.println("---------------------------------------------------------");
			System.out.println(product.getText());

		}
	}
	
	private void scrollDown(int x, int y) {
		
		JavascriptExecutor jsEngine;
		
		String jsCommand = String.format("window.scrollBy(%d, %d)", x, y);
		
		jsEngine = (JavascriptExecutor) driver; // typecasting Javascript 
		
		jsEngine.executeScript(jsCommand);
			
	}
	
	public static void main(String[] args) {
		AmazonScrollDown as = new AmazonScrollDown();
		as.invokeBrowser();
		as.searchProduct("Apple watch", "Electronics");
		as.printAllProductViaScrolldownUsingJs();
	}

}
