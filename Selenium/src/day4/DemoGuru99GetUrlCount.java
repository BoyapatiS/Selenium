package day4;

public class DemoGuru99GetUrlCount {

	public static void main(String[] args) {
		Guru99GetUrlCount g99 = new Guru99GetUrlCount();
		g99.invokeBrowser();
		
		System.out.println("Link count : " +g99.getLinkCount());
		
		g99.getAllLinksDetail();
		g99.closeBrowser();
	}

}
