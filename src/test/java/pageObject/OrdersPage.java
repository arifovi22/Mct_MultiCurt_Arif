package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class OrdersPage extends MasterPage {
	String orderOption ="Xpath://table/tbody/tr/td[5]";
	
	

	public OrdersPage(WebDriver driver) {
		super(driver);
	}

	


	public List<String> getAllOptions() {
		
		// Get the Locators Of all the Option And Return the Text in All Options Back 
		return getList(orderOption);
		
	}

	
	
	
	
	
	
	
	
	
	
}
