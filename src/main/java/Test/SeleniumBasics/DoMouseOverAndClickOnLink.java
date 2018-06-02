package Test.SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoMouseOverAndClickOnLink {

	WebDriver driver;
	
	@Test
	public void enterText(){
		
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver_2.38\\chromedriver.exe");
		
		// Create Object of driver.
		driver = new ChromeDriver();
		
		// Navigate to site
		driver.get("https://www.actitime.com/download");
		//Find "Features" menu by xpath 
		//WebElement features = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		
		//Find "Features" menu by its link text name 
		WebElement features = driver.findElement(By.linkText("Features"));
		// Create Object of Action Class 
		Actions action = new Actions(driver);
		
		// Move to element for which you want mouse Over
		action.moveToElement(features).build().perform();
		
		// Just sleep for 1 second to make sure mouse over is successful.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Click on link
		//driver.findElement(By.linkText("Work Scope Management")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Work Scope Management')]")).click();
	}
}
