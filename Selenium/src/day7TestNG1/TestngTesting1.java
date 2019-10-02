package day7TestNG1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngTesting1 {
  
	@Test(priority = 0) //lowest number has highest priority
	public void testcase1() {
		System.out.println("Executing first test case 1");
	}
	
	@Test(priority = 2, enabled = false) //now it won't excecute, its disabled.
	public void testcase5() {
		System.out.println("Executing first test case 5");
	}
	
	@Test(priority = 3)
	public void testcase7() {
		System.out.println("Executing first test case 7");
	}
	
	@Test(priority = 3, invocationCount = 4) //this testcase will be executed 4 times
	public void testcase3() {
		System.out.println("Executing first test case 3");
	}
	
	@BeforeMethod //executed before every test case
	public void beforeMethod() {
		System.out.println("I execute before every test case.");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I execute after every test case.");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before a class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After a class");
	}
	
}
