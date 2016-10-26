package net.phptravels.admin;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAsAdminOnChrome {

	private WebDriver driver, driver2;
	private ChromeOptions options;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		// Launch Chrome browser
		driver = new ChromeDriver(options);

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

		// Close Chrome browser
		driver.quit();
		
	}

	@BeforeClass
	public void beforeClass() throws Exception {

		// Set Chrome driver property
		System.setProperty("webdriver.chrome.driver", 
				"./src/test/resources/drivers/chromedriver.exe");
		
		//Create instance of class ChromeOptions()
		options = new ChromeOptions();
		
		// Path to profile
		options.addArguments("user-data-dir=C:\\Users\\Piotrek\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
		
		// Path to sikuli images
		ImagePath.add("src/test/resources/images.sikuli");
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
		
		//  Clear text field
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
		
		//  Clear text value
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
		if(screen.exists("tooltipChrome.png", 5) != null){			
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
		if (screen.exists("tooltipChrome.png", 5) != null) {
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
		
		// Set implicitly timeout to 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Close browser
		driver.close();
		
		// Launch browser
		driver2 = new ChromeDriver(options);
		
		// Maximize the browser window
		driver2.manage().window().maximize();
		
		// Navigate to http://phptravels.net/admin
		driver2.navigate().to("http://phptravels.net/admin");
				
		// Add cookie
		for(Cookie getCookie:cookies){
		    if(getCookie.getDomain().equals("phptravels.net")){
		        driver2.manage().addCookie(getCookie);
		    }
		}
		
		// Set implicitly timeout to 3 seconds
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Navigate to http://phptravels.net/admin
		driver2.get("http://phptravels.net/admin");
		
		// Verify page title
		Assert.assertEquals(driver2.getTitle(), "Dashboard");	
		
		// Delete cookie
		for(Cookie getCookie:cookies){
		    if(getCookie.getDomain().equals("phptravels.net")){
		        driver2.manage().deleteCookie(getCookie);
		    }
		}
		
		// Set implicitly timeout to 10 seconds
		driver2.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Quit browser
		driver2.quit();
			
	}

	
}
