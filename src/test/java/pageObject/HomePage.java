package pageObject;

import org.openqa.selenium.WebDriver;

public class HomePage extends MasterPage {
	String loginLink = "ID:dLabellogin";
	String usernameFIeld = "ID:username";
	String passwordField = "ID:password";
	String loginButton = "ID:jqLogin";
	String signUpButton = "ID:jqSignup";
	String profileNameLabel = "Xpath://*[@id=\"dLabel\"]/span";
	String logOutLink = "Xpath://*[@id=\"drp_div\"]/ul/li/div/div[2]/a";

	
	String myAccountLink = "Xpath:.//*[@id='drp_div']/ul/li/div/div[1]/a";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public void gotoHomePage() {
		
		getUrl("https://demo.iscripts.com/multicart/demo/index.php");
	}
	
	public void loginTest() {
		clickOnElement(loginLink);
		typeOnElement(usernameFIeld,"user");
		typeOnElement(passwordField,"pass");
		clickOnElement(loginButton);		
	}

	public void takeMetoSignUPPage() {
		clickOnElement(loginLink);
		clickOnElement(signUpButton);
	}

	public void takeMetoMyAccountPage() {
		clickOnElement(profileNameLabel);
		clickOnElement(myAccountLink);
	}
		
	public void logOut() {
		clickOnElement(profileNameLabel);
		clickOnElement(logOutLink);
	}

	public void closeBrowser() {
		
		super.closeBrowser();
	}
	
	public String getProfileNameLabel() {
		return getElement(profileNameLabel);
	}

	

}
