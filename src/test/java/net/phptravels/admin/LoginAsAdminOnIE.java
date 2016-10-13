package net.phptravels.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAsAdminOnIE {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		// Launch IE browser
		driver = new InternetExplorerDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait time out to 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navigate to http://phptravels.net/admin
		driver.get("http://phptravels.net/admin");
	}

	@AfterMethod
	public void afterMethod() throws Exception {

		// Close IE browser
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() throws Exception {

		// Set IE driver property
		System.setProperty("webdriver.ie.driver", 
				"./src/test/resources/drivers/IEDriverServer.exe");
	}
	
	@Test
	public void isLoginInWithCorrectAdminEmailAndPassword() throws Exception {
		
		// Find Email text field
		WebElement emailTF = driver.findElement(By.name("email"));
		
		//  Clear text value
		emailTF.clear();
		
		// Enter Email
		emailTF.sendKeys("admin@phptravels.com");
		
		// Find Password text field
		WebElement passwordTF = driver.findElement(By.name("password"));
		
		//  Clear text value
		passwordTF.clear();
		
		// Enter Password
		passwordTF.sendKeys("demoadmin");
		
		// Find Login button
		WebElement loginB = driver.findElement(By.xpath("//button[@type='submit']"));
			 
		// Click Login button
		loginB.click();
		
		// Waits for the page to load
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs("Dashboard"));
		
		// Verify page title
		Assert.assertEquals(driver.getTitle(), "Dashboard");
		
	}

}
