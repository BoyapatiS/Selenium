package day3;

public class DemoAmazonProject {

	public static void main(String[] args) {
		AmazonProject ap = new AmazonProject();
		ap.invokeBrowser();
		ap.selectCategory();
		
//		ap.printResults();
//		System.out.println(ap.printResults());
		String result = ap.printResults();
		System.out.println("Result : " +result);
		
		ap.productDetails();
		
//		System.out.println("Product details : " +ap.productDetails());
//		ap.productPrice();
//		System.out.println("Product price : $" +ap.productPrice());
		
		String productDetails = ap.nthProduct();
		System.out.println(productDetails);

		ap.closeBrowser();

	}

}
