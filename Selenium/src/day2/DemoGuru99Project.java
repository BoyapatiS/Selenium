package day2;

public class DemoGuru99Project {

	public static void main(String[] args) throws InterruptedException {
		
		Guru99Project g99 = new Guru99Project();
		
		g99.invokeBrowser();
		g99.login("mngr201389", "UtAbUbu");	
//		g99.addCustomer();
//		g99.getCustomer();
//		System.out.println(g99.getCustomer());
//		g99.addAccount(g99.getCustomer());
//		g99.editCustomer();
		g99.logOut();
		g99.alertAndFrameHandling();
		
//		g99.closeBrowser();
	}

}
