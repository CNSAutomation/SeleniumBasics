package Test.SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestAddCart {
	// Getting the Test Case name, as it will going to use in so many places
	public WebDriver driver;
	@Test
	public void Test_Login_Validation() throws Exception {
	System.setProperty("webdriver.gecko.driver", getClass().getResource(Constant.FF_Driver).getPath());
	driver = new FirefoxDriver();
	driver.navigate().to("http://www.seleniumpoint.com/testwebsite.php");
	driver.findElement(By.id("remail")).sendKeys("test@seleniumpoint.com");
	driver.findElement(By.id("rpassword")).sendKeys("test@123");
	driver.findElement(By.id("rsubmit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[4]/a")).click();
	String Parent_Window = driver.getWindowHandle();    
	System.out.println("This is the parent window" + driver.getTitle());
	 for (String Child_Window : driver.getWindowHandles())  
	 {  
	 driver.switchTo().window(Child_Window);
	 Thread.sleep(2000);
	 //Perform operation on child window 
	 System.out.println("window Title" + driver.getTitle());
	 }
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 
	 driver.close();
	  
	 Thread.sleep(2000);
	 //Switching back to Parent Window  
	 driver.switchTo().window(Parent_Window); 
	
	}

	@AfterTest
	public void endReport() {
		driver.quit();
	}
}