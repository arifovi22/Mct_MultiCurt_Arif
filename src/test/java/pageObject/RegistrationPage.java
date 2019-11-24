package pageObject;

import org.openqa.selenium.WebDriver;

public class RegistrationPage  extends MasterPage{
	String profileNameLabel = "Xpath://*[@id=\"dLabel\"]/span";
	String clickOnMyAccount ="Xpath://*[@id=\"drp_div\"]/ul/li/div/div[1]/a";
	
	
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void takeMetoMyAccountPage() {
		clickOnElement(profileNameLabel);
		clickOnElement(clickOnMyAccount);
	}
	
	
	
	
	
	
	
	
}
