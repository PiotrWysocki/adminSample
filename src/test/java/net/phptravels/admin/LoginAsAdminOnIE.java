package net.phptravels.admin;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
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

		// Navigate to http://phptravels.net/admin
		driver.get("http://phptravels.net/admin");
		
		// Waits for tag b
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("b"))));
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
		
		// Path to sikuli images
		ImagePath.add("src/test/resources/images.sikuli");
	}
	
	@Test
	public void isLoginInWithCorrectAdminEmailAndPassword() throws Exception {
		
		// Find Email text field
		WebElement emailTF = driver.findElement(By.name("email"));
		
		//  Clear text field
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
	
	@Test
	public void isNotLoginInWithIncorrectAdminEmail() throws Exception {
		
		// Find Email text field
		WebElement emailTF = driver.findElement(By.name("email"));
		
		//  Clear text field
		emailTF.clear();
		
		// Enter Email
		emailTF.sendKeys("admin@phptravel.com");
		
		// Find Password text field
		WebElement passwordTF = driver.findElement(By.name("password"));
		
		//  Clear text field
		passwordTF.clear();
		
		// Enter Password
		passwordTF.sendKeys("demoadmin");
		
		// Find Login button
		WebElement loginB = driver.findElement(By.xpath("//button[@type='submit']"));
			 
		// Click Login button
		loginB.click();
		
		// Waits for div visibility
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Boolean divB = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='resultlogin']/div"), "Invalid Login Credentials"));
		
		// Verify divB
		Assert.assertTrue(divB);
				
	}
	
	@Test
	public void isNotLoginInWithIncorrectAdminPassword() throws Exception {
		
		// Find Email text field
		WebElement emailTF = driver.findElement(By.name("email"));
		
		//  Clear text value
		emailTF.clear();
		
		// Enter Email
		emailTF.sendKeys("admin@phptravels.com");
		
		// Find Password text field
		WebElement passwordTF = driver.findElement(By.name("password"));
		
		//  Clear text field
		passwordTF.clear();
		
		// Enter Password
		passwordTF.sendKeys("demoadmi");
		
		// Find Login button
		WebElement loginB = driver.findElement(By.xpath("//button[@type='submit']"));
			 
		// Click Login button
		loginB.click();
		
		// Waits for div visibility
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Boolean divB = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='resultlogin']/div"), "Invalid Login Credentials"));
		
		// Verify divB
		Assert.assertTrue(divB);
				
	}
	
	@Test
	public void isNotLoginInWithoutAdminEmail() throws Exception {
		
		// Find Password text field
		WebElement passwordTF = driver.findElement(By.name("password"));
		
		//  Clear text field
		passwordTF.clear();
		
		// Enter Password
		passwordTF.sendKeys("demoadmin");
		
		// Find Login button
		WebElement loginB = driver.findElement(By.xpath("//button[@type='submit']"));
			 
		// Click Login button
		loginB.click();
		
		// Create a new screen object 
		Screen screen = new Screen();
				
		// Verify if tooltip message is appeared
		if(screen.exists("tooltipIE.png", 5) != null){
			Assert.assertTrue(true);			
		}else{			
			Assert.assertFalse(true);			
		}
						
	}
	
	@Test
	public void isNotLoginInWithoutAdminPassword() throws Exception {

		// Find Email text field
		WebElement emailTF = driver.findElement(By.name("email"));

		// Clear text value
		emailTF.clear();

		// Enter Email
		emailTF.sendKeys("admin@phptravels.com");

		// Find Login button
		WebElement loginB = driver.findElement(By.xpath("//button[@type='submit']"));

		// Click Login button
		loginB.click();

		// Create a new screen object
		Screen screen = new Screen();

		// Verify if tooltip message is appeared
		if (screen.exists("tooltipIE.png", 5) != null) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}

	}
	
	@Test
	public void isFunctionRememberMeWork() throws Exception {
		
		// Find Email text field
		WebElement emailTF = driver.findElement(By.name("email"));
		
		//  Clear text value
		emailTF.clear();
		
		// Enter Email
		emailTF.sendKeys("admin@phptravels.com");
		
		// Find Password text field
		WebElement passwordTF = driver.findElement(By.name("password"));
		
		//  Clear text field
		passwordTF.clear();
		
		// Enter Password
		passwordTF.sendKeys("demoadmin");
		
		// Find checkbox "Remember Me"
		WebElement rememberMeCB = driver.findElement(By.xpath("//ins[@class='iCheck-helper']"));
		
		// Click checkbox
		rememberMeCB.click();
		
		// Find Login button
		WebElement loginB = driver.findElement(By.xpath("//button[@type='submit']"));
			 
		// Click Login button
		loginB.click();
		
		// Get all cookies
		Set<Cookie> cookies =  driver.manage().getCookies();
		
		// Waits for the page to load
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs("Dashboard"));
		
		// Close browser
		driver.quit();
		
		// Launch IE browser
		driver = new InternetExplorerDriver();

		// Maximize the browser window
		driver.manage().window().maximize();
		
		// Navigate to http://phptravels.net/admin
		driver.get("http://phptravels.net/admin");
		
		// Add cookie
		for(Cookie getCookie:cookies){
		    if(getCookie.getDomain().equals("phptravels.net")){
		        driver.manage().addCookie(getCookie);
		    }
		}
		
		// Navigate to http://phptravels.net/admin
		driver.get("http://phptravels.net/admin");
			
		// Waits for the page to load
		WebDriverWait waitTwo = new WebDriverWait(driver, 15);
		waitTwo.until(ExpectedConditions.titleIs("Dashboard"));
		
		// Verify page title
		Assert.assertEquals(driver.getTitle(), "Dashboard");
		
		
	}

}
