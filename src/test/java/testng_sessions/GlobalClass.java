package testng_sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class GlobalClass {
	static WebDriver driver;
	
	@BeforeSuite
	public void createDriver() {
		driver = new ChromeDriver();
		
	}
}
