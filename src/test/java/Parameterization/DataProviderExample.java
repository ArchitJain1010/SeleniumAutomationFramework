package Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@DataProvider(name = "LoginData")
    public Object[][] getData() {

        Object data[][] = {

                {"Admin", "admin123"},
                {"John", "john123"},
                {"David", "david123"}

        };

        return data;
    }
	
	@Test(dataProvider = "LoginData")
	public void login(String username, String password) throws InterruptedException {

	    WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/");

	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	    Thread.sleep(2000);
	    System.out.println(username + " --> " + password);

	    driver.quit();

	}


}
