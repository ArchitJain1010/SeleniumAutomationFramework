package myproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTestNG {
	WebDriver driver;
	
	@BeforeSuite (groups= {"regression"})
	public void SetupSuite() {
		System.out.println("Suite started");
	}
	@BeforeClass(groups= {"regression"})
	public void SetupBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Browser Launched");
	}
	@BeforeMethod(groups= {"regression"})
	public void NavigateToApp()
	{
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	System.out.println("Navigated to HRM Login page");
	}
	@Test (groups= {"regression"})
	public void LoginTest() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		boolean loggedIn = driver.getCurrentUrl().contains("dashboard");
		Assert.assertTrue(loggedIn, "Login Failed");
		Thread.sleep(2000);
	}
	@AfterMethod(groups= {"regression"})
	public void cleanCookies() {
		driver.manage().deleteAllCookies();
		System.out.println("Cookies are cleared");
	}
@AfterClass (groups= {"regression"})
public void closeBrowser() {
	driver.quit();
	System.out.println("Browser closed");
}


@AfterSuite(groups= {"regression"})
public void endSuite() {
	System.out.println("Test suite completed");
}

}
