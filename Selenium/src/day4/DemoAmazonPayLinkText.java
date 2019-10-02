package day4;

public class DemoAmazonPayLinkText {

	public static void main(String[] args) {
		AmazonPayLinkText ap = new AmazonPayLinkText();
		ap.invokeBrowser();
		ap.getUrl();
		System.out.println(ap.getUrl());
		ap.closeBrowser();

	}

}
