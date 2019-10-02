package day7TestNG1;

import org.testng.annotations.Test;

public class TestngTesting2 {
	
	@Test(priority = 0) //lowest number has highest priority
	public void testcase1() {
		System.out.println("Executing Testng2 test case 1");
	}
	
	@Test(priority = 2, enabled = false) //now it won't excecute, its disabled.
	public void testcase5() {
		System.out.println("Executing Testng2 test case 5");
	}
	
	@Test(priority = 3)
	public void testcase7() {
		System.out.println("Executing Testng2 test case 7");
	}
	
	@Test(priority = 3, invocationCount = 4) //this testcase will be executed 4 times
	public void testcase3() {
		System.out.println("Executing Testng2 test case 3");
	}
	
}
