package day3;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/* Select Electronics - Search for Apple watch - click search
 * write program to print number of products result (1-24 over 50,000 results)
 * get all the items info on page1
 * get nth product info (5th product)
 */

public class AmazonProject {
	ChromeDriver driver;
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/srithaboyapati/Documents/Programs/Java/Libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com");	
	}
	
	public void selectCategory() {
		WebElement dropdown = driver.findElement(By.name("url"));
		Select searchDropDown = new Select(dropdown);
		searchDropDown.selectByVisibleText("Electronics");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Apple watch");
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();	
	}
	
	public String printResults() {
		return driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span")).getText(); 
	}
	
	public void productDetails() {
		String name = driver.findElement(By.xpath("//a[@class='a-link-normal a-text-normal']/span[@class='a-size-medium a-color-base a-text-normal']")).getText();
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.printf("Product name : "+name+", Product price : $"+price);
//		ProductDetails details = new ProductDetails(name, price);
// 		return details;
		
		String name1 = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText();
		String price1 = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.printf("\nProduct name : "+name1+", Product price : $"+price1);
	
	}
	
	public String nthProduct() {
		Scanner s1 = new Scanner(System.in);
		System.out.println("\nEnter n value: ");
		int productNum = s1.nextInt();
		s1.close();
///		int productNum = 5;
		String xpathVar = String.format("//div[@class='s-result-list s-search-results sg-row']/div[@data-index='%d']", productNum);
//		System.out.println(driver.findElement(By.xpath(xpathVar)).getText());
		return driver.findElement(By.xpath(xpathVar)).getText();
	}
	
//	public String productPrice() {
//		return driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
//	}
	
/*	
	class ProductDetails {
		String name;
		String price;
		
		ProductDetails(String name, String price){
			this.name = name;
			this.price = price;
		}
		
		public String getName() {
			return name;
		}
		public String getPrice() {
			return price;
		}

		@Override
		public String toString() {
			return "ProductDetails [Name = " + name + ", Price = $" + price + "]";
		}
		
	}
*/
	
	public void closeBrowser() {
		driver.close();
	}

}
