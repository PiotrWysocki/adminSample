package net.phptravels.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAsAdminOnChrome {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		// Launch Chrome browser
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait time out to 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navigate to http://phptravels.net/admin
		driver.get("http://phptravels.net/admin");
	}

	@AfterMethod
	public void afterMethod() throws Exception {

		// Close Chrome browser
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() throws Exception {

		// Set Chrome driver property
		System.setProperty("webdriver.chrome.driver", 
				"./src/test/resources/drivers/chromedriver.exe");
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
