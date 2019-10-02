package day8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test(dataProvider = "getData")
	public void printTestData(String username, String password, int employeeId) {
		System.out.println("Username : " +username);
		System.out.println("Password : " +password);
	}
	
	@DataProvider
	public Object[][] getData() { // Object class can store any type of data type
		Object[][] data = new Object[3][3];
		
		data[0][0] = "Sritha";
		data[0][1] = "Sri@123";
		data[0][2] =  2334;
		
		data[1][0] = "Swathi";
		data[1][1] = "Sri@12";
		data[1][2] =  2334;

		data[2][0] = "Sruthi";
		data[2][1] = "Sri@123";
		data[2][2] =  2334;

		return data;
	}
}
