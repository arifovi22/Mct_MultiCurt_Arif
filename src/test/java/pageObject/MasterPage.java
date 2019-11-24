package pageObject;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MasterPage {
	static WebDriver driver;
	
	public MasterPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void browserHandeller() {
	driver.manage().deleteAllCookies();
	driver.manage().window().fullscreen();
	}
	
	public void waitFor(long secound) {
		driver.manage().timeouts().implicitlyWait(secound, TimeUnit.SECONDS);	
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public void typeOnElement(String locatoers, String value) {
		if (locatoers.contains("ID")) {
			driver.findElement(By.id(locatoers.split(":")[1])).sendKeys(value);
		} else if (locatoers.contains("Xpath")) {
			driver.findElement(By.xpath(locatoers.split(":")[1])).sendKeys(value);
		} else if (locatoers.contains("name")) {
			driver.findElement(By.name(locatoers.split(":")[1])).sendKeys(value);	
		}
		}
		
	public void clickOnElement(String locatoers) {
		if (locatoers.contains("ID")) {
			driver.findElement(By.id(locatoers.split(":")[1])).click();
		} else if (locatoers.contains("Xpath")) {
			driver.findElement(By.xpath(locatoers.split(":")[1])).click();
		} else if (locatoers.contains("name")) {
			driver.findElement(By.name(locatoers.split(":")[1])).click();	
		}
		}
		
	public String getElement(String locatoers) {
		try {
			if (locatoers.contains("ID")) {
			return driver.findElement(By.id(locatoers.split(":")[1])).getText();
			} else if (locatoers.contains("Xpath")) {
			return	driver.findElement(By.xpath(locatoers.split(":")[1])).getText();
			} else if (locatoers.contains("name")) {
			return	driver.findElement(By.name(locatoers.split(":")[1])).getText();	
			}
		} catch (Exception e) {
			return "NULL";
		}
		return "NULL";
		}
		
	public List<String> getList(String locatoers) {
		List<String> actuaList = new ArrayList<String>();
		
		try {
			if (locatoers.contains("Xpath")) {
			List<WebElement> allElements = driver.findElements(By.xpath(locatoers.split(":")[1]));
			System.out.println(allElements);
			for (int i=0; i< allElements.size(); i++) {
				System.out.println(allElements.get(i).getText());
				actuaList.add(allElements.get(i).getText());
			}	
			}	
		} catch (Exception e) {
			
		}	
		return actuaList;
	} 
		
	public void closeBrowser() {
		driver.close();
		
	}
		
		
		
		
	}
	
	
	
	
	


