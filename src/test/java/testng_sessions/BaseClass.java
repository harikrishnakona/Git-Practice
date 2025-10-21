package testng_sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext context) {
		driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form");
		context.setAttribute("drivername", driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
