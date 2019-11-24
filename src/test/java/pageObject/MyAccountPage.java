package pageObject;


import org.openqa.selenium.WebDriver;

public class MyAccountPage  extends MasterPage{
String clickOnOrder="Xpath://a[text()='My Orders']";
	
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public void takeMeToOrderPage() {
		clickOnElement(clickOnOrder);
	}
	
	
	
	
	
	
	
	
}
