package net.phptravels.admin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAsAdminOnFirefox {

	private WebDriver driver;
	private FirefoxBinary binary;
	private FirefoxProfile profile;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		// Launch Firefox browser
		driver = new FirefoxDriver(binary, profile);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait time out to 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navigate to http://phptravels.net/admin
		driver.get("http://phptravels.net/admin");
	}

	@AfterMethod
	public void afterMethod() throws Exception {

		// Close Firefox browser
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() throws Exception {

		// Set Firefox 45.0.3.0 ESR path
		binary = new FirefoxBinary(new File("C:\\Firefox4530esr\\firefox.exe"));

		// Create a new Firefox profile
		profile = new FirefoxProfile();
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
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.titleIs("Dashboard"));
		
		// Verify page title
		Assert.assertEquals(driver.getTitle(), "Dashboard");
		
	}

}
