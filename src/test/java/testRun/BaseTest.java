package testRun;




import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.OrdersPage;

public class BaseTest {
	HomePage home;
	
	ThreadLocal<WebDriver> driver =  new ThreadLocal<WebDriver>();
	
	
	
	
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arif\\eclipse project\\Mct_MultiCurt_Arif\\Browser\\chromedriver.exe");
				driver.set(new ChromeDriver());	
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arif\\eclipse project\\Mct_MultiCurt_Arif\\Browser\\geckodriver.exe");
				driver.set(new FirefoxDriver());
			}	
		} catch (Exception e) {
			
		}
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	
	@Test
	public void signIn() {
		this.openBrowser("chrome");  // This Function has the power of creating the new driver 
		WebDriver driver = this.getDriver();
		home =new HomePage(driver);
		home.getUrl("https://www.demo.iscripts.com/multicart/demo/index.php");
		home.waitFor(3);
		home.loginTest();
		home.takeMetoMyAccountPage();
		MyAccountPage mypage = new MyAccountPage(driver);
		
		mypage.takeMeToOrderPage();
		OrdersPage order = new OrdersPage(driver);
		List<String> actualOptionResult = order.getAllOptions();
		
		
		List<String> expOptionResult = new ArrayList<String>();
		expOptionResult.add("STATUS");
		expOptionResult.add("Cancelled");
		expOptionResult.add("Cancelled");
		expOptionResult.add("Pending");
		expOptionResult.add("Pending");
		expOptionResult.add("Pending");
		expOptionResult.add("Pending");
		expOptionResult.add("Pending");
		expOptionResult.add("Pending");
		expOptionResult.add("Delivered");
		expOptionResult.add("Delivered");

	
		assertEquals(actualOptionResult, expOptionResult);
		
		/*
		 *      Pending Pending Pending Pending
		 *  Delivered
		 */
		
	}
	
	
	
	
	

}
